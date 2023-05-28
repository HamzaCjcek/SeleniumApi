import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class D07_BodyTekrarlardanKurtulma {

    @Test
    public void test()
    {
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/10");
        response.prettyPrint();

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.containsString("Eric")).
                body("lastname", Matchers.containsString("Jones")).
                body("totalprice",Matchers.equalTo(572)).
                body("depositpaid",Matchers.equalTo(false));

    }
}
