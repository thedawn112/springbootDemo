//注册
$("#register_button").click(function () {
    var userName = document.getElementById("inputUserName").value;
    var passWord = document.getElementById("inputPassword").valueOf();
    var ErrorInfo = null;
    passWord = sha1(passWord);
    var data = "userName=" + userName + "&passWord=" + passWord;
    if (userName != null && passWord != null) {
        let xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.open("GET", "/ranmao/registerIn?" + data, true);
        xmlHttpRequest.send();
    }
});