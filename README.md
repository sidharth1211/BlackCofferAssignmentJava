
# Social Media REST API

This API is built using Java and Spring Boot. It allows users to interact with a social media platform, including posting, retrieving messages and creating users.





Authentication has been enabled for all the Endpoints using Spring Security.

| Username  | Password   |
| :-------- | :--------- |
| `user`    | `password` |


## API Endpoints

#### Get list of all users

```http
  GET http://localhost:8080/users
```

#### Get details of a particular user by id

```http
  GET http://localhost:8080/users/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### Create a User

```http
  POST http://localhost:8080/users
```
To create a new User do the following using Postman:

    1. Pass Authorization header:
       Username : user 
       Password : password
    2. Pass JSON file in the following format: 
      { 
      "user_name":Sidharth, 
      "birth_date":"1998-11-12"
      }

#### Delete a user

```http
  DELETE http://localhost:8080/users/{id}
```

#### Get user posts

```http
  GET http://localhost:8080/users/{id}/posts
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### Create posts for a user

```http
  POST http://localhost:8080/users/${id}/posts
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

To create a new Post do the following using Postman:

    1. Pass Authorization header:
       Username : user 
       Password : password
    2. Pass JSON file in the following format: 
      { 
      "description":"This is my first post."
      }




## Run Locally

Clone the project

```bash
  git clone https://link-to-project
```

Go to the project directory

```bash
  cd my-project
```

Build and Run Application

```bash
  mvn spring-boot:run
```

