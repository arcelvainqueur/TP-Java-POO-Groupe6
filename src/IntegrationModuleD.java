package net.jonathan;


// Fichier: IntegrationModuleD.java (Partie 8/8)
// Étudiant: [MUTALE KATONGA JONATHAN]


import java.util.Scanner;

public class IntegrationModuleD {

    // Méthode principale qui intègre tous les modules
    public static void executerModuleAffichage() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== AFFICHAGE DE LA PRODUCTION ===");
        System.out.println("Module développé par l'Équipe ");

        // 1. Vérifier si le fichier existe
        boolean fichierExiste = LectureFichierProduction.verifierFichierExiste();

        if (!fichierExiste) {
            System.out.println("\nATTENTION : Le fichier de production n'existe pas.");
            System.out.println("Veuillez d'abord enregistrer des productions.");
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            scanner.nextLine();
            return;
        }

        // 2. Obtenir la date
        System.out.println("\n--- Sélection de la date ---");
        String date = GestionDate.obtenirDatePourAffichage();

        // 3. Afficher les productions pour cette date
        System.out.println("\n--- Productions du " + date + " ---");
        boolean productionTrouvee = FiltrageProduction.afficherProductionPourDate(date);

        // 4. Si des productions existent, afficher la synthèse
        if (productionTrouvee) {
            AffichageSynthèse.afficherSynthèsePourDate(date);
        } else {
            System.out.println("\nAppuyez sur Entrée pour continuer...");
            scanner.nextLine();
        }
    }

    // Méthode pour obtenir les totaux (utilisée par d'autres modules)
    public static String obtenirTotauxTexte(String date) {
        int[] totaux = CalculTotaux.calculerTotauxPourDate(date);
        int totalOK = totaux[0];
        int totalKO = totaux[1];
        int nombreProductions = totaux[2];

        int totalPieces = totalOK + totalKO;
        double tauxDefaut = CalculTotaux.calculerTauxDefaut(totalOK, totalKO);

        String texte = "RÉSUMÉ PRODUCTION " + date + ":\n";
        texte += "• Enregistrements: " + nombreProductions + "\n";
        texte += "• Pièces OK: " + totalOK + "\n";
        texte += "• Pièces KO: " + totalKO + "\n";
        texte += "• Total: " + totalPieces + "\n";
        texte += String.format("• Taux défaut: %.2f%%", tauxDefaut);

        if (tauxDefaut > 5.0) {
            texte += String.format(" (ALERTE >5%%)", tauxDefaut);
        }

        return texte;
    }
}
