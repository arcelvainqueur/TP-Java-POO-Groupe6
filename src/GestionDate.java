// Fichier: GestionDate.java (Partie 2/8)
// Étudiant: KATANDA KAYUMBA DANIEL
// Tâche: Gestion de la saisie et formatage de la date

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GestionDate {
   
    public static String obtenirDatePourAffichage() {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Entrez la date (format AAAA-MM-JJ) ou appuyez sur Entrée pour aujourd'hui: ");
        String dateSaisie = scanner.nextLine().trim();
       
        // Si l'utilisateur n'entre rien, prendre la date du jour
        String dateAfficher;
        if (dateSaisie.isEmpty()) {
            LocalDate aujourdhui = LocalDate.now();
            DateTimeFormatter formateur = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            dateAfficher = aujourdhui.format(formateur);
            System.out.println("Date utilisée : " + dateAfficher);
        } else {
            dateAfficher = dateSaisie;
        }
       
        return dateAfficher;
    }
   
    public static String obtenirDateDuJour() {
        LocalDate aujourdhui = LocalDate.now();
        DateTimeFormatter formateur = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return aujourdhui.format(formateur);
    }
}
