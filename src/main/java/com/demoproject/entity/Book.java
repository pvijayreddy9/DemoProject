package com.demoproject.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @EmbeddedId
    private BookId id;
    private String title;

   

    public BookId getId() {
        return id;
    }

    public void setId(BookId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}

    
}

