package solutions.belov.tms_an_15_homework_lesson_19

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import solutions.belov.tms_an_15_homework_lesson_19.databinding.ActivityAddNoteBinding
import solutions.belov.tms_an_15_homework_lesson_19.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        with(binding) {
            saveButton.setOnClickListener {
                val title = titleEdit.text.toString()
                val text = textEdit.text.toString()
                val sdf = SimpleDateFormat("HH:mm:ss")
                val date = sdf.format(Date()).toString()

                if (title.isNotBlank() && text.isNotBlank()) {
                    val intent = Intent()
                    intent.putExtra("title", title)
                    intent.putExtra("text", text)
                    intent.putExtra("date", date)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }
        }
    }
}