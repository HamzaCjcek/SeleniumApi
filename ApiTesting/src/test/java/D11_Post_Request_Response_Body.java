import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class D11_Post_Request_Response_Body {

    /*
    C12_Post_ExpectedDataVeJsonPathIleAssertion
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
    request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
    POST REQUEST, RESPONSE BODY BILGILERINI
    ASSERT YAPARKEN JSONPATH KULLANMA
Response Body
{
       "bookingid": 24,
        "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
        "checkin": "2021-06-01",
        "checkout": "2021-06-10"
                    },
        "additionalneeds": "wi-fi"
        }
}
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
    public void test()
    {
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-01");
        JSONObject json = new JSONObject();
        json.put("firstname","Ahmet");
        json.put("lastname","Bulut");
        json.put("totalprice",500);
        json.put("depositpaid",false);
        json.put("bookingdate",bookingdates);
        json.put("additionalneeds","wi-fi");

        System.out.println(json);

        Response response2 = given().
                contentType(ContentType.JSON).
                when().
                body(json.toString())
                .put("https://jsonplaceholder.typicode.com/posts/24");
        response2.prettyPrint();

        JsonPath resjsPath = response2.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(json.get("firstname"),resjsPath.get("firstname"));
        softAssert.assertAll();


    }
}
