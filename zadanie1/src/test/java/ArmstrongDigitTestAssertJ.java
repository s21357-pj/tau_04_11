import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pjatk.tau.BigArmstrongNumber;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ArmstrongDigitTestAssertJ {

    @Test
    @DisplayName("Test BigArmstrong is Class")
    public void testInstance(){
        assertThat(pjatk.tau.BigArmstrongNumber.class).isExactlyInstanceOf(Class.class);
    }

    @ParameterizedTest
    @DisplayName("Is digit really Armstrong")
    @ValueSource(strings = {"9"})
    public void testArmstrongDigitTrue(String candidate){
        assertThat(BigArmstrongNumber.isArmstrong(new BigInteger(candidate))).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Is digit not Armstrong")
    @ValueSource(strings = {"10", "11"})
    public void testArmstrongDigitFalse(String candidate){
        assertThat(BigArmstrongNumber.isArmstrong(new BigInteger(candidate))).isFalse();
    }

    @ParameterizedTest
    @DisplayName("Is response not null")
    @ValueSource(strings = {"10", "11"})
    public void testArmstrongResponseNotNull(String candidate){
        assertThat(BigArmstrongNumber.isArmstrong(new BigInteger(candidate))).isNotNull();
    }

    @ParameterizedTest
    @DisplayName("Is string throw exception")
    @ValueSource(strings = {"magic"})
    public void testArmstrongDigitStringException(String candidate){
        assertThatThrownBy(() -> {BigArmstrongNumber.isArmstrong(new BigInteger(candidate));}).
                isInstanceOf(java.lang.NumberFormatException.class).hasMessageContaining(candidate);
    }

}