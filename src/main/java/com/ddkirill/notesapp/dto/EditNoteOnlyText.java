package com.ddkirill.notesapp.dto;

import org.springframework.lang.NonNull;

public record EditNoteOnlyText(@NonNull String id, @NonNull String text) {

}
