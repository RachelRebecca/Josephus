package soldier_enums;

/**
 * Enum class with the various options for eye color, and a toString() method for more appealing spelling
 */
public enum EyeColor
{
    BROWN ("brown"),
    BLUE ("blue"),
    GREEN ("green"),
    HAZEL ("hazel"),
    GRAY ("gray"),
    BLACK ("black");

    private final String color;
    /**
     * EyeColor enum constructor
     * @param eyeColor: the eye color the enum value represents
     */
    EyeColor (String eyeColor)
    {
        color = eyeColor;
    }

    /**
     * Represents EyeColor enum value as a String
     * @return String: the eye color
     */
    public String toString()
    {
        return color;
    }
}
