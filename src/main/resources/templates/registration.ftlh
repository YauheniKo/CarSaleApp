<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    Add new user
    ${message!""} <!--message это ключ из класса RegistrationController метода addUser,
    а символ Восклицательный знак - это дефолт значение,
    на которое будет ссылаться .ftlh, если не задан
    параметр message. Иначе будет ошибка  -->
    <@l.login "/registration" />
</@c.page>





