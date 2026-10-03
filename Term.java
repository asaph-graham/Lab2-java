
import java.util.Comparator;
public class Term {
    private String word;
    private long weight;
    // Initializes a term with a given word and weight.
    public Term(String word, long weight) {
        this.word = word;
        this.weight = weight;
    }

    // Gets the word.
    public String getWord() {
        return word;
    }

    // Gets the weight.
    public long getWeight() {
        return weight;
    }

    // Extracts a prefix from the word.
    public String getPrefix(int len) {
        if(len<=0){
            return "";
        }
        else if(len>=word.length()){
            return word;
        }
        return word.substring(0, len);
    }

    // Compares the two terms in case-insensitive lexicographic order.
    public static Comparator<Term> byLexicographicOrder() {
        return (t1, t2)-> t1.getWord().compareToIgnoreCase(t2.getWord());
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return (t1, t2)-> Long.compare(t2.getWeight(), t1.getWeight());     //t2 first for descending order
    }

    // Compares the two terms in case-insensitive lexicographic order,
    // but using only the first k characters of each word.
    public static Comparator<Term> byPrefixOrder(int k){
        return (t1, t2)-> t1.getPrefix(k).compareToIgnoreCase(t2.getPrefix(k));
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by whitespace, followed by the word.
    public String toString() {
        return String.format("%12d    %s", this.getWeight(), this.getWord());
    }

}
