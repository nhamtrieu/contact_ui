package com.example.roll_dice

object ContactList {
    val contacts = mutableListOf<Contact>()

    fun addContact(contact: Contact){
        if (contacts.contains(contact)){
            return;
        }
        contacts.add(contact)
    }

    fun update(contact: Contact) {
        val exist = contacts.first { it.id == contact.id }
        contacts.remove(exist)
        contacts.add(contact)
    }
}