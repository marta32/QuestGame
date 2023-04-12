# QuestGame -  Spring Boot Project

This project is a Spring Boot REST API for managing a quest game. There are four entities (User, Quest, Answer, Badge). A quest is proposed by a user who has enough tokens. One or many users could answer at the quest, but just one answer is prized. The winner answer is chosen by the user who put the quest. 

Also, there are badges for active users. I defined three badges. More exactly, a badge for the first five quest created, a badge for the first three rewarded answer and a badge for reaching 250 tokens.  

## Tech stack

- Java 17
- Spring Boot 2
- Spring Security
- Maven
- Hibernate
- PostgreSQL for the relational database

## Other tools

- Postman 
- DBeaver
- Swagger
- Git

## Database diagram
![Screenshot](https://github.com/marta32/QuestGame/blob/main/images/Diagram.png)

## APIs
![Screenshot](https://github.com/marta32/QuestGame/blob/main/images/User.png)
-----
![Screenshot](https://github.com/marta32/QuestGame/blob/main/images/Quest.png)
-----
![Screenshot](https://github.com/marta32/QuestGame/blob/main/images/Badge.png)
-----