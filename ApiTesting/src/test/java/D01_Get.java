import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class D01_Get {
    @Test
    public void test()
    {
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/10");
        response.prettyPrint(); // YAzdırır
        System.out.println(response.getStatusCode()); // Durum kodu
        System.out.println(response.getContentType()); // İçerik türü  application/json; charset=utf-8  header altında content type
        System.out.println(response.getHeader("Server"));// Cowboy
        System.out.println(response.getHeader("Connection"));// keep-alive
        System.out.println(response.getStatusLine()); // HTTP/1.1 200 OK
        System.out.println(response.getTime()); // 1415

    }
}
