import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class D06_Post {
    @Test
    public void test()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","API");
        jsonObject.put("body","API ogrenmek ne güzel");
        jsonObject.put("userId",10);
        System.out.println(jsonObject);

        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(jsonObject.toString())
                .put("https://jsonplaceholder.typicode.com/posts/10");

        response.prettyPrint();

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json")
                .body("body", Matchers.containsString("API"))
                .body("body", Matchers.containsString("API ogrenmek ne güzel"))
                .body("userId", Matchers.lessThan(100));
    }
}
