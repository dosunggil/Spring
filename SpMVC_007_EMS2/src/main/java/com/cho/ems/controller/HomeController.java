package com.cho.ems.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cho.ems.config.QualifyConfig;
import com.cho.ems.model.EmsVO;
import com.cho.ems.service.SendMailService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class HomeController {
	
	@Value("#{naver['naver.username']}")
	private String naver_username;
	
	@Value("#{app['my.app']}")
	private String myApp;
	
	@Autowired
	private StandardPBEStringEncryptor pbEnc;
	
	@Autowired
	@Qualifier(QualifyConfig.SERVICE.MAIL_V1)
	private SendMailService xMail;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute("emsVO") EmsVO emsVO, Model model) {
		
		
		
		Pattern PATT_BLACKET = Pattern.compile("\\([^\\(\\)]+\\)");
		Matcher matcher = PATT_BLACKET.matcher(naver_username);
		if(matcher.find()) {
			int startIndex = matcher.start();
			int endIndex = matcher.end();
			String findText = naver_username.substring(startIndex + 1 , endIndex -1);
			String user = pbEnc.decrypt(findText);
			log.debug("NaverUser {}",user);
		}
		
		log.debug("Naver User Name {}", naver_username);
		log.debug("App Name {}", myApp);
		
		
		model.addAttribute("emsVO", emsVO);
		return "home";
	}
	
	
	/*
	 * @Valid : vo(dto) 클래스에 유효성 검사 코드를 추가해 두고
	 * form 으로 부터 데이터가 전송되어 오면 자체적으로 검사를 수행한다.
	 * 
	 * 만약 VO 에 설정된 유효성 검사가 하나라도 통과하지 못하면
	 * result 객체에 오류메세지가 포함되어
	 * .hasErrors 는 true 를 반환한다.
	 * 
	 * @Valid 와 BindingResult 는 순서를 바꾸면 안된다.
	 * 
	 * 보통 파일 업로드를 받을때는 파일 정보를 수신할 매개변수에
	 * @RequestParam() 을 사용한다.
	 * 
	 * 하지만 여러 파일을 수신하는
	 * MultipartHttpServletReequest 를 매개변수로 사용할 때는
	 * 절대 @RequestParam() 을 사용하면 안된다.
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String home(@Valid EmsVO emsVO, BindingResult result,@RequestParam("file") MultipartFile sfile)  {
		
		if(result.hasErrors()) {
			return "home";
		}
		xMail.sendMail(emsVO);
		return "redirect:/";
	}
	
	/*
	 * @RequestParam()
	 * 1. client 에서 보내는 변수와 실제 사용하는 변수의 이름이 다를 경우
	 * 2. 매개변수가 숫자형일때 client 에서 변수에 값을 담지 않고 요청을 하면
	 * 		내부 오류가 발생한다. 이때 required 를 false 로 설정하고
	 * 		defaultValue 를 설정하면 오류를 방지할 수 있다.
	 */
	@ResponseBody
	@RequestMapping(value="/num", method=RequestMethod.GET)
	public String num(@RequestParam(name="num", required = false, defaultValue = "0") Integer numValue, BindingResult result) {
		
		int sum = numValue + 100;
		return  "sum : "+sum;
		
	}
	
	
	@ModelAttribute("emsVO")
	private EmsVO emsVO() {
		return new EmsVO();
	}
	
}
