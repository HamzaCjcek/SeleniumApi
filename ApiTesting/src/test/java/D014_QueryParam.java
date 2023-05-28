import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class D014_QueryParam extends D12_BaseUrl_Setup{
    @Test
    public void test()
    {
        scepHerokuapp.pathParam("a","booking").queryParam("firstname","Eric");
        Response response = given().spec(scepHerokuapp).when().get("/{a}");
        response.prettyPrint();

        scepHerokuapp.pathParam("b","booking").queryParams("firstname","Jim","lastname","Jackson");
        response=given().spec(scepHerokuapp).when().get("/{b}");
        response.prettyPrint();
    }
}
