package fr.joeltroch.m2iformation.jeu.personnages;

import fr.joeltroch.m2iformation.jeu.caracteristiques.Caracteristique;
import fr.joeltroch.m2iformation.jeu.competences.Competence;
import fr.joeltroch.m2iformation.jeu.magie.MagieSort;
import fr.joeltroch.m2iformation.jeu.statistiques.Statistique;
import fr.joeltroch.m2iformation.jeu.statistiques.StatistiqueMana;
import fr.joeltroch.m2iformation.jeu.statistiques.StatistiqueVie;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de base pour tous les personnages.
 * @author Joël Troch
 */
public abstract class Personnage {
	/** Liste des caractéristiques du personnage. */
	final List<Caracteristique> listeCaracteristiques = new ArrayList<>();
	/** Liste des compétences du personnage. */
	final List<Competence> listeCompetences = new ArrayList<>();
	/** Liste des sorts du personnage. */
	final List<MagieSort> listeSorts = new ArrayList<>();
	/** Liste des statistiques du personnage. */
	final List<Statistique> listeStatistiques = new ArrayList<>();
	/** Nom du personnage. */
	final String nom;

	/** Santé actuelle du personnage. */
	private int sante;
	/** Mana actuelle du personnage. */
	private int mana;
	/** Niveau actuel du personnage. */
	int niveau;

	/**
	 * Crée un nouveau personnage avec un nom spécifique.
	 * @param nom Le nom du personnage.
	 */
	Personnage(String nom) {
		this.nom = nom;
	}

	public List<Caracteristique> getListeCaracteristiques() {
		return this.listeCaracteristiques;
	}

	public List<MagieSort> getListeSorts() {
		return this.listeSorts;
	}

	public List<Statistique> getListeStatistiques() {
		return this.listeStatistiques;
	}

	public int getSante() {
		return this.sante;
	}

	public int getMana() {
		return this.mana;
	}

	/**
	 * Retourne la santé max. en se basant sur la statistique de vie.
	 * @return La santé max selon la statistique de vie.
	 */
	public int getSanteMax() {
		for (Statistique statistique : this.listeStatistiques) {
			if (statistique instanceof StatistiqueVie) {
				return statistique.getValeur();
			}
		}

		return 0;
	}

	/**
	 * Retourne la mana max. en se basant sur la statistique de mana.
	 * @return La mana max selon la statistique de mémoire.
	 */
	public int getManaMax() {
		for (Statistique statistique : this.listeStatistiques) {
			if (statistique instanceof StatistiqueMana) {
				return statistique.getValeur();
			}
		}

		return 0;
	}

	/**
	 * Définit la santé du personnage. Il n'y a pas de santé négative et ne dépasse pas la santé max.
	 * @param sante La nouvelle quantité de santé à définir.
	 */
	public void setSante(int sante) {
		final int santeMax = getSanteMax();
		if (sante > santeMax) {
			this.sante = santeMax;
		} else if (sante < 0) {
			this.sante = 0;
		} else {
			this.sante = sante;
		}
	}

	/**
	 * Définit la mana du personnage. Il n'y a pas de mana négative et ne dépasse pas la mana max.
	 * @param mana La nouvelle quantité de santé à définir.
	 */
	public void setMana(int mana) {
		final int manaMax = getSanteMax();
		if (mana > manaMax) {
			this.mana = manaMax;
		} else if (mana < 0) {
			this.mana = 0;
		} else {
			this.mana = mana;
		}
	}

	public abstract void effectuerAction(List<Personnage> personnages);

	@Override
	public String toString() {
		return this.nom;
	}
}
