package com.oguzdogdu.cocktails.ui.maincocktails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.oguzdogdu.cocktails.data.model.Drink
import com.oguzdogdu.cocktails.databinding.CocktailRowBinding

class CocktailAdapter : RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder>() {
    inner class CocktailViewHolder(private val binding: CocktailRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(drink: Drink) {
            binding.apply {
                imgCocktail.load(drink.image)
                txtCocktailName.text = drink.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        return CocktailViewHolder(
            CocktailRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        val drinkItems = drinks[position]
        holder.bind(drinkItems)
    }

    private val diffUtil = object : DiffUtil.ItemCallback<Drink>() {
        override fun areItemsTheSame(oldItem: Drink, newItem: Drink): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Drink, newItem: Drink): Boolean {
            return oldItem == newItem
        }
    }
    private val recyclerListDiffer = AsyncListDiffer(this, diffUtil)

    var drinks: List<Drink>
        get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)

    override fun getItemCount(): Int = drinks.size
}