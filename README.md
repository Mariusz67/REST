## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info

As part of the project, a REST API based on the resource of subjects for studies was prepared. Each subject for studies should contain information about:
- name of the subject ("nazwa"),
- ects points ("punkty"),
- the number of the room where the classes are held ("sala"),
- information whether the course ends with an exam ("czyEgzamin").

The server allows you to enter new items, download items and delete items.

## Technologies
Project is created with:
* Java 17
* Spring Boot

## Setup
To run this project, clone & run it locally using IntelliJ.
Use Postman for testing.

Report scenario:
1. Entering items into the system in the given order:
- Name: Object-oriented methodologies, ECTS: 2, Room: 216, Exam: yes,
- Name: Software testing, ECTS: 1, Room: 216, Exam: no,
- Title: Web technologies and applications, ECTS: 3, Room: 208, Exam: no,
- Name: IT project management, ECTS: 2, Room: 216, Exam: no,
- Name: Advanced database technologies, ECTS: 3, Room: 208, Exam: no,
- Name: Component and Network Technologies, ECTS: 2, Room: 208, Exam: yes
2. Download all items,
3. Downloading items that have an exam,
4. Collection of items that take place in room 216,
5. Downloading subjects that do not have an exam and take place in room 208,
6. Downloading the item with ID 3,
7. Downloading an item with ID 15,
8. Removal of item with ID 2,
9. Download all items,
10. Remove all items,
11. Download all items.

Tests API report:

0.
GET
localhost:8080/api/przedmioty
Content-Type: application/json
Body: null
Response:
200OK
23 ms
166 B
Body: []

1.
POST
localhost:8080/api/przedmioty
Content-Type: application/json
Body:
{
    "nazwa": "Metodologie obiektowe",
    "punkty": 2,
    "sala": "216",
    "czyEgzamin": true
}
Response:
200OK
78 ms
123 B
Body: none


POST
localhost:8080/api/przedmioty
Content-Type: application/json
Body:
{
    "nazwa": "Testowanie oprogramowania",
    "punkty": 1,
    "sala": "216",
    "czyEgzamin": false
}
Response:
200OK
78 ms
123 B
Body: none

POST
localhost:8080/api/przedmioty
Content-Type: application/json
Body:
{
    "nazwa": "Technologie i aplikacje webowe",
    "punkty": 3,
    "sala": "208",
    "czyEgzamin": false
}
Response:
200OK
29 ms
123 B
Body: none

POST
localhost:8080/api/przedmioty
Content-Type: application/json
Body:
{
    "nazwa": "Zarządzanie projektem informatycznym",
    "punkty": 2,
    "sala": "216",
    "czyEgzamin": false
}
Response:
200OK
26 ms
123 B
Body: none


POST
localhost:8080/api/przedmioty
Content-Type: application/json
Body:
{
    "nazwa": "Zaawansowane technologie bazodanowe",
    "punkty": 3,
    "sala": "208",
    "czyEgzamin": false
}
Response:
200OK
31 ms
123 B
Body: none

POST
localhost:8080/api/przedmioty
Content-Type: application/json
Body:
{
     "nazwa": "Technologie komponentowe i sieciowe",
    "punkty": 2,
    "sala": "208",
    "czyEgzamin": true
}
Response:
200OK
10 ms
123 B
Body: none

2.
GET
localhost:8080/api/przedmioty
Content-Type: application/json
Body: none
Response:
200OK
106 ms
724 B
Body:
[
    {
        "id": 1,
        "nazwa": "Metodologie obiektowe",
        "punkty": 2,
        "sala": "216",
        "czyEgzamin": true
    },
    {
        "id": 2,
        "nazwa": "Testowanie oprogramowania",
        "punkty": 1,
        "sala": "216",
        "czyEgzamin": false
    },
    {
        "id": 3,
        "nazwa": "Technologie i aplikacje webowe",
        "punkty": 3,
        "sala": "208",
        "czyEgzamin": false
    },
    {
        "id": 4,
        "nazwa": "Zarządzanie projektem informatycznym",
        "punkty": 2,
        "sala": "216",
        "czyEgzamin": false
    },
    {
        "id": 5,
        "nazwa": "Zaawansowane technologie bazodanowe",
        "punkty": 3,
        "sala": "208",
        "czyEgzamin": false
    },
    {
        "id": 6,
        "nazwa": "Technologie komponentowe i sieciowe",
        "punkty": 2,
        "sala": "208",
        "czyEgzamin": true
    }
]

