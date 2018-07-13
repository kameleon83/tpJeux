package fr.joeltroch.m2iformation.jeu.lieux;

import fr.joeltroch.m2iformation.jeu.personnages.Personnage;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnageJoueur;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnagePNJEnnemiZombie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Classe de test pour {@link LieuArene}.
 * @author Joël Troch
 */
public class LieuAreneTest {
	/** Sujet de test. */
	private final LieuArene test = new LieuArene("Arène de la Badassitude");

	/** Méthode de test pour {@link LieuArene#finDePartie(List)}. */
	@Test
	public void finDePartieTest() {
		PersonnageJoueur joueur = new PersonnageJoueur("Testeur");
		joueur.setSante(100);
		PersonnagePNJEnnemiZombie zombie = new PersonnagePNJEnnemiZombie(false);
		zombie.setSante(100);

		List<Personnage> liste = new ArrayList<>();
		liste.add(joueur);
		liste.add(zombie);

		assertFalse(this.test.finDePartie(liste));
		joueur.setSante(0);
		assertTrue(this.test.finDePartie(liste));
		zombie.setSante(0);
		assertTrue(this.test.finDePartie(liste));
		joueur.setSante(100);
		assertTrue(this.test.finDePartie(liste));
		zombie.setSante(100);
		assertFalse(this.test.finDePartie(liste));
	}

	@Test
	public void parcourirTest() {
	}

	@Test
	public void toStringTest() {
		assertEquals("Arène de la Badassitude", this.test.toString());
	}
}