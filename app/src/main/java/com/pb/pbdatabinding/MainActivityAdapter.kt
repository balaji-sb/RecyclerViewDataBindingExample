package com.pb.pbdatabinding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pb.pbdatabinding.databinding.LayoutChildBinding

/**
 * Created by balaji on 20/12/20 5:36 PM
 */


class MainActivityAdapter : ListAdapter<User, MainActivityHolder>(MainDiffCallback()) {

    var data = arrayListOf<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int{
        return data.size
    }

    class MainDiffCallback : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.userName == newItem.userName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityHolder {
        return MainActivityHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MainActivityHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

}

class MainActivityHolder private constructor(private val binding: LayoutChildBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        binding.user = user
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): MainActivityHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            /*val view = layoutInflater
                .inflate(R.layout.layout_child, parent, false)*/

            val binding = LayoutChildBinding.inflate(layoutInflater, parent, false)
            return MainActivityHolder(binding)
        }
    }
}