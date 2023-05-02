package api.endpoints;

import javax.swing.text.AbstractDocument.Content;

import api.payload.User;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

//userspoints.java
//created for perform Create , read , update, delete request the user ApI.
public class UserEndPoints {
	
	
	 public static Response createUser(User payload){
		 
		 Response response = given()
		 
		 	.contentType(ContentType.JSON)
		 	.accept(ContentType.JSON)
		 	.body(payload)
		.when()
			.post(Routes.post_url);
		 return response;
	}
	 
 public static Response readUser(String userName) {
		 
		 Response response = given()
		 
		 	.pathParams("userName",userName)
		.when()
			.get(Routes.get_url);
		 return response;
	}
 public static Response updateUser(String userName, User payload){
	 
	 Response response = given()
	 
	 	.contentType(ContentType.JSON)
	 	.accept(ContentType.JSON)
	 	.pathParam("username", userName)
	 	.body(payload)
	.when()
		.put(Routes.update_url);
	 return response;
}
 public static Response deleteUser(String userName) {
	 
	 Response response = given()
	 
	 	.pathParams("userName",userName)
	.when()
		.delete(Routes.delete_url);
	 return response;
}

	 
	 
	 
}
