import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<Sentence> sentences;

    public Paragraph(String paragraphString) {
        sentences = splitParagraphIntoSentences(paragraphString);
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    private List<Sentence> splitParagraphIntoSentences(String paragraphString) {
        String[] sentenceStrings = paragraphString.split("[.!?]+");
        List<Sentence> sentences = new ArrayList<>();
        for (String sentenceString : sentenceStrings) {
            sentences.add(new Sentence(sentenceString));
        }
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence.toString());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}