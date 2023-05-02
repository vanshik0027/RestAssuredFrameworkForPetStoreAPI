package api.endpoints;

import javax.swing.text.AbstractDocument.Content;

import api.payload.User;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

//userspoints.java
//created for perform Create , read , update, delete request the user ApI.
public class UserEndPoints2 {
	
	//method created for taking url from properties file
	static ResourceBundle getURL(){
		
		//load properties file
		ResourceBundle routes= ResourceBundle.getBundle("routes");
		return routes;
	}
	
	 public static Response createUser(User payload){
		 
		 String post_url= getURL().getString("post_url");
		 Response response = given()
		 
		 	.contentType(ContentType.JSON)
		 	.accept(ContentType.JSON)
		 	.body(payload)
		.when()
			.post(Routes.post_url);
		 return response;
	}
	 
 public static Response readUser(String userName) {
	 String get_url= getURL().getString("get_url");
		 Response response = given()
		 
		 	.pathParams("userName",userName)
		.when()
			.get(Routes.get_url);
		 return response;
	}
 public static Response updateUser(String userName, User payload){
	 String update_url= getURL().getString("update_url");
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
	 String delete_url= getURL().getString("delete_url");
	 
	 Response response = given()
	 
	 	.pathParams("userName",userName)
	.when()
		.delete(Routes.delete_url);
	 return response;
}

	 
	 
	 
}
