$("#login_buttun").click(function () {
    var LoginName = document.getElementById("login_name").value;
    var LoginPassword = document.getElementById("login_password").value;
    var ErrorInfo = null;
    //如果登录名或登录密码为空时，不允许登录
    if (LoginName == null || LoginPassword == null) {
        alert("密码不能为空");
    } else if (LoginName.length >= 20 || LoginName.length <= 6) {
        alert("登录名称的数量不符合要求，请在6到20个字符之内")
    } else {
        var data = "username=" + LoginName + "&password=" + LoginPassword;
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "/ranmao/loginIn?" + data, true);
        xhttp.send();
    }
});
//获取登录界面
$("#register_button").click(function () {
    window.location.href="../ranmao/register.html";
    return false;
});

function getRegisterPage() {
    document.getElementById("center-panel-form").innerHTML = "<h1>haha</h1>"
};