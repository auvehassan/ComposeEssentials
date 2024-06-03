package com.auvehassan.composeessentials.quick_guides.display_text

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector

//Display pop-up messages or requests for user input:

//The Dialog component displays pop-up messages or requests user input on a layer above the main app content. It creates an interruptive UI experience to capture user attention.
//
//Among the use cases for a dialog are the following:
//
//Confirming user action, such as when deleting a file.
//Requesting user input, such as in a to-do list app.
//Presenting a list of options for user selection, like choosing a country in a profile setup.

//  implementation(platform("androidx.compose:compose-bom:2024.05.00"))
//

//Create an Alert dialog
//The AlertDialog composable provides a convenient API for creating a Material Design themed dialog.
//The following example implements two buttons in an alert dialog, one that dismisses the dialog, and another that confirms its request:



//AlertDialog has specific parameters for handling particular elements of the dialog. Among them are the following:
//
//title: The text that appears along the top of the dialog.
//text: The text that appears centered within the dialog.
//icon: The graphic that appears at the top of the dialog.
//onDismissRequest: The function called when the user dismisses the dialog, such as by tapping outside of it.
//dismissButton: A composable that serves as the dismiss button.
//confirmButton: A composable that serves as the confirm button.
//
//When the user clicks either of the buttons, the dialog closes. When the user clicks confirm, it calls a function that also handles the confirmation.
//In this example, those functions are onDismissRequest() and onConfirmRequest().
//
//In cases where your dialog requires a more complex set of buttons, you may benefit from using the Dialog composable
//and populating it in a more freeform manner.


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}

@Composable
fun DialogExamples() {
    // ...
    val openAlertDialog = remember { mutableStateOf(false) }

    // ...
    when {
        // ...
        openAlertDialog.value -> {
            AlertDialogExample(
                onDismissRequest = { openAlertDialog.value = false },
                onConfirmation = {
                    openAlertDialog.value = false
                    println("Confirmation registered") // Add logic here to handle confirmation.
                },
                dialogTitle = "Alert dialog example",
                dialogText = "This is an example of an alert dialog with buttons.",
                icon = Icons.Default.Info
            )
        }
    }
}





//Create a dialog
//Dialog is a basic composable that doesn't provide any styling or predefined slots for content.
//It is a straightforward container that you should populate with a container such as Card.
//The following are some of the key parameters of a dialog:
//
//onDismissRequest: The lambda called when the user closes the dialog.
//properties: An instance of DialogProperties that provides some additional scope for customization.

