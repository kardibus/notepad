package com.kardibus.notepad.repository;

import com.kardibus.notepad.domain.note.NoteDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteDomain, Long> {
    Iterable<NoteDomain> findByTitleLike(String title);
    Iterable<NoteDomain> findByTextLike(String text);
}
