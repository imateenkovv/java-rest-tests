# 🧪 Java REST API Tests

## 📘 О проекте

Это репозиторий с авто-тестами написанными на  **Java** для платформы [reqres.in](https://reqres.in/)

![logo](img/img.png)
---

## 🚀 Технологии

- `🌐 rest-assured` - для работы с api
- `✅ assertj-core` - для проверок
- `📝 lombok` - для работы с моделями запросов, овтетов и ошибок
- `🧪 junit-jupiter` - фреймворк для авто-тестирования
- `📊 allure-rest-assured` - для генерации отчетов о прохождении авто-тестов

---

## 📂 Структура проекта

```
java-rest-tests/
├─── gradle 
├─── img                     # Скриншоты 
├─── src 
├─── test
│   ├── java
│       ├── checkers        # Классы для проверок
│       ├── common          # Логика обработки запросов/ответов и ошибок
│       ├── helpers         # 
│       ├── testData        # Allure listeners
│       ├── tests           # Тестсьюты
│   ├── resources
└── README.md
```

---

## ⚙️ Установка и запуск

### 1️⃣ Клонируйте репозиторий:

```bash
  git clone https://github.com/imateenkovv/python_rest_tests.git
  cd python_rest_tests
```

### 2️⃣ Установите зависимости:

```bash
    pip install -r requirements.txt
```

### 3️⃣ Запустите тесты:

```bash
    pytest --alluredir=reports
```

### 4️⃣ Сгенерируйте отчёт Allure:

```bash
    allure serve allure-results
```

---

## 📈 Пример отчёта Allure

![Отчет allure](img/img.png)

---

## 👨‍💻 Автор

- Илья Матеенков
- QA Automation Engineer (Java/Python)
- 📎 GitHub: imateenkovv
- [Мое резюме](https://hh.ru/resume/4a1f3e52ff09c71d1e0039ed1f6f4b506b5837?hhtmFrom=resume_list)




