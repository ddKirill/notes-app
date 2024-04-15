package com.ddkirill.notesapp.service;

import com.ddkirill.notesapp.config.StorageProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ImageHandler {

    private final NotesService notesService;
    private final StorageProperties storageProperties;

    public ImageHandler(NotesService notesService, StorageProperties storageProperties) {
        this.notesService = notesService;
        this.storageProperties = storageProperties;
    }

    public void saveImage(Integer noteId, MultipartFile file) throws IOException {
        File newFile = new File(storageProperties.getLocation(), file.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(newFile);

        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        notesService.addImageURL(noteId,storageProperties.getLocation() + "/" + file.getOriginalFilename());

    }
}
