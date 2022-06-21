package com.cho.ems.persistance;

import com.cho.ems.model.EmsVO;

public interface EmsDao extends GenericDao<EmsVO, Long>{
	
	public void create_ems_table();

	
}
