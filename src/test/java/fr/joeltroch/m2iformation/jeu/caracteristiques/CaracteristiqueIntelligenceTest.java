package fr.joeltroch.m2iformation.jeu.caracteristiques;

import fr.joeltroch.m2iformation.jeu.Configuration;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test pour {@link CaracteristiqueIntelligence}.
 * @author Joël Troch
 */
public class CaracteristiqueIntelligenceTest {
	/** Sujet de test. */
	private final CaracteristiqueIntelligence test = new CaracteristiqueIntelligence(3);

	/** Méthode de test pour {@link CaracteristiqueIntelligence#getNomCourt()}. */
	@Test
	public void getNomCourtTest() {
		assertEquals("INT", this.test.getNomCourt());
	}

	/** Méthode de test pour {@link CaracteristiqueIntelligence#addNiveau(int)}. */
	@Test
	public void addNiveauTest() {
		this.test.addNiveau(3);
		assertEquals(6, this.test.getNiveau());
		this.test.addNiveau(Configuration.CARACTERISTIQUE_NIVEAU_MAX);
		assertEquals(Configuration.CARACTERISTIQUE_NIVEAU_MAX, this.test.getNiveau());
	}

	/** Méthode de test pour {@link CaracteristiqueIntelligence#getNiveau()}. */
	@Test
	public void getNiveauTest() {
		assertEquals(3, this.test.getNiveau());
	}

	/** Méthode de test pour {@link CaracteristiqueIntelligence#toString()}. */
	@Test
	public void toStringTest() {
		assertEquals("Intelligence", this.test.toString());
	}
}