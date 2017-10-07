/**
 * Tests the functionality of the FindFile class. Expected outputs listed for
 * each code block.
 *
 * @author Calvin Evans
 * @version 8/4/2017
 */
public class FindFileDriver {

    /**
     * pre:none
     * post: see the println output at the top of each code block for the
     * test that is being run beneath it and the expected output.
     * @param args not used
     */
    public static void main(String[] args) {

        FindFile f = new FindFile(1);
        System.out.println("");
        System.out.println("Search for 1 files");
        System.out.println("Expected output: maxFiles message > Files found:1" +
                " > address of file");

        try {
            f.directorySearch("longwords.txt",
                    "c:\\Users\\Owner\\OneDrive\\");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Files found: " + f.getCount());
        String[] files = f.getFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }

        System.out.println("");
        System.out.println("Run search after maxFiles has been reached");
        System.out.println("Expected output: maxFiles message > Files found:1" +
                " > address of previously searched file");

        try {
            f.directorySearch("Sti_Trace.log", "c:\\Users\\Owner\\");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Files found: " + f.getCount());
        files = f.getFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }

        System.out.println("");
        System.out.println("Clear search and run new on same instance");
        System.out.println("Expected output: maxFiles message > Files found:1" +
                " > address of Sti_Trace file");

        try {
            f.clearSearch();
            f.directorySearch("Sti_Trace.log", "c:\\Users\\Owner\\");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Files found: " + f.getCount());
        files = f.getFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }

        FindFile f2 = new FindFile(100);
        System.out.println("");
        System.out.println("Search for file that does not exist on drive");
        System.out.println("Expected output: Files found: 0");

        try {
            f2.directorySearch("slapstown.txt", "c:\\Users\\Owner\\");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Files found: " + f2.getCount());
        String[] files2 = f2.getFiles();
        for (int i = 0; i < files2.length; i++) {
            System.out.println(files2[i]);
        }

        System.out.println("");
        System.out.println("Multiple searches on non-maxFile FindFile " +
                "instance");
        System.out.println("Expected output: Files found: 22 > address of " +
                "files");
        try {
            f2.directorySearch("Sti_Trace.log", "c:\\Users\\Owner\\");
            f2.directorySearch("sports fans.a2w", "c:\\Users\\Owner\\");
            f2.directorySearch("misc.xml", "c:\\Users\\Owner\\");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Files found: " + f2.getCount());
        files2 = f2.getFiles();
        for (int i = 0; i < files2.length; i++) {
            System.out.println(files2[i]);
        }

        FindFile f3 = new FindFile(2);
        System.out.println("");
        System.out.println("Search for 2 instances of file");
        System.out.println("Expected output: maxFiles message > Files found:2" +
                " > address of files");

        try {
            f3.directorySearch("sports fans.a2w", "c:\\Users\\Owner\\");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Files found: " + f3.getCount());
        String[] files3 = f3.getFiles();
        for (int i = 0; i < files3.length; i++) {
            System.out.println(files3[i]);
        }

        FindFile f4 = new FindFile(5);
        System.out.println("");
        System.out.println("Search for file with more instances than maxFiles" +
                " parameter");
        System.out.println("Expected output: maxFiles message > Files found:5" +
                " > address of files");

        try {
            f4.directorySearch("misc.xml", "c:\\Users\\Owner\\");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Files found: " + f4.getCount());
        String[] files4 = f4.getFiles();
        for (int i = 0; i < files4.length; i++) {
            System.out.println(files4[i]);
        }

        System.out.println("");
        System.out.println("Create instance of class with improper input");
        System.out.println("Expected output: Parameter size exception message");
        FindFile f5 = new FindFile(-3);

        System.out.println("");
        System.out.println("Search for file in invalid directory");
        System.out.println("Expected output: IllegalArgumentException: " +
                "invalid address > Files found: 0");
        try {
            f5.directorySearch("misc.xml", "manhattan, ny");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Files found: " + f5.getCount());
        String[] files5 = f5.getFiles();
        for (int i = 0; i < files5.length; i++) {
            System.out.println(files5[i]);
        }

    }
}
