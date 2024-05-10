### Отчет по итогам тестирования.

#### Описание: 

Автоматизированы позитивные и негативные сценарии сервиса покупки тура взаимодействующие с СУБД и API банка. 

#### Количество тест-кейсов:

* Общее количество тест-кейсов для обеих СУБД - 54 шт

#### Статистика тест-кейсов:

#### MySQL

* Успешные кейсы 64,81% (35 Tests);
* Неуспешных кейсов 35,19% (19 Tests);
<details>
   <summary>Report</summary>

![1](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/eac441e6-7e63-417d-9a2e-c46e3d5436ac)
![2](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/5ab88819-4d09-42d1-be4f-3e228feab1cf)
![FireShot Capture 065 - Allure Report - 172 17 64 1](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/a482b845-e836-449c-b622-959028ed76c5)

</details>

#### PostgreSQL

* Успешные кейсы 64,81% (35 Tests);
* Неуспешных кейсов 35,19% (19 Tests);
<details>
   <summary>Report</summary>

  ![Screenshot_1](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/fa0dcc87-c3c2-452d-921b-20463eceac40)
![Screenshot_2](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/111a6df3-8abb-4271-93fb-4b7bbd78468d)
![FireShot Capture 066 - Allure Report - 172 17 64 1](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/d01a6974-a60e-440c-b1c7-71acc38c84f5)

</details>

#### Общие рекомендации:

* Исправить орфографические ошибки на странице.
* Кнопки "Купить" и "Купить в кредит" не подсвечивать красным до выбора/клика посетителя сайта. По той же логике "Продолжить".
* В Базе данных при покупке с карты, снимается 4_500_000, вместо 45_000.
