/*
 * Copyright 2023 The Android Open Source Project
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

package com.auvehassan.composeessentials.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ComponentsScreen(
    navigate: (TopComponentsDestination) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
//        items(TopComponentsDestination.entries) { destination ->

        items(TopComponentsDestination.values()) { destination ->
            NavigationItem(destination) {
                navigate(
                    destination
                )
            }
        }
    }
}

@Composable
fun NavigationItem(destination: TopComponentsDestination, onClick: () -> Unit) {
    Button(
        onClick = { onClick() }
    ) {
        Text(destination.title)
    }
}

// Enum class for compose components navigation screen.
enum class TopComponentsDestination(val route: String, val title: String) {
    CardExamples("cardExamples", "Card"),
    SwitchExamples("switchExamples", "Switch"),
    SliderExamples("sliderExamples", "Slider"),
    DialogExamples("dialogExamples", "Dialog"),
    ChipExamples("chipExamples", "Chip"),
    FloatingActionButtonExamples("floatingActionButtonExamples", "Floating Action Button"),
    ButtonExamples("buttonExamples", "Button"),
    ProgressIndicatorExamples("progressIndicatorExamples", "Progress Indicators"),
    ScaffoldExample("scaffoldExample", "Scaffold"),
    AppBarExamples("appBarExamples", "App bars"),
    CheckboxExamples("checkboxExamples", "Checkbox"),
    DividerExamples("dividerExamples", "Dividers"),
    BadgeExamples("badgeExamples", "Badges"),
}
