import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Tests {
    public static void main(String[]args){
        Term[] terms= new Term[7];
        terms[0]= new Term("cherry", 15);
        terms[1]= new Term("apple", 10);
        terms[2]= new Term("banana", 20);
        terms[3]= new Term("cherry", 15);
        terms[4]= new Term("berry", 13);
        terms[5]= new Term("cherry", 15);
        terms[6]= new Term("cherry", 15);

        Autocomplete autocomplete= new Autocomplete(terms);
        System.out.println(Arrays.toString(autocomplete.allMatches("dor")));
        System.out.println(autocomplete.numberOfMatches("dor"));

        //int num= RangeBinarySearch.lastIndexOf(terms, terms[1], Term.byPrefixOrder(3));
        //System.out.println(num);
        
        // Term t1= new Term("cherry", 15);
        // //System.out.println(t1.getPrefix(3));

        // Term t2= new Term("apple", 10);
        // Term t3= new Term("banana", 20);

        // List<Term> terms = new ArrayList<>(List.of(t1, t2, t3));
        // System.out.println(terms);
        // terms.sort(Term.byLexicographicOrder());
        // System.out.println("Sorted by lexicographic order:");
        // for (Term term : terms) {
        //     System.out.println(term);
        // }

        // terms.sort(Term.byReverseWeightOrder());
        // System.out.println("Sorted by reverse weight order:");
        // for(Term term: terms){
        //     System.out.println(term);
        // }

        // terms.sort(Term.byPrefixOrder(3));
        // System.out.println("Sorted by prefix order (first 3 characters):");
        // for(Term term: terms){
        //     //System.out.println(term.getPrefix(3));
        //     System.out.println(term.toString());
        // }

        //System.out.println(t1.getWord().compareToIgnoreCase(t2.getWord()));


    }
}
