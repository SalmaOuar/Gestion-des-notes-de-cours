/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CommentaireNotePK implements Serializable {
     @Column(name = "enseignant_id")
    private int enseignantId;

    @Column(name = "note_id")
    private int noteId;

    public CommentaireNotePK() {
    }

    public CommentaireNotePK(int enseignantId, int noteId) {
        this.enseignantId = enseignantId;
        this.noteId = noteId;
    }

    public int getEnseignantId() {
        return enseignantId;
    }

    public void setEnseignantId(int enseignantId) {
        this.enseignantId = enseignantId;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentaireNotePK)) return false;
        CommentaireNotePK that = (CommentaireNotePK) o;
        return enseignantId == that.enseignantId && noteId == that.noteId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(enseignantId, noteId);
    }
}
