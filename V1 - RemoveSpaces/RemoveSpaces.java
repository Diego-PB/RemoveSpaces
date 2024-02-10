import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.*;

public class RemoveSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Demande de saisie du code

        System.out.println("Saisir le code avec espace :");
        String codeAvecEspace = sc.nextLine();

        // Suppression des espaces
        String codeSansEspace = codeAvecEspace.replaceAll("\\s", "");

        // Affichage du code sans espace
        System.out.println("Code sans espace : " + codeSansEspace);

        // Demande de copie dans le presse-papier
        System.out.println("Copier le code sans espace dans le presse-papier (Y/N) ?");
        String reponse = sc.nextLine();

        // Passage de la reponse en majuscule
        reponse = reponse.toUpperCase();

        // Analyse de la reponse
        if (reponse.equals("Y")) {
            // Copie dans le presse-papier
            System.out.println("Code copié dans le presse-papier");

            // Copie dans le presse-papier
            java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(codeSansEspace), null);
        }

        // Fin du programme
        System.out.println("Fin du programme");

    }
}
