<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- <link rel="stylesheet" href="css/style.css"> -->
    <link rel="stylesheet" media="screen and (max-width: 500px)" href="/css/login-small.css" />
    <link rel="stylesheet" media="screen and (min-width: 501px)" href="/css/login-big.css" />
</head>
<body>
<div class="container">
    <div class="name">Авторизация</div>
    <div class="login-panel">
        <form action="/authenticate">
            <#if Session.SPRING_SECURITY_LAST_EXCEPTION?? && Session.SPRING_SECURITY_LAST_EXCEPTION.message?has_content>
                ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
            </#if>
            <input type="text" name="username" placeholder="Имя пользователя" class="invisible-input">
            <div class="divider"></div>
            <input type="password" name="password" class="invisible-input" placeholder="Введите пароль" id="pass"  >
            <div class="divider"></div>
            <div id="in-button"><button id="invisible-btn"></button>войти</div>
            <a href="#" class="cannot-login-a">Не удается войти?</a>
        </form>
    </div>
</div>
</body>
</html>