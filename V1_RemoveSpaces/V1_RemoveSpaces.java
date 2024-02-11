import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.*;

public class V1_RemoveSpaces {

    /**
     * Main program:
     * - Request for code input
     * - Remove spaces
     * - Display code without space
     * - Request for copy to clipboard
     * - End of program
     *
     * @param args : Arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ask for code input

        System.out.println("Enter your code css :");
        String codeWithSpace = sc.nextLine();

        // remove spaces
        String codeWithoutSpace = codeWithSpace.replaceAll("\\s", "");

        // Display code without space
        System.out.println("Code without spaces : " + codeWithoutSpace);

        // ask for copy to clipboard
        System.out.println("Copy code to clipboard (Y/N) ?");
        String answer = sc.nextLine();

        // put the answer in uppercase
        answer = answer.toUpperCase();

        // analyze the answer
        if (answer.equals("Y")) {
            // copy to clipboard
            System.out.println("Code copy to clipboard");
            java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(codeWithoutSpace), null);
        }

        // end of program
        System.out.println("End of program");

    }
}
