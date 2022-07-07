package com.example.ex_coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex_coroutines.coroutinecontext.TestDispatchers
import com.example.ex_coroutines.coroutinecontext.TestWithContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TestDispatchers.runMyFirstCoroutines()

        //TestWithContext.testMyFirstWithContextFunc()
        TestWithContext.testMySecondWithContextFunc()
    }
}