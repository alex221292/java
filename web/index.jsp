<%-- 
    Document   : index
    Created on : 05.08.2014, 18:13:52
    Author     : Алексей
--%>

<%@page import="Session.Session1.Infostud"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="main">
    <%--<c:out value="${test}" /><--%>
    <table border="0">
        <thead>
            <tr>
                <td>Студент</td>
                <td>Группа</td>
            </tr> 
        </thead>
        <c:forEach var="article" items="${articles}">
            <tr><td>
                    <article>
                            <h1>${article.fio}</h1>
                    </article>
                </td>
                <td>
                    <article>
                    <h1>${article.group}</h1>
                    </article>
                </td>
            </tr>
            </c:forEach>
            <c:out value="${tests}"></c:out>
            <form action="Servlet1">
                <input type="submit" name="test">
            </form>
    </table>
</div>