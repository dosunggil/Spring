package com.cho.score.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cho.score.model.StudentVO;
import com.cho.score.service.StudentService;

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
@RestController
@RequestMapping(value = "/api")
public class APIController {

	private final StudentService stService;

	public APIController(StudentService stService) {
		this.stService = stService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<StudentVO> student() {
		return stService.selectAll();
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