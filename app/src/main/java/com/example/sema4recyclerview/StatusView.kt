package com.example.sema4recyclerview

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StatusView(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var status: Status? = null
    var onLikesIncreaseListener: OnLikesIncrease? = null

    var usernameRow: TextView = itemView.findViewById(R.id.usernameTV)
    var statusRow: TextView = itemView.findViewById(R.id.statusTV)
    var dateRow: TextView = itemView.findViewById(R.id.dateTV)
    var likesRow: TextView = itemView.findViewById(R.id.likesTV)
    var likeBtn: ImageButton = itemView.findViewById(R.id.likeBtn)

    init {
        likeBtn.setOnClickListener {
            status?.let {
                onLikesIncreaseListener?.onIncrease(it)
            }
        }
    }

    interface OnLikesIncrease {
        fun onIncrease(status: Status)
    }
}