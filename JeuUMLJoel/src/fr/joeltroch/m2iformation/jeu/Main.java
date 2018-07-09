package fr.joeltroch.m2iformation.jeu;

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
