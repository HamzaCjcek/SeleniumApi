import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class D018 extends D015_Setup{
                    /*
                    C25_Put_DeSerialization
                        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki bodye sahip bir
                        PUT request yolladigimizda donen response’in response body’sinin asagida
                        verilen ile ayni oldugunu test ediniz
                        DE-SERIALIZATION ILE EXPECTED DATA TESTI
                        Expected Data :
                        {
                        "title": "Ahmet",
                        "body": "Merhaba",
                        "userId": 10,
                        "id": 70
                        }
                        Request Body
                        {
                        "title": "Ahmet",
                        "body": "Merhaba",
                        "userId": 10,
                        "id": 70
                        }

                     */

    @Test
    public void test()
    {
        specHerokuapp.pathParams("pp1","posts","pp2",70);
        D015_Setup reqBody = new D015_Setup("Ahmet","Merhaba",10,70);
        System.out.println(reqBody);
        Response response = given().spec(specHerokuapp)
                .contentType(ContentType.JSON).when()
                .body(reqBody).put("/{pp1}/{pp2}");
        response.prettyPrint();

        JsonPath resJP = response.jsonPath();
        Map<String, Object> resMap=response.as(HashMap.class);
        D015_Setup result = response.as(D015_Setup.class);

        Assert.assertEquals(reqBody.getTitle(),result.getTitle());
    }

}
