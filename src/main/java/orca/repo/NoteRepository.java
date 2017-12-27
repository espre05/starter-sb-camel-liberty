package orca.repo;

import java.util.List;

import orca.domain.Notetext;

public interface NoteRepository extends ReadOnlyRepository<Notetext, String> {
    List<Notetext> findByIdAndCode1(int id, Character code);
}
