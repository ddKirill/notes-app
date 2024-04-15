package com.ddkirill.notesapp.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

import java.util.Objects;

@Table(value = "notes")
public class NoteEntity {

    @Id
    @Column(value = "id")
    private Integer id;
    @Column(value = "note_text")
    private String noteText;
    @Column(value = "image_url")
    private String imageURL;

    public NoteEntity(Integer id, @NonNull String noteText, String imageURL) {
        this.id = id;
        this.noteText = noteText;
        this.imageURL = imageURL;
    }

    public Integer getId() {
        return id;
    }

    @NonNull
    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(@NonNull String noteText) {
        this.noteText = noteText;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteEntity that = (NoteEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "id=" + id +
                ", noteText='" + noteText + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
