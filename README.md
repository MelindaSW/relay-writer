# relay-writer
WIP(!) relay writer web application for DND character backstory collaboration. This is a remake of a first year school assignment where Express and SQLite were used in the backend and Vue in the frontend (see the earliest commits). Following is the setup so far.  

#

### Backend
Java  
SpringBoot  
Maven  
PostgreSQL  
JUnit  
Mockito  
Spring Security
Docker  
docker-compose   
   
### Frontend  
Javascript  
React.js  
redux, react-redux  
Material UI  
StoryBook  
Sass  
react-testing-library   

#

## Development setup

Requirements 

Java jdk 11  
Maven (I am currently using v.3.6.2)  
Node (npm or yarn, I am currently using npm v.6.13.4)  
Docker, docker-compose  

### API

First create and connect to a PostgreSQL database with the name relaywriter_db. Either create one locally or with Docker.  
Run `docker-compose -f docker-compose.dev.yml up` in the api directory to start a container created from the latest postgres image. The database will be created if it not already exists. 
Connect with the username and password provided in the docker-compose.dev.yml.
The database is initialized with data on startup from data-postgres.sql in the resources folder.

Run tests from the command line with `mvn test`

Run application with the IDE or in the command line with `./mvnw spring-boot:run`

See and test the endpoints on [localhost:8080/dnd-relay-writer/swagger-ui.html]()

### Client

First install dependencies with `npm install`.  
To start the client, run `npm start`. It should now open on [localhost:3000]().  
To run the tests, use `npm test`.  
To start StoryBook, run `npm storybook`. The ui can be found on [localhost:9009]().