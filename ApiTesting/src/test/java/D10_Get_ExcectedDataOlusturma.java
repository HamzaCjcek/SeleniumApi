import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class D10_Get_ExcectedDataOlusturma {
    /*
    C11_Get_ExpectedDataOlusturma
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
    yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunu test
    ediniz
    Response body :
    {
    "userId": 3,
    "id": 22,
    "title": "dolor sint quo a velit explicabo quia nam",
    "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */
    @Test
    public void test()
    {
        JSONObject expBody = new JSONObject();
        expBody.put("userId",3);
        expBody.put("id","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut sed omnis non odio expedita ear um mollitia molestiae aut atque rem suscipit nam impedit esse");
        System.out.println(expBody);

        Response response = given().when().get("https://jsonplaceholder.typicode.com/posts/22");

        response.prettyPrint();

        JsonPath resjsPath = response.jsonPath();
        Assert.assertEquals(expBody.get("userId"),3);
        Assert.assertEquals(expBody.get("userId"),resjsPath.get("userId"));
        System.out.println((Integer) resjsPath.get("userId"));
    }
}
