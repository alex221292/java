<%-- 
    Document   : index
    Created on : 05.08.2014, 18:13:52
    Author     : Алексей
--%>

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
                        <a href="page?id=${article.studentPK.studentId}">
                            <h1>${article.fio}</h1>
                        </a>
                    </article>
                </td>
                <td>${article.groupNum}</td>
            </tr>
            </c:forEach>
            <c:out value="${tests}"></c:out>
    </table>
</div>