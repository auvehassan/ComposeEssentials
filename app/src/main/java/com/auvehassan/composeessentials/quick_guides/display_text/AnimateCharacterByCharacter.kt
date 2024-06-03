package com.auvehassan.composeessentials.quick_guides.display_text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import java.text.BreakIterator
import java.text.StringCharacterIterator

// Animate character-by-character the appearance of text:
// This code animates text character-by-character.
// It tracks an index to control how much of the text is revealed.
// The displayed text updates dynamically to show only the characters up to the current index.
// Finally, the variable runs the animation when it changes.

//  implementation(platform("androidx.compose:compose-bom:2024.05.00"))
//  implementation("androidx.compose.material3:material3")


@Composable
fun LetterByLetterAnimatedText() {
    val text = "This text animates as though it is being typed \uD83E\uDDDE\u200D♀\uFE0F \uD83D\uDD10  \uD83D\uDC69\u200D❤\uFE0F\u200D\uD83D\uDC68 \uD83D\uDC74\uD83C\uDFFD"

    // Iterate over the characters.
    val breakIterator = remember(text) { BreakIterator.getCharacterInstance() }

    // Define the duration (milliseconds) of the pause before each successive
    // character is displayed. These pauses between characters create the
    // illusion of an animation.
    val typingDelayInMs = 50L

    var substringText by remember {
        mutableStateOf("")
    }

    LaunchedEffect(text) {
        // Initial start delay of the typing animation
        delay(1000)
        breakIterator.text = StringCharacterIterator(text)

        var nextIndex = breakIterator.next()
        // Iterate over the string, by index boundary
        while (nextIndex != BreakIterator.DONE) {
            substringText = text.subSequence(0, nextIndex).toString()
            // Go to the next logical character boundary
            nextIndex = breakIterator.next()
            delay(typingDelayInMs)
        }
    }
    Text(substringText)
}