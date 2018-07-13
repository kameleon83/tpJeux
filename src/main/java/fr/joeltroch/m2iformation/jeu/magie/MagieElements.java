package fr.joeltroch.m2iformation.jeu.magie;

/**
 * Enumération des élément pour les sorts de magie.
 * @author Joël Troch
 */
public enum MagieElements {
	EAU,
	FOUDRE,
	FEU,
	GLACE;

	/**
	 * Retourne si cet élément est "faible" par rapport à un autre. Si c'est le cas, les dégâts sont multipliés.
	 * @param element L'autre élément à comparer.
	 * @return Vrai si l'élement actuel est faible contre l'élément à spécifier.
	 */
	public boolean estFaibleContre(MagieElements element) {
		// Eau VS Foudre
		if (this.equals(EAU) && element.equals(FOUDRE)) {
			return true;
		}

		if (this.equals(FOUDRE) && element.equals(EAU)) {
			return true;
		}

		// Feu VS Glace
		if (this.equals(FEU) && element.equals(GLACE)) {
			return true;
		}

		return this.equals(GLACE) && element.equals(FEU);
	}
}
