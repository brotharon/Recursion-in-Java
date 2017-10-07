/**
 * The BinarySearch class will look for through a sorted array and determine
 * if the target word matches any of the words in the array.
 *
 * @author Calvin Evans
 * @version 8/3/2017
 */
public class BinarySearch extends SearchAlgorithm {

    /**
     * pre: none, default constructor.
     * post: only creates an instance of this class so that the search can be
     * run.
     */
    public BinarySearch() {
    }

    /**
     * pre: Takes in 2 parameters an array of Strings to conduct an iterative
     * binary search through and a String as the target word to search for.
     * post: conducts an interative search of a String array using a binary
     * algorithm to cut the search size in half each time if it does not
     * match the target word until the word has been matched. If it matches
     * the word it returns the index location of the word in the String array
     * . If the word is not matched an Exception is thrown with a message
     * that the target word was not found in the array.
     *
     * @param words  an array of Strings to be searched through
     * @param target a String to be the target of the search
     * @return an integer reference to the index location of the target word
     * in the array
     * @throws ItemNotFoundException an exception thrown if the target word
     *                               is not contained within the array
     */
    public int search(String[] words, String target) throws
            ItemNotFoundException {
        if (words == null || target == null) { //checking for null input
            throw new ItemNotFoundException("Cannot Search: Null Input");
        }
        //setting variables to be used in iterative search
        resetCount();
        int top = words.length; //right index of the current search area
        int bottom = 0; //left index of the current search area

        while (top > bottom) { //continues searching until the indexes cross
            // which indicates that the word is not in the array. base case 1
            if (words[(top + bottom) / 2].equals(target)) { //check for base
                // case 2
                incrementCount();
                return (top + bottom) / 2;
            } else if (target.compareTo(words[(top + bottom - 1) / 2]) > 0) {
                //if the target is alphabetically greater than the checked
                // word the search is moved to the halfway point between
                // current and top indexes
                bottom = (bottom + top) / 2;
                incrementCount();
            } else if (target.compareTo(words[(top + bottom) / 2]) < 0) {
                //if the target is alphabetically smaller than the checked
                // word the search is moved to the halfway point between
                // current and bottom indexes
                top = (top + bottom) / 2;
            }
        }
        throw new ItemNotFoundException(target + " Not Found In Array");

    }

    /**
     * pre: Takes in 2 parameters an array of Strings to conduct a recursive
     * binary search through and a String as the target word to search for.
     * post: conducts a recursive search of a String array using a binary
     * algorithm to cut the search size in half each time if it does not
     * match the target word until the word has been matched. If it matches
     * the word it returns the index location of the word in the String array
     * . If the word is not matched an Exception is thrown with a message
     * that the target word was not found in the array.
     *
     * @param words  an array of Strings to be searched through
     * @param target a String to be the target of the search
     * @return an integer reference to the index location of the target word
     * in the array
     * @throws ItemNotFoundException an exception thrown if the target word
     *                               is not contained within the array
     */
    public int recSearch(String[] words, String target) throws
            ItemNotFoundException {
        if (words == null || target == null) {//check for null input
            throw new ItemNotFoundException("Cannot Search: Null Input");
        }

        resetCount(); //iteration counter to 0

        return recSearchHelper(words, target, words.length, 0);

    }

    /**
     * pre: none, takes all inputs from the recSearch method
     * post: runs the recursive binary search described in the text for the
     * recSearch method.
     *
     * @param words  an array of Strings
     * @param target a String to find in the array
     * @param top    upper index of current search area
     * @param bottom lower index of current search area
     * @return an int reference to the index location of the target word in
     * the array
     * @throws ItemNotFoundException an exception thrown if the target word
     *                               is not contained within the array.
     */
    private int recSearchHelper(String[] words, String target, int top, int
            bottom) throws ItemNotFoundException {
        if (target.equals(words[(top + bottom) / 2])) {//base case 1
            incrementCount();
            return (top + bottom) / 2;
        } else if (bottom >= top) {//base case 2
            throw new ItemNotFoundException(target + " Not Found In Array");
        } else if (target.compareTo(words[(top + bottom - 1) / 2]) >
                0) {  //if the target is alphabetically greater than the
            // checked word the search is moved to the halfway point between
            // current and top indexes
            incrementCount();
            return recSearchHelper(words, target, top, (top + bottom) / 2);
        } else if (target.compareTo(words[(top + bottom) / 2]) < 0) {
            //if the target is alphabetically smaller than the checked
            // word the search is moved to the halfway point between
            // current and bottom indexes
            incrementCount();
            return recSearchHelper(words, target, (top + bottom) / 2,
                    bottom);
        } else {
            throw new ItemNotFoundException(target + " Not Found In Array");
        }
    }
}
