package com.cho.address.persistence;

import java.util.List;

import com.cho.address.model.AddressVO;
import com.cho.address.model.SearchPage;

public interface AddressDao {

	public List<AddressVO> selectAll();
	public AddressVO findById(long id);
	public int insert(AddressVO vo);
	public int delete(long id);
	public int update(AddressVO vo);
	public void create_addr_table();
	public List<AddressVO> searchAndPage(SearchPage searchPage);
}
