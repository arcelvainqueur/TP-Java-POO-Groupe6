package net.john mbaya;

// Fichier: Étudiant 6 - Calcul totaux: 6/8
// Étudiant: [MBAYA MUTOMBO JOHN]

$codeJava = @'
public class CalculTotaux {
    public static void main(String[] args) {
        // ==== CODE DE L'ÉTUDIANT 6 ====
        // Calcul des totaux et taux de production

        System.out.println("=== CALCUL DES TOTAUX ET TAUX ===");

        // Exemple de données (à remplacer par tes vraies données)
        int qtyOK = 150;
        int qtyKO = 10;
        int total = qtyOK + qtyKO;

        // Calcul du taux de défaut
        double tauxDefaut = 0;
        if (total > 0) {
            tauxDefaut = (qtyKO * 100.0) / total;
        }

        // Affichage des résultats
        System.out.println("Quantité OK: " + qtyOK);
        System.out.println("Quantité KO: " + qtyKO);
        System.out.println("Total produit: " + total);
        System.out.println("Taux de défaut: " + String.format("%.2f", tauxDefaut) + "%");

        // Alerte si taux > 5%
        if (tauxDefaut > 5.0) {
            System.out.println("⚠️  ALERTE: Taux de défaut supérieur à 5% !");
        }

        System.out.println("==================================");
    }
}
'@

        # Écrire dans le fichier
$codeJava | Out-File -FilePath "src\CalculTotaux.java" -Encoding UTF8

# Vérifier
Write-Host "✅ Fichier créé avec succès !" -ForegroundColor Green
Write-Host "Contenu du fichier :" -ForegroundColor Yellow
Get-Content src\CalculTotaux.java | Select-Object -First 10
