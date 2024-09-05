# Ендпоинты

1) Добавление нового клиента: \
POST */api/clients*
 

2) Добавление нового контакта клиента (телефон или email): \
POST */api/clients/add/contact*


3) Получение списка клиентов: \
GET */api/clients*


4) Получение информации по заданному клиенту (по id): \
GET */api/clients/{id}*


5) Получение списка контактов заданного клиента: \
GET */api/clients/{id}/contacts*


6) Получение списка контактов заданного типа заданного клиента: \
GET */api/clients/{id}/contacts?type*

Документация с OpenAPI: \
*/swagger-ui/index.html*