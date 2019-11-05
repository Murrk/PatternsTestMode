# Patterns [![Build status](https://ci.appveyor.com/api/projects/status/xx5tohq43d4k7hyq?svg=true)](https://ci.appveyor.com/project/Murrk/patternstestmode)

## Домашнее задание к занятию «2.3. Patterns»

### Инструкция по запуску

Перед запуском тестов необходимо установить [java 8](https://www.oracle.com/technetwork/java/javase/downloads/2133151)

* Склонировать репозиторий `git clone https://github.com/Murrk/PatternsTestMode.git`
* Перейти в директорию с проектом
* Развернуть jar целевого сервиса набрав в консоли команду `java -jar app-ibank.jar -P:profile=test`
* Выполнить команду `./gradlew test` (`./gradlew.bat test`, если запускается из windows)
* Отчет можно посмотреть в директории `build/reports/tests/test/`
