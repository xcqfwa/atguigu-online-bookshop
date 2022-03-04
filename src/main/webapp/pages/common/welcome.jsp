<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/1
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    <a href="index.jsp">返回商城</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
</div>
