<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <div>
        <@l.logout />
        <span><a href="/user" >User list</a></span>
    </div>
    <div>
        <form method="post" enctype="multipart/form-data" action="/main">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="text" name="text" placeholder="Введите сообщение">
            <input type="text" name="tag" placeholder="Тэг">
            <input type="text" name="brand" placeholder="Брэнад авто">
            <input type="text" name="mod" placeholder="Модель авто">
            <input type="text" name="year" placeholder="Год выпуска">
            <input type="text" name="bodyType" placeholder="Тип кузова">
            <input type="text" name="transmission" placeholder="Коробка передач">
            <input type="text" name="typeOfDrive" placeholder="Тип привода">
            <input type="text" name="fuel" placeholder="Тип топлива">
            <input type="text" name="volume" placeholder="Объём двигателя">
            <input type="text" name="price" placeholder="Цена">

            <input type="file" name="file">
            <br><br>

            <button type="submit"> Добавить</button>
            <br> <br>
        </form>
    </div>


        <form method="get" action="/main">
            <div>Поиск по "Тэг"</div>
            <input type="text" name="filter" value="${filter!""}" >
            <div>Поиск по "Брэнд авто"</div>
            <input type="text" name="filter1" value="${filter1!""}">
        <button type="submit">Найти</button>
    </form>

    <#list ads as ad>
        <div>
            <b>${ad.id}</b>
            <span>${ad.text}</span>
            <i>${ad.tag}</i>
            <span>
                <#list ad.listInfoCar() as list>${list}<#sep>, </#list>
           </span>
            <strong>${ad.authorName}</strong>
        </div>
        <div>
            <#if ad.filename??>
                <img src="/img/${ad.filename}"
            </#if>
        </div>
    <#else>
        No ads
    </#list>
</@c.page>