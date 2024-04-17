### Программы для запуска автотестов:
* IDE: IntelliJ IDEA
* Docker Desktop

### Подготовка окружения для запуска автотестов:

1. Клонируем репозиторий проекта.
2. Открываем проект в IntelliJ IDEA.
3. Запускаем приложение Docker Desktop.
4. В терминале IDE запускаем контейнеры командой:

          docker compose up
6. Открываем второй терминал и в нем запускаем приложение командой:

          java -jar ./artifacts/aqa-shop.jar

### My MySQL Запуск автотестов:

1. В третьем терминале запускаем автотесты командой:

         .\gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"
2. Создать и открыть отчет Allure для просмотра результатов тестирования командой:

         .\gradlew allureServe 
4. Завершим выполнение пакетного файла командой:

         CTRL + C =>> Enter =>> y =>> Enter

### PostgreSQL Запуск автотестов:

1. В третьем терминале запускаем автотесты командой:

        .\gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"
2. Создать и открыть отчет Allure для просмотра результатов тестирования командой:

         .\gradlew allureServe 
4. Завершим выполнение пакетного файла командой:

         CTRL + C =>> Enter =>> y =>> Enter
