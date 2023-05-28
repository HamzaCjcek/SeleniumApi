import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.internal.mapping.GsonMapper;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class D017_Serialization_ExpectedData extends D015_Setup{
    /*
                   {
                    ""title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70

                    }
     */

    @Test
    public void test()
    {
        //Map’i JSONObject’e cevirmek icin de Gson Class’indan yardim aliriz. Gson Class’indaki metodlari
        //kullanmak icin once o Class’dan bir object olustururuz.
        specHerokuapp.pathParams("pp1","posts","pp2",70);
        D015_Setup tester = new D015_Setup();
        HashMap<String,Object> reqBody = tester.reqBodyMap();
        HashMap<String,Object> expBody = tester.reqBodyMap();
        Gson gson = new Gson();
        String jsonFromJavaObject = gson.toJson(reqBody);
        Response response = given().
                spec(specHerokuapp).contentType(ContentType.JSON).when()
                .body(jsonFromJavaObject.toString()).put("/{pp1}/{pp2}");
        response.prettyPeek();

    }
}
