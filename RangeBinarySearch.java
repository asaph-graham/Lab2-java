import java.util.Comparator;

public class RangeBinarySearch{

    // Returns the index of the *first* element in terms[] that equals the search key,
    // according to the given comparator, or -1 if there are no matching elements.
    // Complexity: O(log N), where N is the length of the array
    public static int firstIndexOf(Term[] terms, Term key, Comparator<Term> comparator) {
        if(terms==null || terms.length==0){
            return -1;
        }
        //implementing binary search here...
        int lo= 0;
        int hi= (terms.length-1);
        int middle= -1;     //placeholder incase we don't find the word.

        while(lo<=hi){
            int mid= (lo+hi)/2;
            int compare= comparator.compare(key, terms[mid]);
            if(compare<0){
                hi= mid-1;
            }
            else if(compare>0){
                lo= mid+1;
            }
            else{
                middle= mid;
                hi= mid-1;      //to find the leftmost/first index of the term
            }
        }
        return middle;
    }

    // Returns the index of the *last* element in terms[] that equals the search key,
    // according to the given comparator, or -1 if there are no matching elements.
    // Complexity: O(log N)
    public static int lastIndexOf(Term[] terms, Term key, Comparator<Term> comparator) {
        if(terms==null || terms.length==0){
            return -1;
        }

        //implementing binary search here...
        int lo=0, hi= (terms.length-1);
        int middle= -1;     //placeholder incase we don't find the word.

        while(lo<=hi){
            int mid= (lo+hi)/2;
            int compare= comparator.compare(key, terms[mid]);
            if(compare<0){
                hi= mid-1;
            }
            else if(compare>0){
                lo= mid+1;
            }
            else{
                middle= mid;
                lo= mid+1;      //to find the rightmost/last index of the term
            }
        }

        return middle;
    }

}
