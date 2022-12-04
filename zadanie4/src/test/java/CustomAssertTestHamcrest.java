import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class IsTen extends TypeSafeMatcher<Integer> {
    @Override
    protected boolean matchesSafely(Integer s) {
        if(s != 10) {
            return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("only ten");
    }
}
class IsPositive extends TypeSafeMatcher<Integer> {
    @Override
    protected boolean matchesSafely(Integer s) {
        if(s < 0) {
            return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("only ten");
    }
}

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomAssertTestHamcrest {
    static Matcher<Integer> isTen() {
        return new IsTen();
    }
    static Matcher<Integer> isPositive() {
        return new IsPositive();
    }
    @Test
    public void testPositiveNumber(){
        assertThat(10, isPositive());
    }
    @Test
    public void testTen(){
        assertThat(10, isTen());
    }
}