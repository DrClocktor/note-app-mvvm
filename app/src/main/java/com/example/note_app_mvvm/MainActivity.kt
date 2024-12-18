package com.example.note_app_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.note_app_mvvm.ui.theme.NoteappmvvmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteappmvvmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var titleText by remember {
                        mutableStateOf("")
                    }

                    var descriptionText by remember {
                        mutableStateOf("")
                    }

                    var checked by remember {
                        mutableStateOf(false)
                    }

                    var todos by remember {
                        mutableStateOf(mutableListOf("Take out trash"))
                    }

                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = "Todo app",
                            fontSize = 32.sp
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        TextField(
                            titleText,
                            label = { Text("Title") },
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange =  { textValue ->
                                titleText = textValue;
                        })

                        Spacer(modifier = Modifier.height(24.dp))

                        TextField(
                            descriptionText,
                            label = { Text("Description") },
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange =  { textValue ->
                                descriptionText = textValue;
                        })

                        Spacer(modifier = Modifier.height(24.dp))

                        Button(onClick = {

                        }) {
                            Text("Add todo")
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        HorizontalDivider(thickness = 2.dp)

                        Spacer(modifier = Modifier.height(24.dp))

                        Text("Number of todos: 10")

                        Spacer(modifier = Modifier.height(24.dp))

                        Text("Number of todos left: 4")

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(
                            text = "Todos",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        LazyColumn {
                            items(todos) { item ->
                                Row {
                                    Checkbox(
                                        checked = checked,
                                        onCheckedChange = { checked = it }
                                    )

                                    Spacer(modifier = Modifier.width(20.dp))

                                    Text("Take out trash")

                                    Spacer(modifier = Modifier.width(20.dp))

                                    Button(onClick = {
                                        println("Delete button pressed")
                                    }) {
                                        Text("Delete")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}




