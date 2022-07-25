package com.example.excusesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.excusesapp.databinding.ExcuseItemBinding
import com.example.excusesapp.model.Excuses

class ExcusesAdapter (
    private val mExcusesList: MutableList<Excuses> = mutableListOf()
        ): RecyclerView.Adapter<MyViewHolder>(){
            fun setExcuses(excuses: MutableList<Excuses>) {
                mExcusesList.clear()
                mExcusesList.addAll(excuses)
                notifyDataSetChanged()
            }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyViewHolder =
        MyViewHolder(
            ExcuseItemBinding.inflate(
                LayoutInflater.from(parent.context ),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(mExcusesList[position])

    override fun getItemCount(): Int  = mExcusesList.size

}


class MyViewHolder(
    private val binding: ExcuseItemBinding
): RecyclerView.ViewHolder(binding.root){

    fun bind(excuses: Excuses){
        binding.excuseText.text = excuses.excuse
        binding.categoryText.text = excuses.category
    }
}