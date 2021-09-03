package fileHadler;

import comparators.MyComparator;
import option.Options;
import org.apache.commons.io.input.ReversedLinesFileReader;
import parser.ParserInt;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс FileReaderLiner - выполняет чтение из входных файлов,
 * а также запись отвортированных данных в выходной файл
 */
public class FileReaderLiner {

    private Options options;

    public FileReaderLiner(Options options) {
        this.options = options;
    }


    /**
     * Метод readAndSortAndMergeFiles
     * - Читает из входных файлов (построчно)
     * - Записывает наименьшее значение
     * @param fileList    - Список фходных файлов
     */
    public void readAndSortAndMergeFiles(List<File> fileList) throws IOException {

        List<BufferedReader> bufferedReaders = new ArrayList<>();
        List<String> tempLines = new ArrayList<>();
        File outputFile = new File(options.getOutputFile());
        if (options.getSortingMode().equalsIgnoreCase("-d")) {
            outputFile = new File("temp.txt");
        }

        BufferedReader bufferedReader;
        FileReader fileReader;
        String currentLine;


        for (int i = 0; i < fileList.size(); i++) {

            fileReader = new FileReader(fileList.get(i));
            bufferedReader = new BufferedReader(fileReader);
            bufferedReaders.add(bufferedReader);

            currentLine = bufferedReaders.get(i).readLine();
            tempLines.add(currentLine);
        }


        try (FileWriter fileWriter = new FileWriter(outputFile);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            int nextIndex;
            String nextFileLine;

            while (bufferedReaders.size() != 0) {
                nextIndex = 0;
                nextFileLine = tempLines.get(0);
                String nt, nf;

                for (int i = 0; i < bufferedReaders.size(); i++) {

                    nf = nextFileLine;
                    nt = tempLines.get(i);

                    if (options.getDataType().equalsIgnoreCase("-i")) {
                        try {
                            Integer o1 = ParserInt.parseInteger(nf);
                            Integer o2 = ParserInt.parseInteger(nt);

                            if (MyComparator.compare(o1, o2) > 0) {
                                nextIndex = i;
                                nextFileLine = tempLines.get(i);
                            }
                        } catch (NumberFormatException ignored) {
                        }

                    } else {

                        if (MyComparator.compare(nf, nt) > 0) {
                            nextIndex = i;
                            nextFileLine = tempLines.get(i);
                        }
                    }

                }
                printWriter.println(nextFileLine);

                currentLine = bufferedReaders.get(nextIndex).readLine();


                if (currentLine != null) {
                    tempLines.set(nextIndex, currentLine);
                } else {
                    tempLines.remove(nextIndex);
                    bufferedReaders.get(nextIndex).close();

                    bufferedReaders.remove(nextIndex);
                }
            }

        } finally {
            if (options.getSortingMode().equalsIgnoreCase("-d")) {
                reverseFile(outputFile);
                Files.delete(outputFile.toPath());
            }
        }
    }

    /**
     * Метод reverseFile - выполняет "переворот" файла при сортировки по убыванию (-d)
     * @param outputFile   - имя выходного файла
     */
    private void reverseFile(File outputFile) throws IOException {

        File file = new File(options.getOutputFile());
        try (ReversedLinesFileReader fr = new ReversedLinesFileReader(outputFile, Charset.defaultCharset());
             FileWriter fileWriter = new FileWriter(file);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            String ch = fr.readLine();

            while (ch != null) {
                printWriter.println(ch);
                ch = fr.readLine();
            }
        }
    }
}