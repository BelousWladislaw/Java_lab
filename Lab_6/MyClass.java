import java.io.*;
import java.util.*;

// Класс для объектов, описанных в задании
class MyClass implements Comparable<MyClass> {
    private String name;
    private int value;

    public MyClass(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(MyClass other) {
        // Сортировка по возрастанию по полю name
        return this.name.compareTo(other.name);
    }
}