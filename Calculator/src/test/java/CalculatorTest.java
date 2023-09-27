import br.edu.unifal.Calculator;
import br.edu.unifal.DivisionByZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("#add > When both numbers are positive > Return a positive number")
    void addWhenBothNumbersArePositiveReturnAPositiveNumber(){
        int result = calculator.add(3,4);
        Assertions.assertEquals(7,result);
    }

    @Test
    @DisplayName("#add > When both numbers are negative > Return a negative number")
    void addWhenBothNumbersAreNegativeReturnANegativeNumber(){
        int result = calculator.add(-3,-4);
        Assertions.assertEquals(-7,result);
    }

    @Test
    @DisplayName("#add > when one number is positve and the other is negative > return a positive number")
    void addWhenOneNumbersIsPositiveAndTheOtherIsNegativeReturnAPositiveNumber(){
        int result = calculator.add(-3,4);
        Assertions.assertEquals(1,result);
    }

    @Test
    @DisplayName("#add > when one number is positive and the other is negativa > return a negative number")
    void addWhenOneNumbersIsPositiveAndTheOtherIsNegativeReturnANegativeNumber(){
        int result = calculator.add(3,-4);
        Assertions.assertEquals(-1,result);
    }
    @Test
    @DisplayName("#add > when one number is zero > return the given number")
    void addWhenOneNumbersIsZeroReturnTheGivenNumber(){
        int result = calculator.add(3,0);
        int secondResult = calculator.add(0,4);
        Assertions.assertAll(
                () -> Assertions.assertEquals(3,result),
                () -> Assertions.assertEquals(4,secondResult)
        );
    }

    @Test
    @DisplayName("#add > when one numbers is negative and the another is zero > return the given number")
    void addWhenOneNumbersIsNegativeAndTheAnotherIsZeroReturnTheGivenNumber(){
        int result = calculator.add(-3,0);
        int secondResult = calculator.add(0,-4);
        Assertions.assertAll(
                () -> Assertions.assertEquals(-3,result),
                () -> Assertions.assertEquals(-4,secondResult)
        );
    }

    @Test
    @DisplayName("#add > when the both numbers are zero > throw exception")
    void addWhenBothNumbersAreZeroReturnZero() {
        int result = calculator.add(0, 0);
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("#divide > when the divisor is zero > throw exception")
    void divideWhenTheDivisorIsZeroTrhowAnException() {
        Assertions.assertThrows(DivisionByZeroException.class, ()->{
            calculator.divide(5 , 0);
       });
    }

    @Test
    @DisplayName("#divide > when both number are negative > return a positive number")
    void divideWhenBothNumbersAreNegativeReturnAPositiveNumber(){
        try {
            float result = calculator.divide(-10,-2);
            Assertions.assertEquals(5, result);
        }catch (DivisionByZeroException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("#divide > when both number are positive > return a positive number")
    void divideWhenBothNumbersArePositiveReturnAPositiveNumber(){
        try {
            float result = calculator.divide(10,2);
            Assertions.assertEquals(5, result);
        }catch (DivisionByZeroException e){
            System.out.println(e.getMessage());
        }

    }







}
