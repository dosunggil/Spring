document.addEventListener("DOMContentLoaded", () => {
  const memo_table = document.querySelector("table.memo-list");

  memo_table?.addEventListener("click", (e) => {
    console.log("클릭");
    const td = e.target;

    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const seq = tr.dataset.seq;
      // alert(isbn);
      document.location.href = `${rootPath}/memo/${seq}/detail`;
    }
  });
});
