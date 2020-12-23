<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-1 col-form-label">Имя :</label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="Имя" />
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-1 col-form-label">Пароль:</label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="Пароль" />
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit"><#if isRegisterForm>Создать<#else>Вход</#if></button>
            <br>
        <#if !isRegisterForm><a href="/registration">Регистрация</a></#if>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Выход</button>
    </form>
</#macro>