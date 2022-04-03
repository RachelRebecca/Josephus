import soldier_enums.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class to represent a Soldier
 * Each soldier needs an ID
 */
public class Soldier
{
    private int id;
    private Names name;
    private HairColor hairColor;
    private EyeColor eyeColor;
    private UniformColor uniformColor;
    private Characteristics characterTrait;
    private int age;
    private boolean isAlive;
    private boolean isVictor;


    /**
     * Constructor for Soldier
     * (the ID number is passed maintain soldier uniqueness since most other traits are randomly chosen)
     * @param idNum: the soldier's ID which is passed through it as a parameter
     */
    public Soldier(int idNum)
    {
        id = idNum;
        Random rand = new Random();
        setName(rand);
        setEyeColor(rand);
        setHairColor(rand);
        setUniformColor(rand);
        setCharacterTrait(rand);
        age = ThreadLocalRandom.current().nextInt(20, 81);
        isAlive = true;
        isVictor = false;

    }

    /**
     * Randomly set the soldier's name from the name values of the Names enum
     * @param rand: used to randomly set the name
     */
    private void setName(Random rand)
    {
        int nameNumber = rand.nextInt(Names.values().length);
        name = Names.values()[nameNumber];
    }

    /**
     * Randomly set the soldier's eye color from the eye color values of the EyeColor enum
     * @param rand: used to randomly set the eye color
     */
    private void setEyeColor(Random rand)
    {
        int eyeNumber = rand.nextInt(EyeColor.values().length);
        eyeColor = EyeColor.values()[eyeNumber];
    }

    /**
     * Randomly set the soldier's hair color from the hair color values of the HairColor enum
     * @param rand: used to randomly set the hair color
     */
    private void setHairColor(Random rand)
    {
        int hairNumber = rand.nextInt(HairColor.values().length);
        hairColor = HairColor.values()[hairNumber];
    }

    private void setUniformColor(Random rand)
    {
        int uniformNumber = rand.nextInt(UniformColor.values().length);
        uniformColor = UniformColor.values()[uniformNumber];
    }

    /**
     * Randomly set the soldier's dominant character trait from the character trait values of the Characteristics enum
     * @param rand: used to randomly set the dominant character trait
     */
    private void setCharacterTrait(Random rand)
    {
        int characterNumber = rand.nextInt(Characteristics.values().length);
        characterTrait = Characteristics.values()[characterNumber];
    }

    /**
     * sets alive state of soldier
     * @param alive: if soldier is alive
     */
    public void setAlive(boolean alive)
    {
        isAlive = alive;
    }

    /**
     * sets victor state of soldier
     * @param victor: if soldier is the victor
     */
    public void setVictor(boolean victor)
    {
        isVictor = victor;
    }

    /**
     * getter for ID
     * @return int: id of soldier
     */
    public int getId()
    {
        return id;
    }

    /**
     * getter for name
     * @return String: name of soldier
     */
    public Names getName()
    {
        return name;
    }

    /**
     * getter for hair color
     * @return HairColor enum: hair color of soldier
     */
    public HairColor getHairColor()
    {
        return hairColor;
    }

    /**
     * getter for eye color
     * @return EyeColor enum: eye color of soldier
     */
    public EyeColor getEyeColor()
    {
        return eyeColor;
    }

    /**
     * getter for character trait
     * @return Characteristics enum: dominant character trait of soldier
     */
    public Characteristics getCharacterTrait()
    {
        return characterTrait;
    }

    /**
     * getter for age
     * @return int: age of soldier
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Draws the soldier's body based on its current state (victor, alive, not alive)
     * @return a String representing the body of the soldier at its current state
     */
    public String drawBody()
    {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        String body = "";

        if (isVictor)
        {
            String crown = uniformColor.toString() +
                           "\n     \\\\/|\\//" +
                            "\n      \\___/";
            body = crown +   "\n-----   O" +
                            "\n| | |  \\|/ =|===>" +
                            "\n\\_|_/   |" +
                             "\n       / \\ " +
                             "\n" + ANSI_RESET;
        }
        else if (isAlive)
        {
            String helmet = uniformColor.toString() +
                            "\n _" +
                            "\n| |";
            body = helmet + "\n O" +
                           "\n\\|/" +
                            "\n |" +
                            "\n/ \\" +
                            "\n" + ANSI_RESET;
        }
        else
        {
            body = ANSI_RED + "\n___ " + uniformColor.toString() +
                             "\n\\|/" +
                              "\n |" +
                              "\n/ \\ " + " O " +
                              "\n" + ANSI_RESET;
        }
        return body;
    }

    /**
     * represents the Solider object as a String
     * @return String: the soldier's name, ID, age, body, and dominant characteristic
     */
    @Override
    public String toString()
    {
        return  getName() + ", ID: " + getId() + ", age: " + getAge() +
                drawBody() +
                "characteristic: " + getCharacterTrait();
    }
}
