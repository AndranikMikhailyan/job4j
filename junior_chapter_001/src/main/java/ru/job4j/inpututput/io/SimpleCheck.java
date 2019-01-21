package ru.job4j.inpututput.io;

import java.io.IOException;
import java.io.InputStream;

public class SimpleCheck {

    public boolean isNumber(InputStream in) {
        boolean rslt = true;
        try {
            int temp;
            while ((temp = in.read()) != -1) {
                if (temp % 2 != 0) {
                    rslt = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rslt;
    }
}
