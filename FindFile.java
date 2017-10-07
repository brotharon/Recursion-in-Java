import java.io.File;

/**
 * FindFile will search for a target file in a linear search pattern. Tested
 * on a Windows 10 computer data structure. May encounter different than
 * expected outputs on non-Windows OS.
 *
 * This class was designed to store the data until the maxFiles is reached. If
 * you would like to run a different search with the same number of maxFiles
 * after this has been filled you can create a new FindFile instance or call
 * the clearSearch method on one of your current instances of this class
 * prior to running the search again.
 *
 * To clarify, this class will continue to add new searched file addresses to
 * the stored String array so long as the maxFiles parameter set by the
 * constructor has not been met. Once this parameter has been met this class
 * will no longer store any additional data.
 *
 * @author Calvin Evans
 * @version 8/3/2017
 */

public class FindFile {

    String[] locations;
    int count;

    /**
     * pre: constructor takes in an int as the maximum number of files to be
     * found for the search.
     * post: initializes this class by creating an array with a number of
     * indexes equal to the max number of files to be found.
     * @param maxFiles an int equal to the number of instances of the file to
     *                be found in the search
     */
    public FindFile(int maxFiles) {
        if (maxFiles > 0) {
            locations = new String[maxFiles];
        } else {
            System.out.println("You have to search for at least one file. " +
                    "Search parameter set to search for one file.");
            locations = new String[1];
        }
    }

    /**
     * pre: none
     * post: sets all values in array to null to initialize for new search.
     */
    private void emptyArray(){
        for (int i = 0; i < locations.length; i++){
            locations[i] = null;
        }
    }

    /**
     * pre: none
     * post: none
     * @return returns a count of the number of times the searched file was
     * found in the given directory up to the max number of files to search
     * passed in to the constructor.
     */
    protected int getCount() {
        return count;
    }

    /**
     * pre: none
     * post: iterates through the stored array to create a deep copy of the
     * stored array as the output.
     * @return returns the output array which is a deep copy of the stored
     * array.
     */
    protected String[] getFiles() {
        String[] output = new String[count];

        for (int i = 0; i < count; i++) {
            output[i] = locations[i];
        }

        return output;
    }

    /**
     * pre: none
     * post: sets all of the currently used indexes in locations to be blank
     * and resets count to 0.
     */
    public void clearSearch(){
        for (int i = 0; i < count; i++){
            locations[i] = "";
        }
        count = 0;
    }

    /**
     * pre: takes in a String as the target file to be searched for and a
     * String as the name of the directory to begin the search in.
     * post: checks that the parameter dirName is a directory, throws
     * IllegalArgumentException if it isn't. Creates an array of the Files
     * stored in the directory. Checks to ensure that the directory was not
     * empty by running a null check on the files array. Iterates through the
     * directory and all sub-directories looking for the target file until it
     * reaches the max number of files requested.
     * @param target a non-null String for the name of the file to be
     *               searched for.
     * @param dirName a non-null String for the name of the directory to
     *                begin the search in.
     * @throws Exception Can throw 2 exceptions. IllegalArgumentException if
     * the input String dirName is not a directory. Exception once the max
     * number of files has been reached. Both output messages detailing the
     * reason for the exception. Neither causes a crash or System.exit.
     */
    public void directorySearch(String target, String dirName) throws
            Exception {
        File dir = new File(dirName);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Please Check Your Input " +
                    "Directory Address And Try Again");
        }

        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }

        for (int i = 0; i < files.length; i++) { //iterates over each files
            // in the current directory.
            String matchMe = dir.getAbsolutePath() + "\\" + target; //adjusts
            // the name of the target file to match it to the current directory
            if (count == locations.length) { //base case
                throw new Exception("maxFiles found");
            } else if (files[i].isDirectory()) {//recursive call to search
                // found sub-directories
                directorySearch(target, files[i].getAbsolutePath());
            } else if (files[i].toString().equals(matchMe)) {//found match,
                // saves current directory location and file name to next
                // open location in array and iterates count.
                locations[count] = matchMe;
                count++;
            }
        }
    }
}





