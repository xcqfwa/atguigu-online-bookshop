<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            // 给删除购物车中的商品项绑定单击事件
            $("a.deleteItemClass").click(function () {
                return confirm("您确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗？")
            });

            // 给清空购物车绑定单击事件
            $("a.clearItemsClass").click(function () {
                return confirm("您确定要清空购物车吗？")
            });

            // 给修改商品数量输入框绑定内容改变事件 onChange
            $("input.updateCountClass").change(function () {
                // 获取商品名称
                let itemName = $(this).parent().parent().find("td:first").text();
                // 获取商品改变后的数量
                let itemCount = this.value;
                // 获取要修改的商品 id
                let bookId = $(this).attr("bookId");

                if (confirm("您确定要将【" + itemName + "】数量修改为 " + itemCount + " 吗？")) {
                    location.href = "http://localhost:8080/book/cartServlet?action=updateCount&bookId=" + bookId + "&newCount=" + itemCount;
                } else {
                    // defaultValue 属性时表单项 Dom 对象的属性，它表示默认的 value 值
                    this.value = this.defaultValue;
                }
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@ include file="/pages/common/welcome.jsp" %>
</div>

<div id="main">

    <c:if test="${empty sessionScope.cart.items}">
        <h1 href="index.jsp" style="text-align: center; padding: 250px">您的购物车中暂无数据，赶快返回商城浏览商品吧！</h1>
    </c:if>

    <c:if test="${not empty sessionScope.cart.items}">
        <table>
            <tr>
                <th>商品名称</th>
                <th>数量</th>
                <th>单价</th>
                <th>金额</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td><input bookId="${entry.value.id}" class="updateCountClass"
                               style="width: 66px; text-align: center" type="text"
                               value="${entry.value.count}"></td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItemClass" href="cartServlet?action=deleteItem&bookId=${entry.value.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a href="cartServlet?action=clear" class="clearItemsClass">清空购物车</a></span>
            <span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
        </div>
    </c:if>

</div>

<%@include file="/pages/common/footer.jsp" %>

</body>
</html>