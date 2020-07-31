package com.e.jeux.Constants

class Constants {
    companion object{

        //Todo : Ajouter les constants
        //Ligretto
        const val ligretto = "Ligretto"
        const val descriptionLigretto = "Ligretto est un petit jeu de carte déjanté dans " +
                "lequel les joueurs doivent se débarrasser simultanément de leur cartes le plus" +
                " rapidement possible en créant des séries croissantes."
        const val ligrettoActivity = "LigrettoActivity"

        //10000
        const val game10000 = "10000"
        const val description10000 = "Le jeu 10000 est un jeux de dé. Il peut se jouer à 5 ou 6 dés. " +
                "Le but du jeu est d'atteindre 10000 points.Un joueur peut " +
                "lancer les dés tant qu’il obtient des points.\n" +
                "Si un lancer donne des points, les dés payants peuvent être " +
                "mis en réserve. Les dés restants peuvent être relancés ou le " +
                "joueur peut décider de valider ses points. Les dés mis en réserve " +
                "ne peuvent plus se combiner avec les dés des prochains lancers.\n" +
                "Si tous les dés sont payants, le joueur obtient une main pleine. Il " +
                "garde les points accumulés lors de la main pleine précédente et doit " +
                "relancer tous les dés.\n" +
                "Si un lancer ne donne pas de points, le tour se termine et le score " +
                "obtenu lors des lancers précédents est perdu. " +
                "\nComptage des points :\n" +
                "– chaque 1 seul vaut 100 points.\n" +
                "– chaque 5 seul vaut 50 points.\n" +
                "– les 2, 3, 4 et 6 seuls ne valent rien.\n" +
                "– 3 dés identitiques en 1 lancer vaut le nombre x100 (Par exemple : 3 dés avec " +
                "la valeur 4 vaut 400 points) mais ATTENTION 3 dés avec la valeur 1 " +
                "vaut 1000 points et 3 dés avec la valeur 5 vaut 700 points."
        const val game10000Activity = "game10000Activity"

        //Molkky
        const val molkky = "Molkky"
        const val descriptionMolkky = "Le jeu peut se jouer de deux à plusieurs joueurs " +
                "mais aussi par équipes (composées de deux à quatre joueurs).\n" +
                "\n" +
                "Le joueur lance le mölkky dans les quilles, placées à 3,50 mètres5. " +
                "Le pointage du joueur dépend du nombre de quilles renversées :\n" +
                "\n" +
                "s'il fait tomber une quille, il marque la valeur de la quille ;\n" +
                "s'il fait tomber plusieurs quilles, il marque le nombre de quilles " +
                "tombées (si toutes les quilles tombent, le joueur marque donc douze points) ;\n" +
                "si une quille n'est pas complètement allongée au sol et qu'elle se " +
                "trouve en équilibre sur une autre ou sur le mölkky (le lanceur), " +
                "elle n'est pas comptée.\n" +
                "Les quilles tombées sont ensuite relevées sur leur pied, numéro " +
                "face à la zone de lancer, juste là où elles se trouvent et sans " +
                "les soulever du sol. Ainsi la configuration de l'aire de jeu évolue. " +
                "Chaque joueur réalise un lancer à tour de rôle et il est fait autant " +
                "de tours que nécessaire.\n" +
                "\n" +
                "Si un joueur (ou une équipe) ne marque pas de point trois fois " +
                "consécutivement, il est éliminé. Si plusieurs joueurs sont éliminés, " +
                "le dernier restant est le vainqueur, quand bien même les 50 points " +
                "ne seraient pas atteints."
        const val molkkyActivity = "MolkkyActivity"

        //Default
        const val default = "Jeu basique"
        const val descriptionDefault = "Jeu permettant l'addition et la soustraction de score " +
                "sans limite de score."
        const val defaultActivity = "DefaultActivity"

        //Belote
        const val belote = "Belote"
        const val descriptionBelote = "La belote est un jeu de cartes qui se pratique à quatre" +
                ", à trois ou deux avec un jeu de 32 cartes. Les joueurs sont répartis en " +
                "équipe(s) de deux joueurs, les membres d'une même équipe se faisant face et " +
                "ayant à leur droite et à leur gauche chacun des joueurs adverses. " +
                "C'est un jeu à contrat, dans le sens où l'une des deux équipes s'engage à " +
                "faire plus de points que l'adversaire, et dont l'échec est sévèrement pénalisé."
        const val beloteActivity = "BeloteActivity"
    }
}