<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Warehouse</title>

    <asset:link rel="icon" href="caduceus-medical-symbol.svg" type="image/x-ico" />
</head>
<body>
    <content tag="nav">
        
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>
                <li><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>
                <li><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>
                <li><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>
            </ul>
        </li>
        
    </content>

    <div class="svg" role="presentation">
        <div class="grails-logo-container">
            <asset:image src="price-tag.svg" class="grails-logo"/>
        </div>
    </div>

    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1></h1>

            <p></p>

            <div id="controllers" role="navigation">
                <ul class="nav nav-pills">
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller">
                            <li role="presentation">
                                <g:link controller="${c.logicalPropertyName}">${c.name}</g:link>
                            </li>
                        </li>
                    </g:each>
                </ul>
            </div>
        </section>
    </div>

</body>
</html>
