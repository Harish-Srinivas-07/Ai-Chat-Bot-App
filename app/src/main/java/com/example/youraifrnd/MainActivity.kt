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
                // on below line we are specifying background color for our application
                Surface(
                    // on below line we are specifying modifier and color for our app
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    // on below line we are specifying theme as scaffold.
                    Scaffold(

                        // in scaffold we are specifying top bar.
                        topBar = {

                            // inside top bar we are specifying background color.
                            TopAppBar(backgroundColor = greenColor,
                                title = {
                                    Text(
                                        text = "Mahalakshmi College of Arts & Science",
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

// on below line we are creating a
// function as custom Chrome Tabs.
@Composable
fun customChromeTab() {
    // on below line we are creating a
    // variable for getting context.
    val ctx = LocalContext.current

    // on below line we are creating a column
    Column(
        // inside this column we are specifying modifier
        // to column as max size, max height and ,max width.
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),

        // on below line we are adding vertical
        // arrangement and horizontal alignment.
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // on the below line we are creating a button.
        Button(

            // on below line we are adding modifier to our button
            // for adding max width and adding padding to button
            // from all sides.
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),

            // on below line we are adding color for our button.
            colors = ButtonDefaults.buttonColors(backgroundColor = greenColor),

            // on below line we are adding on click for our button.
            onClick = {

                // on below line we are creating an open tab method
                // to open our custom chrome tabs.
                openTab(ctx)

            })
        // on the below line we are creating
        // a text for our button
        // and adding padding to our text.
        {
            Text(text = "Open Ai Chat Bot", modifier = Modifier.padding(8.dp))

        }
        Text(text = "*Hereby Presenting Our Mini Project", color = Color.LightGray)
    }
}

// on below line we are creating a function to open custom chrome tabs.
fun openTab(context: Context) {
    // on below line we are creating a variable for
    // package name and specifying package name as
    // package of chrome application.
    val package_name = "com.android.chrome"

    // on below line we are creating a variable for
    // our URL which we have to open in chrome tabs
    val URL = "https://tinyurl.com/openai-chatbot"

    // on below line we are creating a variable
    // for the activity and initializing it.
    val activity = (context as? Activity)

    // on below line we are creating a variable for
    // our builder and initializing it with
    // custom tabs intent
    val builder = CustomTabsIntent.Builder()

    // on below line we are setting show title
    // to true to display the title for
    // our chrome tabs.
    builder.setShowTitle(true)

    // on below line we are enabling instant
    // app to open if it is available.
    builder.setInstantAppsEnabled(true)

    // on below line we are setting tool bar color for our custom chrome tabs.
    builder.setToolbarColor(ContextCompat.getColor(context, R.color.white))

    // on below line we are creating a
    // variable to build our builder.
    val customBuilder = builder.build()

    // on below line we are checking if the package name is null or not.
    if (package_name != null) {
        // on below line if package name is not null
        // we are setting package name for our intent.
        customBuilder.intent.setPackage(package_name)

        // on below line we are calling launch url method
        // and passing url to it on below line.
        customBuilder.launchUrl(context, Uri.parse(URL))
    } else {
        // this method will be called if the
        // chrome is not present in user device.
        // in this case we are simply passing URL
        // within intent to open it.
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(URL))

        // on below line we are calling start
        // activity to start the activity.
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
