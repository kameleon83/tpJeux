package fr.joeltroch.m2iformation.jeu.competences;

import fr.joeltroch.m2iformation.jeu.personnages.Personnage;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnageJoueur;

import java.util.List;

/**
 * Interface pour les compétences.
 * @author Joël Troch
 */
public interface Competence {
	/**
	 * Prépare cette compétence pour un personnage joueur.
	 * @param joueur Le joueur en question.
	 * @param personnages La liste des personnages dans le lieu (cibles/victimes/joueurs).
	 * @return <code>true</code> si le joueur a bien spécifié ce qu'il voulait et/ou cette compétence peut être utilisée.
	 * <code>false</code> dans le cas contraire.
	 */
	boolean preparerCompetenceJoueur(PersonnageJoueur joueur, List<Personnage> personnages);

	@Override
	String toString();

	// Salut tout le monde ^^
	// Salut tout le monde ^^
	// Salut tout le monde ^^
	// Salut tout le monde ^^
	// Salut tout le monde ^^
	// Salut tout le monde ^^
	// Salut tout le monde ^^
}
