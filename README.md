# Коллоквиум по КПО

## Краткое условие

**Язык реализации:** Java

**Задача:** Разработать API для обмена валют

## Установка и использование

1. Клонировать данный репозиторий.
2. Открыть проект в IntelliJ IDEA.
3. Запустить проект.

## Архитектура системы

1. **Контроллеры**: Обрабатывают входящие HTTP-запросы и управляют потоком данных. Они принимают запросы, проверяют входные данные, вызывают соответствующие методы сервисов и возвращают HTTP-ответы с соответствующими данными или ошибками.

2. **Сервисы**: Реализуют бизнес-логику системы. Они обрабатывают запросы от контроллеров, выполняют необходимые операции с данными, взаимодействуют с репозиториями для доступа к данным и генерируют соответствующие ответы.

3. **Репозитории**: Обеспечивают доступ к данным системы. Они предоставляют методы для поиска, создания, обновления и удаления данных в базе данных.

4. **Модели**: Представляют объекты данных, используемые в системе. Они содержат поля и методы для работы с соответствующими данными.

5. **DTO (Data Transfer Objects)**: Используются для передачи данных между клиентом и сервером.

## Postman

Коллекцию Postman можно найти [здесь](./postman).
