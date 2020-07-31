package com.e.jeux.WelcomePage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.jeux.Constants.Constants
import com.e.jeux.Model.GameDescriptionModel
import com.e.jeux.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Pour ajouter un nouveau jeu à la liste :
               - Création du jeu dans constante.
               - Ajout des contantes dans l'array ci-dessous.(todo)
               - Création d'un nouveau dossier avec le nom du jeu.
               - Implémentation des règles du jeu dans le dossier.
               - Ajout de l'intent dans startGameActivity() de AddPLayerPageActivity. (todo)
               - (optionnel) modification ou ajout du model de joueur.

               ! Vous pouvez suivre les todo.
         */

        val array = ArrayList<GameDescriptionModel>()

        //Todo : Ajouter le jeu
        array.add(GameDescriptionModel(
            Constants.default,
            Constants.descriptionDefault,
            Constants.defaultActivity
        ))
        array.add(GameDescriptionModel(
            Constants.ligretto,
            Constants.descriptionLigretto,
            Constants.ligrettoActivity
        ))
        array.add(GameDescriptionModel(
            Constants.game10000,
            Constants.description10000,
            Constants.game10000Activity
        ))
        array.add(GameDescriptionModel(
            Constants.molkky,
            Constants.descriptionMolkky,
            Constants.molkkyActivity
        ))
        array.add(GameDescriptionModel(
            Constants.belote,
            Constants.descriptionBelote,
            Constants.beloteActivity
        ))

        rvWelcomeActivity.layoutManager = LinearLayoutManager(this)
        rvWelcomeActivity.adapter = WelcomeRecyclerView(array, this)
    }
}
