package com.sena.app.models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private static int nextId = 1;
    private int id;
    private String title;
    private String edititionDate;
    private String editorial;
    private String isbn;
    private List<String> authors;
    private boolean readed;
    private int timeReaded;

    // Constructor
    public Book(String title, String edititionDate, String editorial, String isbn) {
        this.id = nextId++;
        this.title = title;
        this.edititionDate = edititionDate;
        this.editorial = editorial;
        this.isbn = isbn;
        this.authors = new ArrayList<>();
        this.readed = false;
        this.timeReaded = 0;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getEdititionDate() {
        return edititionDate;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public boolean isReaded() {
        return readed;
    }

    public int getTimeReaded() {
        return timeReaded;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setEdititionDate(String edititionDate) {
        this.edititionDate = edititionDate;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public void setTimeReaded(int timeReaded) {
        this.timeReaded = timeReaded;
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder authorsStr = new StringBuilder();
        for (int i = 0; i < authors.size(); i++) {
            authorsStr.append(authors.get(i));
            if (i < authors.size() - 1) {
                authorsStr.append(", ");
            }
        }

        return "Libro ID: " + id + "\n" +
               "   Titulo: " + title + "\n" +
               "   Fecha de Edicion: " + edititionDate + "\n" +
               "   Editorial: " + editorial + "\n" +
               "   ISBN: " + isbn + "\n" +
               "   Autores: " + authorsStr.toString() + "\n" +
               "   Leido: " + (readed ? "Si" : "No") + "\n" +
               "   Tiempo de Lectura: " + timeReaded + " horas\n" +
               "=======================================";
    }
}
