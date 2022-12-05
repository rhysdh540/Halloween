import java.util.Random;

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
     * @return a random candy
     */
    static Candy getRandomCandy() {
        return values()[new Random().nextInt(values().length)];
    }

    /**
     * turns a candy into a String
     * @return a String representation of the candy
     */
    public String toString(){
        if(this == JOLLY_RANCHERS) return "Jolly Ranchers"; // because capitalization
        return this.name().toLowerCase().replace("_", " ");
    }
}
