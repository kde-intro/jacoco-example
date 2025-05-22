# Что будет реализовываться
- Скомпилировать тестируемое приложение и получить в результате его jar-файл, sources, classes. (Проект №1)
- Запустить тестируемое приложение с JaCoCo agent и по завершению процесса тестируемого приложения получить наполненный сырой отчет - файл exec. (Проект №2)
- Используя sources, classes тестируемого приложения и сырой файл отчета exec, создать html-отчет. (Проект №2)


# Описание 
* build.gradle - gradle-скрипт тестового приложения и реализует задачу пункта 1 раздела Что будет реализовываться. (Проект №1)
* codecoverage.gradle - отдельный gradle-скрипт, который реализует различные задачи пунктов 2, 3 раздела Что будет реализовываться. (Проект №2)
   * unachiveJacocoAgent - получение jar-файла JaCoCo Agent.
   * launchApp - запуск тестируемого приложение с JaCoCo Agent. При запуске создается файл jacoco.exec - сырой отчет.
   * doTests - заглушка, выполненение различных тестов (ручных, автоматизированных).
   * stopApp - заглушка, завершение выполнения процесса тестируемого приложения (VM shutdown). По завершению процесса заполняется файл exec.
   * codeCoverageReport - генерация html-отчета с использованием sources, classes, exec.
* src - sources тестируемого приложения. Содержит три метода:
   * /handler1
   * /handler2/{type some value}
   * /handler3


# Воспроизведение
- Скомпилировать тестируемое приложение
```
./gradlew build
```
- Запустить тестируемое приложение. По умолчанию используется порт 4577 (изменить можно в файле application.properties или через флаг при запуске)
```
./gradlew -b codecoverage.gradle launchApp
```
- Выполнить тесты. Например, выполнить два метода сервиса.
- Завершить процесс тестируемого приложения.
- Генерация html-отчета
```
./gradlew -b codecoverage.gradle codeCoverageReport
```

Отчет будет в _build/jacoco_html_rep/_

# Требования

* Java 8


# Полезное

* [JaCoCo Agent](https://www.eclemma.org/jacoco/trunk/doc/agent.html)
* [JaCoCo Plugin](https://docs.gradle.org/current/userguide/jacoco_plugin.html)
* [JaCoCo Report](https://docs.gradle.org/current/dsl/org.gradle.testing.jacoco.tasks.JacocoReport.html)
* Тестовое приложение (сервис), Spring. [Process Monitoring](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-process-monitoring.html)
```
ApplicationPidFileWriter creates a file containing the application PID (by default, in the application directory with a file name of application.pid).
```
* Тестовое приложение (сервис), Spring. [Use a Random Unassigned HTTP Port](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-change-the-http-port)
* Тестовое приложение (сервис), Spring. [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)


# Заметки
* Файл exec можно экспортировать в SonarQube# NewTest
