package com.e.jeux.WelcomePage

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import com.e.jeux.AddPlayerPage.AddPlayerPageActivity
import com.e.jeux.Model.GameDescriptionModel
import com.e.jeux.R
import kotlinx.android.synthetic.main.custom_item_game.view.*

class WelcomeRecyclerView(var gameList : List<GameDescriptionModel>, var context : Context) : Adapter<GameHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        return GameHolder(LayoutInflater.from(context).inflate(
            R.layout.custom_item_game,
            parent,
            false
        ))
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        holder.rvNameGame.text = gameList[position].name
        holder.rvComment.text = gameList[position].comment
        holder.rvArrow.setOnClickListener {
            if (!holder.isOpen){
                holder.rvArrow.background = context.resources.getDrawable(
                    context.resources.getIdentifier(
                        "arrow_up","drawable",context.packageName
                    ),
                    null
                )
                holder.rvComment.visibility = View.VISIBLE
                holder.rvLine.visibility = View.VISIBLE
                holder.isOpen = true
            }
            else{
                holder.rvArrow.background = context.resources.getDrawable(
                    context.resources.getIdentifier(
                        "arrow_down","drawable",context.packageName
                    ),
                    null
                )
                holder.rvComment.visibility = View.GONE
                holder.rvLine.visibility = View.GONE
                holder.isOpen = false
            }
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context,AddPlayerPageActivity::class.java)
            intent.putExtra("Game",gameList[position].name)
            intent.putExtra("Activity",gameList[position].activity)
            context.startActivity(intent)
        }
    }

}

class GameHolder(v : View) : ViewHolder(v){
    var isOpen = false

    var rvBackground = v.rvBackground
    var rvNameGame = v.rvNameGame
    var rvLine = v.rvLine
    var rvArrow = v.rvArrow
    var rvComment = v.rvComment
}