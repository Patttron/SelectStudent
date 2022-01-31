package teach.meskills.twofragments

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.findViewById<TextView>(R.id.nameStudent)
    val isCheck = itemView.findViewById<CheckBox>(R.id.checkboxStudent)

    fun change(student: Student) {
        name.text = student.name
        isCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            student.isChecked = isChecked
        }
        isCheck.isChecked = student.isChecked
    }
}