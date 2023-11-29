package com.example.roll_dice

import android.content.Context
import android.view.View
import android.widget.PopupMenu

object CustomPopupMenu {
    fun show(context: Context, anchor: View){
        val popupMenu = PopupMenu(context, anchor)
        popupMenu.inflate(R.menu.popup_menu)
        popupMenu.show()
    }
}