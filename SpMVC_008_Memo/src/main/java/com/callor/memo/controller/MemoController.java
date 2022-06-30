package com.callor.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;


@Controller
@RequestMapping(value = "/memo")
public class MemoController {

	@Autowired
	private MemoService memoService;

	@RequestMapping(value = "/addMemo", method = RequestMethod.GET)
	public String addMemo(MemoVO memoVO) {
		return null;
	}	
	  @RequestMapping(value = "/{seq}/delete") public String
	  delete(@PathVariable("seq") int seq) { memoService.delete(seq);
	  return "redirect:/";
	  }
	@RequestMapping(value = "/{seq}/update", method = RequestMethod.GET)
	public String update(@PathVariable("seq") int seq, Model model) {
		MemoVO memoVO = memoService.findById(seq);
		model.addAttribute("MEMOVO", memoVO);
		return "memo/addMemo";
	}

}
