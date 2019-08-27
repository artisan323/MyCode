<%--
  Created by IntelliJ IDEA.
  User: wannengqingnian
  Date: 2019/5/12
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>英雄联盟商店</title>
    <script type="text/javascript">
        function getData() {
            //创建ajax引擎对象\
            var name = document.getElementById("name").value;
            if (name != "赵信"){
                alert("请输入赵信");
            }
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
                        eval("var obj = " + result);
                        //获取元素对象
                        var div = document.getElementById("showdiv");
                        div.innerHTML = obj.id + obj.name + obj.location;
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
            ajax.open("get", "FindServlet?name=" + name);
            ajax.send(null);

        }
    </script>
    <style type="text/css">
        #showdiv{
            border : solid 2px;
            width: 300px;
            height: 300px;
        }
    </style>
</head>
<body>
    <h2>英雄联盟商店</h2>
    <hr />
    请输入:<input type="text" id="name"><input type="button" value="搜索" onclick="getData()">
    <div id="showdiv"></div>
</body>
</html>
