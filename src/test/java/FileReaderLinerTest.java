import fileHadler.FileReaderLiner;
import option.Options;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderLinerTest {

    private static FileReaderLiner fileReaderLiner;
    private static Options options;
    private static List<File> filesInteger;
    private static List<File> filesString;
    private static String expectedIntegerAsc;
    private static String expectedIntegerDesc;
    private static String expectedStringAsc;
    private static String expectedStringDesc;
    private static String outputFileInteger;
    private static String outputFileString;

    @BeforeClass
    public static void init() {
        options = new Options();

        filesInteger = new ArrayList<>();
        filesInteger.add(new File("C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\in1.txt"));
        filesInteger.add(new File("C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\in2.txt"));
        filesInteger.add(new File("C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\in3.txt"));

        filesString = new ArrayList<>();
        filesString.add(new File("C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\str\\st1.txt"));
        filesString.add(new File("C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\str\\st2.txt"));
        filesString.add(new File("C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\str\\st3.txt"));

        expectedIntegerAsc = "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\expectedIntegerAsc.txt";
        expectedIntegerDesc = "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\expectedIntegerDesc.txt";
        expectedStringAsc = "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\str\\expectedStringAsc.txt";
        expectedStringDesc = "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\str\\expectedStringDesc.txt";

        outputFileInteger = "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\outI.txt";
        outputFileString = "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\str\\outS.txt";
    }

    @Test
    public void sortIntegerAscendingOrder() throws IOException {
        options.setDataType("-i");
        options.setSortingMode("-a");
        options.setOutputFile(outputFileInteger);
        fileReaderLiner = new FileReaderLiner(options);
        fileReaderLiner.readAndSortAndMergeFiles(filesInteger);
        Assert.assertTrue(file—ompare(options.getOutputFile(), expectedIntegerAsc));
    }

    @Test
    public void sortIntegerDescendingOrder() throws IOException {
        options.setDataType("-i");
        options.setSortingMode("-d");
        options.setOutputFile(outputFileInteger);
        fileReaderLiner = new FileReaderLiner(options);
        fileReaderLiner.readAndSortAndMergeFiles(filesInteger);
        Assert.assertTrue(file—ompare(options.getOutputFile(), expectedIntegerDesc));
    }

    @Test
    public void sortStringAscendingOrder() throws IOException {
        options.setDataType("-s");
        options.setSortingMode("-a");
        options.setOutputFile(outputFileString);
        fileReaderLiner = new FileReaderLiner(options);
        fileReaderLiner.readAndSortAndMergeFiles(filesString);
        Assert.assertTrue(file—ompare(options.getOutputFile(), expectedStringAsc));
    }

    @Test
    public void sortStringDescendingOrder() throws IOException {
        options.setDataType("-s");
        options.setSortingMode("-d");
        options.setOutputFile(outputFileString);
        fileReaderLiner = new FileReaderLiner(options);
        fileReaderLiner.readAndSortAndMergeFiles(filesString);
        Assert.assertTrue(file—ompare(options.getOutputFile(), expectedStringDesc));
    }

    private boolean file—ompare(String file, String expected) throws IOException {

        try(BufferedInputStream fis1 = new BufferedInputStream(new FileInputStream(file));
            BufferedInputStream fis2 = new BufferedInputStream(new FileInputStream(expected))) {
            int b1, b2;
            do {
                b1 = fis1.read();
                b2 = fis2.read();
                if (b1 != b2) {
                    return false;
                }
            }
            while (b1 != -1 && b2 != -1);
        }
        return true;
    }
}
