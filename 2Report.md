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

![1](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/dd8c6611-b107-4c92-835f-2a3d6529744c)
![2](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/1bb094eb-c49f-44ea-aa74-da9fc5b25924)
![FireShot Capture 048 - Allure Report - 172 17 64 1](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/0d683278-5556-4348-a509-8c6e344d4ef8)


</details>

#### PostgreSQL

* Успешные кейсы 66,66% (34 Tests);
* Неуспешных кейсов 33,33% (18 Tests);
<details>
   <summary>Report</summary>

![Screenshot_5](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/d550cb10-80b1-46bc-80bb-76b59bc92d36)
![Screenshot_1](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/e73de37c-98ab-4050-8e8c-1c6e31abf156)
![FireShot Capture 054 - Allure Report - 172 17 64 1](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/6e6bde1a-5e1c-4297-ac5f-d08b29248aba)


</details>

#### Общие рекомендации:

* Исправить орфографические ошибки на странице.
* Кнопки "Купить" и "Купить в кредит" не подсвечивать красным до выбора/клика посетителя сайта. По той же логике "Продолжить".
* В Базе данных при покупке с карты, снимается 4_500_000, вместо 45_000.
