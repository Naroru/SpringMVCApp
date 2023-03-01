<#import "parts/common.ftlh" as common_macros>
<#import "parts/login.ftlh" as loginForm>

<@common_macros.page>

<div>
<@loginForm.logout />
</div>

    <div>
        <form method="post">
            <input type="text" name="text" placeholder="Enter text"/>
            <input type="text" name="tag" placeholder="Tag"/>
            <#--            <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
            <button type="submit">Add</button>
        </form>
    </div>

    <div>Messages</div>

<#--    форма фильтра сообщений. На мапу "/main" будет послан get запрос, который будет содержать параметр filter ( name="filter" )-->
<#--    контроллер обработает запрос и получит значение через RequestParam-->
<#--    Если фильтр уже установлен, то контроллер поместит в модель аттрибут filter и этот аттрибут ( текущее знач. филтра)-->
<#--    будет выведено в поле потому что  value="${filter} -->
    <form method="get" action="/main">
        <input type="text" name="filter" value="${filter}">
        <button type="submit">Find</button>
    </form>

    <#list messages as message>
        <div>
            <b>${message.id}</b>
            <span>${message.text}</span>
            <i>${message.tag}</i>
        </div>
    <#else>
        No messages
    </#list>

</@common_macros.page>