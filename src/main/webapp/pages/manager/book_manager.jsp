<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {
            // 给 删除 a 标签绑定单击事件
            // 在事件的 function 函数中，有一个 this 对象，这个 this 对象是当前正在响应事件的 dom 对象
            $("a.deleteClass").click(function () {
                return confirm("您确定要删除《" + $(this).parent().parent().find("td:first").text() + "》这本书吗？")
            });
        });

        $(function () {
            // 给跳转到第 x 页按钮绑定单击事件
            $("#specifiedPage").click(function () {
                let specifiedPageNo = $("#pn_input").val();
                if (specifiedPageNo < 1 || specifiedPageNo > ${requestScope.page.pageTotal}) {
                    alert("您输入的页码数无效，请检查后重新输入");
                    return;
                }
                // JavaScript 语言中提供了一个 location 对象，它的属性 href 可以获取浏览器中的地址，可读可写
                location.href = "manager/bookServlet?action=page&pageNo=" + specifiedPageNo;
            });
        });
    </script>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <%@include file="/pages/common/menu.jsp" %>

</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}">修改</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
        </tr>
    </table>

    <div id="page_nav">
        <br/>

        <c:if test="${requestScope.page.pageNo > 1}">
            <a href="manager/bookServlet?action=page&pageNo=1">首页</a>
            <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
        </c:if>
        <%--        <a href="#">3</a>--%>
        【${requestScope.page.pageNo}】
        <%--        <a href="#">5</a>--%>
        <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
            <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
            <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
        </c:if>
        <br/>
        共&nbsp;${requestScope.page.pageTotal}&nbsp;页,${requestScope.page.recordTotalCount}条记录&nbsp;&nbsp;&nbsp;第<label
            for="pn_input"></label><input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
        <input type="button" value="确定" id="specifiedPage">
    </div>
</div>

<%@include file="/pages/common/footer.jsp" %>

</body>
</html>