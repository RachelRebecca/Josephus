package soldier_enums;

/**
 * Enum class with the various options for hair color, and a toString() method for more appealing spelling
 */
public enum HairColor
{
    BLOND ("blond"),
    BLACK ("black"),
    BROWN ("brown"),
    RED ("red"),
    GRAY ("gray");

    private final String color;

    /**
     * HairColor enum constructor
     * @param hairColor: the hair color the enum value represents
     */
    HairColor(String hairColor)
    {
        color = hairColor;
    }

    /**
     * Represents HairColor enum value as a String
     * @return String: the hair color
     */
    public String toString()
    {
        return color;
    }
}
