package com.bagih.intentexample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bagih.intentexample.ui.component.SecondPage
import com.bagih.intentexample.ui.theme.IntentExampleTheme

class SecondActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val extra_name = intent.getStringExtra(Intent.EXTRA_TEXT)
        setContent {
            IntentExampleTheme {
                extra_name?.let {
                    SecondPage(message = extra_name)
                }
            }
        }
    }
}