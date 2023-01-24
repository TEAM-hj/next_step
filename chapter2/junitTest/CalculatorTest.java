package chapter2.junitTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator cal;

    @BeforeEach
    public void stup() {
        cal = new Calculator();
    }

    @Test
    public void add() {
        assertEquals(9,cal.add(6,3));
    }

    // 결과값을 프로그램을 통해 자동화
    @Test
    public void subtract() {
        assertEquals(3, cal.subtract(6,3));
    }
}