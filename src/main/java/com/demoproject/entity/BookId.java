package com.demoproject.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class BookId implements Serializable {
    private String isbn;
    private int edition;

    
    public BookId() {}

   
    public BookId(String isbn, int edition) {
        this.isbn = isbn;
        this.edition = edition;
    }

    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }


	

    
}

