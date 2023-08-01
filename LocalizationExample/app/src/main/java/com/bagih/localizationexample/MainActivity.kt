package com.bagih.localizationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import com.bagih.localizationexample.ui.theme.LocalizationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocalizationExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomePage()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LocalizationExampleTheme {
        HomePage()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyPage(modifier: Modifier = Modifier) {
    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding() + 8.dp,
                    end = paddingValues.calculateEndPadding(layoutDirection = LayoutDirection.Ltr) + 8.dp,
                    bottom = paddingValues.calculateBottomPadding() + 8.dp,
                    start = paddingValues.calculateStartPadding(layoutDirection = LayoutDirection.Ltr) + 8.dp

                )
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.title),
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize
            )
            Spacer(modifier = modifier.height(16.dp))
            AsyncImage(
                model = R.drawable.benang_kelambu,
                contentDescription = stringResource(id = R.string.title),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),

            )
            Spacer(modifier = Modifier.height(16.dp))
            TextBody(content = stringResource(id = R.string.description_p1))
            Spacer(modifier = Modifier.height(8.dp))
            TextBody(content = stringResource(id = R.string.description_p2))
            Spacer(modifier = Modifier.height(8.dp))
            TextBody(content = stringResource(id = R.string.description_p3))
        }
    }
}

@Composable
fun TextBody(modifier: Modifier = Modifier, content: String) {
    Text(
        text = content,
        textAlign = TextAlign.Justify,
        modifier = modifier.padding(horizontal = 8.dp)
    )
}

@Composable
fun HomePage() {
    BodyPage()
}