package com.example.gb_2_notes2.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gb_2_notes2.R;
import com.example.gb_2_notes2.domain.MockNotesRepository;
import com.example.gb_2_notes2.domain.Note;

import java.util.List;

public class NotesListFragment extends Fragment {

    public NotesListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        TextView id;
        TextView title;
        TextView date;
        ImageView image;

        List<Note> notes = new MockNotesRepository().getNotes();

        LinearLayout notesList = view.findViewById(R.id.notes_list);

        for (Note note : notes) {
            View itemView = LayoutInflater.from(requireContext())
                    .inflate(R.layout.note_item, notesList, false);

            itemView.setOnClickListener(v -> openNoteDetail(note));
            
            id = itemView.findViewById(R.id.note_item_id);
            title = itemView.findViewById(R.id.note_item_title);
            date = itemView.findViewById(R.id.note_item_date);
            image = itemView.findViewById(R.id.note_item_image);

            id.setText(String.valueOf(note.getId()));
            title.setText(note.getTitle());
            date.setText(note.getDate());

            Glide.with(image)
                    .load(note.getImageUrl())
                    .centerCrop()
                    .into(image);

            notesList.addView(itemView);
        }
    }

    private void openNoteDetail(Note note) {
        Toast.makeText(requireContext(), "Click!!!", Toast.LENGTH_SHORT).show();
/*
        if (noteClickListener != null) {
            noteClickListener.onNoteClicked(note);
        }
*/
    }
}