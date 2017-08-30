package Lecture2;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean marry(Person person) {
        if (person.man == this.man || person.spouse == this)
            return false;

        if (this.spouse != null) {
            this.spouse.divorce();
            this.divorce();

        }

        if (person.spouse != null) {
            person.spouse.divorce();
            person.divorce();
        }

        this.spouse = person;
        person.spouse = this;

        return true;
    }

    public boolean divorce() {
        if (spouse != null) {
            spouse = null;
            return true;
        }
        return false;
    }
}
