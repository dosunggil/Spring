document.addEventListener("DOMContentLoaded", () => {
  const id_check = document.querySelector("button.id-check");
  const join_btn = document.querySelector("button.join");
  const join_form = document.querySelector("form.join");

  const index = {
    username: 0,
    password: 1,
    re_password: 2,
    name: 3,
    email: 4,
  };

  // form.join 내부에 있는 모든 input 태그
  // querySelectorAll 을 사용하면 tag 요소들을 배열로 가져온다.
  const inputList = document.querySelectorAll("form.join input");

  // inputList 에는 0번 요소부터 4번 요소까지 form 태그에 작성된 순서대로 담겨있다.
  // index 객체에서 각 요소의 첨자를 가져오고
  // 첨자를 사용하여 input tag 를 각 순서대로 변수에 담겠다.
  const username = inputList[index.username];
  const password = inputList[index.password];
  const re_password = inputList[index.re_password];
  const name = inputList[index.name];
  const email = inputList[index.email];

  const username_msg = document.querySelector("div.username");

  // join button 클릭

  const username_isBlank = () => {
    username_msg.innerText = "* USER NAME 을 입력해주세요.";
    username_msg.classList.remove("ok");
    // div.username 항목에 warn 이라는 class 를 덧붙여라.
    username_msg.classList.add("warn");
    username.focus();
    return false;
  };

  if (join_btn) {
    join_btn.addEventListener("click", () => {
      if (username.value === "") {
        username_isBlank();
        return false;
      }

      if (password.value === "") {
        alert("비밀번호를 입력해주세요");
        password.focus();
        return false;
      }
      if (re_password.value === "") {
        alert("비밀번호 확인을 입력해주세요");
        re_password.focus();
        return false;
      }
      if (password.value !== re_password.value) {
        alert("비밀번호를 다시 확인해주세요");
        password.value = "";
        re_password.value = "";
        password.focus();
        return false;
      }

      // 유효성 검사 종료
      // form 에 담긴 데이터를 서버로 전송한다.
      join_form.submit();
    });
  }

  if (id_check) {
    id_check.addEventListener("click", () => {
      if (username.value === "") {
        username_isBlank();
        return false;
      } //end if

      // URL, PathVarriable 방식으로 데이터(검사하고자 하는 username)를 전송하기
      // REST Full 방식이라고 한다
      // localhost:8080/school/user/idcheck/callor 로 요청하기
      fetch(
        `${rootPath}/user/idcheck/${username.value}?username=${username.value}`
      )
        .then((res) => {
          console.table(index);
          console.table(res);
          return res.text();
        })
        .then((result) => {
          if (result === "OK") {
            username_msg.classList.remove("warn");
            username_msg.classList.add("ok");
            username_msg.innerText = " * 사용할 수 있는 USER NAME 입니다.";
          } else {
            username_msg.classList.remove("ok");
            username_msg.classList.add("warn");
            username_msg.innerText = " * 사용중인 USER NAME 입니다.";
          }
        });
    });
  }
});
