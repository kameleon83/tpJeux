package fr.joeltroch.m2iformation.jeu.caracteristiques;

import fr.joeltroch.m2iformation.jeu.Configuration;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test pour {@link CaracteristiqueVitalite}.
 * @author Joël Troch
 */
public class CaracteristiqueVitaliteTest {
	/** Sujet de test. */
	private final CaracteristiqueVitalite test = new CaracteristiqueVitalite(10);

	/** Méthode de test pour {@link CaracteristiqueVitalite#getNomCourt()}. */
	@Test
	public void getNomCourtTest() {
		assertEquals("VIT", this.test.getNomCourt());
	}

	/** Méthode de test pour {@link CaracteristiqueVitalite#addNiveau(int)}. */
	@Test
	public void addNiveauTest() {
		this.test.addNiveau(10);
		assertEquals(Configuration.CARACTERISTIQUE_NIVEAU_MAX, this.test.getNiveau());
		this.test.addNiveau(Configuration.CARACTERISTIQUE_NIVEAU_MAX);
		assertEquals(Configuration.CARACTERISTIQUE_NIVEAU_MAX, this.test.getNiveau());
	}

	/** Méthode de test pour {@link CaracteristiqueVitalite#getNiveau()}. */
	@Test
	public void getNiveauTest() {
		assertEquals(10, this.test.getNiveau());
	}

	/** Méthode de test pour {@link CaracteristiqueVitalite#toString()}. */
	@Test
	public void toStringTest() {
		assertEquals("Vitalité", this.test.toString());
	}
}