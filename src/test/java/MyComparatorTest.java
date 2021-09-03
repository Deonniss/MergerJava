import comparators.MyComparator;
import org.junit.Assert;
import org.junit.Test;

public class MyComparatorTest {

    @Test
    public void compareInteger() {
        Integer i1 = 10, i2 = 20;

        Assert.assertEquals(-1, MyComparator.compare(i1, i2));
        Assert.assertEquals(1, MyComparator.compare(i2, i1));
        Assert.assertEquals(0, MyComparator.compare(i1, i1));
    }

    @Test
    public void compareString() {
        String s1 = "denis", s2 = "golovin";

        Assert.assertTrue(MyComparator.compare(s1, s2) < 0);
        Assert.assertTrue(MyComparator.compare(s2, s1) > 0);
        Assert.assertEquals(0, MyComparator.compare(s1, s1));
    }

}
