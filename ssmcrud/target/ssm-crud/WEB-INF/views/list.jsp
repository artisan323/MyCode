<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%
        application.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link href="${APP_PATH}/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-2.js"></script>

</head>
<body>
    <div class="container">
        <%--标题栏--%>
        <div class="row"></div>
            <div class="col-md-12">
                <h1>SSM-CRUD</h1>
            </div>

        <%--新增删除按钮--%>
        <div class="row">
            <div class="col-md-4 col-md-offset-8">
                <button class="btn btn-primary">新增</button>
                <button class="btn btn-danger">删除</button>
            </div>
        </div>

            <%--表格--%>
        <div class="row"></div>
            <div class="col-md-12">
                <table class="table table-hover">
                    <tr>
                        <th>#</th>
                        <th>empName</th>
                        <th>gender</th>
                        <th>email</th>
                        <th>deptName</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="emp">
                        <tr>
                            <th>${emp.emoId}</th>
                            <th>${emp.empName}</th>
                            <th>${emp.gender == "M" ? "男" : "女"}</th>
                            <th>${emp.email}</th>
                            <th>${emp.department.deptName}</th>
                            <th>
                                <button class="btn btn-primary btn-sm">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
                                </button>
                                <button class="btn btn-danger btn-sm">
                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
                                </button>
                            </th>
                        </tr>
                    </c:forEach>
                </table>
            </div>



            <%--分页--%>
        <div class="row">
            <div class="col-md-6">
               当前${pageInfo.pageNum}页，总${pageInfo.pages}页，总${pageInfo.total}条记录
            </div>
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">

                        <li><a href="/emps?pn=1">首页</a></li>

                        <%--如果有上一页，可以继续点--%>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <li>
                                <a href="/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                            <c:if test="${page_num == pageInfo.pageNum}">
                                <li class="active"><a href="#">${page_num}</a> </li>
                            </c:if>
                            <c:if test="${page_num != pageInfo.pageNum}">
                                <li><a href="/emps?pn=${page_num}">${page_num}</a> </li>
                            </c:if>
                        </c:forEach>

                        <%--如果有下一页，显示下一页--%>
                        <c:if test="${pageInfo.hasNextPage}">
                            <li>
                                <a href="/emps?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>


                        <li><a href="/emps?pn=${pageInfo.pages}">尾页</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</body>
</html>
