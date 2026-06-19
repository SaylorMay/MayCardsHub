package archivedCode;

// For handling any logs and things of the sort
public class Logger {

    public static final String CATBOX_UPLOAD_STRING = "[CATBOX UPLOAD]";
    public static final String SOURCE_EXTRACT_STRING = "[SOURCE EXTRACT]";
    public static final String SOURCE_INTERPRET_STRING = "[SOURCE INTERP]";
    public static final String TESTING_STRING = "[TESTING]";
    public static final String ERROR_STRING = "[ERROR]";
    public static final String WARN_STRING = "[WARN]";
    public static final String MISC_STRING = "[LOG]";
    public static final String JSON_MAKER_STRING = "[JSON MAKER]";

    // A static class containing every type of Log Type
    public static class LogType {
        // Log type for uploading to catbox
        public static final int CATBOX_UPLOAD = 0;

        // Log type for extracting urls
        public static final int SOURCE_EXTRACT = 1;

        // Log type for Interpreting any HTML stuff
        public static final int SOURCE_INTERPRET = 2;

        // Log type for testing
        public static final int TESTING = 3;

        // Log type for Errors
        public static final int ERROR =  4;

        // Log type for Warnings
        public static final int WARN = 5;

        // Log type for Miscellaneous Logs
        public static final int MISC = 6;

        // Log type for creating a Json file
        public static final int JSON_MAKER = 7;
    }

    public static String log(int logType, String logMessage) {return log(logType, logMessage, null);}

    // Sends and returns a formatted log to be logged
    // int logType: The LogType.? that should be used   Eg:  LogType.WARN
    // String logMessage: The message to be sent
    // String location: Where the log was logged        Eg:  Conversion.idToSuperType()
    public static String log(int logType, String logMessage, String location) {

        // If there is a valid location String, adds an indicator to where
        if (location != null) {logMessage = "[" + location + "] " + logMessage;}

        // Adds the little indicator to the beginning of the message for the LogType
        switch(logType) {
            // For Logs dealing with Uploading
            case LogType.CATBOX_UPLOAD:
                logMessage = CATBOX_UPLOAD_STRING + " " + logMessage;
                break;

            // For Logs dealing with URL Extraction
            case LogType.SOURCE_EXTRACT:
                logMessage = SOURCE_EXTRACT_STRING + " " + logMessage;
                break;

            // For Logs dealing with URL Extraction
            case LogType.SOURCE_INTERPRET:
                logMessage = SOURCE_INTERPRET_STRING + " " + logMessage;
                break;

            // For Logs dealing with URL Extraction
            case LogType.TESTING:
                logMessage = TESTING_STRING + " " + logMessage;
                break;

            // For Logs dealing with Errors
            case LogType.ERROR:
                logMessage = ERROR_STRING + " " + logMessage;
                break;

            // For Logs dealing with Warnings
            case LogType.WARN:
                logMessage = WARN_STRING + " " + logMessage;
                break;

            // For Logs dealing with random misc logs
            case LogType.MISC:
                logMessage = MISC_STRING + " " + logMessage;
                break;

            // Logs for making a json file
            case LogType.JSON_MAKER:
                logMessage = JSON_MAKER_STRING + " " + logMessage;
                break;
        }

        // Prints and returns the new log message
        System.out.println(logMessage);
        return logMessage;
    }

}
