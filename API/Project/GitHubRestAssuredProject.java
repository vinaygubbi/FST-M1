package activities;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitHubRestAssuredProject {
    // Declare request specification
    RequestSpecification requestSpec;
    String sshKey;
    int id;

    @BeforeClass
    public void setUp() {
        // Create request specification
        requestSpec =  new RequestSpecBuilder()
                // Set content type
                .setContentType(ContentType.JSON)
                // Set Token Authentication
                .addHeader("Authorization", "token ghp_6nI6ZS2rNuvVmjL6ikDI")
                // Set base URL
                .setBaseUri("https://api.github.com")
                // Build request specification
                .build();
        
        sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAAAgQDIrho13bssw89Efy7ZSupgfPrZA2L4SaqkyRPEku74zKNSkO7YcM2hzMP+W1t29MeE5fCpyotj8ewADbLvx";
        
    }

    @Test(priority=1)
    public void addKeys() {
        String reqBody = "{\"title\": \"TestKey\":, \"key\" \""+ sshKey +"\"}";
        Response response = given().spec(requestSpec) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post("/user/keys"); // Send POST request

        String resBody = response.getBody().asPrettyString(); // Send request body
        System.out.println(resBody);
        id = response.then().extract().path("id");

        // Assertions
        response.then().statusCode(201);
    }

    @Test(priority=2)
    public void getKeys() {
        Response response = given().spec(requestSpec) // Use requestSpec
                .when().get("/user/keys"); // Send GET request
        
        String resBody = response.getBody().asPrettyString();
        System.out.println(resBody);
        
        // Assertions
        response.then().statusCode(200);
    }
    
    @Test(priority=3)
    public void deleteKeys() {
        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("keyId", id) // Add path parameter
                .when().delete("/user/keys/{keyId}"); // Send GET request
        
        String resBody = response.getBody().asPrettyString();
        System.out.println(resBody);

        // Assertions
        response.then().statusCode(204);
    }

}
