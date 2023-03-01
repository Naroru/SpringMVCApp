<#--импорт макроса-->
<#import "parts/common.ftlh" as common_macros>
<#import "parts/login.ftlh" as loginForm>
<#--начало макроса. common_macros - это синоним файла parts/common.ftlh". Там мы используем имя page для макроса. Поэтому @common_macros.page> -->
<@common_macros.page>

<#--    вызвали макрос parts/login.ftlh и в качестве параметра path передали "/login"-->
    <@loginForm.userForm "/login" />

    <a href="/registration">Add new user</a>

</@common_macros.page>