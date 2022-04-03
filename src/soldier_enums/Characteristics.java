package soldier_enums;

/**
 * Enum class for dominant characteristics of the soldier
 */
public enum Characteristics
{
    STRONG ("strong"),
    HAPPY ("happy"),
    BRAVE ("brave"),
    HOPEFUL ("hopeful"),
    VALIANT ("valiant"),
    FIGHTER ("fighter"),
    DETERMINED ("determined"),
    EFFICIENT ("efficient"),
    POWERFUL ("powerful"),
    COURAGEOUS ("courageous"),
    LOVING ("loving"),
    DISCIPLINED ("disciplined"),
    GENUINE ("genuine"),
    AMBITIOUS ("ambitious"),
    HONEST ("honest"),
    SINCERE ("sincere"),
    LOYAL ("loyal"),
    FAMILY_ORIENTED ("family-oriented"),
    MONEY_HUNGRY ("money-hungry"),
    OPTIMISTIC ("optimistic"),
    ENERGETIC ("energetic"),
    POSITIVE ("positive"),
    NEGATIVE ("negative"),
    LONELY ("lonely"),
    CRUEL ("cruel"),
    CURIOUS ("curious"),
    WILD ("wild"),
    BARBARIC ("barbaric"),
    INTELLIGENT ("intelligent"),
    IMMATURE ("immature"),
    WISE ("wise"),
    TRUSTWORTHY ("trustworthy"),
    DARING ("daring"),
    COMPASSIONATE ("compassionate"),
    UNSELFISH ("unselfish"),
    SELFISH ("selfish"),
    GENEROUS ("generous"),
    MANIPULATIVE ("manipulative"),
    NARCISSISTIC ("narcissistic"),
    HERETICAl ("heretical");

    private final String characterTrait;

    /**
     * Characteristics constructor
     * @param characteristic: the characteristic in appealing form
     */
    Characteristics(String characteristic)
    {
        characterTrait = characteristic;
    }

    /**
     * represents the Characteristics enum value as a String
     * @return String: the character trait in its appealing form
     */
    public String toString()
    {
        return characterTrait;
    }
}
