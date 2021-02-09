package com.kardibus.notepad.service;

import com.kardibus.notepad.domain.note.NoteDomain;

public interface DataService {

     Iterable<NoteDomain> searchInTitle(String title);
     Iterable<NoteDomain> searchInText(String text);
     void deleteNote(Long id);
     void addNote(String title, String text);
     void updateNote(NoteDomain id,String title,String text);
     Iterable<NoteDomain> allNote();
}
