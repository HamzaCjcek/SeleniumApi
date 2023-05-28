import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class D12_BaseUrl_Setup {
    protected RequestSpecification scepHerokuapp;

    @Before
    public void setup() throws Exception
    {
        scepHerokuapp=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

    }

}
