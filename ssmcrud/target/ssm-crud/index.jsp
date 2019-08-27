<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%
        application.setAttribute("APP_PATH", request.getContextPath());
    %>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-2.js"></script>
    <link href="${APP_PATH}/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap/js/bootstrap.js"></script>

</head>
<body>


<!-- 新增模态框 -->
<div class="modal fade" id="empAndModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>
            <form class="form-horizontal" method="post">

                <div class="form-group">
                    <label class="col-sm-2 control-label">empName</label>
                    <div class="col-sm-9">
                        <input type="text" name="empName" class="form-control" id="add_empName" placeholder="empName">
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-2 control-label">email</label>
                    <div class="col-sm-9">
                        <input type="text" name="email" class="form-control" id="add_email" placeholder="email">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">gender</label>
                    <div class="col-sm-9">
                        <label class="radio-inline">
                            <input type="radio" name="gender" id="add_gender1" value="M"> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="gender" id="add_gender2" value="F"> 女
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">deptName</label>
                    <div class="col-sm-5">
                        <select class="form-control" name="dId">

                        </select>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="emp_save">保存</button>
                </div>

            </form>
        </div>
    </div>
</div>


<div class="container">
    <%--标题栏--%>
    <div class="row"></div>
    <div class="col-md-12">
        <h1>SSM-CRUD</h1>
    </div>

    <%--新增删除按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary" id="emp_add_model">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>

    <%--表格--%>
    <div class="row"></div>
    <div class="col-md-12">
        <table class="table table-hover" id="emp_table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>

    <%--分页--%>
    <div class="row">
        <div class="col-md-6" id="page_info_area"></div>
        <div class="col-md-6" id="page_nav_area"></div>
    </div>
</div>
<script type="text/javascript">

    //定义一个记录总记录数变量
    var totalRecord;

    //页面加载完成后，直接发一个ajax请求， 获取数据
    $(function () {

        //一开始加载去首页
       to_page(1);
    });

    //选择去哪一页
    function to_page(pn) {
        $.ajax({
            url : "${APP_PATH}/emps",
            data : "pn="+pn,
            type : "GET",
            success : function (result) {
                //显示表格信息
                build_emps_table(result);
                //显示总共多少页
                build_page_info(result);
                //显示分页
                build_page_nav(result);
            }
        });
    }

    //显示表格
    function build_emps_table(result) {
        //每次加载页面都要先清空原理来数据
        $("#emp_table tbody").empty();
        var emps = result.extend.pageInfo.list;
        $.each(emps, function (index, item) {
            var id = $("<td></td>").append(item.emoId);
            var empName = $("<td></td>").append(item.empName);
            var gender = $("<td></td>").append(item.gender == "M"?"男":"女");
            var email = $("<td></td>").append(item.email);
            var deptName = $("<td></td>").append(item.department.deptName);

            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");

            var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm")
                    .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");


            $("<tr></tr>").append(id).append(empName).append(gender)
                .append(email).append(deptName).append(editBtn).append(delBtn)
                .appendTo("#emp_table tbody");
        });
    }

    //显示页数信息
    function build_page_info(result) {
        $("#page_info_area").empty();
        var page = result.extend.pageInfo;
        $("#page_info_area").append("当前"+ page.pageNum +"页，总" + page.pages +"页，总" + page.total +"条记录")
        totalRecord = page.total;
    }

    //显示分页信息
    function build_page_nav(result) {

        $("#page_nav_area").empty();

        var nav = result.extend.pageInfo;
        var ul = $("<ul></ul>").addClass("pagination");

        var firstpage = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prepage = $("<li></li>").append($("<a></a>").append("&laquo;"));

        //判断前一页和首页是否能点击
        if (nav.hasPreviousPage == false){
            firstpage.addClass("disabled");
            prepage.addClass("disabled");
        }else{
            //为首页和前一页添加点击事件
            firstpage.click(function () {
                to_page(1);
            });
            prepage.click(function () {
                to_page(nav.pageNum - 1);
            });
        }

        var nextpage = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastpage = $("<li></li>").append($("<a></a>").append("尾页").attr("href", "#"));

        //判断下一页和尾页是否可以点击
        if (nav.hasNextPage == false){
            nextpage.addClass("disabled");
            lastpage.addClass("disabled");
        }else {
            //为尾页和下一页添加点击事件
            lastpage.click(function () {
                to_page(nav.pages);
            });
            nextpage.click(function () {
                to_page(nav.pageNum + 1);
            });
        }



        ul.append(firstpage).append(prepage);
        $.each(nav.navigatepageNums, function (index, item) {
            var numli = $("<li></li>").append($("<a></a>").append(item));
            if(nav.pageNum == item){
                numli.addClass("active");
            }

            numli.click(function () {
               to_page(item);
            });

            ul.append(numli);
        });
        ul.append(nextpage).append(lastpage);

        var navpage = $("<nav></nav>").append(ul);
        navpage.appendTo("#page_nav_area");

    }


    //显示模态框
    $("#emp_add_model").click(function () {

        //发送ajax请求，查出部门信息，添加在下拉列表
        getDepts();
        //弹出模态框
        $('#empAndModal').modal({
            backdrop:"static"
        });
    });

    //查出部门信息方法
    function getDepts() {
        $.ajax({
            url:"${APP_PATH}/depts",
            type:"GET",
            success:function (result) {
                console.log(result);
                $.each(result.extend.depts, function () {
                   var optionEle = $("<option></option>").append(this.deptName).attr("value", this.depyId);
                   optionEle.appendTo("#empAndModal select")
                });
            }
        });
    }


    //验证数据
    function validate_add_from(){
        //拿到数据
        var empName = $("#add_empName").val();

        //使用正则表达式验证用户名
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        if (!regName.test(empName)){
            alert("用户名为2-5为位中文或6-16位中文数字组合");
            return false;
        }

        //验证邮箱
        var email = $("#add_email").val();
        var regEmail = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
        if (!regEmail.test(email)) {
            alert("邮箱格式错误");
            return false;
        }

        return true;
    }

    //保存添加的数据
    $("#emp_save").click(function () {
        //判断输入信息是否正确
        if (!validate_add_from()){
            return false;
        }

        //正确后添加数据库
        $.ajax({
            url:"${APP_PATH}/emp",
            type:"POST",
            data:$("#empAndModal form").serialize(),
            success:function (result) {
                //显示添加成功信息
                alert(result.msg);
                //关闭模态框
                $("#empAndModal").modal('hide');
                //跳转到最后一页
                to_page(totalRecord);
            }
        })
    });

</script>
</body>
</html>
