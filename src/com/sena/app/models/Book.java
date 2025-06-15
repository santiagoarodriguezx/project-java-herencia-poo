package com.sena.app.models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    // Atributos básicos
    private static int nextId = 1;
    private int id;
    private String title;
    private String edititionDate;
    private String editorial;
    private String isbn;

    // Constructor básico
    public Book(String title, String edititionDate, String editorial, String isbn) {
        this.id = nextId++;
        this.title = title;
        this.edititionDate = edititionDate;
        this.editorial = editorial;
        this.isbn = isbn;
    }

    // Getters y Setters básicos
    // TODO: Implementar getters y setters
}
