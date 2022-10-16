package Example2.entities;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.util.Scanner;

public class Book {
    private int bookID, qty, status, totalPage;
    private MysqlxDatatypes.Scalar.String name, genre, author;
    private float price;

    public Book() {
    }

    public Book(int bookID, int qty, int status, int totalPage, String name, String genre, String author, float price) {
        this.bookID = bookID;
        this.qty = qty;
        this.status = status;
        this.totalPage = totalPage;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.price = price;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void input(Book b){
        Scanner sc=new Scanner(System.in);
        int  qty, status, totalPage;
        String name, genre, author;
        float price;

        System.out.println("Enter name");
        name = sc.nextLine();
        b.setName(name);
        System.out.println("Enter author");
        author = sc.nextLine();
        b.setAuthor(author);
        System.out.println("Enter status");
        do {
            status=inputInt();
        }while (status!=1 && status!=0);
        b.setStatus(status);
        System.out.println("Enter quantity: ");
        qty = inputInt();
        b.setQty(qty);
        System.out.println("Enter total page: ");
        totalPage = inputInt();
        b.setTotalPage(totalPage);
        System.out.println("Enter name: ");
        name = sc.nextLine();
        b.setName(name);
        System.out.println("Enter genre: ");
        genre = sc.nextLine();
        b.setGenre(genre);
        System.out.println("Enter price: ");
        price = inputF();
        b.setPrice(price);
    }

    public int inputInt(){
        Scanner sc=new Scanner(System.in);
        int n=0;
        try {
            String temp=sc.nextLine();
            n=Integer.parseInt(temp);
        }catch (Exception e){
            System.out.println("Nhap sai nhap lai");
            inputInt();
        }
        return  n;
    }

    public float inputF(){
        Scanner sc=new Scanner(System.in);
        float n=0;
        try {
            String temp=sc.nextLine();
            n=Float.parseFloat(temp);
        }catch (Exception e){
            System.out.println("Nhap sai nhap lai");
            inputF();
        }
        return  n;
    }


}
