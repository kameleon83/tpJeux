package fr.joeltroch.m2iformation.jeu.statistiques;

import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueForce;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test pour {@link StatistiqueDegatsPhysique}.
 * @author Joël Troch
 */
public class StatistiqueDegatsPhysiqueTest {
	/** Caractéristique de force pour le sujet de test. */
	private final CaracteristiqueForce force = new CaracteristiqueForce(2);
	/** Sujet de test. */
	private final StatistiqueDegatsPhysique test = new StatistiqueDegatsPhysique(47, this.force);

	/** Méthode de test pour {@link StatistiqueDegatsPhysique#getValeur()}. */
	@Test
	public void getValeurTest() {
		assertEquals(47, this.test.getValeur());
	}

	/** Méthode de test pour {@link StatistiqueDegatsPhysique#toString()}. */
	@Test
	public void toStringTest() {
		assertEquals("Dégâts physique", this.test.toString());
	}
}