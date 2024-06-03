/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.auvehassan.composeessentials

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.auvehassan.composeessentials.components.BadgeExample
import com.auvehassan.composeessentials.components.ButtonExamples
import com.auvehassan.composeessentials.components.CardExamples
import com.auvehassan.composeessentials.components.CheckboxExamples
import com.auvehassan.composeessentials.components.ChipExamples
import com.auvehassan.composeessentials.components.DialogExamples
import com.auvehassan.composeessentials.components.DividerExamples
import com.auvehassan.composeessentials.components.FloatingActionButtonExamples
import com.auvehassan.composeessentials.components.ProgressIndicatorExamples
import com.auvehassan.composeessentials.components.ScaffoldExample
import com.auvehassan.composeessentials.components.SliderExamples
import com.auvehassan.composeessentials.components.SwitchExamples
import com.auvehassan.composeessentials.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    Surface(modifier, color = MaterialTheme.colorScheme.background) {
        var showItemOnClick by rememberSaveable { mutableIntStateOf(-1) }
        if (showItemOnClick == 0){
            ListsComponents()
        }else if (showItemOnClick == 1){
            ScaffoldExample()
        }else {
            LazyColumn {
                item {
                    Button(
                        modifier = Modifier.padding(vertical = 24.dp),
                        onClick = { showItemOnClick = 0 }
                    ) {
                        Text("Components")
                    }
                }
                item {
                    Button(
                        modifier = Modifier.padding(vertical = 24.dp),
                        onClick = { showItemOnClick = 1}
                    ) {
                        Text("LazyLists")
                    }
                }
            }
        }
    }
}


@Composable
private fun ListsComponents() {
    // [START android_compose_layouts_lazy_column_basic]
    LazyColumn {
        // Add a single item
        item {
            BadgeExample()
        }
        item {
            ButtonExamples()
        }
        item {
            CardExamples()
        }
        item {
            CheckboxExamples()
        }
        item {
            ChipExamples()
        }
        item {
            DialogExamples()
        }
        item {
            DividerExamples()
        }
        item {
            FloatingActionButtonExamples()
        }
        item {
            ProgressIndicatorExamples()
        }
        item {
            SliderExamples()
        }
        item {
            SliderExamples()
        }
        item {
            SwitchExamples()
        }
    }
    // [END android_compose_layouts_lazy_column_basic]
}

@Composable
private fun Greeting(name: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

@Composable
private fun CardContent(name: String) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello, ")
            Text(
                text = name, style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanded) {
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Filled.ExpandLess else Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    BasicsCodelabTheme {
    }
}

@Preview
@Composable
fun MyAppPreview() {
    BasicsCodelabTheme {
        MyApp(Modifier.fillMaxSize())
    }
}