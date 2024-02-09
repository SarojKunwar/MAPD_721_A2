package com.example.contentprovoderwithloader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contentprovoderwithloader.ui.theme.ContactManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContactManagerScreen()
                }
            }
        }
    }
}

@Composable
fun ContactManagerScreen() {
    var contactName by remember { mutableStateOf("") }
    var contactNumber by remember { mutableStateOf("") }
    var contacts by remember { mutableStateOf(emptyList<Contact>()) }

    Column(modifier = Modifier.padding(16.dp)) {
        // Input fields for contact name and number
        TextField(
            value = contactName,
            onValueChange = { contactName = it },
            label = { Text("Contact Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = contactNumber,
            onValueChange = { contactNumber = it },
            label = { Text("Contact Number") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Buttons to fetch contacts and add a new contact
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (contacts.isEmpty()) {
                        contacts = loadContacts() // Fetch contacts only if the list is empty
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Fetch Contacts")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    contacts += Contact(contactName, contactNumber)
                    // Clear input fields after adding contact
                    contactName = ""
                    contactNumber = ""
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Add Contact")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Contacts list
        LazyColumn {
            items(contacts) { contact ->
                ContactItem(contact)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        // About section
        Text("Student Name: Saroj Kunwar")
        Text("Student ID: 301365787")
    }
}

@Composable
fun ContactItem(contact: Contact) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${contact.name}: ${contact.number}",
            modifier = Modifier.padding(8.dp)
        )
    }
}

data class Contact(val name: String, val number: String)

fun loadContacts(): List<Contact> {
    return listOf(

    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ContactManagerTheme {
        ContactManagerScreen()
    }
}
