package com.e.jeux.Games.Belote

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
import androidx.lifecycle.Observer
import com.e.jeux.Model.Player
import com.e.jeux.R
import com.github.guilhe.keyboardevents.KeyboardState
import com.github.guilhe.keyboardevents.KeyboardStateLiveData
import com.github.guilhe.keyboardevents.bindKeyboardStateEvents
import kotlinx.android.synthetic.main.activity_belote.*
import kotlinx.android.synthetic.main.activity_game10000.*
import kotlinx.android.synthetic.main.custom_dialog_score.*

class BeloteActivity : AppCompatActivity() {

    private var index = 0
    private var listPlayer = Singleton.listeJoueur
    private lateinit var eux : Player
    private lateinit var nous : Player
    var annonceEux = ArrayList<String>()
    var annonceNous = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_belote)
        addPlayer(intent)
        prepareView()
        startGame(index)

        //KeyBoardListener
        KeyboardStateLiveData.state.observe(this, Observer {
            when(it){
                //Keyboard open
                KeyboardState.OPEN -> {
                    nextDone.visibility = View.GONE
                }
                //Keyboard closed
                KeyboardState.CLOSED -> {
                    nextDone.visibility = View.VISIBLE
                }
                else -> {
                }
            }
        })
        bindKeyboardStateEvents()
    }

    private fun addPlayer(intent : Intent){
        val players = intent.getStringArrayListExtra("listPlayer")
        Singleton.clearEquipe()
        if (players.size<4){
            finish()
        }
        Singleton.addEquipe(players[0])
        Singleton.addEquipe(players[2])
        Singleton.addEquipe(players[1])
        Singleton.addEquipe(players[3])
    }

    private fun prepareView(){
        player1.text = listPlayer[0].name
        player2.text = listPlayer[1].name
        player3.text = listPlayer[2].name
        player4.text = listPlayer[3].name
        createEquipe(listPlayer[0],listPlayer[1],listPlayer[2],listPlayer[3])
        createList()
    }

    private fun setBackgroundColor(id : Int){
        when(id) {
            0 -> {
                player1.background = this.getDrawable(R.drawable.background_button_orange)
                player2.background = this.getDrawable(R.drawable.background_button_gray)
                player3.background = this.getDrawable(R.drawable.background_button_gray)
                player4.background = this.getDrawable(R.drawable.background_button_gray)
            }
            2 -> {
                player1.background = this.getDrawable(R.drawable.background_button_gray)
                player2.background = this.getDrawable(R.drawable.background_button_orange)
                player3.background = this.getDrawable(R.drawable.background_button_gray)
                player4.background = this.getDrawable(R.drawable.background_button_gray)
            }
            1 -> {
                player1.background = this.getDrawable(R.drawable.background_button_gray)
                player2.background = this.getDrawable(R.drawable.background_button_gray)
                player3.background = this.getDrawable(R.drawable.background_button_orange)
                player4.background = this.getDrawable(R.drawable.background_button_gray)
            }
            3 -> {
                player1.background = this.getDrawable(R.drawable.background_button_gray)
                player2.background = this.getDrawable(R.drawable.background_button_gray)
                player3.background = this.getDrawable(R.drawable.background_button_gray)
                player4.background = this.getDrawable(R.drawable.background_button_orange)
            }
        }
    }

    private fun createEquipe(
        j1 : Player,
        j2 : Player,
        j3 : Player,
        j4 : Player
    ){
        eux = Player("$j1 $j2",0,0)
        nous = Player("$j3 $j4",0,0)
    }

    private fun createList(){
        rvListAnnonceEux.layoutManager = LinearLayoutManager(this)
        rvListAnnonceEux.adapter = BeloteAnnonceDoneRecyclerView(
            annonceEux,
            this,
            Side.EUX,
            this
        )
        rvlistAnnonceNous.layoutManager = LinearLayoutManager(this)
        rvlistAnnonceNous.adapter = BeloteAnnonceDoneRecyclerView(
            annonceNous,
            this,
            Side.NOUS,
            this
        )
    }

    private fun addAnnonce(side: Side){
        val listAnnonce = listOf(Annonce.carre,Annonce.suite,Annonce.belotte)

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog_annonce)
        dialog.show()
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.rvDialog.layoutManager = LinearLayoutManager(this)
        dialog.rvDialog.adapter = BeloteAnnonceRecyclerView(
            listAnnonce,
            this,
            side,
            this
        )

        dialog.buttonDialog.setOnClickListener {
            dialog.cancel()
        }
    }

    private fun startGame(index : Int){
        //init
        setBackgroundColor(index)
        scoreEux.text.clear()
        scoreNous.text.clear()
        totalScoreEux.text = eux.score.toString()
        totalScoreNous.text = nous.score.toString()

        //Annonce
        annonceNousButton.setOnClickListener {
            addAnnonce(Side.NOUS)
        }
        annonceEuxButton.setOnClickListener {
            addAnnonce(Side.EUX)
        }

        //Listener valide
        valideEux.setOnClickListener {
            checkScore(scoreEux.text.toString().toInt(),Side.EUX)
            nous.score += getScoreAnnonce(annonceNous)
            annonceEux.clear()
            annonceNous.clear()
            startGame(index+1)
        }

        valideNous.setOnClickListener {
            checkScore(scoreNous.text.toString().toInt()+getScoreAnnonce(annonceNous),Side.NOUS)
            eux.score += getScoreAnnonce(annonceEux)
            annonceEux.clear()
            annonceNous.clear()
            startGame(index+1)
        }
    }

    private fun checkScore(score : Int, side: Side){
        var scoreAnnonce = 0
        when(side){
            Side.EUX -> scoreAnnonce += getScoreAnnonce(annonceEux)
            Side.NOUS -> scoreAnnonce += getScoreAnnonce(annonceNous)
        }
        if (score <= 0){
            //erreur
        }
        else if (score+scoreAnnonce <= 81){
            when(side){
                Side.EUX -> nous.score += 162
                Side.NOUS -> eux.score += 162
            }
        }
        else if (score >= 252){
            when(side){
                Side.EUX -> eux.score += score
                Side.NOUS -> nous.score += score
            }
        }
        else{
            when(side){
                Side.EUX -> {
                    eux.score += score+scoreAnnonce
                    nous.score += 162-score+scoreAnnonce
                }
                Side.NOUS -> {
                    eux.score += 162-score+scoreAnnonce
                    nous.score += score+scoreAnnonce
                }
            }
        }
    }

    private fun getScoreAnnonce(listAnnonces : ArrayList<String>) : Int{
        var score = 0
        for (annonce in listAnnonces){
            when(annonce){
                Annonce.carre -> score += 20
                Annonce.suite -> score += 20
                Annonce.belotte -> score += 20
            }
        }
        return score
    }
}
