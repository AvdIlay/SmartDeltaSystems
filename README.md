# Student Information REST Service

## Описание

Этот проект представляет собой REST сервис для управления информацией о студентах. Сервис позволяет выполнять CRUD операции (создание, чтение, обновление, удаление) над сущностями студентов и включает OAuth2.0 авторизацию для обеспечения безопасности.

## Состав объекта студента

- Фамилия (lastName)
- Имя (firstName)
- Отчество (middleName)
- Группа (studentGroup)
- Средняя оценка (averageGrade)

## Технологии
- Java 17
- Spring Boot
- Spring Security
- JWT для авторизации
- Postgres база данных
- Maven для управления зависимостями

## API Эндпоинты
# Регистрация нового пользователя
curl -X POST http://localhost:8080/auth/register -H "Content-Type: application/json" -d '{
"username": "user",
"password": "password",
"role": "USER_ROLE"
}'

# Получение токена доступа
curl -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d '{
"username": "user",
"password": "password"
}'

# Управление студентами
Все запросы, кроме регистрации и авторизации, требуют заголовка Authorization: Bearer <access_token>.

# Получение списка всех студентов 
curl -X GET http://localhost:8080/students -H "Authorization: Bearer <access_token>"

# Получение информации о студенте по ID
curl -X GET http://localhost:8080/students/{id} -H "Authorization: Bearer <access_token>"

# Создание нового студента
curl -X POST http://localhost:8080/students -H "Content-Type: application/json" -H "Authorization: Bearer <access_token>" -d '{
"lastName": "Иванов",
"firstName": "Иван",
"middleName": "Иванович",
"studentGroup": "101",
"averageGrade": 4.5
}'

# Обновление информации о студенте
curl -X PUT http://localhost:8080/students/{id} -H "Content-Type: application/json" -H "Authorization: Bearer <access_token>" -d '{
"lastName": "Петров",
"firstName": "Петр",
"middleName": "Петрович",
"studentGroup": "102",
"averageGrade": 4.7
}'

# Удаление студента
curl -X DELETE http://localhost:8080/students/{id} -H "Authorization: Bearer <access_token>"
