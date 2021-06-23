package RestAssuredByYoutube.RestAssuredByYoutube;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataDrivenTesting {

	
//	@Test(dataProvider = "getData")
	public void createUser(String firstname, String lastname, int subjectID) {
		
		JSONObject obj = new JSONObject();
		obj.put("firstname", firstname);
		obj.put("lastname", lastname);
		obj.put("subjectID", subjectID);
		
		baseURI = "http://localhost:3000";
		port = 3000;
		
		given().
		    contentType(ContentType.JSON).
		    body(obj.toJSONString()).
	    when().
	        post("users/").
		then().statusCode(201)
		.log().all();
		
		
	}


@DataProvider(name = "getData")
public Object[][] dataProvider() {
	Object [] [] data = new Object[2][3];
	
	data[0][0]= "ravi";
	data[0][1]="jewar";
	data[0][2]= 29;
	
	data[1][0]= "jadeja";
	data[1][1]="gujjar";
	data[1][2]= 39;
	
	return data;
	/*  Alternative way no need to specify size 
	 return new Object[][]
	 {
	 "ravi" , "jewar", 29},
	 {
	 "jadeja" , "gujjar", 39};
	  */
	
}
//@Test(dataProvider = "getDelete")
public void deleteUsers(int i) {
	baseURI ="http://localhost:3000";
	port = 3000;
	
	when().delete("users/"+i).
	then().statusCode(200).log().all();
}

@DataProvider
public Object[] getDelete() {
	return new Object [] 
			{5,6,9};
	
  }

@Parameters({"id"})
@Test
public void getSingleUser(int ID) {
	baseURI ="http://localhost:3000";
	port = 3000;
	when().get("/users/"+ID).then().statusCode(200).log().all();
	
      }
}