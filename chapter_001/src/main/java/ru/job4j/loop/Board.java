package ru.job4j.loop;

/**
 * @author Andranik Mikhailyan
 * @version 0.1
 * @since 0.1
 */

public class Board {

    public String paint(int width, int heigth) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }

}
