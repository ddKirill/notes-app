package com.ddkirill.notesapp.service;

import com.ddkirill.notesapp.dto.NoteView;
import com.ddkirill.notesapp.model.NoteEntity;

import java.util.List;

public interface DTOMapper {

    NoteView toDTO(NoteEntity noteEntity);

    List<NoteView> noteEntityListToDTO(List<NoteEntity> noteEntityList);
}
