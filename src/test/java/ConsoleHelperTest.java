import exception.NotAllValuesException;
import helper.ConsoleHelper;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ConsoleHelperTest {

    private static ConsoleHelper consoleHelper;

    @Test(expected = FileNotFoundException.class)
    public void expectedFileNotFoundException() throws IOException {
        String[] args = {"-a", "-i",
                "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\outI.txt",
                "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\in1.txt",
                "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\in2.txt",
                "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\in5.txt"};
        consoleHelper = new ConsoleHelper(args);
        consoleHelper.execute();
    }

    @Test(expected = IllegalArgumentException.class)
    public void expectedIllegalArgumentException() throws IOException {
        String[] args = {"-t",
                "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\outI.txt",
                "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\in1.txt",
                "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\in2.txt",
                "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\in3.txt"};
        consoleHelper = new ConsoleHelper(args);
        consoleHelper.execute();
    }

    @Test(expected = NotAllValuesException.class)
    public void expectedNotAllValuesException() throws IOException {
        String[] args = {"-a", "-s",
                "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\outI.txt"};
                consoleHelper = new ConsoleHelper(args);
        consoleHelper.execute();
    }

    @Test
    public void correctExecution() throws IOException {
        String[] args = {"-a", "-i",
                "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\outI.txt",
                "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\in1.txt",
                "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\in2.txt",
                "C:\\PROGRAMMING\\project\\MergerJava\\src\\main\\testResources\\int\\in3.txt"};
        consoleHelper = new ConsoleHelper(args);
        consoleHelper.execute();
    }
}
