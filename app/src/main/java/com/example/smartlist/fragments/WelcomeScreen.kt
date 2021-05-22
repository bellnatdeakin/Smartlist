package com.example.smartlist.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.smartlist.R
import kotlinx.android.synthetic.main.fragment_welcomescreen.view.*
import androidx.navigation.fragment.findNavController
import com.example.smartlist.Item
import com.example.smartlist.ItemViewModel
import kotlinx.android.synthetic.main.fragment_dialog.view.*

class WelcomeScreen : Fragment() {

    private lateinit var mUserViewModel: ItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcomescreen, container, false)
        mUserViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        view.gotonextbutton.setOnClickListener{
            findNavController().navigate(R.id.action_welcomescreen_to_listFragment)
        }

        view.addtextbutton.setOnClickListener{
            val mDialogView = LayoutInflater.from(context).inflate(R.layout.fragment_dialog, null)
            val mBuilder = AlertDialog.Builder(context)
                .setView(mDialogView)
            val mAlertDialog = mBuilder.show()

            mDialogView.dialog_button.setOnClickListener{
                mAlertDialog.dismiss()
                val text = mDialogView.eT.text.toString()
                mUserViewModel.addItem(Item(0, text, false))
                Toast.makeText(requireContext(), "Added $text", Toast.LENGTH_LONG).show()
            }
        }


        return view
    }

}