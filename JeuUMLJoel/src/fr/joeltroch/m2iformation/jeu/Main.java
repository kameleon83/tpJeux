package fr.joeltroch.m2iformation.jeu;

import fr.joeltroch.m2iformation.jeu.caracteristiques.Caracteristique;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnageJoueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe principale de l'application.
 * @author Joël Troch
 */
public class Main {
	/** Unique instance de la classe Scanner pour toute l'application (singleton). */
	private static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * Retoune la seule instance de la classe Scanner (singleton).
	 * @return L'unique instance de Scanner utilisée dans toute le programme.
	 */
	public static Scanner getScanner() {
		return SCANNER;
	}

	/**
	 * Permet au joueur de dépenser ses points de compétences.
	 * @param pointsADepenser Le nombre de points de compétences à dépenser.
	 * @param joueur Le joueur concerné.
	 */
	public static void depenserPointsCompetences(int pointsADepenser, PersonnageJoueur joueur) {
		// Prépare une liste d'incréments
		List<Integer> resultat = new ArrayList<>();
		for (int i = 0; i < joueur.getListeCaracteristiques().size(); i++) {
			resultat.add(0);
		}

		// Tant qu'on a des points à dépenser
		while (pointsADepenser > 0) {
			System.out.println("Vous pouvez dépenser " + pointsADepenser + " points de compétences.\n");

			// Affiche les caractéristiques
			for (int i = 0; i < joueur.getListeCaracteristiques().size(); i++) {
				Caracteristique caracteristique = joueur.getListeCaracteristiques().get(i);

				System.out.println((i + 1) + ". " + caracteristique.toString() + " (" + caracteristique.getNomCourt() + ") - "
						+ (caracteristique.getNiveau() + resultat.get(i)) + "/"
						+ Configuration.CARACTERISTIQUE_NIVEAU_MAX);
			}

			// Demande de faire un choix
			System.out.println("\nChoix ?");
			int choix = getScanner().nextInt();
			getScanner().nextLine();

			// Le choix est valide
			if (choix > 0 && choix <= joueur.getListeCaracteristiques().size()) {
				// Vérifie qu'on ne dépasse pas le niveau maximum
				Caracteristique caracteristique = joueur.getListeCaracteristiques().get(choix - 1);
				final int niveauTest = caracteristique.getNiveau() + resultat.get(choix - 1) + 1;

				if (niveauTest <= Configuration.CARACTERISTIQUE_NIVEAU_MAX) {
					resultat.set(choix - 1, resultat.get(choix - 1) + 1);
					pointsADepenser--;
				} else {
					System.out.println("Niveau maximal atteint !");
				}
			} else {
				System.out.println("Choix invalide !");
			}
		}

		// Ajoute les points
		for (int i = 0; i < joueur.getListeCaracteristiques().size(); i++) {
			joueur.getListeCaracteristiques().get(i).addNiveau(resultat.get(i));
		}
	}

	/**
	 * Génère un nombre aléatoire entre un minimum et un maximum spécifique.
	 * @param min Le nombre minimum.
	 * @param max Le nombre maximum.
	 * @return Le nombre aléatoire généré.
	 */
	public static int genererNombreAleatoire(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	/**
	 * Point d'entrée de l'application.
	 * @param args Arguments de la ligne de commande.
	 */
	public static void main(String[] args) {
		// TODO

		getScanner().close();
	}
}
