package com.e.jeux.Games.Belote

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import com.e.jeux.Model.Player
import com.e.jeux.R
import kotlinx.android.synthetic.main.activity_belote.*
import kotlinx.android.synthetic.main.custom_annonce_list.view.*
import kotlinx.android.synthetic.main.custom_victory.view.*
import kotlin.math.log

class BeloteAnnonceRecyclerView(
    var annonceList : List<String>,
    var context : Context,
    var side : Side,
    var activity: BeloteActivity
) : Adapter<AnnonceHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnonceHolder {
        return AnnonceHolder(LayoutInflater.from(context).inflate(
            R.layout.custom_annonce_list,
            parent,
            false
        ))
    }

    override fun getItemCount(): Int {
        return annonceList.size
    }

    override fun onBindViewHolder(holder: AnnonceHolder, position: Int) {
        holder.annonce.text = annonceList[position]
        holder.nbAnnonce.text = "x${holder.i}"
        holder.itemView.setOnClickListener {
            holder.i += 1
            holder.nbAnnonce.text = "x${holder.i}"
            if (side == Side.EUX){
                activity.annonceEux.add(annonceList[position])
                activity.rvListAnnonceEux.adapter?.notifyDataSetChanged()
            }
            else if (side == Side.NOUS){
                activity.annonceNous.add(annonceList[position])
                activity.rvlistAnnonceNous.adapter?.notifyDataSetChanged()
            }
        }
    }

}

class BeloteAnnonceDoneRecyclerView(
    var annonceListDone : List<String>,
    var context : Context,
    var side : Side,
    var activity: BeloteActivity
) : Adapter<AnnonceHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnonceHolder {
        return AnnonceHolder(LayoutInflater.from(context).inflate(
            R.layout.custom_annonce_list,
            parent,
            false
        ))
    }

    override fun getItemCount(): Int {
        return annonceListDone.size
    }

    override fun onBindViewHolder(holder: AnnonceHolder, position: Int) {
        holder.annonce.text = annonceListDone[position]
        holder.nbAnnonce.visibility = View.GONE
        holder.itemView.setOnClickListener {
            if (side == Side.EUX){
                activity.annonceEux.remove(annonceListDone[position])
                activity.rvListAnnonceEux.adapter?.notifyDataSetChanged()
            }
            else if (side == Side.NOUS){
                activity.annonceNous.remove(annonceListDone[position])
                activity.rvlistAnnonceNous.adapter?.notifyDataSetChanged()
            }
        }
    }

}

class AnnonceHolder(v : View) : ViewHolder(v){
    var i = 0
    var annonce = v.rvNameAnnonce
    var nbAnnonce = v.rvNbAnnonce
}