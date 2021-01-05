<#import "parts/common.ftlh" as c>

<@c.page>
    <a class="btn btn-primary mb-2" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить новое объявление
    </a>
    <div class="collapse <#if message??>show</#if>" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if ad??>${ad.text}</#if>" name="text" placeholder="Введите сообщение" />
                    <#if textError??>
                        <div class="invalid-feedback">
                            ${textError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="tag" placeholder="Тэг">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="brand" placeholder="Брэнад авто">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="mod" placeholder="Модель авто">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="year" placeholder="Год выпуска">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="bodyType" placeholder="Тип кузова">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="transmission" placeholder="Коробка передач">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="typeOfDrive" placeholder="Тип привода">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="fuel" placeholder="Тип топлива">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="volume" placeholder="Объём двигателя">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="price" placeholder="Цена">
                </div>
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">Добавить файл</label>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить объявление</button>
                </div>
            </form>
        </div>
    </div>

    <div class="form row">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter"  class="form-control"  value="${filter!""}" placeholder="Поиск по Тэг">
                <input type="text" name="filter1"  class="form-control"  value="${filter1!""}"placeholder="Поиск по Брэнд">
                <button type="submit" class="btn btn-primary ml-2">Найти</button>
            </form>
        </div>
    </div>

    <div class="card-columns">
        <#list ads as ad>
            <div class="card my-3">

                <#if ad.filename??>
                <div class="card-footer text-muted">
                    <img src="/img/${ad.filename}" class="card-img-top">
                </div>
                </#if>

            <div class="m-2">
                <span>${ad.text}</span>
                <i>${ad.tag}</i>
                <span>
                <#list ad.listInfoCar() as list>${list}<#sep>, </#list>
                </span>
            </div>

                <div class="card-footer text-muted">

                    ${ad.authorName}
                </div>
            </div>
        <#else>
            Нет объявлений по данному запросу
        </#list>
    </div>
</@c.page>