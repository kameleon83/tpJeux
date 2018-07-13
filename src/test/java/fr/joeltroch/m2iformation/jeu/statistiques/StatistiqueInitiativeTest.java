package fr.joeltroch.m2iformation.jeu.statistiques;

import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueForce;
import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueIntelligence;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test pour {@link StatistiqueInitiative}.
 * @author Joël Troch
 */
public class StatistiqueInitiativeTest {
	/** Caractéristique de force pour le sujet de test. */
	private final CaracteristiqueForce force = new CaracteristiqueForce(5);
	/** Caractéristique d'intelligence pour le sujet de test. */
	private final CaracteristiqueIntelligence intelligence = new CaracteristiqueIntelligence(7);
	/** Sujet de test. */
	private final StatistiqueInitiative test = new StatistiqueInitiative(this.force, this.intelligence);

	/** Méthode de test pour {@link StatistiqueInitiative#getValeur()}. */
	@Test
	public void getValeurTest() {
		assertEquals(6, this.test.getValeur());
	}

	/** Méthode de test pour {@link StatistiqueInitiative#toString()}. */
	@Test
	public void toStringTest() {
		assertEquals("Initiative", this.test.toString());
	}
}