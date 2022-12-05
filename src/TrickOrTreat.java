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
        GUMMY_WORMS;

        /**
         * gets a random candy from the enum
         *
         * @return a random candy
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
        return new String[]{"telling people that the house was haunted", "placing glowing eyes in a bush", "covering a wall in Silly String", "ringing the doorbell and running away", "dropping a fake snake through the mail hole"}[new Random().nextInt(0, 5)];
    }

    /**
     * generates a random time, rounded to 15 minutes, between 6:00 and 11:45
     * @return a random time
     */
    public static String arriveTime(){
        return new Random().nextInt(6, 12) + ":" +
                new int[]{0, 15, 30, 45}[new Random().nextInt(0, 4)];
    }
}
