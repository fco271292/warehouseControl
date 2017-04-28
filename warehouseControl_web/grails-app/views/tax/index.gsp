<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tax.label', default: 'Impuesto')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-tax" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-tax" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="input-group">
                            <input type="text" name="searchTax" id="searchTax" placeholder="Impuesto" class="form-control">
                            <span class="input-group-btn">
                                <button id="btnsearchTax" class="btn btn-secondary" onclick="filterItems('tableTax','searchTax')">Buscar</button>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <table id="tableTax">
                <thead>
                    <tr>
                        <g:sortableColumn property="description" title="Descripción" />
                        <g:sortableColumn property="amount" title="Cantidad" />
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${taxList}" var="taxInstance">
                        <tr>
                            <td><g:link action="show" id="${taxInstance.id}">${taxInstance.description}</g:link></td>
                            <td>${taxInstance.amount}</td>
                        </tr>
                    </g:each>
                </tbody>
            </table>

            <div class="pagination">
                <g:paginate total="${taxCount ?: 0}" />
            </div>
        </div>
        <asset:javascript src="searchTable.js"/>
    </body>
</html>