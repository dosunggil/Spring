function resize(e) {
  e.style.height = "1px";
  e.style.height = 12 + e.scrollHeight + "px";
}

function setThumbnail(event) {
  for (var image of event.target.files) {
    var reader = new FileReader();

    reader.onload = function (event) {
      const img = document.querySelector("img.img-img");
      img.setAttribute("src", event.target.result);
      document.querySelector("div.img-box").appendChild(img);
    };
    reader.readAsDataURL(image);
  }
}

function AAA(SEQ) {
  if (!confirm("정말 삭제할까요?")) {
    return false;
  } else {
    document.location.href = `${rootPath}/memo/${SEQ}/delete`;
  }
}
