package helper;

import exception.NotAllValuesException;
import fileHadler.FileReaderLiner;
import option.Options;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс ConsoleHelper - обрабатывает команду поступающую программе
 * Options options            - Класс опций
 * String[] args              - Опции, которые задал пользователь
 * List<File> listInputFile   - Список входных файлов
 */
public class ConsoleHelper {

    private Options options;
    private String[] args;
    private List<File> listInputFile;

    public ConsoleHelper(String[] args) {
        this.args = args;
        options = new Options();
        listInputFile = new ArrayList<>();
    }

    /**
     * Метод execute - выполняет анализ команды
     */
    public void execute() throws IOException {

        if (args.length < 3 || args.length == 3
                && (args[0].equalsIgnoreCase("-a") || args[0].equalsIgnoreCase("-d"))
                && (args[1].equalsIgnoreCase("-s") || args[1].equalsIgnoreCase("-i"))) {
            throw new NotAllValuesException();
        }

        if (args[0].equalsIgnoreCase("-a") || args[0].equalsIgnoreCase("-d")) {

            options.setSortingMode(args[0]);
            if (!args[1].equalsIgnoreCase("-s") && !args[1].equalsIgnoreCase("-i")) {
                throw new IllegalArgumentException();
            }
            options.setDataType(args[1]);
            options.setOutputFile(args[2]);

            for (int i = 3; i < args.length; i++) {
                listInputFile.add(new File(args[i]));
            }
        } else {
            if (!args[0].equalsIgnoreCase("-s") && !args[0].equalsIgnoreCase("-i")) {
                throw new IllegalArgumentException();
            }
            options.setDataType(args[0]);
            options.setOutputFile(args[1]);
            for (int i = 2; i < args.length; i++) {
                listInputFile.add(new File(args[i]));
            }
        }

        FileReaderLiner liner = new FileReaderLiner(options);
        liner.readAndSortAndMergeFiles(listInputFile);
    }
}
