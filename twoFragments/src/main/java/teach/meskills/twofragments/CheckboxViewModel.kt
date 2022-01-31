package teach.meskills.twofragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CheckboxViewModel : ViewModel() {

    val students = MutableLiveData<List<Student>>()

    init {
        students.value = listOf(
            Student("Anton", false),
            Student("Stas", false),
            Student("Alex", false),
            Student("Marina", false),
            Student("Dasha", false),
            Student("Nastya", false),
            Student("Anna", false),
            Student("Egor", false),
            Student("Andrey", false),
            Student("Sasha", false),
            Student("Nadezhda", false),
            Student("Natasha", false),
            Student("Dima", false),
            Student("Yaroslav", false)
        )
    }

    fun onStudentClick(stud: Student) {
        students.value = students.value?.map {
            if (it.name == stud.name) {
                stud.copy(isChecked = stud.isChecked.not())
            } else {
                it
            }
        }
    }
}