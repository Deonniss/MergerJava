import org.junit.Assert;
import org.junit.Test;
import parser.ParserInt;

public class ParseIntTest {

    @Test
    public void parseStringToInteger() {
        Assert.assertTrue(ParserInt.parseInteger("123") == 123);
    }

    @Test(expected = NumberFormatException.class)
    public void parsingException() {
        ParserInt.parseInteger("Denis");
    }
}
