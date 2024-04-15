package com.ddkirill.notesapp.controller;

import com.ddkirill.notesapp.dto.EditNoteOnlyText;
import com.ddkirill.notesapp.dto.NewNoteOnlyText;
import com.ddkirill.notesapp.dto.NoteView;
import com.ddkirill.notesapp.model.NoteEntity;
import com.ddkirill.notesapp.service.DTOMapper;
import com.ddkirill.notesapp.service.ImageHandler;
import com.ddkirill.notesapp.service.NotesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class NotesController {

    private final DTOMapper dtoMapper;
    private final NotesService notesService;
    private final ImageHandler imageHandler;

    public NotesController(DTOMapper dtoMapper, NotesService notesService, ImageHandler imageHandler) {
        this.dtoMapper = dtoMapper;
        this.notesService = notesService;
        this.imageHandler = imageHandler;
    }

    /***
     *
     * @return
     */
    @GetMapping("/all")
    public List<NoteView> getAll() {
        List<NoteEntity> allNotesEntityList = notesService.getAllNotes();
        return dtoMapper.noteEntityListToDTO(allNotesEntityList);
    }

    @DeleteMapping(value = "/delete/{noteId:\\d+}")
    public String deleteNote(@PathVariable String noteId) {
        notesService.deleteNote(Integer.valueOf(noteId));
        return new String("Notes is deleted!");
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addNote(@RequestBody NewNoteOnlyText newNoteOnlyText) {
        notesService.addNewNotesOnlyText(newNoteOnlyText.text());
        return new String("Note is added!");
    }

    @PostMapping(value = "/edit/{noteId:\\d+}")
    @ResponseStatus(HttpStatus.CREATED)
    public String editNote(@PathVariable String noteId, @RequestBody EditNoteOnlyText editNoteOnlyText) {
        notesService.editTextNote(Integer.valueOf(noteId),editNoteOnlyText.text());
        return new String("Note # " + noteId + "is editing!");
    }

    @PostMapping(value = "/addImage/{noteId:\\d+}")
    @ResponseBody
    public String addImageToNote(@PathVariable String noteId, @RequestParam("file") MultipartFile file ) throws IOException {
        imageHandler.saveImage(Integer.valueOf(noteId),file);
        return new String("Image added!");
    }
}
