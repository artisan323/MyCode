package com.sb.sbamqp.pojo;

/**
 * @author wannengqingnian
 */
public class Book {

    public Book() {

    }
    public Book(String bookName, String authorName) {
        this.bookName = bookName;
        this.authorName = authorName;
    }

    private String bookName;
    private String authorName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
