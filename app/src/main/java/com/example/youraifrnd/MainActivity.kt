package com.example.youraifrnd

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.core.content.ContextCompat
import com.example.youraifrnd.ui.theme.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YourAiFrndTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(backgroundColor = greenColor,
                                title = {
                                    Text(
                                        text = "S.A Engineering College",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center,
                                        color = Color.White
                                    )
                                }
                            )
                        }
                    ) {
                        customChromeTab()
                    }
                }
            }
        }
    }
}

@Composable
fun customChromeTab() {
    val ctx = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = greenColor),

            onClick = {
                openTab(ctx)

            })
        {
            Text(text = "Open Ai Chat Bot", modifier = Modifier.padding(8.dp))

        }
        Text(text = "*Hereby Presenting Our Mini Project", color = Color.LightGray)
    }
}

fun openTab(context: Context) {

    val package_name = "com.android.chrome"
    val URL = "https://gemini-flash-chatbot.vercel.app/"  //for more info refer the git : https://github.com/Harish-Srinivas-07/Gemini-chatBot
    val activity = (context as? Activity)
    val builder = CustomTabsIntent.Builder()
    builder.setShowTitle(true)
    builder.setInstantAppsEnabled(true)
    builder.setToolbarColor(ContextCompat.getColor(context, R.color.white))
    val customBuilder = builder.build()
    if (package_name != null) {
        customBuilder.intent.setPackage(package_name)
        customBuilder.launchUrl(context, Uri.parse(URL))
    } else {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(URL))
        activity?.startActivity(i)
    }

}

@Preview(name="Homepage",showBackground = true, showSystemUi = true)
@Composable
fun AiPreview() {
    YourAiFrndTheme {
        customChromeTab()
    }
}
