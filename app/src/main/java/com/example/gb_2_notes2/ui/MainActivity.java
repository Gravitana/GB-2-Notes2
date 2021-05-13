package com.example.gb_2_notes2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.gb_2_notes2.R;
import com.example.gb_2_notes2.domain.Note;

public class MainActivity extends AppCompatActivity implements NotesListFragment.OnNoteListItemClickListener {

    private boolean isLandscape = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isLandscape = getResources().getBoolean(R.bool.isLandscape);

        initToolbar();
        initContent();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);

//        initDrawer(toolbar);

        toolbar.setTitle(R.string.app_title);

        toolbar.setOnMenuItemClickListener(item -> {
//            Toast.makeText(MainActivity.this, "Action!", Toast.LENGTH_SHORT).show();
            int id = item.getItemId();
            return menuItemClicked(id);
        });
    }

    private void initContent() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (isLandscape) {
            Fragment fragment = fragmentManager.findFragmentById(R.id.list_fragment);

            if (fragment == null) {
                fragmentManager.beginTransaction()
                        .replace(R.id.list_fragment, new NotesListFragment())
                        .commit();
            }
        } else {
            Fragment fragment = fragmentManager.findFragmentById(R.id.container);

            if (fragment == null) {
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new NotesListFragment())
                        .commit();
            }
        }
    }

    @Override
    public void onNoteListItemClicked(Note note) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (isLandscape) {
            fragmentManager.beginTransaction()
                    .replace(R.id.details_fragment, NoteDetailFragment.newInstance(note))
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, NoteDetailFragment.newInstance(note))
                    .addToBackStack(null)
                    .commit();
        }
    }

    private boolean menuItemClicked(int id) {
        if (id == R.id.action_new) {
            doToast(R.string.action_new);
            return true;
        }
        if (id == R.id.action_sort) {
            PopupMenu popupMenuSort = new PopupMenu(MainActivity.this, findViewById(R.id.action_sort));
            popupMenuSort.inflate(R.menu.notes_sort_menu);
            popupMenuSort.show();

            popupMenuSort.setOnMenuItemClickListener(item -> {
                int idSubItem = item.getItemId();
                return menuItemClicked(idSubItem);
            });

            return true;
        }
        if (id == R.id.action_sort_title) {
            doToast(R.string.action_sort_title);
            return true;
        }
        if (id == R.id.action_sort_date) {
            doToast(R.string.action_sort_date);
            return true;
        }
        if (id == R.id.action_settings) {
            doToast(R.string.action_settings);
            return true;
        }
        if (id == R.id.action_theme) {
            doToast(R.string.action_theme);
            return true;
        }
        if (id == R.id.action_account) {
            doToast(R.string.action_account);
            return true;
        }
        if (id == R.id.action_favorite) {
            doToast(R.string.action_favorite);
            return true;
        }
        if (id == R.id.action_backup) {
            doToast(R.string.action_backup);
            return true;
        }

        return false;
    }

    private void doToast(int action) {
        Toast.makeText(MainActivity.this, action, Toast.LENGTH_SHORT).show();
    }

}