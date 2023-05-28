import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class D12_BaseUrl extends D12_BaseUrl_Setup{
    @Test
    public void test()
    {
        scepHerokuapp.pathParams("pp1","booking","pp2",1);
        Response response = given().spec(scepHerokuapp).get("/{pp1}/{pp2}");
        response.prettyPrint();
    }
}
