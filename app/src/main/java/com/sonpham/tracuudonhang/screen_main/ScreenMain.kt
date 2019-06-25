package com.sonpham.tracuudonhang.screen_main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sonpham.tracuudonhang.R
import com.sonpham.tracuudonhang.dialogs.OrderSearchDialog
import kotlinx.android.synthetic.main.screen_main.*

class ScreenMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_main)
        main_screen_search.setOnClickListener {
            OrderSearchDialog.newInstance { shipmentID, company ->
                Toast.makeText(this, "$shipmentID ${company.name}", Toast.LENGTH_SHORT).show()
            }.show(supportFragmentManager, OrderSearchDialog.TAG)
        }
    }
}
