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

* Успешные кейсы 62,96% (34 Tests);
* Неуспешных кейсов 33,33% (18 Tests);
* Тестовые дефекты 3,7% (2 Tests);
<details>
   <summary>Report</summary>

![3](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/b93757cd-a265-4d9a-a213-66a8db5cfe8b)
![5](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/04b61f30-3078-4159-b57c-096c0125514f)
![FireShot Capture 050 - Allure Report - 172 17 64 1](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/07b0e297-db07-4e0e-99af-cb20ac18fa51)
![4](https://github.com/Kris-i-kris/GraduationProject/assets/138568517/ae42cdb7-bc80-440b-af14-7e55b989159a)


</details>

#### Общие рекомендации:

* Исправить орфографические ошибки на странице.
* Кнопки "Купить" и "Купить в кредит" не подсвечивать красным до выбора/клика посетителя сайта. По той же логике "Продолжить".
* В Базе данных при покупке с карты, снимается 4_500_000, вместо 45_000.
