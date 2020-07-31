package com.e.jeux.Games.Default

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.jeux.Constants.Singleton
import com.e.jeux.Model.Player
import com.e.jeux.R
import kotlinx.android.synthetic.main.activity_default.*
import kotlinx.android.synthetic.main.custom_dialog_score.*

class DefaultActivity : AppCompatActivity() {

    private var index = 0
    private var scoreSave : Int = 0
    private var score : String = ""
    private var scoreNew : Int = 0
    private var valider = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_default)
        addPlayer(intent)

        buttonScore.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog_score)
            dialog.show()
            dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dialog.rvDialog.layoutManager = LinearLayoutManager(this)
            val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
            dialog.rvDialog.adapter = DefaultScoreRecyclerView(list.reversed(), this)

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
        Log.i("TEST","scoreSave next : "+this.scoreSave)
        Score_joueur_int.text = Singleton.listeJoueur[index].score.toString()
        this.score = ""
        Nouveau_joueur_int.text = "0"
    }

    fun startGame(index : Int){
        this.valider = false
        Log.i("TEST","index : "+index)
        Log.i("TEST","scoreSave 0 : "+this.scoreSave)
        Log.i("TEST","score equipe : "+Singleton.listeJoueur[index].score)

        init(index)

        moins.setOnClickListener {
            this.score = "-"
            Nouveau_joueur_int.text = this.score
        }
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
            valide()
        }

        next.setOnClickListener {
            if(scoreNew != 0) {
                Singleton.listeJoueur[index].score = scoreNew
            }
            else if(valider == false){
                valide()
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
    }

    fun valide(){
        this.valider = true
        var intScore : Int = 0
        if(score != ""){
            intScore = this.score.toInt()
        }
        this.scoreNew = scoreSave + intScore
        Score_joueur_int.text = scoreNew.toString()
    }
}
