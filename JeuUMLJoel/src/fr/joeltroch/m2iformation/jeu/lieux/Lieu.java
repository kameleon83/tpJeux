package fr.joeltroch.m2iformation.jeu.lieux;

import fr.joeltroch.m2iformation.jeu.personnages.PersonnageJoueur;

public abstract class Lieu {
	final String nom;

	Lieu(String nom) {
		this.nom = nom;
	}

	public abstract void parcourir(PersonnageJoueur joueur);
}
