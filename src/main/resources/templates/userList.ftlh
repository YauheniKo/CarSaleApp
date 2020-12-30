<#import "parts/common.ftlh" as c>

<@c.page>
    Список пользователей
    <div class="container">
    <table class="table table-bordered">
    <thead>
    <tr>

        <th с>Имя</th>
        <th>Роль</th>
        <th>Действие</th>

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
    </div>
</@c.page>