import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.*;

public class V2_RemoveSpaces {

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

        // delete spaces
        String codeFinal = modifyCode(codeWithSpace);

        // Display code without space
        System.out.println("Code without spaces : " + codeFinal);

        // ask for copy to clipboard
        System.out.println("Copy code to clipboard (Y/N) ?");
        String answer = sc.nextLine();

        // Passage de la reponse en majuscule
        answer = answer.toUpperCase();

        // analyze the answer
        if (answer.equals("Y")) {
            // copy to clipboard
            System.out.println("Code copy to clipboard");
            java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(codeFinal), null);
        }

        // end of program
        System.out.println("End of program");

    }

    /**
     * Modify the code
     *
     * @param pfCodeWithSpace : Code with space
     * @return Code without space
     */
    public static String modifyCode(String pfCodeWithSpace) {
        String codeWithoutSpace = "";

        // Delete all spaces
        codeWithoutSpace = pfCodeWithSpace.replaceAll("\\s", "");


        // if 'isCaracterAfter' is false, add a space after the pattern
        if (!isCaracterAfter(codeWithoutSpace, "div", ">")) {
            codeWithoutSpace = addSpaceAfter(codeWithoutSpace, "div");
        }

        // Add a space after the pattern 'solid'
        codeWithoutSpace = addSpaceAfter(codeWithoutSpace, "solid");

        // Add a space before the pattern '#'
        codeWithoutSpace = addSpaceBefore(codeWithoutSpace, "#");


        return codeWithoutSpace;
    }

    /**
     * Add a space after the pattern
     *
     * @param pfCode   : Code to modify
     * @param pfPatern : Pattern to modify
     * @return Modified code
     */
    public static String addSpaceAfter(String pfCode, String pfPatern) {
        String CodeModifie = "";

        // Ajout d'un espace après le patern
        CodeModifie = pfCode.replaceAll(pfPatern, pfPatern + " ");

        return CodeModifie;
    }

    /**
     * Add a space before the pattern
     *
     * @param pfCode   : Code to modify
     * @param pfPatern : Pattern to modify
     * @return Modified code
     */
    public static String addSpaceBefore(String pfCode, String pfPatern) {
        String codeModify = "";

        // Add a space before the pattern
        codeModify = pfCode.replaceAll(pfPatern, " " + pfPatern);

        return codeModify;
    }


    /**
     * Look in a code, if a caracter is present after a pattern
     *
     * @param pfCode     : Code to analyze
     * @param pfPatern   : Pattern to analyze
     * @param pfCaracter : Caracter to analyze
     * @return True if the caracter is present after the pattern
     */
    public static boolean isCaracterAfter(String pfCode, String pfPatern, String pfCaracter) {
        boolean isCaracterAfter = false;

        // Look for the pattern
        int position = pfCode.indexOf(pfPatern);

        // Look for the caracter
        if (position != -1) {
            if (position + pfPatern.length() < pfCode.length()) {
                if (pfCode.substring(position + pfPatern.length(), position + pfPatern.length() + 1).equals(pfCaracter)) {
                    isCaracterAfter = true;
                }
            }
        }

        return isCaracterAfter;
    }
}