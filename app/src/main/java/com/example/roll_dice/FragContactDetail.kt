package com.example.roll_dice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.roll_dice.databinding.FragContactDetailBinding

class FragContactDetail : Fragment() {
    private lateinit var binding: FragContactDetailBinding
    private var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (it.containsKey("Contact")) {
                parseArgs(it)
            }
        }
    }

    private fun parseArgs(bundle: Bundle) {
        contact = bundle.getSerializable("Contact") as Contact
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragContactDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupToolbar()
        contact?.let {
            binding.img.text = contact!!.name[0].uppercase()
            binding.editTextName.setText(contact!!.name)
            binding.editTextEmail.setText(contact!!.email)
            binding.editTextPhoneNumber.setText(contact!!.phoneNumber)
        }

        if (contact == null){
            binding.img.visibility = View.GONE
        }

        binding.btnSave.setOnClickListener {
            handleClick()
        }
    }

    private fun handleClick() {
        val name = binding.editTextName.text.toString().trim()
        val phone = binding.editTextPhoneNumber.text.toString().trim()
        val email = binding.editTextEmail.text.toString().trim()
        if (contact == null){
            ContactList.addContact(
                Contact(
                    name,
                    phone,
                    email,
                )
            )
        }
        else {
            ContactList.update(Contact(
                name = name,
                phoneNumber = phone,
                email = email,
                id = contact!!.id
            ))
        }
        findNavController().popBackStack()
    }

    private fun setupToolbar() {
        binding.apply {
            toolbar.setNavigationIcon(R.drawable.ic_back_black)
            toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
            toolbarText.text = "Contact List"
        }
    }

}