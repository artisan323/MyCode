
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax流程</title>
    <script type="text/javascript">
        function getData() {
            //创建ajax引擎对象
            var ajax;
            if (window.XMLHttpRequest){
                ajax = new XMLHttpRequest();
            }else if (window.ActiveXObject) {
                ajax = new ActiveXObject("Msxml2.XMLHTTP");
            }
            //复写onreadystatement函数
            ajax.onreadystatechange = function () {
                //判断ajax的状态码
                if (ajax.readyState == 4){
                    //判断响应状态码
                    if (ajax.status == 200){
                        //获取响应内容
                        var result = ajax.responseText;
                        //获取元素对象
                        var div = document.getElementById("showdiv");
                        div.innerHTML = result;
                    }else if (ajax.status == 404){
                        var div = document.getElementById("showdiv");
                        div.innerHTML = "请求资源不存在";
                    }else if (ajax.status == 500){
                        var div = document.getElementById("showdiv");
                        div.innerHTML = "服务器繁忙";
                    }
                }else{
                    var div = document.getElementById("showdiv");
                    div.innerHTML = "<img src='img/jiazai.jpg' width='290px' height='290px'>";
                }
            }
            //发送请求 默认异步
            ajax.open("get", "ajaxServlet");
            ajax.send(null);
            //post方式
            // ajax.open("post", "ajaxServlet");
            // ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            // ajax.send("uname=张三&pwd=123");
        }
    </script>
    <style type="text/css">
        #showdiv{
            width: 300px;
            height: 300px;
            border: solid 1px;
        }
    </style>
</head>
<body>
    <input type="button" value="测试" onclick="getData()">
    <div id="showdiv">

    </div>
</body>
</html>
