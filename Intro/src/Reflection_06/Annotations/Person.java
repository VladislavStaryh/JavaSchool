package Reflection_06.Annotations;

public class Person {
    @Length(min=2, max=30)
    public String Name;

    public Person(String name) {
        Name = name;
    }
}
