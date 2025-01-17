package com.app.studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val studentId = intent.getStringExtra("STUDENT_ID")
        val student = Database.students.find { it.id == studentId }

        if (student != null) {
            findViewById<TextView>(R.id.nameTextView).text = student.name
            findViewById<TextView>(R.id.idTextView).text = student.id
            findViewById<TextView>(R.id.phoneTextView).text = student.phone
            findViewById<TextView>(R.id.addressTextView).text = student.address

            findViewById<Button>(R.id.editButton).setOnClickListener {
                val intent = Intent(this, EditStudentActivity::class.java)
                intent.putExtra("STUDENT_ID", student.id)
                startActivity(intent)
            }

        }
    }
}