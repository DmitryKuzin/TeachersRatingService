<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="stylesheet" href="css/bootstrap.min.css"> -->
    <link rel="stylesheet" media="screen and (min-width: 501px)" href="/css/teachers.css" />
    <link rel="stylesheet" media="screen and (max-width: 500px)" href="/css/teachers-small.css" />
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/teachers.js"></script>
</head>
<body>
<div class="header">Преподаватели</div>
<div class="links"><a href="/institutes">КФУ</a> \ ${institute.name?upper_case}</div>
<div class="container">
<#if teachersRatings?has_content>
    <#list teachersRatings as teacher>
        <a href="#teacher-window-1" class="open-modal" data-teacher-id="${teacher.id}">
            <div class="teacher-card">
                <div class="card-left">
                    <div class="logo"><img src="/img/${teacher.imagePath}" class="teacher-img"></div>
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
                    <br>
                    <#if teacher.voteAmount?? && teacher.rating??>
                        <#if teacher.voteAmount gt 0>
                            Рейтинг: ${teacher.rating}<br>
                            Голосов: ${teacher.voteAmount}
                        <#else >
                            Голосов: 0
                        </#if>
                    <#else>
                        Голосов: 0
                    </#if>
                </div>
            </div>
        </a>
    </#list>
</#if>
</div>
<a href="#x" class="overlay" id="teacher-window-1"></a>
<div class="popup">
    <div class="header">Оценка</div>
    <div class="card">
        <div class="card-left">
            <div class="logo"><img src="/img/img3.jpg" class="teacher-img"></div>
        </div>
        <div class="card-right"> Саламатин <br> Андрей <br> Николаевич
            <br> <h4 class="undertitle">профессор кафедры <br> прикладной математики</h4></div>
    </div>
    <div class="rating">
        <form id="teacher-rate" action="/vote" method="post">
            <fieldset class="form-options">
                <legend class="form-question"> Оцените работу преподавателя </legend>
                <div class="form-answer"><input type="radio" name="rate" id="rate_1" value="1" required> 1 </div>
                <div class="form-answer"><input type="radio" name="rate" id="rate_2" value="2" > 2 </div>
                <div class="form-answer"><input type="radio" name="rate" id="rate_3" value="3" > 3 </div>
                <div class="form-answer"><input type="radio" name="rate" id="rate_4" value="4" > 4 </div>
                <div class="form-answer"><input type="radio" name="rate" id="rate_5" value="5" > 5 </div>
                <input type="hidden" name="teacherId" value="">
            </fieldset>
            <button type="submit" class="form-button">
                ОТПРАВИТЬ
            </button>
        </form>
    </div>
    <a class="close" id="close-button" title="Закрыть" href="#close"></a>
</div>
</body>
</html>