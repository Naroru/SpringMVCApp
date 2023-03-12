<#import "parts/common.ftlh" as common_macros>
<#import "parts/login.ftlh" as loginForm>

<@common_macros.page>

    List of users

<table>

    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>

    <tbody>
    <#list users as user>

        <tr>

            <td>${user.username}</td>

            <td>
                <#list  user.roles as role>
                    ${role} <#sep>,
                </#list>
            </td>

<#--            Ссылки используют гет метод. В гет методе данные храняться в URL. В данной строке ссылка будет иметь значение  /user/id_пользователя-->
<#--            В Контроллере мы будем принимать этот параметр, ток мы будем принимать не id, а сразу User, т.к. спринг автоматом может преобразовать-->
            <td><a href="/users/${user.id}">edit</a></td>

        </tr>
    </#list>
    </tbody>

</table>

</@common_macros.page>