package solutions.belov.tms_an_15_homework_lesson_19

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
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

        init()

        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddNoteActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    private fun init() {
        with(binding) {
            recyclerView.isVisible = false
            if (adapter.itemCount > 0) {
                noNotes.isVisible = false
                recyclerView.isVisible = true
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.adapter = adapter

                recyclerView.addItemDecoration(
                    DividerItemDecoration(
                        this@MainActivity,
                        LinearLayoutManager.VERTICAL
                    )
                )
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            data?.extras?.let {
                val title = it.getString("title").toString()
                val text = it.getString("text").toString()
                val date = it.getString("date").toString()
                notes.add(Note(title, text, date))

                Log.d("ZZZ", notes.toString())
                adapter.notifyDataSetChanged()

                init()
            }
        }
    }
}