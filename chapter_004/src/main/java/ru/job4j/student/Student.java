package ru.job4j.student;

public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return  name + " " + score + " || ";
    }

    @Override
    public int compareTo(Student o) {
        return -Integer.compare(this.getScore(), o.getScore());
    }
}
