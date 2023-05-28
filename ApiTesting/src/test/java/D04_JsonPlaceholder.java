import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class D04_JsonPlaceholder {

    @Test
    public void test()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", "Ahmet");
        jsonObject.put("body", "Merhaba");
        jsonObject.put("userId", "10");
        jsonObject.put("id", "70");

        System.out.println(jsonObject);

        Response response = given().contentType(ContentType.JSON).when().body(jsonObject.toString()).put("https://jsonplaceholder.typicode.com/posts/70");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                header("Server","cloudflare").
                statusLine("HTTP/1.1 200 OK");
    }
}
