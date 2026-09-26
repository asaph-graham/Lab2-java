import java.util.Arrays;

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
        /* TODO */  //done... isWorking
        Arrays.sort(dictionary, Term.byLexicographicOrder());
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    // Complexity: O(log N + M log M), where M is the number of matching terms
    public Term[] allMatches(String prefix){
        /* TODO */      //done... isWorking
        int len= prefix.length();
        Term key= new Term(prefix, 0);

        int firstIndex= RangeBinarySearch.firstIndexOf(dictionary, key, Term.byPrefixOrder(len));
        int lastIndex= RangeBinarySearch.lastIndexOf(dictionary, key, Term.byPrefixOrder(len));

        if(firstIndex==-1){
            Term[] noMatch= new Term[1];
            noMatch[0]= new Term("No match found", 0);
            return  noMatch;
        }

        int range= (lastIndex-firstIndex)+1;
        if((lastIndex-firstIndex)==0){
            Term[] oneMatch= new Term[1];
            oneMatch[0]= new Term(dictionary[firstIndex].getWord(), dictionary[firstIndex].getWeight());
            return oneMatch;
        }

        Term[] matches= new Term[range];
        int j= firstIndex;
        for(int i=0;i<range;i++){
            matches[i]= dictionary[j];
            j++;
        }

        return matches;
    }

    // Returns the number of terms that start with the given prefix.
    // Complexity: O(log N)
    public int numberOfMatches(String prefix){
        /* TODO */      //done... isWorking
        int len= prefix.length();
        Term key= new Term(prefix, 0);

        int firstIndex= RangeBinarySearch.firstIndexOf(dictionary, key, Term.byPrefixOrder(len));
        int lastIndex= RangeBinarySearch.lastIndexOf(dictionary, key, Term.byPrefixOrder(len));

        if(firstIndex==-1){
            return firstIndex;
        }
        return (lastIndex-firstIndex)+1;
    }

}
