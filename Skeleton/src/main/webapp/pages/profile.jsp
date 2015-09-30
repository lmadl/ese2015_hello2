<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<table class = "default">
  <tr>
    <th>id</th>
    <th>first name</th>
    <th>last name</th>
    <th>email</th>
    <th>team name</th>
  </tr>
  <tr>
    <td><c:out value="${user.id}"/></td>
    <td><c:out value="${user.firstName}"/></td>
    <td><c:out value="${user.lastName}"/></td>
    <td><c:out value="${user.email}"/></td>
    <td><c:out value="${user.team}"/></td>
  </tr>
</table>


	<c:if test="${page_error != null }">
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <h4>Error!</h4>
                ${page_error}
        </div>
    </c:if>


<c:import url="template/footer.jsp" />