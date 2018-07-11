package fr.joeltroch.m2iformation.jeu.competences;

import fr.joeltroch.m2iformation.jeu.Main;
import fr.joeltroch.m2iformation.jeu.equipements.Equipement;
import fr.joeltroch.m2iformation.jeu.equipements.EquipementArme;
import fr.joeltroch.m2iformation.jeu.personnages.Personnage;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnageJoueur;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui représente la compétence "attaquer".
 * @author Joël Troch
 */
public class CompetenceAttaquer implements Competence {
	/** L'arme utilisée pendant l'attaque. */
	private EquipementArme arme;

	/**
	 * Crée une nouvelle compétence "attaquer" en spécifiant une arme (utilisée par les PNJ).
	 * @param arme L'arme à utiliser.
	 */
	public CompetenceAttaquer(EquipementArme arme) {
		this.arme = arme;
	}

	/** Crée une nouvelle compétence "attaquer" sans spécifier d'arme. */
	public CompetenceAttaquer() {
		this.arme = null;
	}

	public void utiliser(Personnage source, Personnage cible) {
		System.out.println("\"" + source.toString() + "\" attaque \"" + cible.toString() + "\" avec \"" + this.arme.toString() + "\"");

		this.arme.attaquer(source, cible);
		this.arme.appliquerBonus(source, cible);
	}

	@Override
	public boolean preparerCompetenceJoueur(PersonnageJoueur joueur, List<Personnage> personnages) {
		// Effectue une liste des armes utilisables
		List<EquipementArme> armesPossibles = new ArrayList<>();
		for (int i = 0; i < joueur.getListeEquipements().size(); i++) {
			Equipement equipementActuel = joueur.getListeEquipements().get(i);
			if (equipementActuel instanceof EquipementArme) {
				armesPossibles.add((EquipementArme)equipementActuel);
			}
		}

		// Aucune arme
		if (armesPossibles.size() <= 0) {
			System.out.println("Vous avez aucune arme !");
			return false;
		}

		// Liste les armes
		System.out.println("Quelle arme ?");
		for (int i = 0; i < armesPossibles.size(); i++) {
			EquipementArme armeActuelle = armesPossibles.get(i);
			System.out.println((i + 1) + ". " + armeActuelle.toString());
		}

		// Demande l'arme à attaquer
		int choix = Main.getScanner().nextInt();
		Main.getScanner().nextLine();

		// Choix invalide
		if (choix < 0 || choix > armesPossibles.size()) {
			System.out.println("Arme incorrecte !");
			return false;
		}
		this.arme = armesPossibles.get(choix - 1);

		// Liste les victimes
		System.out.println("Quelle victime ?");
		List<Personnage> victimesPossibles = Main.getListeCiblesPossibles(personnages);

		// Quelle victime ?
		choix = Main.getScanner().nextInt();
		Main.getScanner().nextLine();

		// Choix invalide
		if (choix < 0 || choix > victimesPossibles.size()) {
			System.out.println("Victime invalide !");
			return false;
		}

		// Attaque la victime
		Personnage victime = victimesPossibles.get(choix - 1);
		this.utiliser(joueur, victime);

		// Dans le cas où l'attaque tue la victime
		if (victime.getSante() <= 0) {
			System.out.println("\"" + victime.toString() + "\" est mort !");
		}

		return true;
	}

	@Override
	public String toString() {
		return "Attaquer";
	}
}
