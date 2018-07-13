package fr.joeltroch.m2iformation.jeu.caracteristiques;

import fr.joeltroch.m2iformation.jeu.Configuration;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test pour {@link CaracteristiqueMemoire}.
 * @author Joël Troch
 */
public class CaracteristiqueMemoireTest {
	/** Sujet de test. */
	private final CaracteristiqueMemoire test = new CaracteristiqueMemoire(5);

	/** Méthode de test pour {@link CaracteristiqueMemoire#getNomCourt()}. */
	@Test
	public void getNomCourtTest() {
		assertEquals("MEM", this.test.getNomCourt());
	}

	/** Méthode de test pour {@link CaracteristiqueMemoire#addNiveau(int)}. */
	@Test
	public void addNiveauTest() {
		this.test.addNiveau(4);
		assertEquals(9, this.test.getNiveau());
		this.test.addNiveau(Configuration.CARACTERISTIQUE_NIVEAU_MAX);
		assertEquals(Configuration.CARACTERISTIQUE_NIVEAU_MAX, this.test.getNiveau());
	}

	/** Méthode de test pour {@link CaracteristiqueMemoire#getNiveau()}. */
	@Test
	public void getNiveauTest() {
		assertEquals(5, this.test.getNiveau());
	}

	/** Méthode de test pour {@link CaracteristiqueMemoire#toString()}. */
	@Test
	public void toStringTest() {
		assertEquals("Mémoire", this.test.toString());
	}
}