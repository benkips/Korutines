package com.mabnets.korutines.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mabnets.korutines.databinding.MyitemBinding
import com.mabnets.korutines.models.Quote

class Quotesadapter(private val quotez:List<Quote>):RecyclerView.Adapter<Quotesadapter.Quotesholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Quotesholder {
        val binding = MyitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Quotesholder(binding)
    }

    override fun getItemCount(): Int =quotez.size

    override fun onBindViewHolder(holder: Quotesholder, position: Int) {
      //  holder.binding.fnm.text= quotez[position].quotes.toString()
        with(holder){
            with(quotez[position]) {
                binding.fnm.text =quote
            }
        }
    }
    inner class Quotesholder(val binding: MyitemBinding):RecyclerView.ViewHolder(binding.root){}
}