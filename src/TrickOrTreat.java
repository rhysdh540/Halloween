import java.util.Random;

public class TrickOrTreat {
    public enum Candy {
        CANDY_CORN,
        GUMMY_BEARS,
        LOLLIPOPS,
        CHOCOLATE_BARS,
        GUM,
        CANDIED_APPLE,
        CANDY_CANES,
        SMARTIES,
        JOLLY_RANCHERS,
        GUMMY_WORMS,
        CANDY_APPLES;


        /**
         * Returns a random candy from the enum
         *
         * @return a random candy from the enum
         */
        static Candy getRandomCandy() {
            return values()[new Random().nextInt(values().length)];
        }

        /**
         * turns a candy into a String
         *
         * @return a String representation of the candy
         */
        public String toString() {
            if (this == JOLLY_RANCHERS) return "Jolly Ranchers"; // because capitalization
            return this.name().toLowerCase().replace("_", " ");
        }
    }

    /**
     * returns a random trick to play
     * @return a random trick
     */
    public static String randomTrick(){
        String[] tricks = {"telling people that the house was haunted", "placing glowing eyes in a bush", "covering a wall in Silly String", "ringing the doorbell and running away", "dropping a fake snake through the mail slot"};
        return tricks[new Random().nextInt(0, tricks.length)];
    }

    /**
     * generates a random time, rounded to 15 minutes, between 6:00 and 11:45
     * @return a random time
     */
    public static String arriveTime(){
        return new Random().nextInt(6, 12) + ":" +
                new String[]{"00", "15", "30", "45"}[new Random().nextInt(0, 4)];
    }
    public static String randomCostume(){
        String[] costumes = {"a pirate", "a witch", "a ghost", "a vampire", "a zombie", "a werewolf", "a mummy", "a clown", "a superhero", "a princess", "a cowboy", "a ninja", "a robot", "an astronaut", "a police officer", "a firefighter", "a doctor", "a nurse", "a chef", "a construction worker", "a farmer", "a pilot", "a horse", "a sheep", "a goat", "an elephant", "a lion", "a tiger", "a bear", "a monkey", "a giraffe", "a zebra", "a hippo", "Davis Clarke", "an iPhone 14 Pro Max", "Walter White", "Duke, the Java mascot", "a dude in a Norway sweater", "Connor Rusch", "an electron", "Dark Father", "Copper (II) Acetate (aq)", "Mr. And Mrs. Thomas M. Cole", "a sussy baka"};
        return costumes[new Random().nextInt(0, costumes.length)];
    }
}
