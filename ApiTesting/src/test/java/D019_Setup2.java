import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class D019_Setup2 {
    private String firstname;
    private String lastname;
    private int totalprice;
    private D019_Setup bookingdates;
    private Boolean depositpaid;
    private String additionalneeds;
}
