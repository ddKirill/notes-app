package com.ddkirill.notesapp.repository;

import com.ddkirill.notesapp.model.NoteEntity;
import org.springframework.data.repository.CrudRepository;

public interface NotesRepository extends CrudRepository<NoteEntity, Integer> {


}
