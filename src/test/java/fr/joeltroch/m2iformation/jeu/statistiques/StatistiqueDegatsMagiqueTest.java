package fr.joeltroch.m2iformation.jeu.statistiques;

import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueForce;
import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueIntelligence;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe de test pour {@link StatistiqueDegatsMagique}.
 * @author Joël Troch
 */
public class StatistiqueDegatsMagiqueTest {
	/** Caractéristique d'intelligence pour le sujet de test. */
	private final CaracteristiqueIntelligence intelligence = new CaracteristiqueIntelligence(4);
	/** Sujet de test. */
	private final StatistiqueDegatsMagique test = new StatistiqueDegatsMagique(100, this.intelligence);

	/** Méthode de test pour {@link StatistiqueDegatsMagique#getValeur()}. */
	@Test
	public void getValeurTest() {
		assertEquals(200, this.test.getValeur());
	}

	/** Méthode de test pour {@link StatistiqueDegatsMagique#toString()}. */
	@Test
	public void toStringTest() {
		assertEquals("Dégâts magique", this.test.toString());
	}
}