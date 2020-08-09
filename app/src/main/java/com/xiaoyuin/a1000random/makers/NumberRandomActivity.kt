package com.xiaoyuin.a1000random.makers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xiaoyuin.a1000random.R
import com.xiaoyuin.a1000random.data.Maker

class NumberRandomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_random)
    }
}

class NumberRandomMaker: Maker("Random Number")