package com.harman.work;

import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

public class Library {

	
	// These variables are static because you don't need multiple copies
    // for sorting, as they have no intrinsic state.
    static private Comparator<Book> ascTitle;
    static private Comparator<Book> descPageNumber;

    // We initialize static variables inside a static block.
    static {
        ascTitle = new Comparator<Book>(){
            @Override
            public int compare(Book b1, Book b2){
                return b1.getTitle().compareTo(b2.getTitle());
            }
        };

        descPageNumber = new Comparator<Book>(){
            @Override
            public int compare(Book b1, Book b2){
                // Java 7 has an Integer#compare function
                return Integer.compare(b1.getPageNumber(), b2.getPageNumber());
                // For Java < 7, use 
                // Integer.valueOf(n1).compareTo(n2);
                // DO NOT subtract numbers to make a comparison such as n2 - n1.
                // This can cause a negative overflow if the difference is larger 
                // than Integer.MAX_VALUE (e.g., n1 = 2^31 and n2 = -2^31)
            }
        };
    }

    private Book[] books;
    public Book[] getBooks(){ return books; }

    public void sortAscTitle(){
        Arrays.sort(books, ascTitle);
    }

    public void sortDescPageNumber(){
        Arrays.sort(books, descPageNumber);
    }

    public Library(Book[] books){
        this.books = books;
    }

    public static void main(String[] args){
        Library library = new Library( new Book[]{
            new Book("1984", 123), 
            new Book("I, Robot", 152), 
            new Book("Harry Potter and the Philosopher's Stone", 267),
            new Book("Harry Potter and the Goblet of Fire", 759),
            new Book("The Bible", 1623)
        });

        library.sortAscTitle();
        System.out.println(Arrays.toString(library.getBooks()));

        library.sortDescPageNumber();
        System.out.println(Arrays.toString(library.getBooks()));
    }
	
}

class Book{
    String title;
    int pageNumber;

    public Book(String title, int pageNumber){
        this.title = title;
        this.pageNumber = pageNumber;
    }

    String getTitle(){ return title; }
    int getPageNumber(){ return pageNumber; }

    public String toString(){
        return "(" + title + ", " + pageNumber + " pages)";
    }
}
