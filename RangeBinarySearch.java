
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class RangeBinarySearch{

    // Returns the index of the *first* element in terms[] that equals the search key,
    // according to the given comparator, or -1 if there are no matching elements.
    // Complexity: O(log N), where N is the length of the array
    public static int firstIndexOf(Term[] terms, Term key, Comparator<Term> comparator) {
        /* TODO */  //done... isWorking
        Arrays.sort(terms, comparator);     //to sort alphabetically at runtime(later, when the function is called)

        //implementing binary search here...
        int lo=0, hi= (terms.length-1);
        int middle= -1;     //placeholder incase we don't find the word.
        int keyLength= key.getWord().length();

        while(lo<=hi){
            int mid= (lo+hi)/2;

            int compare= key.getWord().compareToIgnoreCase(terms[mid].getPrefix(keyLength));
            if(compare<0){
                hi= mid-1;
            }
            else if(compare>0){
                lo= mid+1;
            }
            else{
                middle= mid;
                break;
            }
        }

        // finding the first index...
        if(middle==-1){
            return middle;  //word was never found
        }
        else if(middle==0){
            return middle;   //in case we are at the first element... trying to avoid out of bounds exception
        }
        int compare= terms[middle].getWord().compareToIgnoreCase(terms[middle-1].getWord());
        while (compare==0){
            middle--;
            if(middle==0){
                return middle;  //so that we avoid out of bounds exception
            }
            compare= terms[middle].getWord().compareToIgnoreCase(terms[middle-1].getWord());
        }

        return middle;
    }

    // Returns the index of the *last* element in terms[] that equals the search key,
    // according to the given comparator, or -1 if there are no matching elements.
    // Complexity: O(log N)
    public static int lastIndexOf(Term[] terms, Term key, Comparator<Term> comparator) {
        /* TODO */  //done... isWorking
        Arrays.sort(terms, comparator);     //to sort alphabetically at runtime(later, when the function is called)

        //implementing binary search here...
        int lo=0, hi= (terms.length-1);
        int middle= -1;     //placeholder incase we don't find the word.
        int keyLength= key.getWord().length();

        while(lo<=hi){
            int mid= (lo+hi)/2;

            int compare= key.getWord().compareToIgnoreCase(terms[mid].getPrefix(keyLength));
            if(compare<0){
                hi= mid-1;
            }
            else if(compare>0){
                lo= mid+1;
            }
            else{
                if(terms.length==1 && compare!=0){
                    return -1;
                }
                middle= mid;
                break;
            }
        }

        // finding the last index...
        if(middle==-1){
            return middle;  //word was never found
        }
        else if(middle==(terms.length-1)){
            return middle;   //in case we are at the last element... trying to avoid out of bounds exception
        }
        int compare= terms[middle].getWord().compareToIgnoreCase(terms[middle+1].getWord());
        while (compare==0){
            middle++;
            if(middle==(terms.length-1)){
                return middle;  //so that we avoid out of bounds exception
            }
            compare= terms[middle].getWord().compareToIgnoreCase(terms[middle+1].getWord());
        }

        return middle;
    }

}
