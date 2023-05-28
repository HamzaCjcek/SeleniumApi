import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class D015_TestDataClass extends D015_Setup{
    /*
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
        specHerokuapp.pathParams("pp1","posts","pp2",22);
        JSONObject expBody= new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut nsed omnis non odio nexpedita ear um mollitia molestiae aut atque rem suscipit\\nnam impedit esse");
        Response response = given().spec(specHerokuapp).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

        JsonPath respJP=response.jsonPath();

        Assert.assertEquals(expBody.get("userId"),respJP.get("userId"));
        Assert.assertEquals(expBody.get("id"),respJP.get("id"));
        Assert.assertEquals(expBody.get("title"),respJP.get("title"));
        //Assert.assertEquals(expBody.get("body"),respJP.get("body"));
    }
}
