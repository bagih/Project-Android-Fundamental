package com.bagih.intentexample

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bagih.intentexample.presentation.ImageViewModel
import com.bagih.intentexample.ui.component.MainPage
import com.bagih.intentexample.ui.theme.IntentExampleTheme

class MainActivity : ComponentActivity() {

    private val imageViewModel by viewModels<ImageViewModel>()

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
                        Intent(this, SecondActivity::class.java).apply {
                            putExtra(Intent.EXTRA_TEXT, "pesan dari MainActivity")
                        }.also {
                            startActivity(it)
                        }
                    },
                        onInstagramButtonClick = {
                            Intent(Intent.ACTION_MAIN).also {
                                it.`package` = "com.instagram.android"
                                try {
                                    startActivity(it)
                                } catch (e: ActivityNotFoundException) {
                                    e.printStackTrace()
                                }
                            }
                        }) {
                        val emailIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_EMAIL, arrayOf("bagih@bagih.com"))
                            putExtra(Intent.EXTRA_TEXT, getString(R.string.text_email))
                            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject))
                        }

                        intent.resolveActivity(packageManager)?.let {
                            startActivity(emailIntent)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                imageViewModel.imageUri?.let {
                    Text(text = "Uri for selected image is: $it")
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val uri = intent?.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
        imageViewModel.updateUri(uri)
    }
}