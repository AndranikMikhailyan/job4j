package ru.job4j.inpututput.io;

import org.junit.Test;

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
        String tmpdir = System.getProperty("java.io.tmpdir");
        File parent = new File(tmpdir + "parent");
        parent.mkdir();
        File folder1 = new File(parent.getPath() + "\\папка1");
        File folder2 = new File(parent.getPath() + "\\папка2");
        folder1.mkdir();
        folder2.mkdir();
        File fileTxt = new File(parent, "text.txt");
        File fileDoc = new File(parent, "book.doc");
        File fileDoc2 = new File(folder1, "books.doc");
        File filedwg = new File(folder2, "temp.dwg");
        File filedwg2 = new File(folder1, "temp2.dwg");
        filedwg2.createNewFile();
        filedwg.createNewFile();
        fileDoc2.createNewFile();
        fileTxt.createNewFile();
        fileDoc.createNewFile();
        List<File> list = search.files(parent.getPath(), List.of("dwg"));
        assertThat(list, is(Arrays.asList(filedwg2, filedwg)));
    }

    @Test
    public void whenSearchTxtThenReturn1Txt() throws IOException {
        Search search = new Search();
        String tmpdir = System.getProperty("java.io.tmpdir");
        File parent = new File(tmpdir + "parent");
        parent.mkdir();
        File folder1 = new File(parent.getPath() + "\\папка1");
        File folder2 = new File(parent.getPath() + "\\папка2");
        folder1.mkdir();
        folder2.mkdir();
        File fileTxt = new File(parent, "text.txt");
        File fileDoc = new File(parent, "book.doc");
        File fileDoc2 = new File(folder1, "books.doc");
        File filedwg = new File(folder2, "temp.dwg");
        File filedwg2 = new File(folder1, "temp2.dwg");
        filedwg2.createNewFile();
        filedwg.createNewFile();
        fileDoc2.createNewFile();
        fileTxt.createNewFile();
        fileDoc.createNewFile();
        List<File> list = search.files(parent.getPath(), List.of("txt"));
        assertThat(list, is(Arrays.asList(fileTxt)));
    }
}
