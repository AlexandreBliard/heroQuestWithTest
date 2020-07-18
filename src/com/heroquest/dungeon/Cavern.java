package com.heroquest.dungeon;

import com.heroquest.pj.CommunPeople;
import com.heroquest.pnj.Dragon;
import com.heroquest.pnj.Goblins;
import com.heroquest.pnj.Sorcerer;

import java.util.ArrayList;

public class Cavern {

    final int BOARD_SIZE = 63;
    /**
     * génération de la caverne, utilisera le constructeur
     * de Salle pour générer salle par salle la taille de
     * la caverne définit suivant la variable BOARD_SIZE
     * qui ensuite générera le nombre de monstres et qui ensuite
     * effectuera la répartition dans les Salles sachant
     * que les dernières auront les ennemis les plus puissants
     * et qu'une méthode vérifie la présence d'un ennemi.
     * @return
     * @throws NoSuchFieldException
     */
    public ArrayList<Salle> salles()  {

        double fqGobelin = 0.90;
        double fqSorcerer = 0.65;
        double fqDragon = 0.15;
        int nbGobelin = BOARD_SIZE / 4;
        int nbSorcerer = BOARD_SIZE / 8;
        int nbDragon = BOARD_SIZE / 16;
        DescriptionSalle texte = new DescriptionSalle();
        RandomReward loot = new RandomReward();
        CommunPeople goblins = new Goblins();
        CommunPeople sorcerer = new Sorcerer();
        CommunPeople dragon = new Dragon();
        ArrayList<Salle> plateaux = new ArrayList<Salle>(BOARD_SIZE);
        for (int i = 0; i<=BOARD_SIZE; i++) {//boucle créations du plateaux
            Salle salle = new Salle(texte.description(), loot.reward());//salle avec description & loot aléatoire et sans ennemi
            plateaux.add(salle);
            if (i == BOARD_SIZE) {
                RandomNumber randomNumber = new RandomNumber();
                AddRandomMonster random = new AddRandomMonster();
                random.addRandomMonster(nbDragon, texte, loot, dragon,
                        randomNumber, plateaux, BOARD_SIZE, fqDragon);
                random.addRandomMonster(nbSorcerer, texte, loot, sorcerer,
                        randomNumber, plateaux, BOARD_SIZE, fqSorcerer);
                random.addRandomMonster(nbGobelin, texte, loot, goblins,
                        randomNumber, plateaux, BOARD_SIZE, fqGobelin);
            }
        }
        return plateaux;
    }
}
