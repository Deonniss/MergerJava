package helper;

public class Messenger {

    private static String notAllValues = "You have not entered all the values!";
    private static String incorrectValues = "You entered incorrect values!";
    private static String fileNotFound = "The specified file cannot be found!";
    private static String correctCommand = "The program parameters are set at startup via command-line arguments, in order:\n" +
            "1. sorting mode (- a or -d), optional, by default we sort in ascending order;\n" +
            "2. data type (- s or -i), required;\n" +
            "3. the name of the output file, required;\n" +
            "4. the remaining parameters are the names of the input files, at least one.\n" +
            "Examples of starting from the command line for Windows:\n" +
            "java -jar MergerJava.jar -a -i out.txt in.txt (for ascending integers)\n" +
            "java -jar MergerJava.jar -s out.txt in1.txt in2.txt in3.txt (for ascending rows)\n" +
            "java -jar MergerJava.jar -d -s out.txt in1.txt in2.txt (for descending rows)";


    public static String getNotAllValues() {
        return notAllValues;
    }

    public static String getIncorrectValues() {
        return incorrectValues;
    }

    public static String getFileNotFound() {
        return fileNotFound;
    }

    public static String getCorrectCommand() {
        return correctCommand;
    }
}
