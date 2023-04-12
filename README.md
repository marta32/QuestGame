# QuestGame -  Description

This project is a Spring Boot REST API for managing a quest game. There are four entities: 
- User, 
- Quest, 
- Answer, 
- Badge. 

A quest is proposed by a user who has enough tokens. One or many users could answer at the quest, but just one answer is prized. The winner answer is chosen by the user who put the quest. In order to see ranking, we can retrieve all users which are automatically sorted by their tokens.

Also, there are badges for active users. I defined three badges. More exactly:
- a badge for the first five quest created,
- a badge for the first three rewarded answer,
- a badge for reaching 250 tokens.

## Basic test flow
 
   You can use my Postman Collection (requires basic auth credentials): 
   https://github.com/marta32/QuestGame/blob/main/Accesa%20Collection.postman_collection.json
1. Create a quest.

   POST: http://44.214.187.174/api/quests

   JSON:
   ```
   {
   "quest":"10+5=?",
   "tokens": "10"
   }
   ``` 
2. Add answer to that quest. For exemple, add answer 15 to quest with id 1.

   POST: http://44.214.187.174/api/quest/1/answer

   JSON:
   ```
   {
    "questAnswer":"15"
   }
   ```

3. Pick a winner answer. For example, pick winner answer with id 1 to quest with id 1. 

   PUT: http://44.214.187.174/api/quests/1/answer/1/pickWinner

## Tech stack

- Java 17
- Spring Boot 2
- Spring Security
- Maven
- Hibernate
- PostgreSQL for the relational database

## Deploy on AWS

- EC2 with Elastic IP
- RDS with PostgreSQL

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