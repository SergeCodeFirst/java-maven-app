import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.example.Application;

public class AppTest {
    @Test
    public void testApp() {
        Application myApp = new Application();
        String result = myApp.getStatus();
        assertEquals("OK", result);
    }
}
