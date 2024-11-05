package com.truecodes;

public class Book implements Borrowable{
    private String title;
    private String author;
    private String ISBN;
    private Integer copies;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Book(String title, String author, String ISBN, Integer copies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.copies = copies;
    }
    public String get_details(){
        return "Book Title: "+getTitle()+" Book Author: "+getAuthor()+" ISBN: "+getISBN()+" no. of copies: "+getCopies();
    }
    public boolean is_available(){
        if(getCopies() == 0){
            return false;
        }else{
            return true;
        }
    }

    public void return_book(){
        setCopies(getCopies()+1);
    }

    @Override
    public void borrow_book(Book book) {
    }

    @Override
    public void borrow_book() {
        if(getCopies()>0)setCopies(getCopies()-1);
        else System.out.println("no copies available for this book");
    }
}
