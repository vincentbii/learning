package io.bii.geeks;


public class Tester extends Test1 {

    public static void main(String[] args) {
        Bii.safe.names("vincent");
    }

}

class Test1 extends Test2 {

}

class Test2 {

    void hey() {
        System.out.println("hey");
    }
}