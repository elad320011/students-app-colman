package com.app.studentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val idEditText = findViewById<EditText>(R.id.idEditText)
        val phoneEditText = findViewById<EditText>(R.id.phoneEditText)
        val addressEditText = findViewById<EditText>(R.id.addressEditText)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            val name = nameEditText.text.toString()
            val id = idEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val address = addressEditText.text.toString()

            if (name.isNotEmpty() && id.isNotEmpty()) {
                Database.students.add(Student(id, name, phone, address))
                finish() // Go back to the previous screen
            }
        }

        findViewById<Button>(R.id.cancelButton).setOnClickListener {
            finish() // Go back to the previous screen without saving
        }
    }
}
