import java.util.Scanner;

/**
 * Program to simulate the Josephus problem
 */
public class Josephus
{
    public static void main(String[] args)
    {
        int numSoldiers = getNumber("number of soldiers");
        int count = getNumber("the count to skip soldiers by");

        //add requested number of soldiers to GCList
        GCList<Soldier> soldierList = new GCList<>();
        for (int id = numSoldiers; id > 0; id--)
        {
            soldierList.addFirst(new Soldier(id));
        }

        System.out.println(soldierList); // the initial GCList
        System.out.println("\n\n\n\n\n");

        //keep advancing the list to make the first Soldier according to the count, and remove him from GCList
        while (soldierList.size() > 1) // keep going until only 1 soldier remains
        {
            soldierList.advance(count - 1);
            killFirstSoldier(soldierList);
            soldierList.remove(soldierList.getFirst());
            System.out.println("\n\n\n\n\n");
        }

        //print the survivor, if there is no one remaining somehow then don't print anything - use colors to make it more appealing
        final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RESET = "\u001B[0m";
        if (!soldierList.isEmpty())
        {
            soldierList.getFirst().setVictor(true);
            System.out.println("SURVIVOR: " + soldierList.getFirst());
            System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "--- survivor started out in position number " + soldierList.getFirst().getId() + " ---" + ANSI_RESET);
        }
    }

    /**
     * Keeps prompting user for a number until user input is valid (i.e. greater than 1)
     * @param lookingFor: a String printed to console telling user what they were being asked to enter an integer for
     * @return number: the validated integer representing what program is lookingFor
     */
    private static int getNumber(String lookingFor)
    {
        int number;
        Scanner keyboard = new Scanner(System.in);
        String userInput;
        do
        {
            System.out.println("Please enter an integer (> 1) for " + lookingFor + ":");
            userInput = keyboard.nextLine();
        }
        while (!isValidInteger(userInput));
        number = Integer.parseInt(userInput);
        return number;
    }

    /**
     * Tests if argument passed is truly an integer, and if it is >= 2 - if yes, it is valid
     * @param test: the argument being tested to see if it's valid or not
     * @return boolean: if it's valid, returns true, if not, returns false
     */
    private static boolean isValidInteger(String test)
    {
        boolean isValid = true;
        try
        {
            int number = Integer.parseInt(test);
            if (number < 2)
                isValid = false;
        }
        catch (Exception e)
        {
            isValid = false;
        }
        return isValid;
    }

    /**
     * Formally kills the first soldier on the list being removed in the Josephus problem
     * @param soldierList: the circular linked list containing the soldiers
     */
    private static void killFirstSoldier(GCList<Soldier> soldierList)
    {
        soldierList.getFirst().setAlive(false);
        System.out.println("KILLED: " + soldierList.getFirst());
    }
}
