package com.example.sema4recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult(), ::onResult)
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: StatusAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)

        statusRecycler.layoutManager = layoutManager
        statusRecycler.setHasFixedSize(true)

        adapter = StatusAdapter()
        statusRecycler.adapter = adapter

        floatingAddBtn.setOnClickListener {
            val intent = Intent(this, NewStatusActivity::class.java)
            launcher.launch(intent)
        }
    }

    private fun onResult(result: ActivityResult) {
        if (result.resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Not new status or invalid data", Toast.LENGTH_LONG).show()
        } else if (result.resultCode == RESULT_OK) {
            val data: Serializable? = result.data?.getSerializableExtra("newStatus")
            val newStatus: Status = data as Status
            adapter.addStatus(newStatus)
            Log.e(">>>", newStatus.username)
        }
    }
}