### Отчет по итогам тестирования.

#### Описание: 

Автоматизированы позитивные и негативные сценарии сервиса покупки тура взаимодействующие с СУБД и API банка. 

#### Количество тест-кейсов:

* Общее количество тест-кейсов для обеих СУБД - 54 шт

#### Статистика тест-кейсов:

#### MySQL

* Успешные кейсы 66,66% (36 Tests);
* Неуспешных кейсов 33,33% (18 Tests);
<details>
   <summary>Report</summary>

![Screenshot_3](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/2170f0ba-fb6c-4fea-a0d5-213ab77a14f6)
![Screenshot_4](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/1efce660-e78e-4089-a85b-3b67da37c76d)
![FireShot Capture 064 - Allure Report - 172 17 64 1](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/1f2e7033-3cbb-4088-adbb-ed6596b0e6f9)

</details>

#### PostgreSQL

* Успешные кейсы 62,96% (34 Tests);
* Неуспешных кейсов 37,03% (20 Tests);
<details>
   <summary>Report</summary>

   ![Screenshot_1](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/33b33929-3220-46cd-9652-426fa2d391bc)
![Screenshot_2](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/e3152a04-b87d-430b-acd6-69f68705244a)
![FireShot Capture 063 - Allure Report - 172 17 64 1](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/b9b5e832-3600-48ce-94f6-945894ad1d68)

</details>

#### Общие рекомендации:

* Исправить орфографические ошибки на странице.
* Кнопки "Купить" и "Купить в кредит" не подсвечивать красным до выбора/клика посетителя сайта. По той же логике "Продолжить".
* В Базе данных при покупке с карты, снимается 4_500_000, вместо 45_000.
