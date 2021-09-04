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
 * FileReaderLiner class - performs reading from input files,
 * as well as writing the sorted data to the output file
 */
public class FileReaderLiner {

    private Options options;

    public FileReaderLiner(Options options) {
        this.options = options;
    }

    /**
     * readAndSortAndMergeFiles method
     * - Reads from input files (line by line)
     * - Writes the smallest value
     * @param fileList - List of output files
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

                nextIndex = sort(tempLines);
                nextFileLine = tempLines.get(nextIndex);
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
     * sort method
     * - searches for a value that satisfies sort mode and returns its index
     * @param tempLines     - a list of the "top" values from each file
     * @return nextIndex    - the value of the next index
     */
    private int sort(List<String> tempLines) {

        String nf, nt;
        int nextIndex = 0;
        String nextFileLine = tempLines.get(0);

        for (int i = 0; i < tempLines.size(); i++) {

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
        return nextIndex;
    }

    /**
     * reverseFile method - performs a "flip" of the file when sorting in descending order (-d)
     * @param outputFile - the name of the output file
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