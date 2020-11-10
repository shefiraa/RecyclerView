package com.stematelshefira.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_grid_hero.view.*
import kotlinx.android.synthetic.main.item_row_hero.view.*
import kotlinx.android.synthetic.main.item_row_hero.view.img_item_photo as img_item_photo1

class GridHeroAdapter(private val listHero: ArrayList<Hero>): RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>(){
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, I: Int): GridViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_hero, viewGroup, false)
        return  GridViewHolder(view)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: GridHeroAdapter.GridViewHolder, position: Int) {
        holder.bind(listHero[position])
    }
    inner  class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(hero: Hero){
            with(itemView){
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(img_item_photo)

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(hero) }
            }
        }
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}