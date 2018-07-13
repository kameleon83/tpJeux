package fr.joeltroch.m2iformation.jeu.personnages;

import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueVitalite;
import fr.joeltroch.m2iformation.jeu.competences.CompetenceAttaquer;
import fr.joeltroch.m2iformation.jeu.equipements.EquipementArmeFeuFolletBouleDeFeu;
import fr.joeltroch.m2iformation.jeu.magie.MagieElements;
import fr.joeltroch.m2iformation.jeu.statistiques.StatistiqueVie;

import java.util.List;

/**
 * Classe qui représente un feu follet.
 * @author Joël Troch
 */
public class PersonnagePNJEnnemiFeuFollet extends PersonnagePNJEnnemi {
	public PersonnagePNJEnnemiFeuFollet(boolean estBoss) {
		super("Feu follet", estBoss, MagieElements.FEU);

		CaracteristiqueVitalite caracteristiqueVitalite = new CaracteristiqueVitalite(2);
		StatistiqueVie statistiqueVie = new StatistiqueVie(caracteristiqueVitalite);

		this.listeCaracteristiques.add(caracteristiqueVitalite);
		this.listeStatistiques.add(statistiqueVie);

		this.setSante(statistiqueVie.getValeur());
	}

	@Override
	public void effectuerAction(List<Personnage> personnages) {
		int index = 0;
		for (int i = 0; i < personnages.size(); i++) {
			if (personnages.get(i) instanceof PersonnageJoueur) {
				index = i;
				break;
			}
		}
		Personnage joueur = personnages.get(index);

		CompetenceAttaquer attaque = new CompetenceAttaquer(new EquipementArmeFeuFolletBouleDeFeu());
		attaque.utiliser(this, joueur);
	}
}
