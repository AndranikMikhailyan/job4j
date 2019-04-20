package inpututput.io;

import org.junit.Test;
import ru.job4j.io.SimpleCheck;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleCheckTest {

    @Test
    public void whenAllBytesIsEvenThenTrue() {
        InputStream in = new ByteArrayInputStream(new byte[] {2, 4, 6});
        SimpleCheck checker = new SimpleCheck();
        assertThat(checker.isNumber(in), is(true));
    }

    @Test
    public void whenArraysHasSameOddThenFalse() {
        InputStream in = new ByteArrayInputStream(new byte[] {2, 5, 6});
        SimpleCheck checker = new SimpleCheck();
        assertThat(checker.isNumber(in), is(false));
    }
}
