<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>结账</title>
    <%@include file="/pages/common/head.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <%@ include file="/pages/common/back.jsp" %>
</div>

<div id="main">
    <h1 style="text-align: center;margin-top: 200px">你的订单已结算，订单号为：${sessionScope.orderId}</h1>
</div>

<%@include file="/pages/common/footer.jsp" %>

</body>
</html>