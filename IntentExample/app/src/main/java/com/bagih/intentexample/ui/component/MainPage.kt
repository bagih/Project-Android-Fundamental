package com.bagih.intentexample.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bagih.intentexample.R

@Composable
fun MainPage(onSecondActivityButtonClick: () -> Unit, onInstagramButtonClick: () -> Unit, onEmailButtonClick: () -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = onSecondActivityButtonClick) {
            Text(text = stringResource(id = R.string.goto_second_page_text_button))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onInstagramButtonClick) {
            Text(text = stringResource(id = R.string.main_page_open_instagram))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onEmailButtonClick) {
            Text(text = stringResource(id = R.string.main_page_compose_email))
        }
    }
}