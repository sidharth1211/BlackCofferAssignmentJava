# BlackCofferAssignmentJava
# Social Media REST API
This API is built using Java and Spring Boot. It allows users to interact with a social media platform, including posting, retrieving messages and creating users.

# API Authentication

# Endpoints
#GET http://localhost:8080/users
Returns a List of all users

#POST http://localhost:8080/users
To create a new User do the following using Postman:
1. Pass Authorization header:
    Username : user
    Password : password
2. Pass JSON file in the following format:
    {
        "user_name":Sidharth,
        "birth_date":"1998-11-12"
    }

#DELETE http://localhost:8080/users/{id}
Delete a specific user.

#GET http://localhost:8080/users/{id}
return details of a specific user




Request body should be in the following format:

Copy code
{
    "text": "Your post text here"
}
GET /api/post
Retrieve all the posts from the social media platform.

GET /api/post/{id}
Retrieve a specific post by its ID.

Additional Information
All endpoints require authentication.
API responses are in JSON format.
This API is built on top of Spring Boot 2.3.3.
Error handling is implemented in the API.
API documentation is available in Swagger UI at /swagger-ui.html
How to use
To run the application: ./mvnw spring-boot:run
To run test : ./mvnw test
Note
If you're using windows replace ./mvnw with mvnw.cmd
