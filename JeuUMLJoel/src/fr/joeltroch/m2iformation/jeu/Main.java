package fr.joeltroch.m2iformation.jeu;

import java.util.Scanner;

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
	 * Point d'entrée de l'application.
	 * @param args Arguments de la ligne de commande.
	 */
	public static void main(String[] args) {
		// TODO

		getScanner().close();
	}
}
