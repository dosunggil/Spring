# tiles 를 사용한 JSP Layout 만들기
* view page(JSP) 의 header, size, footer 등을 include 처리하여 Layout 을 구성하는 도구
* JSP page ```<%@ include file="..." %> ``` 형식으로 JSP 파일을 서로 연결하여 Layout 을 구성하는데 성능상 이슈들이 있고, JSP 파일들이 많아지면 관리가 다소 불편해진다.
* 이러한 단점을 극복하고자 사용하는 Layout 도구

* 필요한 Dependency 설정
```
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-jsp</artifactId>
			<version>3.0.8</version>
		</dependency>

		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-extras</artifactId>
			<version>3.0.8</version>
		</dependency>
```