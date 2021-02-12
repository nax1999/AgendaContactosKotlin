package com.example.contactos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun addContact(view: View) {
        val Nombre: EditText = findViewById(R.id.idNombre)
        val Numero: EditText = findViewById(R.id.idTelefono)
        val Correo: EditText = findViewById(R.id.idCorreo)
        val name: String = Nombre.text.toString()
        val numero = Numero.text.toString()
        val correo = Correo.text.toString()
        val intent = Intent(ContactsContract.Intents.Insert.ACTION)
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE)
        intent.putExtra(ContactsContract.Intents.Insert.NAME, name)
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, numero)
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, correo)
        startActivityForResult(intent, 1)
    }
    override fun onActivityResult(
            requestCode: Int,
            resultCode: Int,
            intent: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Contacto agregado", Toast.LENGTH_SHORT).show()
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Contacto cancelado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}