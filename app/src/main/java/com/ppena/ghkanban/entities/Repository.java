package com.ppena.ghkanban.entities;

import java.io.Serializable;

/**
 * Objeto creado para representar el elemento "Issues"
 *
 * Esta clase se utilizará para representar los repositorios en las listas que se muestran en la pantalla MainActivity"
 *
 * @author Pablo Andres Pena
 */
public class Repository implements Serializable{

    String name;
    String author;

    public Repository(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
