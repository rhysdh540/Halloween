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
        int totalHousesVisited = 0, totalDecoratedHouses = 0;
        for(Person person : people) {
            for(int i : new int[new Random().nextInt(10, 16)]) { // trick or treats 10-15 times
                totalDecoratedHouses += person.trickOrTreat(houses[new Random().nextInt(0, houses.length)]) ? 1 : 0;
                totalHousesVisited++;
            }
            while(person.getTrickPlayedOn() == null) {// if they didn't play a trick, keep trying until they do
                totalDecoratedHouses += person.trickOrTreat(houses[new Random().nextInt(0, houses.length)]) ? 1 : 0;
                totalHousesVisited++;
            }
            person.printOverview();
        }
        System.out.println("Tonight, \033[96;1m" + totalHousesVisited + "\033[0m houses were visited, and \033[96;1m" + totalDecoratedHouses + "\033[0m of them were decorated.");
    }
}