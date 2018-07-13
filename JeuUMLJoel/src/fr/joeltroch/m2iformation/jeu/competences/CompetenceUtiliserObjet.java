package fr.joeltroch.m2iformation.jeu.competences;

import fr.joeltroch.m2iformation.jeu.App;
import fr.joeltroch.m2iformation.jeu.equipements.Equipement;
import fr.joeltroch.m2iformation.jeu.equipements.EquipementObjet;
import fr.joeltroch.m2iformation.jeu.personnages.Personnage;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnageJoueur;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui représente la compétence "utiliserObjet objet".
 * @author Joël Troch
 */
public class CompetenceUtiliserObjet implements Competence {
	/** L'objet utilisé durant l'action. */
	private EquipementObjet objet;

	private void utiliser(Personnage source, Personnage cible) {
		this.objet.utiliser(source, cible);
	}

	@Override
	public boolean preparerCompetenceJoueur(PersonnageJoueur joueur, List<Personnage> personnages) {
		// Fais une liste des objets utilisables
		List<EquipementObjet> objetsPossibles = new ArrayList<>();
		for (int i = 0; i < joueur.getListeEquipements().size(); i++) {
			Equipement equipementActuel = joueur.getListeEquipements().get(i);
			if (equipementActuel instanceof EquipementObjet) {
				objetsPossibles.add((EquipementObjet)equipementActuel);
			}
		}

		// Pas d'objets à utiliserObjet
		if (objetsPossibles.size() <= 0) {
			System.out.println("Aucun objet !");
			return false;
		}

		// Affiche les objets
		System.out.println("Quel objet ?");
		for (int i = 0; i < objetsPossibles.size(); i++) {
			EquipementObjet objetActuel = objetsPossibles.get(i);
			System.out.println((i + 1) + ". " + objetActuel.toString());
		}

		// Demande l'objet
		int choix = App.getScanner().nextInt();
		App.getScanner().nextLine();

		// Choix invalide ou assigne l'objet à utiliserObjet
		if (choix <= 0 || choix > objetsPossibles.size()) {
			System.out.println("Objet invalide !");
			return false;
		}
		this.objet = objetsPossibles.get(choix - 1);

		// Liste les cibles potentielles
		System.out.println("Quelle cible ?");
		List<Personnage> ciblesPossibles = App.getListeCiblesPossibles(personnages);

		// Demande la cible
		choix = App.getScanner().nextInt();
		App.getScanner().nextLine();

		// Choix invalide
		if (choix < 0 || choix > ciblesPossibles.size()) {
			return false;
		}

		// Utilise l'objet et supprime le de l'inventaire
		Personnage victime = ciblesPossibles.get(choix - 1);
		this.utiliser(joueur, victime);
		joueur.getListeEquipements().remove(this.objet);

		// Dans le cas où cet objet tue la victime
		if (victime.getSante() <= 0) {
			System.out.println("\"" + victime.toString() + "\" est mort !");
		}

		return true;
	}

	@Override
	public String toString() {
		return "Utiliser objet";
	}
}
