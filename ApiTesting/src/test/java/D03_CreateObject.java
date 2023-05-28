import org.json.JSONObject;
import org.junit.Test;

public class D03_CreateObject {

    /*
    {
        "title":"Ahmet,
        "body":"Merhaba",
        "userId": 1
     }
     */

    @Test
    public void test()
    {
        JSONObject ilkobj = new JSONObject();
        ilkobj.put("title","Ahmet");
        ilkobj.put("body","Merhaba");
        ilkobj.put("userId","1");

        System.out.println(ilkobj);

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin","2021-04-23");
        bookingdates.put("checkin","2022-08-11");

        JSONObject outerJson = new JSONObject();
        outerJson.put("firstname","Jim");
        outerJson.put("additionalneeds","Breakfast");
        outerJson.put("bookingdates",bookingdates);
        outerJson.put("totalprice",111);
        outerJson.put("firstname",true);
        outerJson.put("lastname","Brown");

        System.out.println(outerJson);

    }
}
