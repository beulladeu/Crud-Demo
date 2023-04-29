Консольное CRUD приложение, которое имеет следующие сущности:

Developer (id, firstName, lastName, List<Skill> skills, Specialty specialty)
Skill (id, name)
Specialty (id, name)
Status (enum ACTIVE, DELETED)

Developer -> List<Skill> skills + Specialty specialty
Каждая сущность имеет поле Status. В момент удаления, запись из файла не удаляется, изменяется её статус на DELETED.

В качестве хранилища данных использованы текстовые файлы:
developers.json, skills.json, specialties.json

Пользователь в консоли имеет возможность создания, получения, редактирования и удаления данных.

Слои:
model - POJO клаcсы
repository - классы, реализующие доступ к текстовым файлам
controller - обработка запросов от пользователя
view - все данные, необходимые для работы с консолью

Для работы с json используется библиотека https://mvnrepository.com/artifact/com.google.code.gson/gson

