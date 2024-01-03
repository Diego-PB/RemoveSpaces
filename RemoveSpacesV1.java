/**
 * Retire tout espace d'un texte donné.
 * possibilité de copier rapidement le resultat dans le presse-papier
 *
 * @author https://github.com/Diego-PB
 * 
 * version : 1
 * Retire TOUT les espaces
 */
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class RemoveSpacesV1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un texte: ");
        String input = scanner.nextLine();
        String result = input.replaceAll("\\s", "");

        System.out.println("Texte sans espaces: ");
        System.out.println(result);

        // Copier le texte dans le presse-papiers
        System.out.println("Copier le texte dans votre presse-papier ? (oui/non)");
        String copier = scanner.nextLine();

        if(copier.equals("oui")){
            System.out.println("//");
            System.out.println("Le texte sans espace, vient d'etre copier dans votre presse-papier !");
            System.out.println("//");
            StringSelection stringSelection = new StringSelection(result);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }else{System.out.println("Le texte n'est pas copié, fin du programme");}
    }
}
