<%--
  Created by IntelliJ IDEA.
  User: SpringBear
  Date: 2022/3/3
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
    </c:if>

    <%-- 设置页码显示范围 --%>
    <c:choose>
        <%-- 情况 1：如果总页码小于等于 5 ，页码显示范围是 1 - 总页码 --%>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>
        <%-- 情况 2：总页码数大于 5 --%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <%-- 子情况 1：当前页码为前 3 页，则页码显示范围为 1-5 页 --%>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%-- 子情况 2：当前页码为末 3 页，则页码显示范围为末 5 页 --%>
                <c:when test="${requestScope.page.pageNo >= requestScope.page.pageTotal - 2}">
                    <c:set var="begin" value="${requestScope.page.pageTotal - 4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>
                <%-- 其余情况：页码显示范围为 pageTotal-2 到 pageTotal+2 --%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo - 2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo + 2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

    <%-- 逐个输出页码 --%>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <%-- 设置当前页码不可点击 --%>
        <c:if test="${i == requestScope.page.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.page.pageNo}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>
    <%-- 页码显示结束 --%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共&nbsp;${requestScope.page.pageTotal}&nbsp;页 共 ${requestScope.page.recordTotalCount} 条记录&nbsp;&nbsp;&nbsp;第<label
        for="pn_input"></label><input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
    <input type="button" value="确定" id="specifiedPage">
</div>