package fr.joeltroch.m2iformation.jeu;

import fr.joeltroch.m2iformation.jeu.personnages.Personnage;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnagePNJEnnemiZombie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest {
	@Test
	public void getListeCiblesPossibles() {
		Personnage sujet1 = new PersonnagePNJEnnemiZombie(false);
		sujet1.setSante(100);
		Personnage sujet2 = new PersonnagePNJEnnemiZombie(false);
		sujet2.setSante(0);
		Personnage sujet3 = new PersonnagePNJEnnemiZombie(false);
		sujet3.setSante(-50);

		List<Personnage> sujets = new ArrayList<>();
		sujets.add(sujet1);
		sujets.add(sujet2);
		sujets.add(sujet3);

		List<Personnage> resultat = App.getListeCiblesPossibles(sujets);
		assertEquals(1, resultat.size());
		assertEquals(sujet1, resultat.get(0));
	}

	@Test
	public void getVagueActuelle() {
		assertEquals(1, App.getVagueActuelle());
	}

	@Test
	public void incrementVagueActuelle() {
		App.incrementVagueActuelle();
		assertEquals(2, App.getVagueActuelle());
		App.incrementVagueActuelle();
		assertEquals(3, App.getVagueActuelle());
		App.incrementVagueActuelle();
		assertEquals(4, App.getVagueActuelle());
	}
}