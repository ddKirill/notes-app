package com.ddkirill.notesapp.service;

import com.ddkirill.notesapp.model.NoteEntity;
import com.ddkirill.notesapp.repository.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    private final NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }


    public List<NoteEntity> getAllNotes() {

        Iterable<NoteEntity> notesEntityIterable = notesRepository.findAll();
        LinkedList<NoteEntity> notesViewLinkedList = new LinkedList<>();

        for (NoteEntity noteEntity : notesEntityIterable) {
            NoteEntity notesView = new NoteEntity(noteEntity.getId(), noteEntity.getNoteText(),noteEntity.getImageURL());
            notesViewLinkedList.add(notesView);
        }
        return notesViewLinkedList;
    }

    public void deleteNote(Integer id) {
        notesRepository.deleteById(id);
    }


    public void addNewNotesOnlyText(String textNotes) {
        notesRepository.save(new NoteEntity(null,textNotes,null));
    }


    public void editTextNote(Integer noteId, String newText) {
        NoteEntity noteEntity = findNoteById(noteId);
        noteEntity.setNoteText(newText);
        notesRepository.save(noteEntity);
    }


    public void addImageURL(Integer noteId, String imageURL) {
        NoteEntity noteEntity = findNoteById(noteId);
        noteEntity.setImageURL(imageURL);
        notesRepository.save(noteEntity);
    }

    private NoteEntity findNoteById(Integer id) {
        Optional<NoteEntity> optionalNoteEntity = notesRepository.findById(id);
        return optionalNoteEntity.orElse(null);
    }

}
