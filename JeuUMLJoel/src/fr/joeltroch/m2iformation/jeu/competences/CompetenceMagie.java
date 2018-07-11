package fr.joeltroch.m2iformation.jeu.competences;

import fr.joeltroch.m2iformation.jeu.Main;
import fr.joeltroch.m2iformation.jeu.magie.MagieSort;
import fr.joeltroch.m2iformation.jeu.personnages.Personnage;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnageJoueur;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui représente la compétence "utiliser magie".
 * @author Joël Troch
 */
public class CompetenceMagie implements Competence {
	/** Le sort utilisé. */
	private MagieSort sort;

	private void utiliser(Personnage source, Personnage cible) {
		if (source == cible) {
			System.out.println("\"" + source.toString() + "\" utilise le sort \"" + this.sort.toString() + "\" sur lui(elle)-même.");
		} else {
			System.out.println("\"" + source.toString() + "\" utilise le sort \"" + this.sort.toString() + "\" sur \"" + cible.toString() + "\"." );
		}

		this.sort.utiliser(source, cible);
	}

	@Override
	public boolean preparerCompetenceJoueur(PersonnageJoueur joueur, List<Personnage> personnages) {
		// Liste les sorts utilisables
		List<MagieSort> sortsPossibles = new ArrayList<>();
		for (int i = 0; i < joueur.getListeSorts().size(); i++) {
			MagieSort sortActuel = joueur.getListeSorts().get(i);
			if (joueur.getMana() >= sortActuel.getManaRequise()) {
				sortsPossibles.add(sortActuel);
			}
		}

		// Pas de sorts utilisables
		if (sortsPossibles.size() <= 0) {
			System.out.println("Vous avez aucun sort utilisable !");
			return false;
		}

		// Liste les sorts utilisables
		System.out.println("Quelle sort ?");
		for (int i = 0; i < sortsPossibles.size(); i++) {
			MagieSort sortActuel = sortsPossibles.get(i);
			System.out.println((i + 1) + ". " + sortActuel.toString() + " (-" + sortActuel.getManaRequise() + " MP)");
		}

		// Demande le sort à utiliser
		int choix = Main.getScanner().nextInt();
		Main.getScanner().nextLine();

		// Choix invalide ou assigne le sort à utiliser
		if (choix < 0 || choix > sortsPossibles.size()) {
			System.out.println("Sort incorrect !");
			return false;
		}
		this.sort = sortsPossibles.get(choix - 1);

		// Liste les cibles
		System.out.println("Quelle cible ?");
		List<Personnage> ciblesPossibles = Main.getListeCiblesPossibles(personnages);

		// Demande la cible
		choix = Main.getScanner().nextInt();
		Main.getScanner().nextLine();

		// Choix invalide
		if (choix < 0 || choix > ciblesPossibles.size()) {
			System.out.println("Cible invalide !");
			return false;
		}

		// Utilise le sort sur la cible
		Personnage cible = ciblesPossibles.get(choix - 1);
		this.utiliser(joueur, cible);
		joueur.setMana(joueur.getMana() - this.sort.getManaRequise());

		// Dans le cas où le sort tue la cible
		if (cible.getSante() <= 0) {
			System.out.println("\"" + cible.toString() + "\" est mort !");
		}

		return true;
	}

	@Override
	public String toString() {
		return "Magie";
	}
}
