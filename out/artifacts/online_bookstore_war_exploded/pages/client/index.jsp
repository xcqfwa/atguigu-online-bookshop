<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚书房</title>

    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            // 给加入购物车按钮绑定单击事件
            $("button.addToCart").click(function () {
                if (${empty sessionScope.user}) {
                    alert("请您先进行登录！");
                    return;
                }
                // 将 this 对象转换为 jQuery 对象并调用获取其指定元素的值
                let bookId = $(this).attr("bookId");
                location.href = "${basePath}cartServlet?action=addItem&bookId=" + bookId;
            });

            // 给跳转到第 x 页按钮绑定单击事件
            $("#specifiedPage").click(function () {
                let specifiedPageNo = $("#pn_input").val();
                if (specifiedPageNo < 1 || specifiedPageNo > ${requestScope.page.pageTotal}) {
                    alert("您输入的页码数无效，请检查后重新输入");
                    return;
                }
                $("#min").val(${param.min});
                $("#max").val(${param.max});

                // JavaScript 语言中提供了一个 location 对象，它的属性 href 可以获取浏览器中的地址，可读可写
                location.href = "client/bookServlet?action=pageByPrice&min=" + ${param.min}+"&max=" + ${param.max}+"&pageNo=" + specifiedPageNo;
            });
        });
    </script>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">

    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/register.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span class="um_span">欢迎 ${sessionScope.user.username} 登录！</span>
            <a href="pages/cart/cart.jsp">购物车</a>
            <a href="manage/bookServlet?action=page">图书管理</a>
            <a href="userServlet?action=logout">退出登录</a>&nbsp;&nbsp;
        </c:if>
    </div>

</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/bookServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice">
                价格：<label for="min"></label><input id="min" type="text" name="min" value="${param.min}"/> 元 -
                <label for="max"></label><input id="max" type="text" name="max" value="${param.max}"/> 元
                <input type="submit" value="查询"/>
            </form>
        </div>

            <c:if test="${empty sessionScope.cart.items}">
                <%-- 购物车为空 --%>
                <div style="text-align: center">
                    <div>
                        <span style="color: red">当前购物车为空</span>
                    </div>
                </div>
            </c:if>
            <c:if test="${not empty sessionScope.cart.items}">
                <div style="text-align: center">
                    <span>您的购物车中有 ${sessionScope.cart.totalCount} 件商品</span>
                    <div>
                        您刚刚将<span style="color: red">${sessionScope.lastAddName}</span>加入到了购物车中
                    </div>
                </div>
            </c:if>

        <%-- 输出图书信息 --%>
        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">

                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}"/>
                </div>

                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button class="addToCart" bookId="${book.id}">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <%-- 静态包含引入分页条 --%>
    <%@include file="/pages/common/page_nav.jsp" %>

</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>