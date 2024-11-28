import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class probTest {
    @Test
    void  sum() {
        prob calculator = new prob();
        int sum = calculator.sum(10,15);
        Assertions.assertEquals(25,sum);

    }
}