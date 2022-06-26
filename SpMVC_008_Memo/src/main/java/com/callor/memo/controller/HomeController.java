package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

@Controller
public class HomeController {

	@Autowired
	private MemoService memoService;
	
	
	
	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public String home(Model model) {
		List<MemoVO> memoList = memoService.selectAll();
		model.addAttribute("MEMO",memoList);
		
		return "home";
	}

	@RequestMapping(value={"","/"} , method = RequestMethod.POST)
	public String hoem(@ModelAttribute("memoVO") MemoVO memoVO
			, @RequestParam("mfile") MultipartFile file) {
		if(memoVO.getM_seq()==0) {
			memoService.insertMemoAndFile(memoVO, file);
			return "redirect:/";
		} else {
			memoService.updateMemoAndFile(memoVO, file);
			return "redirect:/";
		}
		
	}
	
	@ModelAttribute("memoVO")
	private MemoVO memoVO() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		MemoVO memoVO = MemoVO.builder().m_date(dayFormat.format(date)).m_time(timeFormat.format(date))
				.m_author("dosunggil").build();

		return memoVO;
	}
}
