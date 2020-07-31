package com.e.jeux.Games.Default

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import com.e.jeux.Model.Player
import com.e.jeux.R
import kotlinx.android.synthetic.main.custom_victory.view.*

class DefaultScoreRecyclerView(var playerList : List<Player>, var context : Context) : Adapter<VictoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VictoryHolder {
        return VictoryHolder(LayoutInflater.from(context).inflate(
            R.layout.custom_victory,
            parent,
            false
        ))
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: VictoryHolder, position: Int) {
        if (position == 0){
            holder.background.background = context.getDrawable(
                context.resources.getIdentifier(
                    "background_button_orange",
                    "drawable",
                    context.packageName)
            )
        }
        else{
            holder.background.background = context.getDrawable(
                context.resources.getIdentifier(
                    "background_game_list",
                    "drawable",
                    context.packageName)
            )
        }
        holder.namePlayer.text = playerList[position].name
        holder.scorePlayer.text = "Score : "+playerList[position].score
    }

}

class VictoryHolder(v : View) : ViewHolder(v){
    var isOpen = false

    var namePlayer = v.rvNamePlayer
    var scorePlayer = v.rvScore
    var background = v.background_victory
}