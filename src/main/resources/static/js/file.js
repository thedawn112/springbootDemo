//是否提供相关的文件
function getFileList() {
    let n = 0;
    for (let i = 0; i < 100; i++) {
        n = i + 1;
        $("#fileTable").append("<tr><th>" + n + "</th><th>Mark</th><th>Otto</th><th>@mod</th><th><button>提交</button></th></tr>")
    }
}
//加载页面的时候执行此函数
$().ready(function () {
    getFileList();
});