import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class D09 {
    @Test
    public void test()
    {
        /*
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

        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin",2021-06-01);
        bookingdates.put("checkout",2021-06-10);

        JSONObject booking=new JSONObject();
        booking.put("firstname","Ahmet");
        booking.put("lastname","Bulut");
        booking.put("totalprice",500);
        booking.put("depositpaid",false);
        booking.put("bookingdate",bookingdates);
        booking.put("additionalneeds","wi-fi");

        System.out.println(booking);

        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(booking.toString())
                .put("https://jsonplaceholder.typicode.com/posts/1");

        response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", Matchers.hasSize(24))
                .body("data.employee_name",Matchers.hasItem("Ashton Cox"))
                .body("data.employee_age",Matchers.hasItems(61,40,30));
    }
}
