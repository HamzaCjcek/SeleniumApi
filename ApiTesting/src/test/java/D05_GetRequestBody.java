import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class D05_GetRequestBody {

    @Test
    public void testGetRequestBody()
    {
        Response response = given().when().get("https://jsonplaceholder.typicode.com/posts/70");

        response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("userId", Matchers.equalTo(7))
                .body("title", Matchers.equalTo("optio dolar molestias sit"))//voluptatem laborum magni
                .statusLine("HTTP/1.1 200 OK");


    }
}
