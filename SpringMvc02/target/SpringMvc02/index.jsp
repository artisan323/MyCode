<%--
  Created by IntelliJ IDEA.
  User: wannengqingnian
  Date: 2019/5/24
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="demo4" method="post">
    <input type="text" name="name"><br />
    <input type="text" name="pass"><br />
    唱<input type="checkbox" name="hover" value="唱"/>
    跳<input type="checkbox" name="hover" value="跳"/>
    rap<input type="checkbox" name="hover" value="rap"/>
    篮球<input type="checkbox" name="hover" value="篮球"><br />
    <input type="submit" value="提交">
</form>

<a href="demo5/zmx/123">跳转</a>
<a href="demo6" >重定向</a><br />
<a href="demo7" >跳转到demo7传统方式获取json</a>
<a href="demo8" >使用新方式传回json数值</a>
</body>
</html>
