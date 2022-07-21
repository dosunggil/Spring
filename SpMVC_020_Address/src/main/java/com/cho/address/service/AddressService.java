package com.cho.address.service;

import org.springframework.ui.Model;

import com.cho.address.model.SearchPage;
import com.cho.address.persistence.AddressDao;

public interface AddressService extends AddressDao {
	
	public void searchAndPage (Model model, SearchPage searchPage) ;

}
