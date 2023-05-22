import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextProcessing {
    public static void main(String[] args) {
        String filePath = "text.txt"; // Путь к файлу с текстом

        // Чтение текста из файла
        String text = readTextFromFile(filePath);

        // Разделение текста на составные части
        List<Paragraph> paragraphs = splitTextIntoParagraphs(text);
        List<Sentence> sentences = splitTextIntoSentences(text);

        // Поиск слова в первом предложении, которого нет в остальных предложениях
        String word = findUniqueWordInFirstSentence(sentences);
        System.out.println("Word found: " + word);
    }

    private static String readTextFromFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(" "); // Добавляем пробел между строками
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static List<Paragraph> splitTextIntoParagraphs(String text) {
        String[] paragraphStrings = text.split("\\n+");
        List<Paragraph> paragraphs = new ArrayList<>();
        for (String paragraphString : paragraphStrings) {
            paragraphs.add(new Paragraph(paragraphString));
        }
        return paragraphs;
    }

    private static List<Sentence> splitTextIntoSentences(String text) {
        String[] sentenceStrings = text.split("[.!?]+");
        List<Sentence> sentences = new ArrayList<>();
        for (String sentenceString : sentenceStrings) {
            sentences.add(new Sentence(sentenceString));
        }
        return sentences;
    }

    private static String findUniqueWordInFirstSentence(List<Sentence> sentences) {
        Sentence firstSentence = sentences.get(0);
        List<Word> firstSentenceWords = firstSentence.getWords();

        for (int i = 1; i < sentences.size(); i++) {
            List<Word> currentSentenceWords = sentences.get(i).getWords();

            for (Word word : firstSentenceWords) {
                if (!currentSentenceWords.contains(word)) {
                    return word.getWord();
                }
            }
        }

        return null;
    }
}
