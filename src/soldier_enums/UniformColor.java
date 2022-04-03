package soldier_enums;

/**
 * Enum class representing Uniform colors of the soldier
 * Colors use ANSI colors
 */
public enum UniformColor
{
    ANSI_RED ("\u001B[31m"),
    ANSI_GREEN ("\u001B[32m"),
    ANSI_YELLOW ("\u001B[33m"),
    ANSI_BLUE ("\u001B[34m"),
    ANSI_PURPLE ("\u001B[35m"),
    ANSI_CYAN ("\u001B[36m"),
    ANSI_WHITE ("\u001B[37m");

    private final String color;

    /**
     * Constructor for UniformColor enum
     * @param ansiColor: the ANSI color to make console text with the enum color value
     */
    UniformColor(String ansiColor)
    {
        color = ansiColor;
    }

    /**
     * When the color is called using the toString() the String value colors the console text accordingly
     * @return String: the color in ANSI
     */
    public String toString()
    {
        return color;
    }
}
