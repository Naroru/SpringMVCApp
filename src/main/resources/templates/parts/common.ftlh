
<#--Создаем макрос, который будет использоваться в других страницах-->
<#--То есть это общий кусок кода для всех-->
<#--Макрос начинается <#macro имяМакроса  параметр>-->
<#--внутри вложенный макрос <#nested> - в него будет попадать код. см greeting.ftlh-->
<#--см раздел crating library-->
<#--https://freemarker.apache.org/docs/dgui_misc_namespace.html-->
<#--и nested content-->
<#--https://freemarker.apache.org/docs/dgui_misc_userdefdir.html-->

<#macro page>
<#--   перечисляем общий код, который будет вставляться в другие страницы при использовании макро -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My spring MVC App</title>
</head>

<body>
<#--сюда будет вставлять уникальный код из других страниц-->
<#nested>
</body>

</html>
</#macro>