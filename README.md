# CarSaleApp

####Приложение для размещения объявлений о продаже авто.


#####Для корректной работы программы необходимо:
- Установить DataBase
- Создать в DB таблицу
- Изменить настройки в application.properties для подключения к вашей DB:

  - spring.datasource.url=jdbc:postgresql://localhost/product_app_db
                       
   > > product_app_db  -название вашей базы данных
  
  - spring.datasource.username=postgres    
                                                
  > > postgres -имя пользователя бд
  
  - spring.datasource.password=root   
                                                     
  > > root -пароль для  бд  
             
1) Запустить программу в классе Application
 
2) При переходе на http://localhost:8080 откроется главная страница.
3) На навигационной панели:
  - Если вы не зарегистрированы, либо не был произведен вход при нажатии на "Объявления" произойдет перенаправление на страницу "Аутентификации"

Для корректной работы программы необходимо:

1. Установить DataBase

2. Создать в DB таблицу

3. Изменить настройки в application.properties для подключения к вашей DB:

 - spring.datasource.url=jdbc:postgresql://localhost/product_app_db                              # /product_app_db  -название вашей базы данных
  
 - spring.datasource.username=postgres                                                           # /postgres -имя пользователя бд
 
 - spring.datasource.password=root                                                               # /root -пароль для  бд 
                                                          
#### Запустить программу в классе Application
 
Действия в приложении:

1. При переходе на http://localhost:8080 откроется главная страница.

##### На навигационной панели:

  а) Если вы не зарегистрированы, либо не был произведен вход принажати на "Объявления" произойдет перенаправление на страницу "Аутентификации"

  б) После прохождения "Аутентификация"и Вы перейдете на страницу "Объявления" где сможете добавить новое объявление о продаже авто с возможностью загрузки фото.



Используемые технологии:
- Java
- Spring Framework(Spring Boot JPA, Spring Boot Security, Spring Boot MVC, Spring Boot Mail)
- База данных — PostgresSQL
- Миграция БД - Flyway
- Шаблонизатор - Freemarker.
- Оформление Bootstrap
