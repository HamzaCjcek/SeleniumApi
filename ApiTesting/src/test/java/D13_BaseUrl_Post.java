import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.hasSize;

public class D13_BaseUrl_Post extends D12_BaseUrl_Setup{
    @Test
    public void test()
    {
        scepHerokuapp.pathParams("pp1","posts","pp2",44);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","API");
        jsonObject.put("body","API ogrenmek ne güzel");
        jsonObject.put("userId",10);
        System.out.println(jsonObject);
        Response response = given().spec(scepHerokuapp).when().get("/{pp1}/{pp2}");

        response.then().assertThat().statusCode(200).body("title",equalTo("optio dolor molestias sit"));
        response.then().assertThat().statusCode(200).body("userId", hasSize(100));//ıd sı null olan değer

        response.then().assertThat().statusCode(200).body("userId", nullValue());//ıd sı null olan değer

        response.prettyPrint();
    }
}
