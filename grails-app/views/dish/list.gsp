
<%@ page import="order.Dish" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <link href="http://ajax.googleapis.com/ajax/libs/yui/2.8.0r4/build/reset-fonts-grids/reset-fonts-grids.css" media="screen" rel="stylesheet" type="text/css" /> 
        <g:set var="entityName" value="${message(code: 'dish.label', default: 'Dish')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script> 
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/yui/2.8.0r4/build/yuiloader-dom-event/yuiloader-dom-event.js"></script> 
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <!--
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'dish.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'dish.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="price" title="${message(code: 'dish.price.label', default: 'Price')}" />
                        
                            <g:sortableColumn property="tips" title="${message(code: 'dish.tips.label', default: 'Tips')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${dishInstanceList}" status="i" var="dishInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${dishInstance.id}">${fieldValue(bean: dishInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: dishInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: dishInstance, field: "price")}</td>
                        
                            <td>${fieldValue(bean: dishInstance, field: "tips")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${dishInstanceTotal}" />
            </div>
        -->
        <script type="text/javascript">
        yuiloader_insert('', function(){});
        </script>
        </div> 
    </body>
</html>
