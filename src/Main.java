import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /* create a bunch of houses */
        House[] houses = new House[100];
        for (int i = 0; i < houses.length; i++) {
            houses[i] = new House(House.makeRandomAddress(), !(Math.random() > 0.75));
        }

        /* 5 people */
        Person[] people = {
                new Person("Bob", "pirate"),
                new Person("Sally", "witch"),
                new Person("Joe", "ghost"),
                new Person("Sue", "vampire"),
                new Person("John", "zombie")
        };

        /* simulate trick or treating */
        for(Person person : people) {
            for(int i : new int[new Random().nextInt(10, 16)]) // trick or treats 10-15 times
                person.trickOrTreat(houses[new Random().nextInt(0, houses.length)]);

            while(person.getTrickPlayedOn() == null) // if they didn't play a trick, keep trying until they do
                person.trickOrTreat(houses[new Random().nextInt(0, houses.length)]);

            person.printOverview();
        }
    }
}