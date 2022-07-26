package com.cho.score.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cho.score.model.StudentVO;
import com.cho.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

/*
 * @Controller 클래스는 request(요청) 에 대하여 보통 view(.jsp) 파일을
 * rendering 하여 response(응답) 하도록 설계하는 Router 클래스이다.
 * 
 * 이 클래스에서 @ResponseBody 를 부착하면 view 를 response 하는 대신에
 * 직접 문자열을 전송하거나 객체(List,VO) 를 JSON type 으로 response 하도록
 * method 에 적용을 한다.
 * 
 * @RestController 클래스는 request 에 대해서 기본값으로
 * JSON 을 Response 하도록 설계하는 Router 클래스이다.
 * 
 * 모든 method 에 마치 @ResponseBody 가 부착된것처럼 작동을 한다.
 * Spring RestController 를 통하여 JSON 데이터를 response 하기 위해서는
 * JackBind Dependency 가 거의 필수적으로 요구된다.
 * 
 * RestController 는 view 를 rendering 하지 않는다.
 */
// CORS 오류로 인한 문제를 서버차원에서 개발하여 처리하기
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000", "http://192.168.0.*:3000"})
@RestController
@RequestMapping(value = "/api/student")
@Slf4j
public class APIStudentController {

	private final StudentService stService;

	public APIStudentController(StudentService stService) {
		this.stService = stService;
	}

	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public List<StudentVO> student() {
		return stService.selectAll();
	}
	
	@RequestMapping(value="/{st_num}/check",method=RequestMethod.GET)
	public String stNumCheck(@PathVariable("st_num") String st_num) {
		StudentVO stVO = stService.findById(st_num);
		// 전달받은 학번을 조회해봤더니 없더라
		if(stVO == null) {
			return "OK";
		} else {
			return "FAIL";
		}
	}
	@RequestMapping(value="/{st_num}",method=RequestMethod.GET)
	public StudentVO getStudent(@PathVariable("st_num") String st_num ) {
		return stService.findById(st_num);
		
	}
	

	/*
	 * Client 에서 fetch, Ajax 데이터를 POST 로 보낼떄
	 * 데이터를 Serialize (직렬화) 하여 body 에 담아서 전송을 한다.
	 * 
	 * Serialize 된 POST body 에 담긴 데이터를 Controller 에서 VO 에 받을때는
	 * 반드시 @RequestBody 속성을 추가해야 한다.
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@RequestBody StudentVO stVO) {
		log.debug(stVO.toString() + "여기입니다");
		int ret = stService.insert(stVO);
		if(ret>0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestBody StudentVO stVO) {
		log.debug(stVO.toString() + "여기입니다");
		int ret = stService.update(stVO);
		if(ret>0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}
	/*
	 * api/student/학번/delete 로 요청을 했을 때 학번에 해당하는 학생의 데이터를 삭제할 수 있도록 method 작성
	 */

	@RequestMapping(value = "/{num}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("num") String num) {
		int ret = stService.delete(num);
		if (ret > 0) {
			return "OK";
		} else {
			return "FAIL";

		}

	}
}