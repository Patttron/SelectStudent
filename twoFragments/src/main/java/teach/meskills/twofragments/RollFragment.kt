package teach.meskills.twofragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.roll_activity.*
import kotlin.random.Random

class RollFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.roll_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        choose.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment1, RecyclerViewFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
        val viewModel = ViewModelProvider(
            requireActivity()
        ).get(CheckboxViewModel::class.java)
        roll.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(context, R.anim.animation)
            viewModel.students.observe(viewLifecycleOwner) { students ->
                if (students != null) {
                    result.startAnimation(anim)
                    val checkStudents = students.filter { it.isChecked }
                    if (checkStudents.isNotEmpty()) {
                        result.text = checkStudents[Random.nextInt(checkStudents.size)].name
                    } else {
                        result.text = "Choose some students"
                    }
                }
            }
        }
    }
}
