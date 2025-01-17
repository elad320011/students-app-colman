package com.app.studentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditStudentActivity : AppCompatActivity() {
    private lateinit var student: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val studentId = intent.getStringExtra("STUDENT_ID")
        student = Database.students.find { it.id == studentId }!!

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val idEditText = findViewById<EditText>(R.id.idEditText)
        val phoneEditText = findViewById<EditText>(R.id.phoneEditText)
        val addressEditText = findViewById<EditText>(R.id.addressEditText)

        // Populate fields
        nameEditText.setText(student.name)
        idEditText.setText(student.id)
        phoneEditText.setText(student.phone)
        addressEditText.setText(student.address)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            student.name = nameEditText.text.toString()
            student.id = idEditText.text.toString()
            student.phone = phoneEditText.text.toString()
            student.address = addressEditText.text.toString()
            finish()
        }

        findViewById<Button>(R.id.deleteButton).setOnClickListener {
            Database.students.remove(student)
            finish()
        }
        findViewById<Button>(R.id.backButton).setOnClickListener {
            finish()
        }

    }
}
