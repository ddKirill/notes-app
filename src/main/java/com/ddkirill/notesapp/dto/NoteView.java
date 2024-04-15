package com.ddkirill.notesapp.dto;

public class NoteView {

    private final Integer id;
    private final String textNote;
    private final String imageURL;

    public NoteView(Integer id, String textNote, String imageURL) {
        this.id = id;
        this.textNote = textNote;
        this.imageURL = imageURL;
    }

    public Integer getId() {
        return id;
    }

    public String getTextNote() {
        return textNote;
    }

    public String getImageURL() {
        return imageURL;
    }

    @Override
    public String toString() {
        return "NoteView{" +
                "id=" + id +
                ", textNote='" + textNote + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
