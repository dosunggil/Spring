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