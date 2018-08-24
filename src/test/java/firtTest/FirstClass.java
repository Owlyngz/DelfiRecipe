package firtTest;

import org.junit.Test;

public class FirstClass {
    private Integer a = 10;
    private Integer b = 15;
    private Integer sum = firstMethod();

    private int firstMethod() {
        return sum = a + b;
    }

    @Test
    public void thirdMethod() {
        sum = firstMethod();
        System.out.println(sum);

    }
}



