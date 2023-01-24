package chapter2.string_calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator scal;
    @BeforeEach
    void init() {
        scal = new StringCalculator();
    }

    @Test
    void 숫자열배열테스트_쉼표() {
        String testInput = "3,4,5";
        int[] splitedInts = scal.getSplitedInts(testInput);
        assertEquals(3, splitedInts.length);
    }

    @Test
    void 숫자열배열테스트_콜론() {
        String testInput = "3:4:5";
        int[] splitedInts = scal.getSplitedInts(testInput);
        assertEquals(3, splitedInts.length);
    }

    @Test
    void 숫자열배열테스트_음수() {
        String testInput = "-3:4:5";
        assertThrows(RuntimeException.class, () -> {
            scal.getSplitedInts(testInput);
        });
    }

    @Test
    void 숫자열배열테스트_다른_구분자() {
        String testInput = "3+4;5";
        assertThrows(RuntimeException.class, () -> {
            scal.getSplitedInts(testInput);
        });
    }

    @Test
    void 숫자열배열덧셈테스트_쉼표() {
        String testInput = "3,4,5,6,7";
        int[] splitedInts = scal.getSplitedInts(testInput);
        int i = scal.addAll(splitedInts);
        assertEquals(25, i);
    }

    @Test
    void 숫자열배열덧셈테스트_콜론() {
        String testInput = "3:4:5:6:7";
        int[] splitedInts = scal.getSplitedInts(testInput);
        int i = scal.addAll(splitedInts);
        assertEquals(25, i);
    }

}