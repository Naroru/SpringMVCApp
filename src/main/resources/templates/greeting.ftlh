<#--импорт макроса-->
<#import "parts/common.ftlh" as common_macros>

<#--начало макроса. common_macros - это синоним файла parts/common.ftlh". Там мы используем имя page для макроса. Поэтому @common_macros.page> -->
<@common_macros.page>

<#--    все что между началом и концом макроса - будет вставлено в него в макрос #nested. То есть вставиться вместо строки <#nested> -->
    <div> Hello, user!</div>
    <a href="/main">Main page</a>

<#--    конец макроса-->
</@common_macros.page>