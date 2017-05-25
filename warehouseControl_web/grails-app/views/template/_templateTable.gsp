<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>

		<div class="container">

            <div class="row">
                <div class="col-lg-12">
                	<div class="input-group">
                    	<span class="input-group-addon">Buscar</span>
                    	<input type="text" name="searchText" id="searchText" placeholder="${placeholder}" class="form-control"/>
                    </div>        
                </div>
            </div>

			<table id="table">
                <thead>
                    <tr>
                    	<g:each in="${headers}" var="header">
                        	<g:sortableColumn property="${header}" title="${header}" />
                        </g:each>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${objectList}" var="objectInstance">
                        <tr>
                        	<g:each in="${properties}" var="${property}">
	                            <td>
	                            	<g:link action="show" id="${objectInstance.id}">${objectInstance[property]}</g:link>
	                            </td>
	                            <!--<td>${objectInstance[property]}</td>-->
                            </g:each>
                        </tr>
                    </g:each>
                </tbody>
            </table>

		</div>

		<asset:javascript src="/bower/jquery/jquery.min.js" />
		<asset:javascript src="/bower/datatables.net/jquery.dataTables.js" />
		<asset:javascript src="/bower/datatables.net-bs/js/dataTables.bootstrap.min.js" />
		<asset:javascript src="dataTable.js"/>

	</body>
</html>