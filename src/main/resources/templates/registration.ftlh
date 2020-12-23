<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div class="mb-1">Добавить нового пользователя</div>
    ${message!""} <!--message это ключ из класса RegistrationController метода addUser,
    а символ Восклицательный знак - это дефолт значение,
    на которое будет ссылаться .ftlh, если не задан
    параметр message. Иначе будет ошибка  -->
    <@l.login "/registration" true/>
</@c.page>





