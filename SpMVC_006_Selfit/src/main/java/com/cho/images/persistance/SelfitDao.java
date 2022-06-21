package com.cho.images.persistance;

import java.util.List;

import com.cho.images.model.StartMenuDTO;
import com.cho.images.model.WorkOutDTO;

public interface SelfitDao {

	public List<WorkOutDTO> workOutView();
	public List<StartMenuDTO> selectStartMenu();
	public List<StartMenuDTO> selectDaySet(String sc_num);
	
	public List<StartMenuDTO> selectByScNum(String sc_num);
}
