import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pjatk.tau.BigArmstrongNumber;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class ArmstrongDigitTestHamcrest {

    @Test
    @DisplayName("Test BigArmstrong is Class")
    public void testInstance(){
        assertThat(BigArmstrongNumber.class, instanceOf(Class.class));
    }

    @ParameterizedTest
    @DisplayName("Is digit really Armstrong")
    @ValueSource(strings = {"9"})
    public void testArmstrongDigitTrue(String candidate){
        assertThat(BigArmstrongNumber.isArmstrong(new BigInteger(candidate)), is(true));
    }

    @ParameterizedTest
    @DisplayName("Is it works")
    @ValueSource(strings = {"9"})
    public void testArmstrongWorks(String candidate){
        assertThat(BigArmstrongNumber.isArmstrong(new BigInteger(candidate)), anything());
    }

    @ParameterizedTest
    @DisplayName("Is digit not Armstrong")
    @ValueSource(strings = {"10", "11"})
    public void testArmstrongDigitFalse(String candidate) {
        assertThat(BigArmstrongNumber.isArmstrong(new BigInteger(candidate)), isOneOf(false));
    }

    @ParameterizedTest
    @DisplayName("Is response not null")
    @ValueSource(strings = {"10", "11"})
    public void testArmstrongResponseNotNull(String candidate) {
        assertThat(BigArmstrongNumber.isArmstrong(new BigInteger(candidate)), notNullValue());
    }

}