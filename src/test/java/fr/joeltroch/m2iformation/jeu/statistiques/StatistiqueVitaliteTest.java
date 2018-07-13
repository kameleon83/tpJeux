package fr.joeltroch.m2iformation.jeu.statistiques;

import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueVitalite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test pour {@link StatistiqueVie}.
 * @author Joël Troch
 */
public class StatistiqueVitaliteTest {
	/** Caractéristique de vitalité pour le sujet de test. */
	private final CaracteristiqueVitalite vitalite = new CaracteristiqueVitalite(5);
	/** Sujet de test. */
	private final StatistiqueVie test = new StatistiqueVie(this.vitalite);

	/** Méthode de test pour {@link StatistiqueVie#getValeur()}. */
	@Test
	public void getValeurTest() {
		assertEquals(45, this.test.getValeur());
	}

	/** Méthode de test pour {@link StatistiqueVie#toString()}. */
	@Test
	public void toStringTest() {
		assertEquals("Vie", this.test.toString());
	}
}