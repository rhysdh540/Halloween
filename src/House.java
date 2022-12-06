import java.util.ArrayList;
import java.util.Random; // easier for ranges than using Math.random()

public class House {
    private final String address;
    private final boolean isDecorated;
    private final int candyCount; // how much candy the house gives out to each person who visits
    private ArrayList<Person> peopleVisited = new ArrayList<>(); // a list of people who visited this house
    private int tricksPlayed = 0; // how many tricks were played on this house
    private final TrickOrTreat.Candy candyGiven = TrickOrTreat.Candy.getRandomCandy(); // the type of candy given out by this house
    private int candyGivenOut = 0; // total amount of candy given out by this house

    public House(String address, boolean isDecorated) {
        this.address = address;
        this.isDecorated = isDecorated;
        this.candyCount = isDecorated ? new Random().nextInt(1, 11) : 0; // house gives out no candy if not decorated, else a random number between 1 and 10
    }

    /* getters and setters */
    public boolean isDecorated() { return isDecorated; }
    public String getAddress() { return address; }
    public int giveOutCandy() { return candyCount; }
    public TrickOrTreat.Candy candyGiven() { return candyGiven; }
    public int getTricksPlayed() { return tricksPlayed; }
    public void playTrick() { tricksPlayed++; }
    public int numPeopleVisited() { return peopleVisited.size(); }
    public void getVisitedBy(Person person) { peopleVisited.add(person); candyGivenOut += candyCount; }

    /**
     * Generates a random address
     * @return a random address
     */
    public static String makeRandomAddress(){                                                                                                                                                                                                                                                 //haha breaking bad reference
        final String[] names = {"Murphy", "Ford", "Ethels", "Essex", "Williams Mine", "Lords", "Moonlight", "West Side", "Brackley", "Berkshire", "Massachusets", "Perry", "Southern", "Caldwell", "Pratt", "Gregory", "Echo", "Bible", "Valley", "Round Table", "McDowell", "Jesse", "Brown", "Yellow", "Walter", "White"};
        final String[] streets = {"Court", "Street", "Lane", "Way", "Drive", "Avenue", "Road", "Circle", "Boulevard", "Alley", "Park"};
        return new Random().nextInt(1, 10000) + " " + names[new Random().nextInt(0, names.length)] + " " + streets[new Random().nextInt(0, streets.length)];
    }

    /**
     * Prints a summary of the house's trick or treating experience
     * <br>
     * not used in this project, but just in case :shrug:
     */
    public void printOverview() {
        if(isDecorated)
            System.out.println(address + " was visited by " + peopleVisited.size() + " people and gave out " + candyGivenOut + " pieces of candy. " + "No tricks were played on this house because it was decorated.");
        else
            System.out.println(address + " was visited by " + peopleVisited.size() + " people and gave out no candy. " + tricksPlayed + " tricks were played on this house because it was not decorated.");
    }
}
