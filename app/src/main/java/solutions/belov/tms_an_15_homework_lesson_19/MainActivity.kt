package solutions.belov.tms_an_15_homework_lesson_19

import AddNoteActivity
import NoteDetailActivity
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import solutions.belov.tms_an_15_homework_lesson_19.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val notes = mutableListOf<Note>()
    private var adapter = NoteAdapter(notes)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddNoteActivity::class.java)
            startActivityForResult(intent, 1)
        }

        adapter.setOnItemClickListener(object : OnNoteItemClickListener {
            override fun onItemClick(note: Note) {
                val intent = Intent(this@MainActivity, NoteDetailActivity::class.java)
                intent.putExtra(Keys.KEY_TITLE, note.title)
                intent.putExtra(Keys.KEY_TEXT, note.text)
                startActivity(intent)
            }
        })

        with(binding) {
            recyclerView.isVisible = false
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter
            recyclerView.addItemDecoration(SpaceItemDecoration(16))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            data?.extras?.let {
                val title = it.getString(Keys.KEY_TITLE, "")
                val text = it.getString(Keys.KEY_TEXT, "")
                val date = it.getString(Keys.KEY_DATE, "")
                notes.add(Note(title, text, date))
                adapter.notifyDataSetChanged()
            }
        }
    }
}
