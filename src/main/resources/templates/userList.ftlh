<#import "parts/common.ftlh" as c>

<@c.page>
    Список пользователей
<table>
    <thead>
    <tr>
        <th>Имя</th>
        <th>Роль</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/user/${user.id}">изменить</a> </td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>