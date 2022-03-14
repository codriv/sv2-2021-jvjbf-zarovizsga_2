package sentences;

public class SentenceTransformer {

    public String shortenSentence(String sentence) {
        examineCapital(sentence);
        examineEndChar(sentence);
        return transformSentence(sentence);
    }

    private void examineCapital(String sentence) {
        String begin = sentence.substring(0, 1);
        if (begin.toLowerCase().equals(begin)) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }
    }

    private void examineEndChar(String sentence) {
        String endChars = ".!?";
        int lastIndex = sentence.length() - 1;
        String end = sentence.substring(lastIndex);
        if (!endChars.contains(end)) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
    }

    private String transformSentence(String sentence) {
        String[] parts = sentence.split(" ");
        String lastWord = parts[parts.length - 1];
        if (parts.length > 4) {
            return String.join(" ", parts[0], "...", lastWord);
        } else {
            return sentence;
        }
    }
}
