# Дипломный проект по автоматизации тестирования API на [reqres.in](https://reqres.in/)
![img.png](picture/img.png)

---

### ✏️ Описание проекта 
Проект по автоматизации тестирования Api с использованием платформы открытого доступа [reqres.in](https://reqres.in/)
Проект разработан для локального развертывания и запуска api авто-тестов. 

Проект находится в открытом доступе, поэтому вы можете его скачать, доработать, кастомизировать или использовать как шаблон для ваших целей.

---

### 🧰 Используемые технологии и инструменты:

<p align="left">
<a href="https://www.jetbrains.com/idea/"><img src="picture/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA" title="IntelliJ IDEA"/></a>
<a href="https://www.java.com/"><img src="picture/Java.svg" width="50" height="50" alt="Java" title="Java"/></a>
<a href="https://github.com/"><img src="picture/GitHub.svg" width="50" height="50" alt="Github" title="GitHub"/></a>
<a href="https://junit.org/junit5/"><img src="picture/JUnit5.svg" width="50" height="50" alt="JUnit 5" title="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="picture/Gradle.svg" width="50" height="50" alt="Gradle" title="Gradle"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="picture/Allure_Report.svg" width="50" height="50" alt="Allure" title="Allure"/></a>
</p>



### 💻 Запуск тестов из терминала :

`gradle clean test`

---

### Удаленный запуск тестов через [Jenkins:](https://jenkins.autotests.cloud/job/C27-mateenkov-General-Api/)

Запустить авто-тесты можно по кнопке ```Build with parameters```

![img.png](notifications/startbuild.png)

### Allure-отчетность:

По кнопке со значком ![img.png](notifications/iconAllure.png) Allure можно увидеть всю отчетность:

![img.png](notifications/owerViewAllure.png)
![img.png](notifications/AllureReport.png)

### Отчетность в Telegram:

После прохождения всех тестов приходит уведомление в Telegram с небольшим отчетом

![img_1.png](notifications/telegramReport.png)