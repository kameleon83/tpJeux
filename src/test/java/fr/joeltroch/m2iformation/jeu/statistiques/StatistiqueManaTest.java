package fr.joeltroch.m2iformation.jeu.statistiques;

import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueMemoire;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test pour {@link StatistiqueMana}.
 * @author Joël Troch
 */
public class StatistiqueManaTest {
	/** Caractéristique de mémoire pour le sujet de test. */
	private final CaracteristiqueMemoire memoire = new CaracteristiqueMemoire(6);
	/** Sujet de test. */
	private final StatistiqueMana test = new StatistiqueMana(this.memoire);

	/** Méthode de test pour {@link StatistiqueMana#getValeur()}. */
	@Test
	public void getValeurTest() {
		assertEquals(18, this.test.getValeur());
	}

	/** Méthode de test pour {@link StatistiqueMana#toString()}. */
	@Test
	public void toStringTest() {
		assertEquals("Mana", this.test.toString());
	}
}