document.addEventListener("DOMContentLoaded", () => {
  const table = document.querySelector("TABLE");

  // 현재 DOM 화면에 있는 모든 TD 들을 가져와서
  // 모든 TD 들에 click event 를 부착하기
  /*   const tds = document.querySelectorAll("TD");
  for (let i = 0; i, tds.length; i++) {
    tds[i].addEventListener("click", () => {
      alert(tds[i].innerText);
    });
  }
 */
  /*
  이 스크립트가 실행되는 DOM 화면에 table tag 가 있으면 if() {} 코드를 실행하고
  없으면 건너 뛰어라.
  만약 이 스크립트가 실행되는 DOM 화면에 table tag 가 없으면
  변수 table 에는 undefined 가 담기게 된다.
  (== false)
  */
  if (table) {
    table.addEventListener("click", (e) => {
      const target = e.target;
      const text = target.innerText;
      const className = target.className;
      const stNum = target.dataset.num;

      if (className === "name") {
        document.location.href = "/school/student/detail?stNum=" + stNum;
      }
    });
  }
});
