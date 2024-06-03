package com.auvehassan.composeessentials.quick_guides.display_text

import android.util.Log
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

//Support multiple links in a single string of text

//  implementation(platform("androidx.compose:compose-bom:2024.05.00"))
//  implementation("androidx.compose.material3:material3")

// Uses the buildAnnotatedString function to create an annotated string of text.

// Uses the pushStringAnnotation() method to begin annotating the upcoming text with any necessary information, such as a URL string.

// Adds text using append(), and then uses the pop() method to halt the text annotation.

// To add more links, repeat the previous two steps by surrounding each link with the pushStringAnnotation()
// and pop() methods. This annotates the text handled by the onClick event.

// Creates a ClickableText component and uses the onClick parameter to manage user taps.
// Verify if there is a URL annotation linked to the text where you clicked. Then you can perform the click actions.

@Composable
fun AnnotatedClickableText() {
    val annotatedText = buildAnnotatedString {
        append("Go to ")

        // We attach this *URL* annotation to the following content until `pop()` is called.
        pushStringAnnotation(
            tag = "URL", annotation = "https://developer.android.com"
        )
        withStyle(
            style = SpanStyle(
                color = Color.Green, fontWeight = FontWeight.Bold
            )
        ) {
            append("Android Developers")
        }
        pop()

        append(" and check the ")

        pushStringAnnotation(
            tag = "URL", annotation = "https://developer.android.com/jetpack/compose"
        )
        withStyle(
            style = SpanStyle(
                color = Color.Blue, fontWeight = FontWeight.Bold
            )
        ) {
            append("Compose guidelines.")
        }
        pop()
    }

    ClickableText(text = annotatedText, onClick = { offset ->
        annotatedText.getStringAnnotations(
            tag = "URL", start = offset, end = offset
        ).firstOrNull()?.let { annotation ->
            // If yes, we log its value.
            Log.d("Clicked URL", annotation.item)
        }
    })
}