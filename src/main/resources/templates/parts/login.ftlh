
<#--здесь используем параметр path. Значение в него будет подставляться при вызове макроса -->
<#--в формах мы укажем чему равен path-->

<#macro userForm path>

    <form action="${path}" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
<#--           <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
        <div><input type="submit" value="Sign In"/></div>
    </form>

</#macro>

<#macro logout>
    <form method="post">
        <form action="/logout" method="post">
            <input type="submit" value="Sign Out"/>
<#--            <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
        </form>
    </form>
</#macro>
