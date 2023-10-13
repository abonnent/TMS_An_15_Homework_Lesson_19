import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import solutions.belov.tms_an_15_homework_lesson_19.Keys
import solutions.belov.tms_an_15_homework_lesson_19.databinding.ActivityAddNoteBinding
import java.text.SimpleDateFormat
import java.util.Date

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val title = binding.titleEdit.text.toString()
            val text = binding.textEdit.text.toString()
            val date = SimpleDateFormat("HH:mm:ss").format(Date())

            if (title.isNotBlank() && text.isNotBlank()) {
                val intent = Intent()
                intent.putExtra(Keys.KEY_TITLE, title)
                intent.putExtra(Keys.KEY_TEXT, text)
                intent.putExtra(Keys.KEY_DATE, date)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}
