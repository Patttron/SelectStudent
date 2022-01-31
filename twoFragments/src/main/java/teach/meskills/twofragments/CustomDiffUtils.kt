package teach.meskills.twofragments

import androidx.recyclerview.widget.DiffUtil

class CustomDiffUtils : DiffUtil.ItemCallback<Student>() {
    override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
        return oldItem == newItem
    }
}