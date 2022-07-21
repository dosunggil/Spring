package com.cho.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cho.address.config.QualifyConfig;
import com.cho.address.model.AddressVO;
import com.cho.address.model.SearchPage;
import com.cho.address.service.AddressService;

@Controller
public class HomeController {

	private AddressService addrService;

	public HomeController(@Qualifier(QualifyConfig.SERVICE.ADDR_V1) AddressService addrService) {
		this.addrService = addrService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, @RequestParam(name = "pageno" , required=false, defaultValue = "0") int pageno) {
//		List<AddressVO> list = addrService.selectAll();
		SearchPage searchpage = SearchPage.builder()
								.a_name("")
								.limit(10)
								.offset(pageno * 10)
								.build();
		// 페이지 계산
		addrService.searchAndPage(model, searchpage);
		
		// 데이터 가져오기
		List<AddressVO> list = addrService.searchAndPage(searchpage); 
		model.addAttribute("AddrList", list);
		return "home";
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.POST)
	public String home(AddressVO vo) {
		addrService.insert(vo);
		return "redirect:/";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("seq") String strSeq, Model model) {
		long a_seq = Long.valueOf(strSeq);
		AddressVO vovo = addrService.findById(a_seq);
		model.addAttribute("ADDR", vovo);
		return "detail";
	}
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public String detail(AddressVO vo ) {
		addrService.insert(vo);
		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("seq") String strSeq, Model model) {
		long a_seq = Long.valueOf(strSeq);
		AddressVO vovo = addrService.findById(a_seq);
		model.addAttribute("ADDR", vovo);
		return "home";
	}
	
	@RequestMapping(value="/delete/{seq}", method =RequestMethod.GET)
	public String delete(@PathVariable("seq") long seq) {
		addrService.delete(seq);
		return "redirect:/";
	}

}
