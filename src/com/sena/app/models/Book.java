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
    private List<String> authors;
    private boolean readed;
    private int timeReaded;

    // Constructor básico
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

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdititionDate() {
        return edititionDate;
    }

    public void setEdititionDate(String edititionDate) {
        this.edititionDate = edititionDate;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public boolean isReaded() {
        return readed;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public int getTimeReaded() {
        return timeReaded;
    }

    public void setTimeReaded(int timeReaded) {
        this.timeReaded = timeReaded;
    }

    @Override
    public String toString() {
        StringBuilder authorsStr = new StringBuilder();
        for (int i = 0; i < authors.size(); i++) {
            authorsStr.append(authors.get(i));
            if (i < authors.size() - 1) {
                authorsStr.append(", ");
            }
        }

        return "📖 Libro ID: " + id + "\n" +
               "   Título: " + title + "\n" +
               "   Fecha de Edición: " + edititionDate + "\n" +
               "   Editorial: " + editorial + "\n" +
               "   ISBN: " + isbn + "\n" +
               "   Autores: " + authorsStr.toString() + "\n" +
               "   Leído: " + (readed ? "Sí" : "No") + "\n" +
               "   Tiempo de Lectura: " + timeReaded + " horas\n" +
               "═══════════════════════════════════════";
    }
}
