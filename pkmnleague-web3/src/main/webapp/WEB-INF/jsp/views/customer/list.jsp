<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:layout title="Customer">
<jsp:attribute name="body">
    
    <table class="table table-bordered">
        <tr>
            <th>1</th>
            <th>2</th>
            <th>3</th>
            <th></th>
        </tr>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td class="col-xs-1"><c:out value="${customer.name}"/></td>
                <td class="col-xs-2"><c:out value="${customer.surname}"/></td>
                <td class="col-xs-2"><c:out value="${customer.ICO}"/></td>
                <td class="col-xs-2">
                    <a href="${pageContext.request.contextPath}/customer/edit/${customer.id_customer}" class="btn btn-sm btn-primary"><i class="fa fa-pencil"></i>Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    
</jsp:attribute>
</my:layout>