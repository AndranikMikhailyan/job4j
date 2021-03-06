package inpututput.io;

import org.junit.Test;
import ru.job4j.io.Search;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SearchTest {

    @Test
    public void whenSearchDwgThenReturn2DwgFiles() throws IOException {
        Search search = new Search();
        System.out.println(System.getProperty("java.io.tmpdir"));
        String tmpdir = System.getProperty("java.io.tmpdir");
        File parent = new File(tmpdir + "/parent");
        parent.mkdir();
        System.out.println(parent);
        File folder1 = new File(parent.getPath() + "/папка1");
        File folder2 = new File(parent.getPath() + "/папка2");
        folder1.mkdir();
        folder2.mkdir();
        File fileTxt = new File(parent, "text.txt");
        File fileDoc = new File(parent, "book.doc");
        File fileDoc2 = new File(folder1, "books.doc");
        File filedwg = new File(folder2, "temp.dwg");
        filedwg.createNewFile();
        fileDoc2.createNewFile();
        fileTxt.createNewFile();
        fileDoc.createNewFile();
        List<File> list = search.files(parent.getPath(), List.of("dwg"));
        assertThat(list, is(Arrays.asList(filedwg)));
    }

    @Test
    public void whenSearchTxtThenReturn1Txt() throws IOException {
        Search search = new Search();
        System.out.println(System.getProperty("java.io.tmpdir"));
        String tmpdir = System.getProperty("java.io.tmpdir");
        File parent = new File(tmpdir + "/parent");
        parent.mkdir();
        File folder1 = new File(parent.getPath() + "/папка1");
        File folder2 = new File(parent.getPath() + "/папка2");
        folder1.mkdir();
        folder2.mkdir();
        File fileTxt = new File(parent, "text.txt");
        File fileDoc = new File(parent, "book.doc");
        File fileDoc2 = new File(folder1, "books.doc");
        File filedwg = new File(folder2, "temp.dwg");
        filedwg.createNewFile();
        fileDoc2.createNewFile();
        fileTxt.createNewFile();
        fileDoc.createNewFile();
        List<File> list = search.files(parent.getPath(), List.of("txt"));
        assertThat(list, is(Arrays.asList(fileTxt)));
    }
}
