import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<Person> someCollection = new ArrayList<>();

        someCollection.add(new Person("P1", 12));
        someCollection.add(new Person("P2", 65));


        Map map = Streams.of(someCollection)
                .filter(p -> p.getAge() < 25)
                .transform(p -> new Person(p.getName()+"!",p.getAge() + 30))
                .toMap(Person::getName, p -> p);

        System.out.println(map);
        System.out.println(someCollection);


    }

}