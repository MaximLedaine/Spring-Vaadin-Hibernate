package com.app.api.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Note")
public class Note {
  @Id
  @GeneratedValue
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String description;

  // for deserialisation
  public Note() {}

  public Note(String title, String description) {
      this.setTitle(title);
      this.setDescription(description);
  }

  public Long getId() {
    return this.id;
  }

  public String getTitle() {
      return this.title;
  }

  public void setTitle(String title) {
      this.title = title;
  }

  public String getDescription() {
      return this.description;
  }

  public void setDescription(String description) {
      this.description = description;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Note note = (Note) o;
      return Objects.equals(id, note.id);
  }

  @Override
  public int hashCode() {
      return Objects.hash(id);
  }

  public String toString() {
      return this.title;
  }

  public int compareTo(Note l) {
      return l.getId().compareTo(id);
  }
}
