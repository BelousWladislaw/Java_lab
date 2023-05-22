import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Word> words;

    public Sentence(String sentenceString) {
        words = splitSentenceIntoWords(sentenceString);
    }

    public List<Word> getWords() {
        return words;
    }

    private List<Word> splitSentenceIntoWords(String sentenceString) {
        String[] wordStrings = sentenceString.split("\\s+");
        List<Word> words = new ArrayList<>();
        for (String wordString : wordStrings) {
            words.add(new Word(wordString));
        }
        return words;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word word : words) {
            sb.append(word.toString());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}