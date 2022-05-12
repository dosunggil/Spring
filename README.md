# STS 프로젝트

### 2022-04-29
* 메이븐 user setting 에서, .m2 가 자주 깨지니 새로운 경로에 repository 생성 (깃허브 settings)
* 메이븐리파지토리에서 oracle 검색 -> https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc8/21.5.0.0
가장 최신 버전 다운 해서
* sts 프로젝트의 porm.xml 에서 servlet 위에 붙여넣기
* 롬복을 sts 에 연동하기
* 구글에 lombok 검색해서 detools 에 다운받기 -> detools 폴더에서 "여기서 명령창 열기" (쉬프트 우클릭)
* 명령어 java -jar lombok.jar  -> 롬복 인스톨러
* specify location 에서 sts3 경로 찾아서 sts3.exe 선택 -> install/update
* sts.ini 서브라임텍스트로 열어보면 마지막에 lombok이 추가되어있다.
* sts3 를 종료 후 재실행해주고
* 메이븐리파지토리에서 lombok 검색ㅎ하고 가장 최신 들어가서 방금 추가한 오라클 아래 붙여넣기

* 저장하여 sts 업데이트 하고, 프로젝트 내의 java 에서 domain 클래스 (VO 클래스) 에 가서 변수 선언 아래 모두 삭제하고, 클래스 위에 @Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
하나씩 import 해주기 
==> 롬복이 생성자 관련한 코드를 대신 해준다.

# Spring MVC 프로젝트

## :cat:[Spring Mybatis Project](https://github.com/dosunggil/Spring/tree/master/SpMVC_003_SchoolV5)
* Spring 과 Mybatis 를 사용한 DBMS 연동 프로젝트

# mybatis-context 설정하기 (Spring 에 DB 연결 작업)
* [링크](https://github.com/dosunggil/Spring/tree/master/SpMVC_003_SchoolV6)
