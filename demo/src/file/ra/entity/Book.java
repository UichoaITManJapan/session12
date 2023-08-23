package file.ra.entity;

import java.io.Serializable;

public class Book implements Serializable {
    private  String bookId;
    private String bookName;
    private float price;

    public Book() {
    }

    public Book(String bookId, String bookName, float price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookId :" + this.bookId +"- BookName " + this.bookName + "- Price " + price;
    }
}
