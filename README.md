![Client CI](https://github.com/MelindaSW/relay-writer/workflows/Client%20CI/badge.svg?branch=develop)
![API CI](https://github.com/MelindaSW/relay-writer/workflows/API%20CI/badge.svg?branch=develop)

# relay-writer

Relay writer webapp for DND character backstory collaboration. This is a remake of a first year school assignment where I used Node.js, Express, SQLite and Vue.js, as can be seen in the earliest commit. Following is the setup so far.

#

### Backend

[Java](https://www.java.com/en/)  
[SpringBoot](https://spring.io/projects/spring-boot)  
[PostgreSQL](https://www.postgresql.org/)  
[JUnit](https://junit.org/junit5/)  
[Mockito](https://site.mockito.org/)  
[Spring Security](https://spring.io/projects/spring-security)  
[Swagger](https://swagger.io/)  
[Lombok](https://projectlombok.org/)

### Frontend

[JavaScript](https://www.javascript.com/)  
[React.js](https://reactjs.org/)  
[create-react-app](https://github.com/facebook/create-react-app)  
[react-redux](https://react-redux.js.org/)  
[axios](https://github.com/axios/axios)  
[Material UI](https://material-ui.com/)  
[StoryBook](https://storybook.js.org/)  
[Sass](https://sass-lang.com/)  
[react-testing-library](https://testing-library.com/docs/react-testing-library/intro/)

### DevOps

[Github Actions](https://docs.github.com/en/free-pro-team@latest/actions)  
[Docker](https://www.docker.com/)  
[docker-compose](https://docs.docker.com/compose/)  
[Maven](https://maven.apache.org/)

#

## Development setup

### Prerequisites

Java jdk 11  
Maven (I am currently using v.3.6.2)  
Node (npm or yarn, I am currently using npm v.6.13.4)  
Docker, docker-compose

### API

First create and connect to a PostgreSQL database with the name relaywriter_db. Either create one locally or using Docker:  
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
To start StoryBook, run `npm storybook`. The StoryBook ui can then be found on [localhost:9009]().

### Github Actions

Configurations and learning of Github Actions continous integration is currently in progress. I am using [act](https://github.com/nektos/act) to test run the jobs locally. The yml files can be found in .github\workflows

#

Check out the relay-writer [project](https://github.com/MelindaSW/relay-writer/projects/1) to see what is going on in the backlog and feel free to contact me if you have any questions or want to join in on the development!
