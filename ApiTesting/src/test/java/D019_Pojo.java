import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class D019_Pojo extends D019_Setup2{

    private int bookingid=24;
    private D019_Setup2 booking;


}
