# Архитектура системы
### Room 
Класс для хранения информации о номерах, таких как номер комнаты, статус доступности, тип комнаты и т.д.
### Booking 
Класс для работы с бронированиями, который будет содержать данные о бронировании, такие как дата заезда, дата выезда 
и номер гостя.
### Guest
Класс для представления клиента (гостя) с методами для просмотра доступных номеров, бронирования и отмены бронирования.
### Admin
Класс для представления администратора, с методами для добавления и удаления номеров.
### Hotel
Класс, который управляет номерами и бронированиями. Он содержит методы для поиска доступных номеров, добавления и 
удаления номеров, создания и отмены бронирований.