package fr.joeltroch.m2iformation.jeu.caracteristiques;

import fr.joeltroch.m2iformation.jeu.Configuration;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe de test pour {@link CaracteristiqueForce}.
 * @author Joël Troch
 */
public class CaracteristiqueForceTest {
	/** Sujet de test. */
	private final CaracteristiqueForce test = new CaracteristiqueForce(1);

	/** Méthode de test pour {@link CaracteristiqueForce#getNomCourt()}. */
	@Test
	public void getNomCourtTest() {
		assertEquals("FOR", this.test.getNomCourt());
	}

	/** Méthode de test pour {@link CaracteristiqueForce#addNiveau(int)}. */
	@Test
	public void addNiveauTest() {
		this.test.addNiveau(1);
		assertEquals(2, this.test.getNiveau());
		this.test.addNiveau(Configuration.CARACTERISTIQUE_NIVEAU_MAX);
		assertEquals(Configuration.CARACTERISTIQUE_NIVEAU_MAX, this.test.getNiveau());
	}

	/** Méthode de test pour {@link CaracteristiqueForce#getNiveau()}. */
	@Test
	public void getNiveauTest() {
		assertEquals(1, this.test.getNiveau());
	}

	/** Méthode de test pour {@link CaracteristiqueForce#toString()}. */
	@Test
	public void toStringTest() {
		assertEquals("Force", this.test.toString());
	}
}