<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <!-- <link rel="stylesheet" href="css/style.css"> -->
    <link rel="stylesheet" media="screen and (max-width: 500px)" href="/resources/css/login-small.css"/>
    <link rel="stylesheet" media="screen and (min-width: 501px)" href="/resources/css/login-big.css"/>
</head>
<body>
<div class="container">
    <div class="name">Авторизация</div>
    <div class="login-panel">
    <#if error??>
    ${error}
        Вы можете <a href="https://registationserv.herokuapp.com">зарегистрироваться</a>
    </#if>
        <form action="/authenticate" method="post">
            <input type="text" name="phone" placeholder="Номер телефона" class="invisible-input">
            <div class="divider"></div>
            <input type="password" name="password" class="invisible-input" placeholder="Введите пароль" id="pass"  >
            <div class="divider"></div>
            <input class="btn" id="in-button" type="submit" value="войти"/>
            <a href="#" class="cannot-login-a">Не удается войти?</a>
        </form>
    </div>
</div>
</body>
</html>