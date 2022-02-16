package com.oguzdogdu.cocktails.ui.maincocktails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.oguzdogdu.cocktails.databinding.CocktailRowBinding
import com.oguzdogdu.cocktails.domain.model.Cocktails

class CocktailAdapter : RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder>() {
    inner class CocktailViewHolder(private val binding: CocktailRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cocktails:Cocktails) {
            binding.apply {
                imgCocktail.load(cocktails.image) {
                    transformations(RoundedCornersTransformation(25f))
                }
                txtCocktailName.text = cocktails.title
                txtDescripcion.text = cocktails.description
            }
            binding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(cocktails)
                }
            }
        }
    }

    private var onItemClickListener: ((Cocktails) -> Unit)? = null

    fun setOnItemClickListener(listener: (Cocktails) -> Unit) {
        onItemClickListener = listener
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

    private val diffUtil = object : DiffUtil.ItemCallback<Cocktails>() {
        override fun areItemsTheSame(oldItem: Cocktails, newItem: Cocktails): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Cocktails, newItem: Cocktails): Boolean {
            return oldItem == newItem
        }
    }
    private val recyclerListDiffer = AsyncListDiffer(this, diffUtil)

    var drinks: List<Cocktails>
        get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)

    override fun getItemCount(): Int = drinks.size
}