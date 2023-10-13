package solutions.belov.tms_an_15_homework_lesson_19

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.note_title)
    val text: TextView = itemView.findViewById(R.id.note_text)
    val date: TextView = itemView.findViewById(R.id.note_date)
}