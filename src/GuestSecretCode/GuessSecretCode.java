package GuestSecretCode;

import java.util.Scanner;
import java.util.Random;

public class GuessSecretCode {

    public static void main(String[] args) {
	
	String ANSI_RESET = "\u001B[0m";
        // Codes de couleur pour les messages de jeu
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RED = "\u001B[31m";

        Scanner saisie = new Scanner(System.in);
        Random randomNumbers = new Random();

        boolean reset = true;  // Variable pour relancer le jeu

        while (reset) {  // Boucle principale du jeu

            // Choix de la difficulté par la taille de la combinaison
            System.out.println("Niveau de difficulté des combinaisons ");
            System.out.print("Rentrez un chiffre pour définir la taille de la combinaison à trouver : ");
            int CombinaisonTaille = saisie.nextInt();

            int[] combinaisonSecrete = new int[CombinaisonTaille];  // Tableau pour stocker la combinaison secrète

            // Génération de la combinaison secrète avec des chiffres entre 1 et 3
            for (int i = 0; i < combinaisonSecrete.length; i++) {
                combinaisonSecrete[i] = (1 + randomNumbers.nextInt(3));
                // Ligne de test pour afficher la combinaison générée
                // System.out.println(combinaisonSecrete[i]);
            }

            int[] combinaisonTest = new int[CombinaisonTaille];  // Tableau pour les essais du joueur
            int nbTours = 0;  // Compteur de tours
            boolean gagne = false;  // Indicateur de victoire

            // Boucle de jeu jusqu'à ce que la combinaison soit trouvée
            while (!gagne) {

                int chiffreOK = 0;  // Compteur des chiffres bien placés
                nbTours++;  // Incrément du nombre de tours

                // Demande au joueur d'entrer une proposition de combinaison
                System.out.println("Entrez votre proposition (chiffres entre 1 et 3) : ");
                for (int iTest = 0; iTest < combinaisonTest.length; iTest++) {
                    combinaisonTest[iTest] = saisie.nextInt();
                }

                // Comparaison de la proposition avec la combinaison secrète
                for (int i = 0; i < combinaisonSecrete.length; i++) {
                    if (combinaisonSecrete[i] == combinaisonTest[i]) {
                        chiffreOK++;  // Incrémente si le chiffre est bien placé
                    }
                }

                // Affiche le nombre de chiffres bien placés dans la tentative
                System.out.println(ANSI_RED + "Vous avez " + chiffreOK + " chiffres bien placés." + ANSI_RESET);
                System.out.println("");

                // Si tous les chiffres sont corrects, le joueur gagne
                if (chiffreOK == combinaisonSecrete.length) {
                    gagne = true;
                    System.out.println(ANSI_YELLOW + "Félicitations ! Vous avez gagné en " + nbTours + " tours." + ANSI_RESET);
                }
            }

            // Proposition de rejouer
            System.out.println("");
            System.out.println("Voulez-vous rejouer ? (Oui = 1 / Non = 2)");
            int tryAgain = saisie.nextInt();

            // Condition pour redémarrer le jeu selon le choix du joueur
            reset = (tryAgain == 1);
        }
    }
}
