package com.cho.school.pesistance;

import java.util.List;

/*
 * Dao 와 Service interface 에서 공통으로 구현할 interface 를 만든다.
 * 
 * 이 interface 는 2개의 Generic type 을 가진다.
 * 일단 VO와 PK 라는 이름으로 Generic type 을 선언해두었다.
 * 
 * 이 interface 를 상속하는 Dao 나 Service interface 에서 
 * 자신이 사용할 VO class type 과 PK 데이터 type 을 지정해준다.
 * 
 * 이 Generic Interface 를 사용함으로써 
 * Dao 나 Service interface 에서는 공통으로 구현할 method 를
 * 매번 작성하는 수고를 덜 수있다.
 */
public interface GenericDao<VO, PK> {

	public List<VO> selectAll();
	public VO findByID(PK id);
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK id);
}
