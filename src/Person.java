import java.util.ArrayList;

public class Person {
    private final String name;
    private final String costume;
    private int candyCount;
    private ArrayList<House> housesVisited = new ArrayList<>();
    private int numTricksPerformed = 0;
    private final TrickOrTreat.Candy favoriteCandy = TrickOrTreat.Candy.getRandomCandy();
    private House gotFavoriteCandy; // the house they got their favorite candy from (null if they didn't get it)
    private House trickPlayedOn;

    public Person(String name, String costume) {
        this.name = name;
        this.costume = costume;
        this.candyCount = 0;
    }

    /* getters and setters */
    public String getName() { return name; }
    public String getCostume() { return costume; }
    public int getCandyCount() { return candyCount; }
    public int numHousesVisited() { return housesVisited.size(); }
    public String getFavoriteCandy() { return favoriteCandy.toString(); }
    public int getNumTricksPerformed() { return numTricksPerformed; }
    public House getTrickPlayedOn() { return trickPlayedOn; }

    /**
     * Simulates trick or treating at a house
     * @param house the house to trick or treat at
     * @return true if the trick or treater received candy, false if they didn't
     */
    public boolean trickOrTreat(House house) {
        this.housesVisited.add(house);
        house.getVisitedBy(this);
        if (house.isDecorated()) {
            this.candyCount += house.giveOutCandy();
            if(house.candyGiven() == favoriteCandy)
                this.gotFavoriteCandy = house;
            return true;
        } else {
            numTricksPerformed++;
            this.trickPlayedOn = house;
            house.playTrick();
            return false;
        }
    }

    /**
     * Prints a summary of the person's trick or treating experience
     * <br>
     * Example output:
     * <pre>
     *    NAME, dressed as a COSTUME, visited COUNT houses and got COUNT pieces of candy. They got their favorite candy, CANDY, at ADDRESS.(or They didn't get their favorite candy, CANDY.) They played the trick of TRICK COUNT times, once on ADDRESS. (or They didn't play any tricks.) They arrived to their home at ADDRESS by TIME.
     * </pre>
     */
    public void printOverview(){
        System.out.print("\033[2J\033[H\033[96;1m" + name + "\033[0m, dressed as \033[96;1m" + costume + "\033[0m, visited \033[96;1m" + housesVisited.size() + "\033[0m houses and got \033[96;1m" + candyCount + "\033[0m pieces of candy. ");
        if(gotFavoriteCandy != null)
            System.out.print("\033[92mThey got their favorite candy, \033[96;1m" + favoriteCandy + "\033[0;92m, at \033[96;1m" + gotFavoriteCandy.getAddress() + "\033[0;92m.");
        else
            System.out.print("\033[91mThey didn't get their favorite candy, \033[96;1m" + favoriteCandy + "\033[0;91m.");

        if(numTricksPerformed == 0) // shouldn't happen since we took care of that in the main method
            System.out.print(" \033[91mThey didn't play any tricks.\033[0m");
        else
            System.out.print(" \033[92mThey played the trick of \033[91;1m" + TrickOrTreat.randomTrick() + " \033[96m" + numTricksPerformed + "\033[0;92m time" + (numTricksPerformed == 1 ? "" : "s") + ", once at \033[96;1m" + trickPlayedOn.getAddress() + "\033[0;92m. ");

        System.out.println("\033[0mThey arrived to their home at \033[96;1m" + House.makeRandomAddress() + "\033[0m by \033[96;1m" + TrickOrTreat.arriveTime() + "\033[0m.\n");
    }

}
