package mogu.hui;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yihui on 15/7/9.
 */
public class SqlSearchTest {
    private SqlSearch search;

    @Before
    public void setUp() {
        search = new SqlSearch();
    }

    @Test
    public void addTest() {
        int a = 20, b = 30;
        Assert.assertEquals(50, search.add(a, b));
    }
}
