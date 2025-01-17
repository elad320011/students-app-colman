package com.app.studentsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(
    private val students: List<Student>,
    private val onStudentClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.bind(student, onStudentClick)
    }

    override fun getItemCount(): Int = students.size

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val studentImage: ImageView = itemView.findViewById(R.id.studentImage)
        private val studentName: TextView = itemView.findViewById(R.id.studentName)
        private val studentId: TextView = itemView.findViewById(R.id.studentId)
        private val studentPhone: TextView = itemView.findViewById(R.id.studentPhone)
        private val studentAddress: TextView = itemView.findViewById(R.id.studentAddress)
        private val studentCheckBox: CheckBox = itemView.findViewById(R.id.studentCheckBox)

        fun bind(student: Student, onStudentClick: (Student) -> Unit) {
            studentName.text = student.name
            studentId.text = student.id
            studentPhone.text = student.phone
            studentAddress.text = student.address
            studentCheckBox.isChecked = student.isChecked

            // Toggle checkbox
            studentCheckBox.setOnCheckedChangeListener { _, isChecked ->
                student.isChecked = isChecked
            }

            // Handle row clicks
            itemView.setOnClickListener {
                onStudentClick(student)
            }

        }
    }
}
