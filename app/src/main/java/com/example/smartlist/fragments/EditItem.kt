package com.example.smartlist.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.smartlist.Item
import com.example.smartlist.ItemViewModel
import com.example.smartlist.R
import kotlinx.android.synthetic.main.fragment_edit_item.view.*

class EditItem : Fragment() {

    private val args by navArgs<EditItemArgs>()
    private lateinit var mUserViewModel: ItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_edit_item, container, false)
        mUserViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        view.editItemText.setText(args.currentItem.text)

        view.updatebutton.setOnClickListener{
            updateItem()
        }

        view.deletebutton.setOnClickListener{
            mUserViewModel.deleteItem(Item(args.currentItem.uid, args.currentItem.text, args.currentItem.checked))
            findNavController().navigate(R.id.action_editItem_to_listFragment)
        }

//        if (findNavController().popBackStack()) {
//            findNavController().navigate(R.id.action_editItem_to_listFragment)
//        }

        return view
    }


    private fun updateItem(){
        val itemText = view?.editItemText?.text.toString()

        if(inputCheck(itemText)){
            val updatedItem = Item(args.currentItem.uid, itemText, args.currentItem.checked)
            mUserViewModel.updateItem(updatedItem)
            findNavController().navigate(R.id.action_editItem_to_listFragment)
        }
        else{
            Toast.makeText(context, "Please don't leave the text field empty!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun inputCheck(text: String): Boolean{
        return !(TextUtils.isEmpty(text))
    }
}