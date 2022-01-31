package teach.meskills.unit21

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import teach.meskills.unit21.Checkboxes.Companion.EXTRA

import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var chosen: TextView

    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            val resultCode = activityResult.resultCode
            val data = activityResult.data
            if (resultCode == RESULT_OK) {
                val students = data?.getStringArrayListExtra(EXTRA)
                findViewById<Button>(R.id.roll).setOnClickListener {
                    if (students!!.isNotEmpty()) {
                        chosen.text = students?.get(Random.nextInt(students.size))
                    } else {
                        chosen.text = "Choose some student"
                    }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chosen = findViewById(R.id.chosen)
        findViewById<Button>(R.id.choose).setOnClickListener {
            getContent.launch(Intent(this, Checkboxes::class.java))
        }
        findViewById<Button>(R.id.roll).setOnClickListener {
            if (chosen.text.isEmpty()) {
                chosen.text = "Choose some student"
            }
        }
    }
}
