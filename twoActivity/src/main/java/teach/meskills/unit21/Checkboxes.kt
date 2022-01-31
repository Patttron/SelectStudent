package teach.meskills.unit21

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

class Checkboxes : AppCompatActivity() {

    companion object {
        const val EXTRA = "Students"
    }

    private var btnOk: Button? = null
    var students = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkboxes)
        findViewById<CheckBox?>(R.id.Stas)
        findViewById<CheckBox?>(R.id.Alex)
        findViewById<CheckBox?>(R.id.Sasha)
        findViewById<CheckBox?>(R.id.Marina)
        findViewById<CheckBox?>(R.id.Nadezhda)
        findViewById<CheckBox?>(R.id.Natali)
        findViewById<CheckBox?>(R.id.Dasha)
        findViewById<CheckBox?>(R.id.Dima)
        findViewById<CheckBox?>(R.id.Egor)
        findViewById<CheckBox?>(R.id.Anton)
        findViewById<CheckBox?>(R.id.Nastya)
        btnOk = findViewById(R.id.btnOk)
        btnOk!!.setOnClickListener {
            sendResult()
        }
    }

    fun onCheckboxClick(view: View?) {
        val checkBox = view as CheckBox
        val checked = checkBox.isChecked
        when (view.id) {
            R.id.Stas -> if (checked) {
                students.add("Stas")
            } else {
                students.remove("Stas")
            }
            R.id.Alex -> if (checked) {
                students.add("Alex")
            } else {
                students.remove("Alex")
            }
            R.id.Sasha -> if (checked) {
                students.add("Sasha")
            } else {
                students.remove("Sasha")
            }
            R.id.Marina -> if (checked) {
                students.add("Marina")
            } else {
                students.remove("Marina")
            }
            R.id.Nadezhda -> if (checked) {
                students.add("Nadezhda")
            } else {
                students.remove("Nadezhda")
            }
            R.id.Natali -> if (checked) {
                students.add("Natasha")
            } else {
                students.remove("Natasha")
            }
            R.id.Dasha -> if (checked) {
                students.add("Dasha")
            } else {
                students.remove("Dasha")
            }
            R.id.Dima -> if (checked) {
                students.add("Dima")
            } else {
                students.remove("Dima")
            }
            R.id.Egor -> if (checked) {
                students.add("Egor")
            } else {
                students.remove("Egor")
            }
            R.id.Anton -> if (checked) {
                students.add("Anton")
            } else {
                students.remove("Anton")
            }
            R.id.Nastya -> if (checked) {
                students.add("Nastya")
            } else {
                students.remove("Nastya")
            }
        }
    }

    private fun sendResult() {
        setResult(RESULT_OK, Intent().apply {
            putExtra(EXTRA, students)
        })
        finish()
    }
}

