public class Parser {
    private Command command;

    private static final int PARAM_POSITION_COMMAND = 0;

    public Command parse(String input) {
        // Need to make sense of the input string

        String[] inputArray = splitInputIntoArray(input);
        Command.COMMAND_TYPE commandType = extractCommandType(inputArray);
        //String argument = extractArgument(inputArray);


        // make command object, then use a getter...? seems convoluted :(
        switch(commandType){

        }

        command = new Command("hello");
        Command.COMMAND_TYPE heloo = null;
        return command;
    }

    private Command.COMMAND_TYPE extractCommandType(String[] inputArray) {
        return inputArray[PARAM_POSITION_COMMAND];
    }

    private String extractArgument(String[] inputArray) {
        return null;
    }

    private String[] splitInputIntoArray(String input) {
        return input.trim().split("\\s+");
    }

    public static String getArguments(String[] commandParameters, String type){
        if (type.equals("add")){
            String toInsert = String.join(" ", commandParameters).substring(4).trim();
            return toInsert;
        } else {
            // type = "delete"
            String lineNumber = String.join(" ", commandParameters).substring(7);
            return lineNumber;
        }
    }

    public static boolean hasValidArguments(String[] inputArray){
        if (inputArray.length == 1){
            // add and delete must take in additional arguments, so commandParameters
            // cannot only have 1 word
            return false;
        } else {
            return true;
        }
    }

}
