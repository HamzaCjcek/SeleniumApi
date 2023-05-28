import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class D02 {
    @Test
    public void test()
    {
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/10");

        response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");// then değerlendirme için assertThat kontrol için
    }
}
