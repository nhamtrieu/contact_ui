package com.example.roll_dice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roll_dice.databinding.ListContactBinding

class Adapter(private val contacts: List<Contact>, val callback: (contact: Contact) -> Unit) :
    RecyclerView.Adapter<Adapter.Holder>() {
    inner class Holder(private val binding: ListContactBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.root.setOnClickListener { callback.invoke(contacts[position]) }
            binding.root.setOnLongClickListener {
                CustomPopupMenu.show(binding.root.context, binding.popUp)
                true
            }

            binding.name.text = contacts[position].name
            binding.img.text = contacts[position].name[0].uppercase()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ListContactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }


}