document.addEventListener("DOMContentLoaded", () => {
    const memo_table = document.querySelector("table.memo-list");
    const memo_drop =  document.querySelector("div.memo-drop");
    const add_memo = document.querySelector("div.btn-addMemo");
    const update = document.querySelector("div.btn-Update");

    update?.addEventListener("click", (e) => {  
        console.log("수정버튼누름")   
        const seq = update.dataset.seq;
        fetch(`${rootPath}/memo/${seq}/update`)
        .then((res) => res.text())
        .then((result) => {
          memo_drop.style.display = "block";
          memo_drop.innerHTML = "null";
          memo_drop.innerHTML = result;
        });
      })
   

    add_memo?.addEventListener("click", (e) => {     
         console.log("추가버튼누름") 
        fetch(`${rootPath}/memo/addMemo`)
        .then((res) => res.text())
        .then((result) => {
          memo_drop.style.display = "block";
          memo_drop.innerHTML = "null";
          memo_drop.innerHTML = result;
        });
      })


    memo_table?.addEventListener("click", (e) => {
        const td = e.target;
        if ((td.tagName === "TD")||(td.tagName==="DIV")) {
          const tr = td.closest("TR");
          const seq = tr.dataset.seq;
      
          fetch(`${rootPath}/memo/${seq}/update`)
          .then((res) => res.text())
          .then((result) => {
            memo_drop.style.display = "block";
            memo_drop.innerHTML = "null";
            memo_drop.innerHTML = result;
          });
        }
    });
      
});
  