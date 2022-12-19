package com.bm.relation.bean;

import java.util.Arrays;
import java.util.List;

public class Pen {

    private String id;
    private String name;
    private int pageCount;
    private String authorId;

    public Pen(String id, String name, int pageCount, String authorId) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.authorId = authorId;
    }

    private static List<Pen> books = Arrays.asList(
            new Pen("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
            new Pen("book-2", "Moby Dick", 635, "author-2"),
            new Pen("book-3", "Interview with the vampire", 371, "author-3")
    );

    public static Pen getById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    public String getId() {
        return id;
    }

    public String getAuthorId() {
        return authorId;
    }
}