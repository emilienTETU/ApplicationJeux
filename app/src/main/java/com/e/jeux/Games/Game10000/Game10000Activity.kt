package com.e.jeux.Games.Game10000

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.jeux.Constants.Singleton
import com.e.jeux.Model.Player
import com.e.jeux.R
import kotlinx.android.synthetic.main.activity_game10000.*
import kotlinx.android.synthetic.main.custom_dialog_score.*

class Game10000Activity : AppCompatActivity() {

    private var index = 0
    private var scoreSave : Int = 0
    private var score : String = ""
    private var scoreNew : Int = 0
    private val scoreDeVictoire = 10000
    private val scorePenalite = 200
    private var valider = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game10000)
        addPlayer(intent)

        buttonScore.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog_score)
            dialog.show()
            dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dialog.rvDialog.layoutManager = LinearLayoutManager(this)
            val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
            dialog.rvDialog.adapter = Game10000VictoryRecyclerView(list.reversed(), this)

            dialog.buttonDialog.setOnClickListener {
                dialog.cancel()
            }
        }

        startGame(index)
    }

    private fun addPlayer(intent : Intent){
        val players = intent.getStringArrayListExtra("listPlayer")
        Singleton.clearEquipe()
        for (player in players){
            Singleton.addEquipe(player)
        }
    }

    fun init(index: Int){
        this.scoreSave = Singleton.listeJoueur[index].score
        nom_joueur.text = Singleton.listeJoueur[index].name
        Score_joueur_int.text = Singleton.listeJoueur[index].score.toString()
        this.score = ""
        Nouveau_joueur_int.text = "0"
        penalite.text = "Pénalité ("+Singleton.listeJoueur[index].penality+")"
        Score_joueur_victoire_int.text = "("+(scoreDeVictoire - scoreSave)+")"
        valide.isClickable = true
    }

    fun startGame(index : Int){
        this.valider = false

        init(index)

        num0.setOnClickListener {
            this.score = score + 0
            Nouveau_joueur_int.text = this.score
        }
        num1.setOnClickListener {
            this.score = score + 1
            Nouveau_joueur_int.text = this.score
        }
        num2.setOnClickListener {
            this.score = score + 2
            Nouveau_joueur_int.text = this.score
        }
        num3.setOnClickListener {
            this.score = score + 3
            Nouveau_joueur_int.text = this.score
        }
        num4.setOnClickListener {
            this.score = score + 4
            Nouveau_joueur_int.text = this.score
        }
        num5.setOnClickListener {
            this.score = score + 5
            Nouveau_joueur_int.text = this.score
        }
        num6.setOnClickListener {
            this.score = score + 6
            Nouveau_joueur_int.text = this.score
        }
        num7.setOnClickListener {
            this.score = score + 7
            Nouveau_joueur_int.text = this.score
        }
        num8.setOnClickListener {
            this.score = score + 8
            Nouveau_joueur_int.text = this.score
        }
        num9.setOnClickListener {
            this.score = score + 9
            Nouveau_joueur_int.text = this.score
        }

        back.setOnClickListener {
            if(this.score.length>0){
                this.score = this.score.substring(0,score.length-1)
                Nouveau_joueur_int.text = this.score
            }
            else {
                this.score = "0"
                Nouveau_joueur_int.text = this.score
            }
        }

        valide.setOnClickListener {
            valide(index)
        }

        next.setOnClickListener {
            if(scoreNew != 0) {
                Singleton.listeJoueur[index].score = scoreNew
            }
            else if(valider == false){
                valide(index)
                Singleton.listeJoueur[index].score = scoreNew
            }
            if ((index+1)<Singleton.listeJoueur.size){
                this.scoreSave = 0
                this.scoreNew = 0
                startGame(index+1)
            }
            else {
                this.scoreSave = 0
                this.scoreNew = 0
                startGame(0)
            }
        }

        penalite.setOnClickListener {
            valider = true
            if(Singleton.listeJoueur[index].penality == 2){
                Log.i("TEST","penalité -200")
                this.scoreNew = scoreSave - scorePenalite
                valide.isClickable = false
                Score_joueur_int.text = scoreNew.toString()
                Singleton.listeJoueur[index].penality = 0
                penalite.text = "Pénalité ("+Singleton.listeJoueur[index].penality+")"
                var scoreToVictory = scoreDeVictoire-scoreNew
                Score_joueur_victoire_int.text = "("+scoreToVictory+")"
            }
            else {
                Log.i("TEST","penalité +1")
                Singleton.listeJoueur[index].penality = Singleton.listeJoueur[index].penality + 1
                penalite.text = "Pénalité ("+Singleton.listeJoueur[index].penality+")"
            }
        }

        start_new_game.setOnClickListener {
            nom_joueur.visibility = View.VISIBLE
            Score_joueur_text.visibility = View.VISIBLE
            Score_joueur_int.visibility = View.VISIBLE
            Score_joueur_victoire_int.visibility = View.VISIBLE
            num1.visibility = View.VISIBLE
            num2.visibility = View.VISIBLE
            num3.visibility = View.VISIBLE
            num4.visibility = View.VISIBLE
            num5.visibility = View.VISIBLE
            num6.visibility = View.VISIBLE
            num7.visibility = View.VISIBLE
            num8.visibility = View.VISIBLE
            num9.visibility = View.VISIBLE
            num0.visibility = View.VISIBLE
            back.visibility = View.VISIBLE
            valide.visibility = View.VISIBLE
            next.visibility = View.VISIBLE
            penalite.visibility = View.VISIBLE
            Nouveau_joueur_text.visibility = View.VISIBLE
            Nouveau_joueur_int.visibility = View.VISIBLE
            victoire_text.visibility = View.GONE
            start_new_game.visibility = View.GONE
            rvVictory.visibility = View.GONE
            for (indexReset in 0..Singleton.listeJoueur.size-1){
                Singleton.listeJoueur[indexReset].score = 0
                Singleton.listeJoueur[indexReset].penality = 0
            }
            scoreSave = 0
            scoreNew = 0
            score = ""
            startGame(0)
        }
    }

    fun valide(index: Int){
        this.valider = true
        var intScore : Int = 0
        if(score != ""){
            intScore = this.score.toInt()
        }
        this.scoreNew = scoreSave + intScore
        if(scoreNew == scoreDeVictoire){
            victoire(index)
        }
        else if(scoreNew > scoreDeVictoire){
            this.scoreNew = scoreSave - scorePenalite
            Score_joueur_int.text = scoreNew.toString()
            var scoreToVictory = scoreDeVictoire-scoreNew
            Score_joueur_victoire_int.text = "("+scoreToVictory+")"
        }
        else{
            Score_joueur_int.text = scoreNew.toString()
            var scoreToVictory = scoreDeVictoire-scoreNew
            Score_joueur_victoire_int.text = "("+scoreToVictory+")"
        }
    }

    fun victoire(index : Int){

        Singleton.listeJoueur[index].score = scoreNew

        //GONE
        nom_joueur.visibility = View.GONE
        Score_joueur_text.visibility = View.GONE
        Score_joueur_int.visibility = View.GONE
        Score_joueur_victoire_int.visibility = View.GONE
        num1.visibility = View.GONE
        num2.visibility = View.GONE
        num3.visibility = View.GONE
        num4.visibility = View.GONE
        num5.visibility = View.GONE
        num6.visibility = View.GONE
        num7.visibility = View.GONE
        num8.visibility = View.GONE
        num9.visibility = View.GONE
        num0.visibility = View.GONE
        back.visibility = View.GONE
        valide.visibility = View.GONE
        next.visibility = View.GONE
        penalite.visibility = View.GONE
        Nouveau_joueur_text.visibility = View.GONE
        Nouveau_joueur_int.visibility = View.GONE

        //Visible
        rvVictory.visibility = View.VISIBLE
        victoire_text.visibility = View.VISIBLE
        victoire_text.text = "Victoire du joueur : "+Singleton.listeJoueur[index].name
        start_new_game.visibility = View.VISIBLE

        rvVictory.layoutManager = LinearLayoutManager(this)
        val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
        rvVictory.adapter = Game10000VictoryRecyclerView(list.reversed(), this)
    }
}
