## <img alt="Wikipedia" height="500" src="images/logo/wikipedia-earth.svg" width="500"/></a>
# Проект по мобильной автоматизации тестирования для приложения Wikipedia

## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов в Browserstack</a>
____
<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://allurereport.org/"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>  
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://www.browserstack.com/"><img src="images/logo/Browserstack.svg" width="50" height="50"  alt="Browserstack"/></a>   
</p>

____
<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>
____
- ✓ *Проверка поиска статьи на главном экране*
- ✓ *Проверка открытия статья из поисковой выдачи*

____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="images/logo/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/qa_guru_mobile_diploma/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/qa_guru_mobile_diploma/"><img src="#" alt="Jenkins" width="950"/></a>  
</p>


### **Параметры сборки в Jenkins:**

- *browser (браузер, по умолчанию chrome)*
- *version (версия браузера, по умолчанию 128)*
- *windowSize (размер окна браузера, по умолчанию 1920x1080)*
- *baseUrl (адрес тестируемого веб-сайта)*
- *remoteUrl (логин, пароль и адрес удаленного сервера Selenoid)*
- *questName (название квеста для теста бронирования)*

## **Запуск тестов**

<a id="console"></a>
### Команды для запуска из терминала
___
***Локальный запуск на эмуляторе:***
```bash  
./gradlew clean test -DdeviceHost=emulation
```

***Локальный запуск тестов в Browserstack:***
```bash  
./gradlew clean test -DdeviceHost=browserstack
```

***Удалённый запуск через Jenkins:***
```bash  
clean test
-DdeviceHost=browserstack
-Duser=${USER}
-Dkey=${KEY}
```
___
<a id="allure"></a>
## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/037-sandraboticelli-escaperoom-12/allure/)</a>
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/allure_report_1.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="images/screen/allure_report_4.png" width="850">  
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="images/screen/allure_report_2.png" width="850">

<img title="Allure Graphics" src="images/screen/allure_report_3.png" width="850">  
</p>

____
<a id="telegram"></a>
## <img alt="Allure" height="25" src="images/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/telegram_report.png" width="550">  
</p>

____
<a id="video"></a>
## <img alt="Browserstack" height="25" src="images/logo/Browserstack.svg" width="25"/></a> Пример видео выполнения тестов в Browserstack
____
<p align="center">
<img title="Browserstack Video" src="images/video/video_report.gif" width="550" height="350"  alt="video">   
</p>



