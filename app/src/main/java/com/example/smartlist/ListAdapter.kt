package com.example.smartlist

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.list_item.view.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.smartlist.fragments.ListFragment
import com.example.smartlist.fragments.ListFragmentDirections

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var itemList = emptyList<Item>()
    private lateinit var mUserViewModel: ItemViewModel

    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    // Gets the number of items in the list
    override fun getItemCount(): Int {
        return itemList.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    // Binds each item in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.view.item.text = currentItem.text
        holder.view.item.isChecked = currentItem.checked
        holder.view.item.id = currentItem.uid

        holder.view.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToEditItem(currentItem)
            holder.view.findNavController().navigate(action)
        }
    }

    fun setData(item: List<Item>){
        this.itemList = item
        notifyDataSetChanged()
    }

}

