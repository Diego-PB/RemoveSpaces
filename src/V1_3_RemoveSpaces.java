import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.*;

public class V1_3_RemoveSpaces {

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
    public static void main(String[] args) throws IOException, UnsupportedFlavorException {
        Scanner sc = new Scanner(System.in);
        String codeWithSpace = "";


        // menu
        System.out.println(" ");
        System.out.println("*********************************************************************************");
        System.out.println("*                                                                               *");
        System.out.println("*                      Remove spaces in the code                                *");
        System.out.println("*                             by @diego-pb                                      *");
        System.out.println("*                                  V3                                           *");
        System.out.println("*                                                                               *");
        System.out.println("*********************************************************************************");
        System.out.println(" ");
        System.out.println("( Read the readme.md file for more information or to be sure to have a correct code )");
        System.out.println(" ");

        System.out.println("Be ready, the code will retrieve your code in the clipboard. make sure you have copied the CssBattle code");
        System.out.println("( press 'enter' when ready )");
        sc.nextLine();


        // Inform the user of the retrieves the text in the clipboard
        System.out.println("Copy the code to the clipboard ...");

        // retrieves the text in the clipboard
        try {
            codeWithSpace = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | HeadlessException | IOException e) {
            throw new RuntimeException(e);
        }

        // delete spaces
        String codeFinal = modifyCode(codeWithSpace);

        // Display code without space
        System.out.println("Code without spaces : " + codeFinal);

        // ask for copy to clipboard
        System.out.println("Copy code to clipboard (Y/N) ?");
        String answer = sc.nextLine();

        // pass the answer to uppercase
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

        // Add a space after the pattern 'div'
        codeWithoutSpace = addSpaceAfter(codeWithoutSpace, "<div");

        // Add a space after the pattern 'solid'
        codeWithoutSpace = addSpaceAfter(codeWithoutSpace, "solid");

        // Add a space after the pattern '#' if there is the 'solid ' pattern after
        if (codeWithoutSpace.contains("solid#")) {
            codeWithoutSpace = codeWithoutSpace.replaceAll("solid#", "solid #");
        }

        // Add a space after the pattern 'solid' if there is a number after
        for (int i = 0; i < 10; i++) {
            codeWithoutSpace = codeWithoutSpace.replaceAll("solid" + i, "solid " + i);
        }

        // Add a space before 'solid' if there is a :
        // 1 - 2 -3 - 4 - 5 - 6 - 7 - 8 - 9 - 0 - A - a - B - b - C - c - D - d - E - e - F - e
        codeWithoutSpace = codeWithoutSpace.replaceAll("1solid", "1 solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("2solid", "2 solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("3solid", "3 solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("4solid", "4 solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("5solid", "5 solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("6solid", "6 solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("7solid", "7 solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("8solid", "8 solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("9solid", "9 solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("0solid", "0 solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("Asolid", "A solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("asolid", "a solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("Bsolid", "B solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("bsolid", "b solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("Csolid", "C solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("csolid", "c solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("Dsolid", "D solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("dsolid", "d solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("Esolid", "E solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("esolid", "e solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("Fsolid", "F solid");
        codeWithoutSpace = codeWithoutSpace.replaceAll("fsolid", "f solid");

        // Add space for the unit
        codeWithoutSpace = spaceForUnit(codeWithoutSpace);


        // Ask if the user want to delete useless character
        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("*********************************************************************************");
        System.out.println(" ");
        System.out.println("Do you want to delete useless caracter (Y/N) ?");
        System.out.println(" ");
        System.out.println("If yes, be sure to have a normal css code to avoid error,");
        System.out.println("more information in the readme.md file");
        System.out.println(" ");
        System.out.println("*********************************************************************************");
        System.out.println(" ");

        // Ask for the answer
        String answer = sc.nextLine();

        // pass the answer to uppercase
        answer = answer.toUpperCase();

        // analyze the answer
        if (answer.equals("Y")) {
            // Remove the last pattern '</div>'
            codeWithoutSpace = removeOnlyLastPatern(codeWithoutSpace, "</div>");
            // Remove the last pattern '</style>'
            codeWithoutSpace = removeOnlyLastPatern(codeWithoutSpace, "</style>");
            // Remove the last pattern '}'
            codeWithoutSpace = removeOnlyLastPatern(codeWithoutSpace, "}");
        }

        // Remove the patern ';' if the chacarter after is a '}'
        if (codeWithoutSpace.contains(";}")) {
            codeWithoutSpace = codeWithoutSpace.replaceAll(";}", "}");
        }


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

        // Add a space after the pattern
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
     * Look in a code, if a character is present after a pattern
     *
     * @param pfCode     : Code to analyze
     * @param pfPatern   : Pattern to analyze
     * @param pfCharacter : Character to analyze
     * @return True if the character is present after the pattern
     */
    public static boolean isCharacterAfter(String pfCode, String pfPatern, String pfCharacter) {
        boolean isCharacterAfter = false;

        // Look for the pattern
        int position = pfCode.indexOf(pfPatern);

        // Look for the character
        if (position != -1) {
            if (position + pfPatern.length() < pfCode.length()) {
                if (pfCode.substring(position + pfPatern.length(), position + pfPatern.length() + 1).equals(pfCharacter)) {
                    isCharacterAfter = true;
                }
            }
        }

        return isCharacterAfter;
    }

    /**
     * Add a space after the unit
     * List of the unit : px, q, em, %, vh, vw
     *
     * @param pfCode : Code to modify
     * @return Modified code
     */
    public static String spaceForUnit(String pfCode) {
        String codeModify = pfCode;

        // Add a space after the pattern (list under) if there is a number after :
        for (int i = 0; i < 10; i++) {
            codeModify = codeModify.replaceAll("px" + i, "px " + i);
            codeModify = codeModify.replaceAll("q" + i, "q " + i);
            codeModify = codeModify.replaceAll("em" + i, "em " + i);
            codeModify = codeModify.replaceAll("%" + i, "% " + i);
            codeModify = codeModify.replaceAll("vh" + i, "vh " + i);
            codeModify = codeModify.replaceAll("vw" + i, "vw " + i);
        }

        // If after a unit px or q or em or % or vh or vw, there is a '#', add a space
        if (codeModify.contains("px#")) {
            codeModify = codeModify.replaceAll("px#", "px #");
        }
        if (codeModify.contains("q#")) {
            codeModify = codeModify.replaceAll("q#", "q #");
        }
        if (codeModify.contains("em#")) {
            codeModify = codeModify.replaceAll("em#", "em #");
        }
        if (codeModify.contains("%#")) {
            codeModify = codeModify.replaceAll("%#", "% #");
        }
        if (codeModify.contains("vh#")) {
            codeModify = codeModify.replaceAll("vh#", "vh #");
        }
        if (codeModify.contains("vw#")) {
            codeModify = codeModify.replaceAll("vw#", "vw #");
        }

        // Add a space if after a unit, there is a 'solid'
        if (codeModify.contains("pxsolid")) {
            codeModify = codeModify.replaceAll("pxsolid", "px solid");
        }
        if (codeModify.contains("qsolid")) {
            codeModify = codeModify.replaceAll("qsolid", "q solid");
        }
        if (codeModify.contains("emsolid")) {
            codeModify = codeModify.replaceAll("emsolid", "em solid");
        }
        if (codeModify.contains("%solid")) {
            codeModify = codeModify.replaceAll("%solid", "% solid");
        }
        if (codeModify.contains("vhsolid")) {
            codeModify = codeModify.replaceAll("vhsolid", "vh solid");
        }
        if (codeModify.contains("vwsolid")) {
            codeModify = codeModify.replaceAll("vwsolid", "vw solid");
        }

        return codeModify;
    }

    /**
     * Remove the last pattern but not the other or the rest of the code
     *
     * @param pfCode    : Code to modify
     * @param pfPatern : Pattern to remove
     * @return Modified code
     *
     */
    public static String removeOnlyLastPatern(String pfCode, String pfPatern) {
        String codeWithoutPatern = pfCode;

        // Look for the last position of the pattern
        int position = codeWithoutPatern.lastIndexOf(pfPatern);

        // If the pattern is found
        if (position != -1) {
            // Remove the pattern
            codeWithoutPatern = codeWithoutPatern.substring(0, position) + codeWithoutPatern.substring(position + pfPatern.length());
        }




        return codeWithoutPatern;
    }
}