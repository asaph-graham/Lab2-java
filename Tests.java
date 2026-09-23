import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class Tests {
    public static void main(String[]args){
        Term t1= new Term("cherry", 15);
        //System.out.println(t1.getPrefix(3));

        Term t2= new Term("apple", 10);
        Term t3= new Term("banana", 20);

        List<Term> terms = new ArrayList<>(List.of(t1, t2, t3));
        System.out.println(terms);
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

        terms.sort(Term.byPrefixOrder(3));
        System.out.println("Sorted by prefix order (first 3 characters):");
        for(Term term: terms){
            //System.out.println(term.getPrefix(3));
            System.out.println(term.toString());
        }
    }
}
