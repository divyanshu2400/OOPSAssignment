package com.truecodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Library {
    Book book;
    Map<String, Book> books = new HashMap<>();
    Map<String, Member> members = new HashMap<>();
    public void register_member(Member member){
        members.put(member.getMember_id(),member);
    }
    public String get_details(){
        return "Number of books: "+books.size()+"No.of members: "+members.size();
    }

    public boolean search_books_by_title(String title){
        for(Map.Entry<String, Book> bookMap: books.entrySet()){
            if(Objects.equals(bookMap.getKey(),title)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Book book1 = new Book("Java","kennedy","jv3453a",3);
        Book book2 = new Book("Python","tom","py73663u",2);
        Book book3 = new Book("SQL","eyrie","sql2552",3);
        Book book4 = new Book("C++","finny","43t3738",1);
        Library library = new Library();
        library.books.put(book1.getISBN(),book1);
        library.books.put(book2.getISBN(),book2);
        library.books.put(book3.getISBN(),book3);
        library.books.put(book4.getISBN(),book4);

        // A member registers to the library
        Member ramesh = new Member("Ramesh","435f");
        library.register_member(ramesh);

        // Member borrows a book
//        ramesh.borrow_book(book1);
        //Library updates book availability.
        library.issue_book(ramesh.getMember_id(), book1.getISBN());
        //  Member returns the book.

        System.out.println(" all books: \n"+library.list_all_books()+" ");
        System.out.println(" borrowed books: \n"+ramesh.list_borrowed_books()+" ");


        library.receive_book(ramesh.getMember_id(), book1.getISBN());
        // Librarian checks the updated inventory.
        System.out.println("again check updated books copies: \n"+library.list_all_books()+" ");
        System.out.println("borrowed books: \n"+ramesh.get_details());
    }
    private Book bookFound;
    public void issue_book(String member_id, String book_isbn){
        // decrease book copy by one
        // add book instance inside borrow book list

        for(Map.Entry<String, Book> bookMap: books.entrySet()){
            if(Objects.equals(bookMap.getKey(), book_isbn)){
                bookFound = bookMap.getValue();
                if(bookFound.is_available()){
                     bookFound.borrow_book();
                }
            }
        }
        for(Map.Entry<String, Member> memberEntry:members.entrySet()){
            if(Objects.equals(memberEntry.getKey(),member_id)){
                Member memberFound = memberEntry.getValue();
                if(bookFound.is_available()) memberFound.borrow_book(bookFound);
                else System.out.println("no book available inside borrowed books for member id:"+member_id);
            }
        }
    }
    public void receive_book(String member_id, String book_isbn){
        // increase book copy by one
        // remove book instance inside borrow book list
        for(Map.Entry<String, Book> bookMap: books.entrySet()){
            if(Objects.equals(bookMap.getKey(), book_isbn)){
                bookFound = bookMap.getValue();
                bookFound.return_book();
            }
        }
        for(Map.Entry<String, Member> memberEntry:members.entrySet()){
            if(Objects.equals(memberEntry.getKey(),member_id)){
                Member memberFound = memberEntry.getValue();
                memberFound.return_book(bookFound);
            }
        }

    }
    public String list_all_books(){
        StringBuilder bookInventoryDetails = new StringBuilder();
        for(Map.Entry<String, Book> bookEntry: books.entrySet()){
            bookInventoryDetails.append(bookEntry.getValue().get_details()).append("\n");
        }
        return bookInventoryDetails.toString();
    }

}
