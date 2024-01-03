/**
 * Retire tout espace d'un texte donné.
 * possibilité de copier rapidement le résultat dans le presse-papiers
 *
 * L'objectif est de supprimer tous les espaces superflus au code css, pour les défis proposés
 * par le site Css Battle [https://cssbattle.dev/]
 *
 * @author https://github.com/Diego-PB
 * 
 * version : 2
 * 
 */

/**
 * Retire tout espace d'un texte donné, sauf :
 * - après le mot "div" / exemple : <div class="a">
 * car pourrait altérer le code
 */
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class RemoveSpacesV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un texte: ");
        String input = scanner.nextLine();

        // Expression régulière modifiée pour ne pas enlever les espaces après "div"
        String result = input.replaceAll("(?<!div)\\s+|(?<=div)\\s+(?=\\w+)", "");

        System.out.println("Texte sans espaces: ");
        System.out.println(result);

        // Copier le texte dans le presse-papiers
        System.out.println("Copier le texte dans votre presse-papier ? (oui/non)");
        String copier = scanner.nextLine();

        if(copier.equals("oui")){
            System.out.println("//");
            System.out.println("Le texte sans espace, vient d'etre copier dans votre presse-papier !");
            System.out.println("// fin du programme");
            StringSelection stringSelection = new StringSelection(result);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }else{System.out.println("Le texte n'est pas copié, fin du programme");}
    }
}
