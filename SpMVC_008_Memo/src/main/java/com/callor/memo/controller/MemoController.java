package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/memo")
public class MemoController {

	@Autowired
	private MemoService memoService;


	@RequestMapping(value = "/addMemo", method = RequestMethod.GET)
	public String addMemo(MemoVO memoVO) {

		return null;
	}

	@RequestMapping(value = "/addMemo", method = RequestMethod.POST)
	public String addMemo(@ModelAttribute("memoVO") MemoVO memoVO, @RequestParam("mfile") MultipartFile file,
			Model model) {

		memoService.insertMemoAndFile(memoVO, file);

		return "redirect:/";
	}

	@RequestMapping(value = "/{seq}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("seq") int seq, Model model) {
		MemoVO memoVO = memoService.findById(seq);
		model.addAttribute("MEMOVO", memoVO);
		return "memo/detail";
	}

	@RequestMapping(value = "/{seq}/delete")
	public String delete(@PathVariable("seq") int seq) {
		memoService.delete(seq);

		return "redirect:/";

	}

	@RequestMapping(value = "/{seq}/update", method = RequestMethod.GET)
	public String update(@PathVariable("seq") int seq, Model model) {
		MemoVO memoVO = memoService.findById(seq);
		model.addAttribute("MEMOVO", memoVO);
		return "memo/addMemo";
	}

	@RequestMapping(value = "/{seq}/update", method = RequestMethod.POST)
	public String update(MemoVO memoVO, @RequestParam("mfile") MultipartFile file) {
		memoService.updateMemoAndFile(memoVO, file);
		return "redirect:/";
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
