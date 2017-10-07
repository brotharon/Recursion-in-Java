
/**
 * Pre: Can be constructed with no argument or with an Object argument passed in
 * Post: Creates an array which can be manipulated similarly to an ArrayList
 * object
 * @author Calvin Evans
 * @version 07/01/2017
 */
public class ArrayList {
    private Object[] list;

    /**
     * Pre: default constructor; requires no argument
     * Post: creates an instance of ArrayList with length 1 containing no
     * objects
     */
    public ArrayList() {
        list = new Object[1];
    }

    /**
     * Pre: constructor takes one argument as an object
     * Post: creates an instance of ArrayList with length 1 containing the
     * object that was passed in at index 0.
     *
     * @param obj the Object o can be an instance of any object
     */
    public ArrayList(Object obj) {
        list = new Object[1];
        list[0] = obj;
    }

    /**
     * Pre: constructor takes in two arguments as an object and an int
     * Post: creates an instance of ArrayList with length 1 containing the
     * object that was passed in at index 0. If user attempts to place object
     * at index other than 0 the console outputs a message stating that the
     * object was placed at index 0 because the ArrayList object must begin
     * at index 0.
     *
     * @param obj     the Object o can be an instance of any object
     * @param index the Int index can be any int, but any int other than 0
     *              will result in the Object being placed at index 0 at the
     *              creation of the ArrayList.
     */
    public ArrayList(Object obj, int index) {
        if (index > 0 || index < 0) {
            list = new Object[1];
            list[0] = obj;
            System.out.println("New ArrayList must start at index 0.");
            System.out.println("Input " + obj + " placed at index 0.");
        } else {
            list = new Object[1];
            list[0] = obj;
        }
    }

    /**
     * Pre: Constructor takes in 2 parameters as an Object and an int
     * Post: Uses the makeSpace method to create a place in the ArrayList at
     * the desired index location and places the Object o into the index
     * location in the ArrayList. Error checking is done to ensure that the
     * index value given is within the scope of the current ArrayList. If the
     * user attempts to place an Object at an index below 0 the Object is
     * placed at 0 in the ArrayList. If the user attempts to place an Object
     * at a location in the ArrayList beyond the current indexes of the
     * ArrayList the object is placed at a new location equal to the previous
     * final index +1.
     *
     * @param obj     the Object o can be an Object of any type
     * @param index the int index should be a value that is within the scope
     *              of the current ArrayList (between 0 and the length -1,
     *              and greater than or equal to 0).
     */
    void insert(Object obj, int index) {
        int newIndex = fixIndex(index);
        if (newIndex == list.length) {
            growArray();//grows index by 1
            list[newIndex] = obj;
        } else if (newIndex >= 0) {
            if (list[newIndex] == null) {
                list[newIndex] = obj;
            } else {
                makeSpace(newIndex);
                list[newIndex] = obj;
            }
        } else {//outputs error message to console
            System.out.println("The given index location does not exist in " +
                    "this ArrayList.");
            System.out.println("Please try again with a value between 0 and " +
                    "" + (list.length - 1) + ".");
        }
    }

    /**
     * Pre: Passed int internally, cannot be called from outside this class
     * Post: changes the input int index into a value that is within the
     * values of available indexes for the ArrayList
     * @param index the location that the user would like the new value
     *              stored in the ArrayList
     * @return the location that the passed in value will be stored in the
     * ArrayList. Only altered if the value passed in would have been outside
     * of the scope of the current ArrayList.
     */
    private int fixIndex(int index) {
        int check = list.length;
        if (index <= 0) {
            return 0;
        } else if (index >= check) {
            return check;
        }
        return index;
    }

    /**
     * Pre: none
     * Post: creates a new array of a length 1 larger than the current array
     * then copies the data from the current array to the new array and saves
     * the new array over the old array effectively increasing the size of
     * the old array by 1.
     */

    private void growArray() {
        Object[] temp = new Object[list.length + 1];
        for (int i = 0; i < list.length; i++) {
            temp[i] = list[i]; //moves the objects stored in the ArrayList 1
            // space to the right.
        }
        list = temp;
    }

    /**
     * Pre: none
     * Post: creates a new array of a length 1 smaller than the current array
     * then copies the data from the current array to the new array and saves
     * the new array over the old array effectively decreasing the size of
     * the old array by 1.
     */
    private void shrinkArray() {
        Object[] temp = new Object[list.length - 1];
        for (int i = 0; i < list.length - 1; i++) {
            temp[i] = list[i]; // moves the objects stored in the ArrayList
            // one space to the left.
        }
        list = temp;
    }

    /**
     * Pre: takes in the index that was passed from user input in the form of
     * an int.
     * Post: Increases the size of the array by 1, moves all objects stored
     * in the array to the left 1 from the index location so the new object
     * can be stored at the desired index.
     *
     * @param index this int is passed internally an has already been checked
     *              to insure it is valid before being passed to this method
     */
    private void makeSpace(int index) {
        growArray();
        for (int i = list.length - 1; i >= index; i--) { //moves all indexes
            // to the right 1 space.
            if (i > 0) {
                list[i] = list[i - 1];
            }
        }
    }

