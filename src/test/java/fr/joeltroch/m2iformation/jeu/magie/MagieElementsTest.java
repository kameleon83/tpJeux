package fr.joeltroch.m2iformation.jeu.magie;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe de test pour {@link MagieElements}.
 * @author Joël Troch
 */
public class MagieElementsTest {
	/** Méthode de test pour {@link MagieElements#estFaibleContre(MagieElements)}. */
	@Test
	public void estFaibleContre() {
		assertFalse(MagieElements.EAU.estFaibleContre(MagieElements.EAU));
		assertTrue(MagieElements.EAU.estFaibleContre(MagieElements.FOUDRE));
		assertFalse(MagieElements.EAU.estFaibleContre(MagieElements.FEU));
		assertFalse(MagieElements.EAU.estFaibleContre(MagieElements.GLACE));

		assertTrue(MagieElements.FOUDRE.estFaibleContre(MagieElements.EAU));
		assertFalse(MagieElements.FOUDRE.estFaibleContre(MagieElements.FOUDRE));
		assertFalse(MagieElements.FOUDRE.estFaibleContre(MagieElements.FEU));
		assertFalse(MagieElements.FOUDRE.estFaibleContre(MagieElements.GLACE));

		assertFalse(MagieElements.FEU.estFaibleContre(MagieElements.EAU));
		assertFalse(MagieElements.FEU.estFaibleContre(MagieElements.FOUDRE));
		assertFalse(MagieElements.FEU.estFaibleContre(MagieElements.FEU));
		assertTrue(MagieElements.FEU.estFaibleContre(MagieElements.GLACE));

		assertFalse(MagieElements.GLACE.estFaibleContre(MagieElements.EAU));
		assertFalse(MagieElements.GLACE.estFaibleContre(MagieElements.FOUDRE));
		assertTrue(MagieElements.GLACE.estFaibleContre(MagieElements.FEU));
		assertFalse(MagieElements.GLACE.estFaibleContre(MagieElements.GLACE));
	}
}