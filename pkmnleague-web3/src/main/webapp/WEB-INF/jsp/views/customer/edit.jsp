<%-- 
    Document   : edit
    Created on : 18.12.2015, 23:15:05
    Author     : olda
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:layout title="Edit customer">
<jsp:attribute name="body">

       <c:if test="${not empty alert_failure}">
           <div class="alert alert-danger" role="alert"><c:out value="${alert_failure}"/></div>
       </c:if>

<form:form method="post" action="${pageContext.request.contextPath}/customer/edit" modelAttribute="editCustomer" cssClass="form-horizontal">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="hidden" name="id" value="${editCustomer.id_customer}"/>

    <div class="form-group">
        <form:label path="name" cssClass="col-sm-2 control-label">Name</form:label>
        <div class="col-sm-10">
            <form:input path="name" id="name" cssClass="form-control"/>
            <form:errors path="name" cssClass="error"/>
        </div>        
        <form:label path="surname" cssClass="col-sm-2 control-label">Sur Name</form:label>
        <div class="col-sm-10">
            <form:input path="surname" id="surname" cssClass="form-control"/>
            <form:errors path="surname" cssClass="error"/>
        </div>        
        <form:label path="dateOfBirth" cssClass="col-sm-2 control-label">Date</form:label>
        <div class="col-sm-10">
            <form:input path="dateOfBirth" id="date" cssClass="form-control"/>
            <form:errors path="dateOfBirth" cssClass="error"/>
        </div>        
        <form:label path="id_address.city" cssClass="col-sm-2 control-label">City</form:label>
        <div class="col-sm-10">
            <form:input path="id_address.city" id="address" cssClass="form-control"/>
            <form:errors path="id_address.city" cssClass="error"/>
        </div>        
        <form:label path="id_address.street" cssClass="col-sm-2 control-label">Street</form:label>
        <div class="col-sm-10">
            <form:input path="id_address.street" id="street" cssClass="form-control"/>
            <form:errors path="id_address.street" cssClass="error"/>
        </div>        
        <form:label path="id_address.houseNumber" cssClass="col-sm-2 control-label">House number</form:label>
        <div class="col-sm-10">
            <form:input path="id_address.houseNumber" id="houseNumber" cssClass="form-control"/>
            <form:errors path="id_address.houseNumber" cssClass="error"/>
        </div>        
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" value="Save" class="btn btn-primary">
        </div>
    </div>

</form:form>
</jsp:attribute>
</my:layout>