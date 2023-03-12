<#import "parts/common.ftlh" as common_macros>
<#import "parts/login.ftlh" as loginForm>

<@common_macros.page>

<#--    переменная, которая будет заполнена из модели (map в контроллере)-->
<#--    Если сообщения нет, то будет ""-->
    ${message! ""}
    <@loginForm.login "/registration" />

</@common_macros.page>