    /**
     * Pre: takes in the index that was passed from user input in the form of
     * an int.
     * Post: Decreases the size of the array by 1, moves all objects stored
     * to the right of the index left 1 space.
     *
     * @param index this int is passed internally an has already been checked
     *              to insure it is valid before being passed to this method
     */
    private void closeSpace(int index) {
        for (int i = index; i < list.length - 1; i++) { //moves all indexes
            // to the left 1 space.
            list[i] = list[i + 1];
        }
        shrinkArray();
    }

    /**
     * Pre: Constructor takes in 1 parameter as an int
     * Post: Uses the closeSpace method to remove a place in the ArrayList at
     * the desired index location. Error checking is done to ensure that the
     * index value given is within the scope of the current ArrayList. Prints
     * a message to console if the user attempts to place the Object at an
     * index outside of the ArrayList, and also tells the user what the
     * current valid range of indexes are.
     *
     * @param index the int index should be a value that is within the scope
     *              of the current ArrayList (between 0 and the length -1,
     *              and greater than or equal to 0).
     */
    Object remove(int index) {
        if (index < list.length && index >= 0) {
            Object retVal = list[index];
            closeSpace(index);
            return retVal;
        } else {//outputs error message to console
            System.out.println("The given index location does not exist in " +
                    "this ArrayList.");
            System.out.println("Please try again with a value between 0 and " +
                    "" + (list.length - 1) + ".");
        }
        return null;
    }

    /**
     * Pre: none
     * Post: none
     *
     * @return returns an int copy of the length of the stored array. Does not
     * modify or alter the stored array.
     */
    int size() {
        return list.length;
    }

    /**
     * Pre: none
     * Post: none
     *
     * @return returns a boolean true if the stored array is empty and false
     * if the array has any indexes even if they are null. Does not modify or
     * alter the stored array.
     */
    boolean isEmpty() {
        return (list.length == 0);
    }

    /**
     * Pre: Requires user to pass in an index location that is within the the
     * currently stored array.
     * Post: Passes the object stored at the index location back to the
     * calling program, or returns a null value and outputs an error message
     * to the console.
     * @param index any int value. Values outside of the indexes of the
     *              current array will return an error message
     * @return returns the Object stored at the index location if possible,
     * otherwise returns null and outputs an error message.
     */
    Object get(int index) {
        if (index < list.length && index >= 0) {
            return list[index];
        }
        System.out.println("Error: Index location outside of Array");
        return null;
    }

    /**
     * Pre: User passes in an object that is believed to be stored in the
     * ArrayList
     * Post:Checks all objects in the ArrayList against the object passed in
     * to determine if there is a match. Returns the first match that the
     * method locates in the ArrayList. If there are other matches beyond the
     * first in the indexes they will not be identified, in order to get them
     * you will need to remove the object at the returned index and run this
     * method again. Continue doing this until the method returns a -1 which
     * indicates that no more matches exist in the ArrayList.
     * @param obj any Object passed from the user
     * @return returns the index location of the first instance of the passed
     * in Object from the ArrayList as an int. If the object is not found in
     * the ArrayList returns -1.
     */
    int indexOf(Object obj) {
        int index = -1;
        if (this.isEmpty()) {
            return index;
        } else {
            for (int i = 0; i < list.length; i++) {
                if (list[i].equals(obj)) { //checks each stored Object
                    // against the passed in Object using the object's
                    // .equals method
                    index = i;
                    return index;
                }
            }
        }
        return index;
    }

    /**
     * Pre: Can take in any object from the user
     * Post: Validates that the object that was passed in is of the
     * appropriate type, compares the object's parameters against this
     * object's parameters using each object's .equals methods.
     * @param obj can handle any Object type for input
     * @return returns a boolean as true if the objects are equal or as false
     * if the objects do not match each other's parameters.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArrayList) {
            ArrayList check = (ArrayList) obj;
            if (check.size() == list.length && this.isEmpty()) {
                return true; //if both objects are of the same length, and
                // this object is empty then they have to be equal as they
                // both have no objects stored in them.
            } else if (check.size() == list.length) {
                for (int i = 0; i < list.length; i++) {
                    if (!list[i].equals(check.get(i))) {//iterates over each
                        // part of both objects and compares them to make
                        // sure that they match.
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Pre: none
     * Post: Iterates over this object and creates a String from each stored
     * object in the ArrayList.
     * @return returns the String object that was created from each object
     * stored in the ArrayList
     */
    @Override
    public String toString() {
        String output;
        if (!this.isEmpty()) {
            output = "" + list[0];
            for (int i = 1; i < list.length; i++) {
                output += ", " + list[i]; //outputs each stored object in the
                // ArrayList as a String to the output variable
            }
            return output;
        } else {
            return output = "Data structure is empty";
        }
    }
}
