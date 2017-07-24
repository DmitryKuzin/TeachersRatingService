<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="stylesheet" href="css/bootstrap.min.css"> -->
    <link rel="stylesheet" media="screen and (min-width: 501px)" href="/css/institutes.css" />
    <link rel="stylesheet" media="screen and (max-width: 500px)" href="/css/institutes-small.css" />
</head>
<body>
<div class="header">Факультеты и институты</div>
<div class="links"> КФУ </div>
<div class="container">
    <#if institutes?has_content>
        <#list institutes as institute>
            <a href="/rating?institute=${institute.id}">
                <div class="institute-card">
                    <div class="card-left">
                        <div class="logo"><img src="/img/img2.jpg" ></div>
                    </div>
                    <div class="card-right">
                        <#if institute.name??>
                            ${institute.name}
                        </#if>
                    </div>
                </div>
            </a>
        </#list>
    </#if>
</div>
</body>
</html>