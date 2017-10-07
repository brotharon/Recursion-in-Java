/**
 * The LinearSearch class will look for through a sorted array and determine
 * if the target word matches any of the words in the array.
 *
 * @author Calvin Evans
 * @version 8/3/2017
 */
public class LinearSearch extends SearchAlgorithm {

    /**
     * pre: none, default constructor.
     * post: only creates an instance of this class so that the search can be
     * run.
     */
    public LinearSearch() {
    }

    /**
     * pre: takes in an array of Strings to be iterated linearly through and a
     * String as a target word to search for.
     * post: iterates linearly through the array from beginning to end until it
     * either finds a match for the target word in the array or it runs out
     * of array to iterate through. Returns the index location of the match
     * for the target if found in the array. Throws an Exception with a
     * message that the target was not found in the array if the target word
     * does not have a match in the array.
     *
     * @param words  an array of Strings to be iterated through
     * @param target a String to be searched for
     * @return an integer reference to the index location of the matching
     * String in the array
     * @throws ItemNotFoundException thrown if no match for the target String
     *                               is found in the array.
     */
    public int search(String[] words, String target) throws ItemNotFoundException {
        for (int i = 0; i < words.length; i++) { //iterates through each
            // index location of the array
            if (words[i].equals(target)) {
                return i;
            }
            incrementCount();//adds 1 to the account for each iteration
        }
        throw new ItemNotFoundException(target + " Not Found In Array");
    }

    /**
     * WARNING: THE FOLLOWING DESCRIBES WHAT THIS CODE SHOULD DO. THIS CODE
     * MAY RESULT IN A STACK OVERFLOW EXCEPTION. I DID GET IT TO WORK WITHOUT
     * ERROR, ON MY DESKTOP BUT NOT MY LAPTOP. BE YE WARNED!!!
     *
     * pre: takes in an array of Strings to be iterated recursively through
     * and a String as a target word to search for.
     * post: iterates recursively through the array from beginning to end until
     * it either finds a match for the target word in the array or it runs
     * out of array to iterate through. Returns the index location of the
     * match for the target if found in the array. Throws an Exception with a
     * message that the target was not found in the array if the target word
     * does not have a match in the array.
     *
     * @param words  an array of Strings to be iterated through
     * @param target a String to be searched for
     * @return an integer reference to the index location of the matching
     * String in the array
     * @throws ItemNotFoundException thrown if no match for the target String
     *                               is found in the array.
     */
    public int recSearch(String[] words, String target) throws
            ItemNotFoundException {
        if (getCount() == words.length) {
            throw new ItemNotFoundException(target + " Not Found In Array");
        }
        if (words[getCount()].equals(target)) {
            return getCount();
        }
        return recSearch(words, target);
    }
}
