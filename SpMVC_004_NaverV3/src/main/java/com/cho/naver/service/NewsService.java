package com.cho.naver.service;

import com.cho.naver.persistance.NewsDao;

/*
 * Serivce 의 기능도 기본적으로 Dao 와 같이 5가지 CRUD 가 필요하고
 * 경우에 따라 별도의 method 가 추가될 수 있다.
 * 
 * Service 도 GenericDao 를 상속받아 사용할 수있다.
 * 
 * 하지만 NewsDao 에 새롭게 추가한 method 가 있는데
 * GenericDao 를 상속받으면 새롭게 추가한 method 를 다시 구현해야한다.
 * 이럴때는 GenericDao 대신 NewDao 를 상속받는다.
 */
public interface NewsService extends NewsDao{

}
