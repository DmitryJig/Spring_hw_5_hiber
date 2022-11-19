работаем на бд H2
У бд H2 версия 1.4.200 как в лекции, последние версии не хотят принимать id=null у вновь создаваемых товаров

С интерфейсом заморачиваться не стал, проверял через постман
1. findAll
GET: http://localhost:8189/app/products

2. findById
GET: http://localhost:8189/app/products/1

3. deleteById
DELETE: http://localhost:8189/app/products/1

4. POST: http://localhost:8189/app/products

для update:
BODY JSON
    {
        "id": 1,
        "title": "soup",
        "cost": 50.0
    }

для save:
BODY JSON
    {
        "title": "Garliс",
        "cost": 270.0
    }