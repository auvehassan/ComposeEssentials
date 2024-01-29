package com.auvehassan.composeessentials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.auvehassan.composeessentials.ui.theme.ComposeEssentialsTheme
class BasicLayoutsInCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeEssentialsTheme {
                MyBasicLayoutsInComposeApp(Modifier.fillMaxSize())
            }
        }
    }

    @Composable
    fun MyBasicLayoutsInComposeApp(modifier: Modifier) {
        SearchBar(modifier)
    }

    @Composable
    fun SearchBar(
        modifier: Modifier = Modifier
    ) {
        TextField(
            value = "",
            onValueChange = {},

            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            },

            colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.surface),

            placeholder = {
                Text(stringResource(R.string.placeholder_search))
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
        )
    }
}