package com.truecodes;

import java.util.ArrayList;
import java.util.List;

public class Member extends Person implements Borrowable{
    private String member_id;
    List<Book> borrowed_books = new ArrayList<>();

    public Member(String name, String member_id) {
        super(name);//deriving from base class person
        this.member_id = member_id;
    }
    public String get_details(){
        return "Member ID for a member: "+getMember_id()+" No.of borrowed books: "+borrowed_books.size();
    }
    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public void return_book(Book book){
        borrowed_books.remove(book);
    }
    public String list_borrowed_books(){
        StringBuilder bookDetails = new StringBuilder();
        for(Book book:borrowed_books){
            bookDetails.append(book.get_details()).append("\n");
        }
        return bookDetails.toString();
    }

    @Override
    public void borrow_book(Book book) {
        borrowed_books.add(book);
    }
}
