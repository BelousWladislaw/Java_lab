import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создание списка для хранения объектов MyClass
        List<MyClass> objects = new ArrayList<>();

        // Чтение объектов из файла в коллекцию
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String name = parts[0];
                int value = Integer.parseInt(parts[1]);
                objects.add(new MyClass(name, value));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
            return;
        }

        // Сортировка коллекции объектов
        Collections.sort(objects);

        // Запись отсортированных объектов в другой файл
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
            for (MyClass obj : objects) {
                writer.println(obj.getName() + " " + obj.getValue());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}