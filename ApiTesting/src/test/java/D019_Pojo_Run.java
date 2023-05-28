import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class D019_Pojo_Run extends D12_BaseUrl_Setup{
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
   */
    @Test
    public void test()
    {
        scepHerokuapp.pathParam("pp1","booking");
        D019_Setup setup = new D019_Setup("2021-06-01","2021-06-10"); // Checkin and Checkout
        D019_Setup2 setup2= new D019_Setup2("Ahmet","Bulut",500,setup,false,"wi-fi");
        D019_Pojo expBody = new D019_Pojo(24,setup2);

        Response response = given().spec(scepHerokuapp)
                .contentType(ContentType.JSON).when()
                .body(setup2)
                .post("/{pp1}");

    }
}
