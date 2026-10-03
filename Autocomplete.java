import java.util.Arrays;
import java.util.Comparator;

public class Autocomplete {
    private Term[] dictionary;

    // Initializes the dictionary from the given array of terms.
    public Autocomplete(Term[] dictionary) {
        this.dictionary = dictionary;
        sortDictionary();
    }

    // Sorts the dictionary in *case-insensitive* lexicographic order.
    // Complexity: O(N log N), where N is the number of terms
    private void sortDictionary() {
        Arrays.sort(this.dictionary, Term.byLexicographicOrder());
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    // Complexity: O(log N + M log M), where M is the number of matching terms
    public Term[] allMatches(String prefix){
        if(prefix==null || prefix.isEmpty()){
            Term[] noMatch= new Term[1];
            noMatch[0]= new Term("No match found", 0);
            return  noMatch;
        }

        int len= prefix.length();
        Term key= new Term(prefix, 0);

        int firstIndex= RangeBinarySearch.firstIndexOf(this.dictionary, key, Term.byPrefixOrder(len));
        int lastIndex= RangeBinarySearch.lastIndexOf(this.dictionary, key, Term.byPrefixOrder(len));

        if(firstIndex==-1|| lastIndex==-1|| firstIndex>lastIndex){
            Term[] noMatch= new Term[1];
            noMatch[0]= new Term("No match found", 0);
            return  noMatch;
        }

        Term[] matches = Arrays.copyOfRange(this.dictionary, firstIndex, lastIndex + 1);
        Arrays.sort(matches, Term.byReverseWeightOrder());
        return matches;
    }

    // Returns the number of terms that start with the given prefix.
    // Complexity: O(log N)
    public int numberOfMatches(String prefix){
        if(prefix==null || prefix.isEmpty()){
            return 0;
        }
        int len= prefix.length();
        Term key= new Term(prefix, 0);

        int firstIndex= RangeBinarySearch.firstIndexOf(this.dictionary, key, Term.byPrefixOrder(len));
        int lastIndex= RangeBinarySearch.lastIndexOf(this.dictionary, key, Term.byPrefixOrder(len));

        if(firstIndex==-1|| lastIndex== -1){
            return 0;
        }
        return lastIndex- firstIndex+ 1;
    }

}
