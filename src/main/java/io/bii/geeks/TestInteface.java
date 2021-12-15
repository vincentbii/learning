package io.bii.geeks;

public interface TestInteface {
     String name = "Vincent";
    void tester();

    static void tester3() {
        System.out.println("static");
    }

    default void tester2() {
        System.out.println("default");
    }
}
