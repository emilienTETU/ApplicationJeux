package com.e.jeux.AddPlayerPage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.jeux.Constants.Constants
import com.e.jeux.Games.Belote.BeloteActivity
import com.e.jeux.Games.Default.DefaultActivity
import com.e.jeux.Games.Game10000.Game10000Activity
import com.e.jeux.Games.Ligretto.LigrettoActivity
import com.e.jeux.Games.Molkky.MolkkyActivity
import com.e.jeux.R
import com.e.jeux.WelcomePage.MainActivity
import kotlinx.android.synthetic.main.activity_add_player_page.*

class AddPlayerPageActivity : AppCompatActivity() {

    var arrayPlayer = ArrayList<String>()

    var gameTitle = "Game"
    var gameActivity = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_player_page)

        getIntentValue(intent)

        titleNameGame.text = gameTitle

        addPlayerButton.setOnClickListener {
            addPlayer(nameEditText.text.toString())
        }

        launchGameButton.setOnClickListener {
            startGameActivity(this,gameActivity)
        }

        rvAddPlayerPageActivity.layoutManager = LinearLayoutManager(this)
        rvAddPlayerPageActivity.adapter = AddPlayerRecyclerView(arrayPlayer, this, this)
    }

    private fun startGameActivity(context : Context,gameName : String){
        var intent = Intent(context,MainActivity::class.java)
        when(gameName){
            //Todo : Ajouter le intent
            Constants.game10000Activity -> {
                intent = Intent(context,Game10000Activity::class.java)
            }
            Constants.ligrettoActivity -> {
                intent = Intent(context,LigrettoActivity::class.java)
            }
            Constants.molkkyActivity -> {
                intent = Intent(context,MolkkyActivity::class.java)
            }
            Constants.defaultActivity -> {
                intent = Intent(context,DefaultActivity::class.java)
            }
            Constants.beloteActivity -> {
                intent = Intent(context,BeloteActivity::class.java)
            }
        }
        intent.putExtra("listPlayer",arrayPlayer)
        startActivity(intent)
    }

    private fun getIntentValue(intent: Intent){
        gameTitle = intent.getStringExtra("Game")
        gameActivity = intent.getStringExtra("Activity")
    }

    private fun addPlayer(name : String) : Boolean{
        arrayPlayer.add(name)
        rvAddPlayerPageActivity.adapter!!.notifyDataSetChanged()
        rvAddPlayerPageActivity.scrollToPosition(arrayPlayer.size-1)
        nameEditText.text.clear()
        return true
    }

    fun deletePlayer(name : String) : Boolean{
        arrayPlayer.remove(name)
        rvAddPlayerPageActivity.adapter!!.notifyDataSetChanged()
        return true
    }
}
