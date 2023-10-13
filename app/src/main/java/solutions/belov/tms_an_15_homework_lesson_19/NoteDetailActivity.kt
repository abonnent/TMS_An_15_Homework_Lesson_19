import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import solutions.belov.tms_an_15_homework_lesson_19.Keys
import solutions.belov.tms_an_15_homework_lesson_19.databinding.ActivityNoteDetailBinding

class NoteDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        if (extras != null) {
            with(binding) {
                title.text = extras.getString(Keys.KEY_TITLE)
                text.text = extras.getString(Keys.KEY_TEXT)
            }
        }
    }
}
