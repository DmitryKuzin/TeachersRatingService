<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="stylesheet" href="css/bootstrap.min.css"> -->
    <link rel="stylesheet" media="screen and (min-width: 501px)" href="/resources/css/institutes.css"/>
    <link rel="stylesheet" media="screen and (max-width: 500px)" href="/resources/css/institutes-small.css"/>
</head>
<body>
<div class="header">Факультеты и институты</div>
<div class="links"> <a href="/institutes">КФУ</a> \ ${institute.name?upper_case} </div>
<div class="container">
<#if studentGroups?has_content>
    <#list studentGroups as studentGroup>
        <a href="/institutes/${institute.id}/groups/${studentGroup.id}/teachers">
            <div class="institute-card">
                <div class="card-left">
                    <div class="logo"><img src="/resources/img/img2.jpg"></div>
                </div>
                <div class="card-right">
                    <#if studentGroup.groupNumber??>
                        ${studentGroup.groupNumber}
                    </#if>
                </div>
            </div>
        </a>
    </#list>
</#if>
</div>
</body>
</html>