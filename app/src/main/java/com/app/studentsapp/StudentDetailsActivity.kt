package com.app.studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.CheckBox
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
            findViewById<CheckBox>(R.id.checkedCheckBox).isChecked = student.isChecked

            findViewById<Button>(R.id.editButton).setOnClickListener {
                val intent = Intent(this, EditStudentActivity::class.java)
                intent.putExtra("STUDENT_ID", student.id)
                startActivity(intent)
                finish() // Close the current activity to refresh on return
            }

            findViewById<Button>(R.id.backButton).setOnClickListener {
                finish()
            }
        }
    }
}
