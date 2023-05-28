import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import java.util.HashMap;

public class D015_Setup {
    protected RequestSpecification specHerokuapp;

    @Before
    public void setup() throws Exception
    {
        specHerokuapp=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();

    }
    public HashMap reqBodyMap()
    {
        HashMap<String,Object> reqBody = new HashMap<>();
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        return reqBody;
    }
    private String title;
    private String body;
    private int userId;
    private int id;

    public D015_Setup() { // parametresiz contrucator
    }

    public D015_Setup(String title, String body, int userId, int id) { // parametreli
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }
    // GET SET
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    // To String
    @Override
    public String toString() {
        return "D018{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId='" + userId + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
