package com.github.ilikeyourhat.fmnw.ui.screen.edit.group

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.ilikeyourhat.fmnw.model.Group
import com.github.ilikeyourhat.fmnw.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class) // Experimental my ass
@Composable
fun EditGroupScreen(
    state: EditGroupScreenState,
    events: EditGroupEvents = EditGroupEvents.DUMMY
) {
    AppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = events::onCloseClicked) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    title = {
                        val titleText = if (state.group.isPersisted()) {
                            "Edit group"
                        } else {
                            "Add new group"
                        }
                        Text(titleText)
                    }
                )
            },
            content = { padding ->
                Surface(modifier = Modifier.padding(padding)) {
                    Content(state, events)
                }
            }

        )
    }
}

@Composable
private fun Content(state: EditGroupScreenState, events: EditGroupEvents) {
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    ) {
        OutlinedTextField(
            value = state.group.name,
            label = { Text(text = "Name") },
            onValueChange = events::onNameChanged,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = events::onDoneClicked,
            content = {
                Text("Save")
            },
            modifier = Modifier.padding(top = 8.dp)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun AddCodeScreen_default() {
    EditGroupScreen(EditGroupScreenState())
}

@Preview
@Composable
fun AddCodeScreen_withBarcode() {
    EditGroupScreen(
        EditGroupScreenState(
            group = Group(
                name = "ABCDEF"
            )
        )
    )
}