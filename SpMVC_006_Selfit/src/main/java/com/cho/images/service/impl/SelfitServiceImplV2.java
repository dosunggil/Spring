package com.cho.images.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cho.images.config.QualifierConfig;
import com.cho.images.model.StartMenuDTO;
import com.cho.images.model.WorkOutDTO;
import com.cho.images.persistance.SelfitDao;

@Service(QualifierConfig.SERVICE.SELFIT_V2)
public class SelfitServiceImplV2 extends SelfitServiceImplV1 {

	public SelfitServiceImplV2(SelfitDao selfitDao) {
		super(selfitDao);
	}

	@Override
	public void startPage(Model model) {

		List<StartMenuDTO> beginMenus = selfitDao.selectByScNum("01");
		List<StartMenuDTO> middelMenus = selfitDao.selectByScNum("02");
		List<StartMenuDTO> advMenus = selfitDao.selectByScNum("03");

		model.addAttribute("BEGIN", beginMenus);
		model.addAttribute("MIDDLE", middelMenus);
		model.addAttribute("ADV", advMenus);
	}

	@Override
	public void getDaySetList(Model model, String sc_num) {
		super.getDaySetList(model, sc_num);
		List<StartMenuDTO> dayList = (List<StartMenuDTO>) model.getAttribute("DAYS");
		String sc_id = dayList.get(0).getSc_id();

		
		// sc_id 를 매개변수로 전달하여 view_workout 의 데이터를 가져오기
	//	List<WorkOutDTO> workList = selfitDao.selectWorkOut(sc_id);

	}

}
