package com.github.ilikeyourhat.fmnw.ui.screen.edit.note

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
import com.github.ilikeyourhat.fmnw.model.Note
import com.github.ilikeyourhat.fmnw.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class) // Experimental my ass
@Composable
fun EditNoteScreen(
    state: EditNoteScreenState,
    events: EditNoteEvents = EditNoteEvents.DUMMY
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
                        val titleText = if (state.note.isPersisted()) {
                            "Edit note"
                        } else {
                            "Add new note"
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
private fun Content(state: EditNoteScreenState, events: EditNoteEvents) {
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    ) {
        OutlinedTextField(
            value = state.note.name,
            label = { Text(text = "Name") },
            onValueChange = events::onNameChanged,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = state.note.value,
            label = { Text(text = "Value") },
            onValueChange = events::onValueChanged,
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
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
    EditNoteScreen(EditNoteScreenState())
}

@Preview
@Composable
fun AddCodeScreen_withBarcode() {
    EditNoteScreen(
        EditNoteScreenState(
            note = Note(
                name = "Test",
                value = "ABCDEF"
            )
        )
    )
}