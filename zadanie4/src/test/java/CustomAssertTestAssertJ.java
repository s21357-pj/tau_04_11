import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

class DigitsAssert extends AbstractAssert<DigitsAssert, Integer> {
    public DigitsAssert(Integer actual) {
        super(actual, DigitsAssert.class);
    }

    public DigitsAssert isTen() {
        if (actual != 10) {
            failWithMessage("Expected 10 but was <%s>", actual.toString());
        }
        return myself;
    }

    public DigitsAssert isGraterTen() {
        if (actual < 10) {
            failWithMessage("To be greater than 10 but was <%s>", actual.toString());
        }
        return this;
    }
    public static DigitsAssert assertThat(Integer actual) {
        return new DigitsAssert(actual);
    }
}



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomAssertTestAssertJ {
    @Test
    public void testPositiveNumber(){
        DigitsAssert.assertThat(11).isGraterTen();
    }
    @Test
    public void testTen(){
        DigitsAssert.assertThat(10).isTen();
    }
}
