<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="2.1" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	xmlns:adk="http://www.aggrepoint.com/adk">
	<jsp:directive.tag dynamic-attributes="attrMap" language="java" pageEncoding="UTF-8" />
	<jsp:directive.attribute name="name" required="true" />
	<jsp:directive.attribute name="object" required="false" type="java.lang.Object"/>
	<jsp:directive.attribute name="property" required="false" />
	<jsp:directive.attribute name="checked" required="false" />
	<jsp:directive.attribute name="value" required="true" />
	<jsp:directive.attribute name="disabled" required="false" type="java.lang.Object" />
	<jsp:directive.attribute name="fdisabled" required="false" type="java.lang.Object" />
	<jsp:directive.attribute name="validate" required="false" />

	<adk:getinput var="inp" type="checkbox" name="${name}" object="${object}" property="${property}" value="${checked eq 'checked'}" disabled="${disabled}" validate="${validate}">
		<adk:inputattr name="value" value="${value}" />

		<jsp:doBody />
	</adk:getinput>

	<adk:element elm="input">
		<adk:attr name="type" value="checkbox" />
		<adk:attr name="name" value="${name}" />
		<adk:attr name="value" value="${value}" />
		<adk:attr name="checked" value="checked" test="${inp.value}" />
		<adk:attr name="validate" value="yes" test="${not empty validate}" />
		<adk:attr name="disabled" value="disabled" test="${inp.disabled || fdisabled}" />

		<c:forEach var="attr" items="${attrMap}">
			<adk:attr name="${attr.key}" value="${attr.value}" />
	    </c:forEach>
	</adk:element>
</jsp:root>