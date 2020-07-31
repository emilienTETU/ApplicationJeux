package com.e.jeux.Constants

import com.e.jeux.Model.Player

object Singleton{
    var listeJoueur = ArrayList<Player>()

    fun addEquipe(name : String){
        this.listeJoueur.add(Player(name,0,0))
    }

    fun clearEquipe(){
        this.listeJoueur.clear()
    }
}