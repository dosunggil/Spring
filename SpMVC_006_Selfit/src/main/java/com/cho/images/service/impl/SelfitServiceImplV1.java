package com.cho.images.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cho.images.config.QualifierConfig;
import com.cho.images.model.StartMenuDTO;
import com.cho.images.persistance.SelfitDao;
import com.cho.images.service.SelfitService;

@Service(QualifierConfig.SERVICE.SELFIT_V1)
public class SelfitServiceImplV1 implements SelfitService {

	protected final SelfitDao selfitDao;

	public SelfitServiceImplV1(SelfitDao dao) {
		this.selfitDao = dao;

	}

	@Override
	public void startPage(Model model) {

		List<StartMenuDTO> startMenus = selfitDao.selectStartMenu();

		List<StartMenuDTO> beginMenus = new ArrayList<>();
		List<StartMenuDTO> middelMenus = new ArrayList<>();
		List<StartMenuDTO> advMenus = new ArrayList<>();

		for (StartMenuDTO dto : startMenus) {
			if (dto.getSc_num().substring(0, 2).equals("01")) {
				beginMenus.add(dto);
			} else if (dto.getSc_num().substring(0, 2).equals("02")) {
				middelMenus.add(dto);
			} else if (dto.getSc_num().substring(0, 2).equals("03")) {
				advMenus.add(dto);
			}
		}
		
		// 각각 메뉴를 MAP 형태의 데이터로 묶어서
		// 한번에 model 에 담기
		Map<String, List<StartMenuDTO>> menuMaps = new HashMap<>();
		menuMaps.put("BEGIN", beginMenus);
		menuMaps.put("MIDDLE", middelMenus);
		menuMaps.put("ADV", advMenus);
		model.addAttribute("MENUMAPS",menuMaps);

	}

	@Override
	public void getDaySetList(Model model, String sc_num) {
		List<StartMenuDTO> daySetList = selfitDao.selectDaySet(sc_num);
		
		model.addAttribute("DAYS",daySetList);
		
	}

}
