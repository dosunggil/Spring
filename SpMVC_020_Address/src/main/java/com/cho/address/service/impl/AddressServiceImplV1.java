package com.cho.address.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cho.address.config.QualifyConfig;
import com.cho.address.model.AddressVO;
import com.cho.address.model.SearchPage;
import com.cho.address.persistence.AddressDao;
import com.cho.address.service.AddressService;

@Service(QualifyConfig.SERVICE.ADDR_V1)
public class AddressServiceImplV1 implements AddressService {

	/*
	 * Service Interface 에서 Dao 를 상속받고 있다.
	 * ServiceImpl 클래스에서 Dao 를 생성자로 주입받는 경우
	 * 생성자에서 오류가 발생하는 경우가 있다. : 무한 반복 주입 오류
	 * 이 오류가 발생하는 경우 생성자 주입 대신 setter 주입으로 변경하면
	 * 오류가 발생하지 않는다.
	 */
	private final AddressDao addrDao;
	public AddressServiceImplV1(AddressDao addrDao) {
		this.addrDao = addrDao;
	}

	@Autowired
	public void table() {
		addrDao.create_addr_table();
	}

	@Override
	public void create_addr_table() {

	}

	@Override
	public List<AddressVO> selectAll() {
	
		return addrDao.selectAll();
	}

	@Override
	public AddressVO findById(long id) {
	
		return  addrDao.findById(id);
	}

	@Override
	public int insert(AddressVO vo) {
		return addrDao.insert(vo);
	}

	@Override
	public int delete(long id) {
		addrDao.delete(id);
		return 0;
	}

	@Override
	public int update(AddressVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AddressVO> searchAndPage(SearchPage searchPage) {
		
		return addrDao.searchAndPage(searchPage);
	}

	/*
	 *	조건에 맞는 데이터를 가져와서
	 *	pagination 을 그리기 위한 SearchPage 클래스의 데이터를 만들 것
	 */
	@Override
	public void searchAndPage(Model model, SearchPage searchPage) {
		
		searchPage.setLimit(addrDao.selectAll().size());
		searchPage.setOffset(0);
		
		// 검색어 조건에 맞는 모든 데이터 가져오기
		List<AddressVO> addrList = addrDao.searchAndPage(searchPage);
		
		long totalCount = addrList.size(); 
		
		//조건에 맞는 데이터가 없으면 중단하기
		if(totalCount <1) return;
		
		// 보여질 데이터 리스트 개수
		searchPage.setListPerPage(10);
		//하단의 페이지 번호 개수
		searchPage.setPageNoCount(10);
		
		// 조건에 맞는 전체 데이터 개수
		searchPage.setTotalCount(totalCount);
		
		long finalPageNo = (totalCount + (searchPage.getListPerPage() - 1)) / searchPage.getListPerPage();
		
		
		if(searchPage.getCurrentPageNo() > finalPageNo)
			searchPage.setCurrentPageNo(finalPageNo);
		
		if(searchPage.getCurrentPageNo() <1) 
			searchPage.setCurrentPageNo(1);
		
		long startPageNo = ((searchPage.getCurrentPageNo()-1) / searchPage.getPageNoCount()) * searchPage.getPageNoCount() +1;
		
		long endPageNo = startPageNo + searchPage.getPageNoCount() -1;
		searchPage.setStartPageNo(startPageNo);
		searchPage.setEndPageNo(endPageNo);
		
		model.addAttribute("PAGE",searchPage);
		
		
	}

}
