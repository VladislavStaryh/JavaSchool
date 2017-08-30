package Lecture2;

public class Main {

    public static void main(String[] args) {
        Person Jack = new Person(true, "Jack");
        Person Mary = new Person(false, "Mary");
        Person John = new Person(true, "John");
        Person Amy = new Person(false, "Amy");

        System.out.println(Jack.marry(Mary));
        System.out.println(John.marry(Amy));
        System.out.println(Jack.marry(John));
        System.out.println(Mary.marry(Amy));
        System.out.println(Jack.marry(Mary));
        System.out.println(John.marry(Amy));
        System.out.println(John.marry(Mary));
        System.out.println(Jack.marry(Amy));

    }


}
