# BlackCofferAssignmentJava
Social Media REST API
This API is built using Java and Spring Boot. It allows users to interact with a social media platform, including posting and retrieving messages.

Endpoints
POST /api/post
Create a new post on the social media platform.

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
