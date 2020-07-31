package com.e.jeux.AddPlayerPage

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import com.e.jeux.Model.GameDescriptionModel
import com.e.jeux.R
import kotlinx.android.synthetic.main.custom_item_game.view.*
import kotlinx.android.synthetic.main.custom_item_player.view.*

class AddPlayerRecyclerView(
    var playerList : List<String>,
    var context : Context,
    var activity : AddPlayerPageActivity
) : Adapter<PlayerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerHolder {
        return PlayerHolder(LayoutInflater.from(context).inflate(
            R.layout.custom_item_player,
            parent,
            false
        ))
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
        holder.namePlayer.text = playerList[position]
        holder.itemView.setOnClickListener {
            activity.deletePlayer(playerList[position])
        }
    }

}

class PlayerHolder(v : View) : ViewHolder(v){
    var isOpen = false

    var namePlayer = v.rvNamePlayer
}