3.
GET
localhost:8080/api/przedmioty?czyEgzamin=true
Content-Type: application/json
Body: none
Response:
200OK
12 ms
345 B
Body:
[
    {
        "id": 1,
        "nazwa": "Metodologie obiektowe",
        "punkty": 2,
        "sala": "216",
        "czyEgzamin": true
    },
    {
        "id": 6,
        "nazwa": "Technologie komponentowe i sieciowe",
        "punkty": 2,
        "sala": "208",
        "czyEgzamin": true
    }
]

4.
GET
localhost:8080/api/przedmioty?sala=216
Content-Type: application/json
Body: none
Response:
200OK
13 ms
436 B
Body:
[
    {
        "id": 1,
        "nazwa": "Metodologie obiektowe",
        "punkty": 2,
        "sala": "216",
        "czyEgzamin": true
    },
    {
        "id": 2,
        "nazwa": "Testowanie oprogramowania",
        "punkty": 1,
        "sala": "216",
        "czyEgzamin": false
    },
    {
        "id": 4,
        "nazwa": "Zarządzanie projektem informatycznym",
        "punkty": 2,
        "sala": "216",
        "czyEgzamin": false
    }
]


5.
GET
localhost:8080/api/przedmioty?sala=208&czyEgzamin=false
Content-Type: application/json
Body: none
Response:
200OK
97 ms
356 B
Body:
[
    {
        "id": 3,
        "nazwa": "Technologie i aplikacje webowe",
        "punkty": 3,
        "sala": "208",
        "czyEgzamin": false
    },
    {
        "id": 5,
        "nazwa": "Zaawansowane technologie bazodanowe",
        "punkty": 3,
        "sala": "208",
        "czyEgzamin": false
    }
]

6.
GET
localhost:8080/api/przedmioty/3
Content-Type: application/json
Body: none
Response:
200OK
20 ms
256 B
Body:
{
    "id": 3,
    "nazwa": "Technologie i aplikacje webowe",
    "punkty": 3,
    "sala": "208",
    "czyEgzamin": false
}

7.
GET
localhost:8080/api/przedmioty/15
Content-Type: application/json
Body: none
Response:
404Not Found
13 ms
130 B
Body: empty

8.
DELETE
localhost:8080/api/przedmioty/2
Content-Type: application/json
Body: none
Response:
204No Content
14 ms
112 B
Body: empty

9.
GET
localhost:8080/api/przedmioty
Content-Type: application/json
Body: none
Response:
200OK
42 ms
636 B
Body:
[
    {
        "id": 1,
        "nazwa": "Metodologie obiektowe",
        "punkty": 2,
        "sala": "216",
        "czyEgzamin": true
    },
    {
        "id": 3,
        "nazwa": "Technologie i aplikacje webowe",
        "punkty": 3,
        "sala": "208",
        "czyEgzamin": false
    },
    {
        "id": 4,
        "nazwa": "Zarządzanie projektem informatycznym",
        "punkty": 2,
        "sala": "216",
        "czyEgzamin": false
    },
    {
        "id": 5,
        "nazwa": "Zaawansowane technologie bazodanowe",
        "punkty": 3,
        "sala": "208",
        "czyEgzamin": false
    },
    {
        "id": 6,
        "nazwa": "Technologie komponentowe i sieciowe",
        "punkty": 2,
        "sala": "208",
        "czyEgzamin": true
    }
]

10.
DELETE
localhost:8080/api/przedmioty
Content-Type: application/json
Body: none
Response:
200OK
19 ms
123 B
Body: empty

11.
GET
localhost:8080/api/przedmioty
Content-Type: application/json
Body: none
Response:
200OK
20 ms
166 B
Body: []
