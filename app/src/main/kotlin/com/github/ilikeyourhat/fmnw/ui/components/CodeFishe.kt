package com.github.ilikeyourhat.fmnw.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.ilikeyourhat.fmnw.ui.core.theme.AppTheme
import com.github.ilikeyourhat.fmnw.ui.core.theme.primaryLight

@Composable
fun CodeFiche(
    headline: String,
    text: String,
    modifier: Modifier = Modifier,
    onDeleteClicked: () -> Unit = {}
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        border = BorderStroke(2.dp, primaryLight),
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = headline,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            end = 8.dp,
                            top = 8.dp
                        )
                )
                Text(
                    text = text,
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            end = 8.dp,
                            bottom = 8.dp
                        )
                )
            }
            var expanded by remember { mutableStateOf(false) }
            IconButton(
                onClick = { expanded = true }
            ) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "")
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        leadingIcon = {
                            Icon(imageVector = Icons.Filled.Delete, contentDescription = "")
                        },
                        text = {  Text("Delete") },
                        onClick = {
                            onDeleteClicked()
                            expanded = false
                        }
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun CodeFiche_default() {
    AppTheme {
        CodeFiche(
            headline = "Headline",
            text = "My secret code"
        )
    }
}

@Preview
@Composable
fun CodeFiche_long() {
    AppTheme {
        CodeFiche(
            headline = "Headline",
            text = "My secret code",
            modifier = Modifier.width(200.dp)
        )
    }
}