package com.truecodes;

public interface Borrowable {
    void borrow_book(Book book);
    default void borrow_book() {
        System.out.println("A book is borrowed.");
    }

}
