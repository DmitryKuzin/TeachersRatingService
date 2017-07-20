<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="stylesheet" href="css/bootstrap.min.css"> -->
    <link rel="stylesheet" media="screen and (min-width: 501px)" href="/resources/css/teachers.css"/>
    <link rel="stylesheet" media="screen and (max-width: 500px)" href="/resources/css/teachers-small.css"/>
</head>
<body>
<div class="header">Преподаватели</div>
<div class="links"><a href="/institutes">КФУ</a> \ <a href="/institutes/${institute.id}/groups">${institute.name?upper_case}</a> \ ${group.groupNumber}</div>
<div class="container">
    <#if teachers?has_content>
        <#list teachers as teacher>
            <a href="/vote/teachers/${teacher.id}">
                <div class="teacher-card">
                    <div class="card-left">
                        <div class="logo"><img src="/resources/img/${teacher.imagePath}" class="teacher-img"></div>
                    </div>
                    <div class="card-right">
                        <#if teacher.lastName??>
                            ${teacher.lastName}
                        </#if>
                        <br>
                        <#if teacher.firstName??>
                            ${teacher.firstName}
                        </#if>
                        <br>
                        <#if teacher.patronymic??>
                            ${teacher.patronymic}
                        </#if>
                    </div>
                </div>
            </a>
        </#list>
    </#if>
</div>
</body>
</html>