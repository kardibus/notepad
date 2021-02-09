package com.kardibus.notepad.domain.note;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "note_domain")
public class NoteDomain {

    public NoteDomain() {
    }

    public NoteDomain(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
}
