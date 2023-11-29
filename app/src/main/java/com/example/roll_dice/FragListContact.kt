package com.example.roll_dice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.roll_dice.databinding.FragListContactBinding

class FragListContact : Fragment() {

    private lateinit var binding: FragListContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragListContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupToolbar()
//        for (i in 1 until 20) {
//            ContactList.addContact(Contact( "name $i", "012345678", "email $i"))
//        }
        val adapter = Adapter(ContactList.contacts) {
            openDetail(it)
        }
        binding.rcv.adapter = adapter
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_fragListContact_to_fragContactDetail)
        }
    }

    private fun setupToolbar() {
        binding.apply {
            toolbar.setNavigationIcon(R.drawable.ic_back_black)
            toolbar.setNavigationOnClickListener { activity?.onBackPressed() }
            toolbarText.text = "Contact List"
        }
    }

    private fun openDetail(contact: Contact) {
        findNavController().navigate(
            R.id.action_fragListContact_to_fragContactDetail, bundleOf(
                "Contact" to contact
            )
        )
    }

}