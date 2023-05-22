import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        // Создание HashMap для подсчета частоты слов
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Чтение файла с текстом
        try (Scanner scanner = new Scanner(new File("text.txt"))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                // Увеличение счетчика для слова
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
            return;
        }

        // Запись результатов в другой файл
        try (PrintWriter writer = new PrintWriter(new FileWriter("word_frequency.txt"))) {
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                writer.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}
