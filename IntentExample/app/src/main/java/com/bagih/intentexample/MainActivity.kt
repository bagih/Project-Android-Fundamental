package com.bagih.intentexample

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bagih.intentexample.ui.component.MainPage
import com.bagih.intentexample.ui.theme.IntentExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage(onSecondActivityButtonClick = {
                        Intent(this, SecondActivity::class.java).also {
                            startActivity(it)
                        }
                    }) {
                        Intent(Intent.ACTION_MAIN).also {
                            it.`package` = "com.instagram.android"
                            try {
                                startActivity(it)
                            } catch (e: ActivityNotFoundException){
                                e.printStackTrace()
                            }
                        }
                    }
                }
            }
        }
    }
}