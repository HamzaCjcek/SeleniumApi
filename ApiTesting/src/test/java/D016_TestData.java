import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class D016_TestData extends D12_BaseUrl_Setup{
        /*
        Request body
        {
        "firstname" : "Ahmet",
        "lastname" : “Bulut",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
        "checkin" : "2021-06-01",
        "checkout" : "2021-06-10"
         },
        "additionalneeds" : "wi-fi"
        }
         */
    @Test
    public void post01()
    {
        D016_TestData_Method test = new D016_TestData_Method();
        test.bookingdatesJson();
        test.reqBodyJson();
        test.reqBodyJson().put("bookingdates",test.bookingdatesJson());
        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(test.reqBodyJson().put("bookingdates",test.bookingdatesJson()).toString())
                .put("https://jsonplaceholder.typicode.com/posts/10");
        response.prettyPrint();
    }

    @Test
    public void post02()
    {
        int statuscode=200;
        scepHerokuapp.pathParam("pp1","booking");
        D016_TestData_Method test = new D016_TestData_Method();
        JSONObject booking = test.bookingdatesJson();
        JSONObject reqBodyJson = test.reqBodyJson();
        JSONObject reqBody = test.reqBodyJson().put("bookingdates",test.bookingdatesJson());

        Response response = given().
                spec(scepHerokuapp).
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                get("/{pp1}");

        response.prettyPrint();

        JsonPath resJP = response.jsonPath();
        Assert.assertEquals(statuscode,response.getStatusCode());
    }
}
