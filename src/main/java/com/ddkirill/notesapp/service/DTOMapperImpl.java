package com.ddkirill.notesapp.service;

import com.ddkirill.notesapp.dto.NoteView;
import com.ddkirill.notesapp.model.NoteEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DTOMapperImpl implements DTOMapper {

    @Override
    public NoteView toDTO(NoteEntity noteEntity) {
        return new NoteView(noteEntity.getId(), noteEntity.getNoteText(), noteEntity.getImageURL());
    }

    @Override
    public List<NoteView> noteEntityListToDTO(List<NoteEntity> noteEntityList) {
        LinkedList<NoteView> noteViewsList = new LinkedList<>();
        for (NoteEntity noteEntity : noteEntityList) {
            noteViewsList.add(new NoteView(noteEntity.getId(),noteEntity.getNoteText(), noteEntity.getImageURL()));
        }
        return noteViewsList;
    }
}
