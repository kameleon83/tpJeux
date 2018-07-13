package fr.joeltroch.m2iformation.jeu.personnages;

import fr.joeltroch.m2iformation.jeu.App;
import fr.joeltroch.m2iformation.jeu.equipements.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui représente un marchand non contrôlable amical.
 * @author Joël Troch
 */
public class PersonnagePNJAmiMarchand extends PersonnagePNJAmi {
	private final List<Equipement> objetsAVendre = new ArrayList<>();

	/**
	 * Crée un marchand non contrôlable amical.
	 * @param nom Le nom du marchad amical non contrôlable.
	 */
	public PersonnagePNJAmiMarchand(String nom) {
		super(nom);
	}

	@Override
	public void parler(PersonnageJoueur joueur) {
		boolean quitterMarchand = false;
		System.out.println(this.nom + " : \"Bienvenue " + joueur.toString() + ", que veux-tu ?\"");

		this.objetsAVendre.add(new EquipementArmeEpeeDoubleTranchant());
		this.objetsAVendre.add(new EquipementArmeEpeeMagique());
		this.objetsAVendre.add(new EquipementObjetPotionVie());
		this.objetsAVendre.add(new EquipementObjetPotionMana());

		while (!quitterMarchand) {
			System.out.println("1. Acheter.");
			System.out.println("2. Vendre.");
			System.out.println("3. Quitter le marchand.");

			// Choix joueur
			System.out.println("\nVous avez " + joueur.getPiecesOr() + " pièces d'or (PO). Choix ?");
			int choix = App.getScanner().nextInt();
			App.getScanner().nextLine();

			switch (choix) {
				case 1:
					if (this.objetsAVendre.size() > 0) {
						// Fais une liste des objets à acheter
						System.out.println("Quel objet à acheter ?");
						for (int i = 0; i < this.objetsAVendre.size(); i++) {
							Equipement objetActuel = this.objetsAVendre.get(i);
							System.out.println((i + 1) + ". " + objetActuel.toString() + " - " + objetActuel.getPrix());
						}

						// Demande l'objet
						choix = App.getScanner().nextInt();
						App.getScanner().nextLine();

						if (choix > 0 && choix <= this.objetsAVendre.size()) {
							Equipement objetAchat = this.objetsAVendre.get(choix - 1);

							// Assez d'argent ?
							if (joueur.getPiecesOr() >= objetAchat.getPrix()) {
								joueur.addPiecesOr(-objetAchat.getPrix());
								joueur.getListeEquipements().add(objetAchat);
								this.objetsAVendre.remove(objetAchat);
								System.out.println("Vous avez acheté " + objetAchat.toString() + " pour " + objetAchat.getPrix() + " PO.");
							} else {
								System.out.println("Pas assez d'argent !");
							}
						} else {
							System.out.println("Choix invalide !");
						}
					} else {
						System.out.println("Aucun objet à acheter !");
					}
					break;
				case 2:
					if (joueur.getListeEquipements().size() > 0) {
						// Fais une liste des objets à vendre
						System.out.println("Quel objet à vendre ?");
						for (int i = 0; i < joueur.getListeEquipements().size(); i++) {
							Equipement objetActuel = joueur.getListeEquipements().get(i);
							System.out.println((i + 1) + ". " + objetActuel.toString() + " - " + (objetActuel.getPrix() / 2));
						}

						// Demande l'objet
						choix = App.getScanner().nextInt();
						App.getScanner().nextLine();

						if (choix > 0 && choix <= joueur.getListeEquipements().size()) {
							Equipement objetVente = joueur.getListeEquipements().get(choix - 1);

							joueur.addPiecesOr(objetVente.getPrix() / 2);
							this.objetsAVendre.add(objetVente);
							joueur.getListeEquipements().remove(objetVente);
							System.out.println("Vous avez vendu " + objetVente.toString() + " pour " + (objetVente.getPrix() / 2) + " PO.");
						} else {
							System.out.println("Choix invalide !");
						}
					} else {
						System.out.println("Aucun objet à vendre !");
					}
					break;
				case 3:
					quitterMarchand = true;
					break;
				default:
					System.out.println("Choix invalide !");
					break;
			}
		}

		System.out.println(this.nom + " : \"Au revoir !\"");
	}
}
