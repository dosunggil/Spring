# 성적 프로젝트
* SpMVC_030_Score

## DB 연결
* MySQL schooDB
## table
* tbl_student, tbl_score, tbl_subject
## DB 연결을 위한 Dependency 설정
* Spring-jdbc
* commons-dbcp2
* mybatis
* mybatis-spring
* mysql-connector/J
* spring-framework : 5.2.22.REL
* lombok
* logback-classic

## Student 정보 요청
* /student 로 요청을 하면 학생데이터 전체를 JSON 웹 화면에 보여주는 코드 작성
* StudentController 에 @ResponseBody 부착된 home() method 선언
* StudentService.selectAll()
* StudentDao.selectAll()
* Student-mapper.xml.selectAll


## thymeleaf 를 이용한 view 구현
* Spring 에서 JSP 가 아닌 html 파일 방식으로 화면 구현하기
* JSP 는 STS 나 Spring 을 지원하는 Tool에서만 파일을 편집할 수 있다.
* thymeleaf 는 HTML 과 tag 의 속성을 사용하여 데이터를 표현하는 방법이기 때문에 다른 HTML 편집 도구를 사용하여 파일을 편집할 수 있다.
* 데이터를 화면에 rendering 하기 위하여 JSP 에서는 ELtag 를 직접 사용하여 화면에 표시되도록 하지만, thymeleaf 는 tag 내에서 th:text 라는 속성을 사용하여 표현한다. 이런 방식으로 데이터를 표현하면 디자이너와 개발자가 효율적으로 협업을 할 수 있다.
* 데이터를 표현하는데, 단축형 코드를 지원하여 좀 더 간결한 코드를 사용할 수 있다.

## 기본 문법
* 데이터 표현하기 : th:text="${변수}"
* 반복문 표현하기 : th:each="요소 : ${리스트}"
* 변수 단축하기 : th:object=${변수} => 변수의 요소들 : "(별){요소}"
* URL 표헌하기 : th:href="@{주소}", th:src="@{주소}"
* rootPath : /*[[@{/}]]*/
* data 속성 : th:attr="data-변수명=${값변수명}"
* if 문
```
<div th:if="${변수 == 3}">
	여기는 변수 == 3 값이 true 일때 표현되는 영역
</div>
<span th:if="${변수.equal('재직중')}">재직중</span>
```

* if else 문
```
<span th:if="${변수 == 3}" th:text="${변수}"></span>
<span th:unless="${변수 ==4}" th:text="값 오류"></span>
```

## thymeleaf layout dialect 
* thymeleaf Template 을 사용하여 화면 layout 을 구현하기 위한 도구
* thymeleaf 에서는 공식적으로 지원하는 layout 구현 도구가 없어서 외부의 도구를 사용한다.
```
<!-- https://mvnrepository.com/artifact/nz.net.ultraq.thymeleaf/thymeleaf-layout-dialect -->
<dependency>
    <groupId>nz.net.ultraq.thymeleaf</groupId>
    <artifactId>thymeleaf-layout-dialect</artifactId>
    <version>3.1.0</version>
</dependency>
```


## thymeleaf 에서 파일 연결하기
* th:include : 파일을 합성하여 완전히 한 파일로 생성 : Controller 에서 model 에 담아 보낸 변수를 모두가 공유가능.
* th:insert : 현재 tag 의 내부에 끼워넣기
* th:replace : 현재 tag 를 지우고 대체하기




