package com.kardibus.notepad.service;

import com.kardibus.notepad.domain.note.NoteDomain;
import com.kardibus.notepad.repository.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class NoteDataServiceImpl implements DataService {


    private final NoteRepository noteRepository;

    public NoteDataServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Iterable<NoteDomain> allNote() {
        Iterable<NoteDomain> noteDomains = noteRepository.findAll();
        return noteDomains;
    }

    @Override
    public void addNote(String title, String text) {
        NoteDomain noteDomain = new NoteDomain();
        noteDomain.setText(text);
        noteDomain.setTitle(title);
        noteRepository.save(noteDomain);
    }

    @Override
    public void updateNote(NoteDomain id, String title, String text) {
        id.setText(text);
        id.setTitle(title);
        noteRepository.save(id);
    }

    @Override
    public Iterable<NoteDomain> searchInTitle(String title) {
        Iterable<NoteDomain> searchInTitle = noteRepository.findByTitleLike("%" + title + "%");
        return searchInTitle;
    }

    @Override
    public Iterable<NoteDomain> searchInText(String text) {
        Iterable<NoteDomain> searchInText = noteRepository.findByTextLike("%" + text + "%");
        return searchInText;
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

}
