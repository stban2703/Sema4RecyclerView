package com.example.sema4recyclerview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_status.*
import java.util.*

class NewStatusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_status)

        sendBtn.setOnClickListener {

            if(usernameET.text.isNotEmpty() && statusET.text.isNotEmpty()) {
                val id = UUID.randomUUID().toString()
                val username = usernameET.text.toString()
                val statusDesc = statusET.text.toString()
                val date = Calendar.getInstance()
                val likes = 0
                val newStatus = Status(id, username, statusDesc, date, likes)
                val intent = Intent().apply {
                    putExtra("newStatus", newStatus)
                }
                setResult(Activity.RESULT_OK, intent)
            } else {
                setResult(Activity.RESULT_CANCELED)
            }
            finish()
        }
    }
}