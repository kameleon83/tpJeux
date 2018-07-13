package fr.joeltroch.m2iformation.jeu.competences;

import fr.joeltroch.m2iformation.jeu.caracteristiques.Caracteristique;
import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueForce;
import fr.joeltroch.m2iformation.jeu.equipements.EquipementArmeEpee;
import fr.joeltroch.m2iformation.jeu.personnages.Personnage;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnageJoueur;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnagePNJEnnemiZombie;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe de test pour {@link CompetenceAttaquer}.
 * @author Joël Troch
 */
public class CompetenceAttaquerTest {
	/** Arme de test utilisée par l'attaquant. */
	private final EquipementArmeEpee equipementArmeEpee = new EquipementArmeEpee();
	/** Attaquant de test. */
	private final PersonnageJoueur personnageJoueur = new PersonnageJoueur("Testeur");
	/** Victime de test. */
	private final PersonnagePNJEnnemiZombie personnagePNJEnnemiZombie = new PersonnagePNJEnnemiZombie(false);
	/** Sujet de test. */
	private final CompetenceAttaquer test = new CompetenceAttaquer(this.equipementArmeEpee);

	/** Méthode de test pour {@link CompetenceAttaquer#utiliser(Personnage, Personnage)}. */
	@Test
	public void utiliserTest() {
		for (Caracteristique caracteristique : this.personnageJoueur.getListeCaracteristiques()) {
			if (caracteristique instanceof CaracteristiqueForce) {
				caracteristique.addNiveau(1);
				break;
			}
		}

		this.test.utiliser(this.personnageJoueur, this.personnagePNJEnnemiZombie);
		assertTrue(this.personnagePNJEnnemiZombie.getSante() >= 18 && this.personnagePNJEnnemiZombie.getSante() <= 23);
	}

	/** Méthode de test pour {@link CompetenceAttaquer#toString()}. */
	@Test
	public void toStringTest() {
		assertEquals("Attaquer", this.test.toString());
	}
}