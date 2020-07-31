package com.e.jeux.Games.Molkky

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
import kotlinx.android.synthetic.main.activity_molkky.*
import kotlinx.android.synthetic.main.custom_dialog_score.*

class MolkkyActivity : AppCompatActivity() {

    private var index = 0
    private var scoreSave : Int = 0
    private var scoreNew : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_molkky)
        addPlayer(intent)

        buttonScore.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog_score)
            dialog.show()
            dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dialog.rvDialog.layoutManager = LinearLayoutManager(this)
            val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
            dialog.rvDialog.adapter = MolkkyVictoryRecyclerView(list.reversed(), this)

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

    fun startGame(index : Int){
        Log.i("TEST","index : "+index)
        Log.i("TEST","scoreSave 0 : "+this.scoreSave)
        Log.i("TEST","score equipe : "+Singleton.listeJoueur[index].score)

        //TEXT
        this.scoreSave = Singleton.listeJoueur[index].score
        nom_equipe.text = Singleton.listeJoueur[index].name
        Log.i("TEST","scoreSave next : "+this.scoreSave)
        Score_equipe_int.text = Singleton.listeJoueur[index].score.toString()

        num1.setOnClickListener {
            scoreNew = this.scoreSave + 1
            if (scoreNew == 51){
                Singleton.listeJoueur[index].score = scoreNew

                nom_equipe.visibility = View.GONE
                Score_equipe_text.visibility = View.GONE
                Score_equipe_int.visibility = View.GONE
                num1.visibility = View.GONE
                num2.visibility = View.GONE
                num3.visibility = View.GONE
                num4.visibility = View.GONE
                num5.visibility = View.GONE
                num6.visibility = View.GONE
                num7.visibility = View.GONE
                num8.visibility = View.GONE
                num9.visibility = View.GONE
                num10.visibility = View.GONE
                num11.visibility = View.GONE
                num12.visibility = View.GONE
                next.visibility = View.GONE

                victoire_text.visibility = View.VISIBLE
                victoire_text.text = "Victoire de l'Equipe : "+Singleton.listeJoueur[index].name
                start_new_game.visibility = View.VISIBLE

                rvVictory.visibility = View.VISIBLE
                rvVictory.layoutManager = LinearLayoutManager(this)
                val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
                rvVictory.adapter = MolkkyVictoryRecyclerView(list.reversed(), this)
            }
            else if (scoreNew >51){
                //TODO : informer l'utilisateur
                scoreNew = 25
                Score_equipe_int.text = scoreNew.toString()
            }
            else{
                Score_equipe_int.text = scoreNew.toString()
            }
        }
        num2.setOnClickListener {
            scoreNew = this.scoreSave + 2
            if (scoreNew == 51){
                Singleton.listeJoueur[index].score = scoreNew

                nom_equipe.visibility = View.GONE
                Score_equipe_text.visibility = View.GONE
                Score_equipe_int.visibility = View.GONE
                num1.visibility = View.GONE
                num2.visibility = View.GONE
                num3.visibility = View.GONE
                num4.visibility = View.GONE
                num5.visibility = View.GONE
                num6.visibility = View.GONE
                num7.visibility = View.GONE
                num8.visibility = View.GONE
                num9.visibility = View.GONE
                num10.visibility = View.GONE
                num11.visibility = View.GONE
                num12.visibility = View.GONE
                next.visibility = View.GONE

                victoire_text.visibility = View.VISIBLE
                victoire_text.text = "Victoire de l'Equipe : "+Singleton.listeJoueur[index].name
                start_new_game.visibility = View.VISIBLE

                rvVictory.visibility = View.VISIBLE
                rvVictory.layoutManager = LinearLayoutManager(this)
                val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
                rvVictory.adapter = MolkkyVictoryRecyclerView(list.reversed(), this)
            }
            else if (scoreNew >51){
                //TODO : informer l'utilisateur
                scoreNew = 25
                Score_equipe_int.text = scoreNew.toString()
            }
            else{
                Score_equipe_int.text = scoreNew.toString()
            }
        }
        num3.setOnClickListener {
            scoreNew = this.scoreSave + 3
            if (scoreNew == 51){
                Singleton.listeJoueur[index].score = scoreNew

                nom_equipe.visibility = View.GONE
                Score_equipe_text.visibility = View.GONE
                Score_equipe_int.visibility = View.GONE
                num1.visibility = View.GONE
                num2.visibility = View.GONE
                num3.visibility = View.GONE
                num4.visibility = View.GONE
                num5.visibility = View.GONE
                num6.visibility = View.GONE
                num7.visibility = View.GONE
                num8.visibility = View.GONE
                num9.visibility = View.GONE
                num10.visibility = View.GONE
                num11.visibility = View.GONE
                num12.visibility = View.GONE
                next.visibility = View.GONE

                victoire_text.visibility = View.VISIBLE
                victoire_text.text = "Victoire de l'Equipe : "+Singleton.listeJoueur[index].name
                start_new_game.visibility = View.VISIBLE

                rvVictory.visibility = View.VISIBLE
                rvVictory.layoutManager = LinearLayoutManager(this)
                val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
                rvVictory.adapter = MolkkyVictoryRecyclerView(list.reversed(), this)
            }
            else if (scoreNew >51){
                //TODO : informer l'utilisateur
                scoreNew = 25
                Score_equipe_int.text = scoreNew.toString()
            }
            else{
                Score_equipe_int.text = scoreNew.toString()
            }
        }
        num4.setOnClickListener {
            scoreNew = this.scoreSave + 4
            if (scoreNew == 51){
                Singleton.listeJoueur[index].score = scoreNew

                nom_equipe.visibility = View.GONE
                Score_equipe_text.visibility = View.GONE
                Score_equipe_int.visibility = View.GONE
                num1.visibility = View.GONE
                num2.visibility = View.GONE
                num3.visibility = View.GONE
                num4.visibility = View.GONE
                num5.visibility = View.GONE
                num6.visibility = View.GONE
                num7.visibility = View.GONE
                num8.visibility = View.GONE
                num9.visibility = View.GONE
                num10.visibility = View.GONE
                num11.visibility = View.GONE
                num12.visibility = View.GONE
                next.visibility = View.GONE

                victoire_text.visibility = View.VISIBLE
                victoire_text.text = "Victoire de l'Equipe : "+Singleton.listeJoueur[index].name
                start_new_game.visibility = View.VISIBLE

                rvVictory.visibility = View.VISIBLE
                rvVictory.layoutManager = LinearLayoutManager(this)
                val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
                rvVictory.adapter = MolkkyVictoryRecyclerView(list.reversed(), this)
            }
            else if (scoreNew >51){
                //TODO : informer l'utilisateur
                scoreNew = 25
                Score_equipe_int.text = scoreNew.toString()
            }
            else{
                Score_equipe_int.text = scoreNew.toString()
            }
        }
        num5.setOnClickListener {
            scoreNew = this.scoreSave + 5
            if (scoreNew == 51){
                Singleton.listeJoueur[index].score = scoreNew

                nom_equipe.visibility = View.GONE
                Score_equipe_text.visibility = View.GONE
                Score_equipe_int.visibility = View.GONE
                num1.visibility = View.GONE
                num2.visibility = View.GONE
                num3.visibility = View.GONE
                num4.visibility = View.GONE
                num5.visibility = View.GONE
                num6.visibility = View.GONE
                num7.visibility = View.GONE
                num8.visibility = View.GONE
                num9.visibility = View.GONE
                num10.visibility = View.GONE
                num11.visibility = View.GONE
                num12.visibility = View.GONE
                next.visibility = View.GONE

                victoire_text.visibility = View.VISIBLE
                victoire_text.text = "Victoire de l'Equipe : "+Singleton.listeJoueur[index].name
                start_new_game.visibility = View.VISIBLE

                rvVictory.visibility = View.VISIBLE
                rvVictory.layoutManager = LinearLayoutManager(this)
                val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
                rvVictory.adapter = MolkkyVictoryRecyclerView(list.reversed(), this)
            }
            else if (scoreNew >51){
                //TODO : informer l'utilisateur
                scoreNew = 25
                Score_equipe_int.text = scoreNew.toString()
            }
            else{
                Score_equipe_int.text = scoreNew.toString()
            }
        }
        num6.setOnClickListener {
            scoreNew = this.scoreSave + 6
            if (scoreNew == 51){
                Singleton.listeJoueur[index].score = scoreNew

                nom_equipe.visibility = View.GONE
                Score_equipe_text.visibility = View.GONE
                Score_equipe_int.visibility = View.GONE
                num1.visibility = View.GONE
                num2.visibility = View.GONE
                num3.visibility = View.GONE
                num4.visibility = View.GONE
                num5.visibility = View.GONE
                num6.visibility = View.GONE
                num7.visibility = View.GONE
                num8.visibility = View.GONE
                num9.visibility = View.GONE
                num10.visibility = View.GONE
                num11.visibility = View.GONE
                num12.visibility = View.GONE
                next.visibility = View.GONE

                victoire_text.visibility = View.VISIBLE
                victoire_text.text = "Victoire de l'Equipe : "+Singleton.listeJoueur[index].name
                start_new_game.visibility = View.VISIBLE

                rvVictory.visibility = View.VISIBLE
                rvVictory.layoutManager = LinearLayoutManager(this)
                val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
                rvVictory.adapter = MolkkyVictoryRecyclerView(list.reversed(), this)
            }
            else if (scoreNew >51){
                //TODO : informer l'utilisateur
                scoreNew = 25
                Score_equipe_int.text = scoreNew.toString()
            }
            else{
                Score_equipe_int.text = scoreNew.toString()
            }
        }
        num7.setOnClickListener {
            scoreNew = this.scoreSave + 7
            if (scoreNew == 51){
                Singleton.listeJoueur[index].score = scoreNew

                nom_equipe.visibility = View.GONE
                Score_equipe_text.visibility = View.GONE
                Score_equipe_int.visibility = View.GONE
                num1.visibility = View.GONE
                num2.visibility = View.GONE
                num3.visibility = View.GONE
                num4.visibility = View.GONE
                num5.visibility = View.GONE
                num6.visibility = View.GONE
                num7.visibility = View.GONE
                num8.visibility = View.GONE
                num9.visibility = View.GONE
                num10.visibility = View.GONE
                num11.visibility = View.GONE
                num12.visibility = View.GONE
                next.visibility = View.GONE

                victoire_text.visibility = View.VISIBLE
                victoire_text.text = "Victoire de l'Equipe : "+Singleton.listeJoueur[index].name
                start_new_game.visibility = View.VISIBLE

                rvVictory.visibility = View.VISIBLE
                rvVictory.layoutManager = LinearLayoutManager(this)
                val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
                rvVictory.adapter = MolkkyVictoryRecyclerView(list.reversed(), this)
            }
            else if (scoreNew >51){
                //TODO : informer l'utilisateur
                scoreNew = 25
                Score_equipe_int.text = scoreNew.toString()
            }
            else{
                Score_equipe_int.text = scoreNew.toString()
            }
        }
        num8.setOnClickListener {
            scoreNew = this.scoreSave + 8
            if (scoreNew == 51){
                Singleton.listeJoueur[index].score = scoreNew

                nom_equipe.visibility = View.GONE
                Score_equipe_text.visibility = View.GONE
                Score_equipe_int.visibility = View.GONE
                num1.visibility = View.GONE
                num2.visibility = View.GONE
                num3.visibility = View.GONE
                num4.visibility = View.GONE
                num5.visibility = View.GONE
                num6.visibility = View.GONE
                num7.visibility = View.GONE
                num8.visibility = View.GONE
                num9.visibility = View.GONE
                num10.visibility = View.GONE
                num11.visibility = View.GONE
                num12.visibility = View.GONE
                next.visibility = View.GONE

                victoire_text.visibility = View.VISIBLE
                victoire_text.text = "Victoire de l'Equipe : "+Singleton.listeJoueur[index].name
                start_new_game.visibility = View.VISIBLE

                rvVictory.visibility = View.VISIBLE
                rvVictory.layoutManager = LinearLayoutManager(this)
                val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
                rvVictory.adapter = MolkkyVictoryRecyclerView(list.reversed(), this)
            }
            else if (scoreNew >51){
                //TODO : informer l'utilisateur
                scoreNew = 25
                Score_equipe_int.text = scoreNew.toString()
            }
            else{
                Score_equipe_int.text = scoreNew.toString()
            }
        }
        num9.setOnClickListener {
            scoreNew = this.scoreSave + 9
            if (scoreNew == 51){
                Singleton.listeJoueur[index].score = scoreNew

                nom_equipe.visibility = View.GONE
                Score_equipe_text.visibility = View.GONE
                Score_equipe_int.visibility = View.GONE
                num1.visibility = View.GONE
                num2.visibility = View.GONE
                num3.visibility = View.GONE
                num4.visibility = View.GONE
                num5.visibility = View.GONE
                num6.visibility = View.GONE
                num7.visibility = View.GONE
                num8.visibility = View.GONE
                num9.visibility = View.GONE
                num10.visibility = View.GONE
                num11.visibility = View.GONE
                num12.visibility = View.GONE
                next.visibility = View.GONE

                victoire_text.visibility = View.VISIBLE
                victoire_text.text = "Victoire de l'Equipe : "+Singleton.listeJoueur[index].name
                start_new_game.visibility = View.VISIBLE

                rvVictory.visibility = View.VISIBLE
                rvVictory.layoutManager = LinearLayoutManager(this)
                val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
                rvVictory.adapter = MolkkyVictoryRecyclerView(list.reversed(), this)
            }
            else if (scoreNew >51){
                //TODO : informer l'utilisateur
                scoreNew = 25
                Score_equipe_int.text = scoreNew.toString()
            }
            else{
                Score_equipe_int.text = scoreNew.toString()
            }
        }
        num10.setOnClickListener {
            scoreNew = this.scoreSave + 10
            if (scoreNew == 51){
                Singleton.listeJoueur[index].score = scoreNew

                nom_equipe.visibility = View.GONE
                Score_equipe_text.visibility = View.GONE
                Score_equipe_int.visibility = View.GONE
                num1.visibility = View.GONE
                num2.visibility = View.GONE
                num3.visibility = View.GONE
                num4.visibility = View.GONE
                num5.visibility = View.GONE
                num6.visibility = View.GONE
                num7.visibility = View.GONE
                num8.visibility = View.GONE
                num9.visibility = View.GONE
                num10.visibility = View.GONE
                num11.visibility = View.GONE
                num12.visibility = View.GONE
                next.visibility = View.GONE

                victoire_text.visibility = View.VISIBLE
                victoire_text.text = "Victoire de l'Equipe : "+Singleton.listeJoueur[index].name
                start_new_game.visibility = View.VISIBLE

                rvVictory.visibility = View.VISIBLE
                rvVictory.layoutManager = LinearLayoutManager(this)
                val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
                rvVictory.adapter = MolkkyVictoryRecyclerView(list.reversed(), this)
            }
            else if (scoreNew >51){
                //TODO : informer l'utilisateur
                scoreNew = 25
                Score_equipe_int.text = scoreNew.toString()
            }
            else{
                Score_equipe_int.text = scoreNew.toString()
            }
        }
        num11.setOnClickListener {
            scoreNew = this.scoreSave + 11
            if (scoreNew == 51){
                Singleton.listeJoueur[index].score = scoreNew

                nom_equipe.visibility = View.GONE
                Score_equipe_text.visibility = View.GONE
                Score_equipe_int.visibility = View.GONE
                num1.visibility = View.GONE
                num2.visibility = View.GONE
                num3.visibility = View.GONE
                num4.visibility = View.GONE
                num5.visibility = View.GONE
                num6.visibility = View.GONE
                num7.visibility = View.GONE
                num8.visibility = View.GONE
                num9.visibility = View.GONE
                num10.visibility = View.GONE
                num11.visibility = View.GONE
                num12.visibility = View.GONE
                next.visibility = View.GONE

                victoire_text.visibility = View.VISIBLE
                victoire_text.text = "Victoire de l'Equipe : "+Singleton.listeJoueur[index].name
                start_new_game.visibility = View.VISIBLE

                rvVictory.visibility = View.VISIBLE
                rvVictory.layoutManager = LinearLayoutManager(this)
                val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
                rvVictory.adapter = MolkkyVictoryRecyclerView(list.reversed(), this)
            }
            else if (scoreNew >51){
                //TODO : informer l'utilisateur
                scoreNew = 25
                Score_equipe_int.text = scoreNew.toString()
            }
            else{
                Score_equipe_int.text = scoreNew.toString()
            }
        }
        num12.setOnClickListener {
            scoreNew = this.scoreSave + 12
            if (scoreNew == 51){
                Singleton.listeJoueur[index].score = scoreNew

                nom_equipe.visibility = View.GONE
                Score_equipe_text.visibility = View.GONE
                Score_equipe_int.visibility = View.GONE
                num1.visibility = View.GONE
                num2.visibility = View.GONE
                num3.visibility = View.GONE
                num4.visibility = View.GONE
                num5.visibility = View.GONE
                num6.visibility = View.GONE
                num7.visibility = View.GONE
                num8.visibility = View.GONE
                num9.visibility = View.GONE
                num10.visibility = View.GONE
                num11.visibility = View.GONE
                num12.visibility = View.GONE
                next.visibility = View.GONE

                victoire_text.visibility = View.VISIBLE
                victoire_text.text = "Victoire de l'Equipe : "+Singleton.listeJoueur[index].name
                start_new_game.visibility = View.VISIBLE

                rvVictory.visibility = View.VISIBLE
                rvVictory.layoutManager = LinearLayoutManager(this)
                val list : List<Player> = Singleton.listeJoueur.sortedBy { it.score }
                rvVictory.adapter = MolkkyVictoryRecyclerView(list.reversed(), this)
            }
            else if (scoreNew >51){
                //TODO : informer l'utilisateur
                scoreNew = 25
                Score_equipe_int.text = scoreNew.toString()
            }
            else{
                Score_equipe_int.text = scoreNew.toString()
            }
        }
        next.setOnClickListener {
            if(scoreNew != 0) {
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
        start_new_game.setOnClickListener {
            nom_equipe.visibility = View.VISIBLE
            Score_equipe_text.visibility = View.VISIBLE
            Score_equipe_int.visibility = View.VISIBLE
            num1.visibility = View.VISIBLE
            num2.visibility = View.VISIBLE
            num3.visibility = View.VISIBLE
            num4.visibility = View.VISIBLE
            num5.visibility = View.VISIBLE
            num6.visibility = View.VISIBLE
            num7.visibility = View.VISIBLE
            num8.visibility = View.VISIBLE
            num9.visibility = View.VISIBLE
            num10.visibility = View.VISIBLE
            num11.visibility = View.VISIBLE
            num12.visibility = View.VISIBLE
            next.visibility = View.VISIBLE
            victoire_text.visibility = View.GONE
            start_new_game.visibility = View.GONE
            rvVictory.visibility = View.GONE
            for (indexReset in 0..Singleton.listeJoueur.size-1){
                Singleton.listeJoueur[indexReset].score = 0
                Singleton.listeJoueur[indexReset].score=0
            }
            scoreSave = 0
            scoreNew = 0
            startGame(0)
        }
    }
}
