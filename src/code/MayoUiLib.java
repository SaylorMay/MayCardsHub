package code;

// Imported for question-prompting methods
import java.util.Scanner;

// A class holding the interface in which to build a GUI
// Contains a nested class that has a bunch of static utility methods to use!
// Credits: Me!!!! SaylorMay!!!!
public class MayoUiLib {


    // The method that starts the UI, and will keep Looping The Rooms until stopFlag is set to true
    public static void runUI(Screen screenEnum) throws Exception {
        setStopFlag(false);

        Screen newScreen = null;

        while (!getStopFlag()) {
            screenEnum.onEntrance(screenEnum);
            while (newScreen == null && !getStopFlag()) {
                newScreen = screenEnum.whileActive();
            }

            screenEnum.onExit(newScreen);

            if (newScreen != null) {
                screenEnum = newScreen;
                newScreen = null;
            }
        }
    }


    // An internal flag that if set to true will end the program when possible
    private static boolean stopFlag = false;

    // Getter/Setter methods for stopFlag
    public static void setStopFlag(boolean stopFlag) {
        MayoUiLib.stopFlag = stopFlag;}
    public static boolean getStopFlag() {return stopFlag;}



    // The interface you should implement as an enum like the enum ScreenExample (Below this interface)
    // Any logic is housed outside of the interface, so don't worry about programming your own loop logic
    interface Screen {
        // The method that executes when the console enters this Screen
        // previousScreen: Use in case you have logic that changes depending on where the user came from
        default void onEntrance(Screen previousScreen) throws Exception {};

        // The method that executes when the console moves to a new screen
        // destinationScreen: Use for if you have logic that changes depending on where the user is going
        default void onExit(Screen destinationScreen) throws Exception {};

        // The method that automatically loops until you return a Screen to change to
        // Return null if you want to iterate through it again, return a Screen if you want to change Screens
        abstract Screen whileActive() throws Exception;
    }


    // An example of what a UI that extends Screen could look like
    public enum ScreenExample implements Screen {
        DEFAULT() {
            @Override
            public void onEntrance(Screen previousScreen) throws Exception {
                // Mainly a tool, it's very possible this stays blank in most rooms
            }
            @Override
            public void onExit(Screen destinationScreen) throws Exception {
                // Mainly a tool, it's very possible this stays blank in most rooms
            }
            @Override
            public Screen whileActive() throws Exception {
                // Probably where most of the code will go
                return null;
            }
        }
    }


//---------------------------------------------- UTILITY METHODS CLASS ----------------------------------------------//

    // A nested class that has a bunch of utility methods for your convenience!
    public static class UIUtils {


        // Uses the Scanner Class to get an answer that matches something from possibleAnswers
        // Will continue to prompt the user until the user gives a valid answer
        // Returns the index value of the matching answer
        // Case insensitive
        public static int getAnswerIndex(String[] possibleAnswers) {

            // Instantiates the Scanner object to read console inputs
            Scanner scanner = new Scanner(System.in);

            // Holds the current possible answer
            String currentAnswer = "";

            // Will loop indefinitely until a value is returned
            while (true) {

                // Gets the next line
                currentAnswer = scanner.nextLine();

                // Iterates through possibleAnswers to find a match with currentAnswer
                for (int i = 0; i < possibleAnswers.length; i++) {
                    // Checks to see if currentAnswer and the current iteration match regardless of capitalization
                    if (possibleAnswers[i].equalsIgnoreCase(currentAnswer)) {
                        return i;
                    }
                }
            }
        }

        // An alternative version of getAnswerIndex that returns the answer String instead of the index
        public static String getAnswer(String[] possibleAnswers) {
            return possibleAnswers[getAnswerIndex(possibleAnswers)];
        }

        // An alternative version of getAnswer that returns the item in returnList that corresponds with the index of the answer
        public static <T> T getAnswer(String[] possibleAnswers, T[] returnList) {
            return returnList[getAnswerIndex(possibleAnswers)];
        }

        // An alternative version of getAnswer that takes any answer
        public static String getAnswer() {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }

        // An alternative version of getAnswer that is a simple yes/no and true/false question
        public static boolean getYesNoAnswer() {
            // Returns true if the answer matches the first 4, and false if the last 4
            return getAnswerIndex(new String[] {"yes", "y", "true", "t", "no", "n", "false", "f"}) <= 3;
        }

        // An alternative version of getAnswer that only accepts integer values in a range
        public static int getRangeAnswer(int startNumber, int endNumber) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                int tempInt = scanner.nextInt();
                if (tempInt >= startNumber && tempInt <= endNumber) {
                    return tempInt;
                }
            }
        }


        // A simple method that just prints out a bunch of lines
        // It's the closest thing to clearing the console on Java gimme a break :(
        public static void printSpacing() {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

}