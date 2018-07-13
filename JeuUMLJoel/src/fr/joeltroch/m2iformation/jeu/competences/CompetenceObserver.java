package fr.joeltroch.m2iformation.jeu.competences;

import fr.joeltroch.m2iformation.jeu.App;
import fr.joeltroch.m2iformation.jeu.caracteristiques.Caracteristique;
import fr.joeltroch.m2iformation.jeu.personnages.Personnage;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnageJoueur;
import fr.joeltroch.m2iformation.jeu.statistiques.Statistique;

import java.util.List;

/**
 * Classe qui représente la compétence "Observer".
 * @author Joël Troch
 */
public class CompetenceObserver implements Competence {
	private void utiliser(Personnage source, Personnage cible) {
		System.out.println("\"" + source.toString() + "\" observe \"" + cible.toString() + "\"");

		System.out.println("\nCaractéristiques :");
		for (Caracteristique caracteristique : cible.getListeCaracteristiques()) {
			System.out.println(caracteristique.toString() + " - " + caracteristique.getNiveau());
		}

		System.out.println("\nStatistiques :");
		for (Statistique statistique : cible.getListeStatistiques()) {
			System.out.println(statistique.toString() + " - " + statistique.getValeur());
		}

		System.out.println("\nPoints de vie : " +  cible.getSante() + " HP.");
	}

	@Override
	public boolean preparerCompetenceJoueur(PersonnageJoueur joueur, List<Personnage> personnages) {
		// Liste les cibles potentielles
		System.out.println("Quelle cible ?");
		List<Personnage> ciblesPossibles = App.getListeCiblesPossibles(personnages);

		// Demande la cible
		int choix = App.getScanner().nextInt();
		App.getScanner().nextLine();

		// Choix invalide
		if (choix < 0 || choix > ciblesPossibles.size()) {
			System.out.println("Cible invalide !");
			return false;
		}

		// Observe la cible
		this.utiliser(joueur, ciblesPossibles.get(choix - 1));
		return true;
	}

	@Override
	public String toString() {
		return "Observer";
	}
}
