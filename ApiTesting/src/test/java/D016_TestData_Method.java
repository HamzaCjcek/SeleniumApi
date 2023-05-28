import org.json.JSONObject;

public class D016_TestData_Method {

    public JSONObject bookingdatesJson()
    {
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");
        return bookingdates;
    }

    public JSONObject reqBodyJson()
    {
        JSONObject object = new JSONObject();
        object.put("firstname","Ahmet");
        object.put("lastname","Bulut");
        object.put("totalprice",500);
        object.put("depositpaid",false);
        object.put("additionalneeds","wi-fi");
        return object;
    }

}
