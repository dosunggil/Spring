document.addEventListener("DOMContentLoaded", () => {
  const book_table = document.querySelector("table.list2");

  /*
    이벤트 버블링을 역 이용한 이벤트 처리
    table tag 에 click event 를 설정하고
    매개변수(e)를 받는다.
    이 매개변수는 클릭된 요소들에 대한 정보를 가지고 있다.
    매개변수의 속성들 중에 target 속성은
    가장 안쪽에 위치한 클릭된 tag 에 대한 정보를 가지고있다.
    만약 클릭된 tag 가 td 라면 자신(td)를 감싸고 있는 가장 가까운 요소인
    tr tag 정보를 요청한다.
  */
  book_table?.addEventListener("click", (e) => {
    console.log("클릭");
    const td = e.target;
    /*
        TD 가 클릭이 되면, 자기의 부모중에 TR 을 찾아라
    */
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const isbn = tr.dataset.isbn;
      // alert(isbn);
      document.location.href = `${rootPath}/books/${isbn}/detail`;
    }
  });
});
