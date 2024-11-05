package com.truecodes;

import java.util.Map;

public class Librarian extends Person{
    private String employee_id;
    Library library;
    public Librarian(String name, String employee_id) {
        super(name);//deriving from base class person
        this.employee_id = employee_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }
    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }
    public void add_book(Book book){
        library = new Library();
        library.books.put(book.getISBN(), book);
    }
    public void remove_book(Book book){
        library = new Library();
        library.books.remove(book.getISBN());
    }
    public String view_inventory(){
        StringBuilder bookInventoryDetails = new StringBuilder();
        library = new Library();
        for(Map.Entry<String,Book> bookEntry:library.books.entrySet()){
            String availability = bookEntry.getValue().getCopies() == 0 ? "no":"yes";
            bookInventoryDetails.append("Book Title: ")
                    .append(bookEntry.getValue().getTitle())
                    .append("Book Author: ")
                    .append(bookEntry.getValue().getAuthor())
                    .append("ISBN: ").append(bookEntry.getValue().getISBN())
                    .append("Is this book available: ").append(availability).append("\n");
        }
        return bookInventoryDetails.toString();
    }


}
