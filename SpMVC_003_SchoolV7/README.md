# form 과 button 관계

```
<form>
	<input>
	<button type="submit">
</form>
```

* 위와 같이 form tag 에 포함된 button 은 기본 타입이 ```submit``` 이다.

* button type 이 ```submit``` 인 경우 form tag 에 포함된 input 의 값을 무조건 서버로 전송하는 event 가 실행된다.
* 만약 button 을 클릭했을 때 js코드를 사용하여 상황을 제어하고 싶으면 button 의 type 을 ```button```으로 설정한다.
* button type 을 ```button``` 으로 설정하면 모양만 button 이고 아무런 역할을 수행하지 못한다.
* button type 에는 ```reset``` 도 있는데 이 type 은 form tag 에 포함된 input tag 의 데이터를 모두 삭제한다.

# 2022-05-30 Password 암호화하기.
* spring-security-core 가져오기
```
<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-core -->
<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-core</artifactId>
			<version>5.3.13.RELEASE</version>
</dependency>
```
* spring/appServlet/security-context.xml 파일 생성하기.
```
<bean id ="passwordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder">
		<constructor-arg index="0" value="4"/>
</bean>
```
* PasswordEncoder 를 상속받은 BCryptPasswordEncoder 클래스를 사용하여 bean 선언
* 이때 생성자에 설정한 value 값에 따라 내부에서 암호화 반복이 수행된다.
* 이 값은 4 이상의 정수로 설정한다. (: default = 4)