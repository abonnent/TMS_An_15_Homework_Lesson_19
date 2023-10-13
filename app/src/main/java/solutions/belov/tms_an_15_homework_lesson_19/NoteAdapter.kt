package solutions.belov.tms_an_15_homework_lesson_19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import solutions.belov.tms_an_15_homework_lesson_19.databinding.NoteItemBinding

class NoteAdapter(private val notes: List<Note>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var itemClickListener: OnNoteItemClickListener? = null

    fun setOnItemClickListener(listener: OnNoteItemClickListener) {
        itemClickListener = listener
    }

    inner class NoteViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = NoteItemBinding.bind(item)
        fun bind(note: Note) = with(binding) {
            noteTitle.text = note.title
            noteText.text = note.text
            noteDate.text = note.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(item)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)

        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(note)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}
