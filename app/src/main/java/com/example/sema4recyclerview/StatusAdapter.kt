package com.example.sema4recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class StatusAdapter: RecyclerView.Adapter<StatusView>(), StatusView.OnLikesIncrease {

    private val statusList = ArrayList<Status>()

    fun addStatus(newStatus: Status) {
        statusList.add(newStatus)
        notifyItemInserted(statusList.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusView {
        var inflater = LayoutInflater.from(parent.context)
        val row = inflater.inflate(R.layout.statusrow, parent, false)
        val statusView = StatusView(row)
        statusView.onLikesIncreaseListener = this
        return statusView
    }

    override fun onBindViewHolder(holder: StatusView, position: Int) {
        val status = statusList[position]
        holder.status = status
        holder.usernameRow.text = status.username
        holder.statusRow.text = status.statusDesc
        val day = status.date.get(Calendar.DAY_OF_MONTH)
        val month = status.date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
        val year = status.date.get(Calendar.YEAR)
        val date = "$day de $month de $year"
        holder.dateRow.text = date

        if(status.likes < 1) {
            holder.likesRow.text = "Sé el primero en dar Me gusta"
        } else {
            holder.likesRow.text = "A ${status.likes} personas les gusta esto"
        }
    }

    override fun getItemCount(): Int {
        return statusList.size
    }

    override fun onIncrease(status: Status) {
        status.likes++
        val index = statusList.indexOf(status)
        notifyItemChanged(index)
    }
}