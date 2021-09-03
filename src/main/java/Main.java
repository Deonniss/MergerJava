import exception.NotAllValuesException;
import helper.ConsoleHelper;
import helper.Messenger;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            ConsoleHelper consoleHelper = new ConsoleHelper(args);
            consoleHelper.execute();
        } catch (FileNotFoundException e) {
            System.out.println(Messenger.getFileNotFound());
        } catch (IllegalArgumentException e) {
            System.err.println(Messenger.getIncorrectValues());
            System.out.println(Messenger.getCorrectCommand());
        } catch (NotAllValuesException e) {
            System.err.println(Messenger.getNotAllValues());
            System.out.println(Messenger.getCorrectCommand());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
