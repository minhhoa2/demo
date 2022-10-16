package Example2.dao;

import Example2.entities.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDao {
    public static Connection connect(){
        Connection conn= null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anhdq12","root","123456");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void save(Book b) throws SQLException {
        String sql= "insert into book (name, price,genre,author,qty,status,totalPage) " +
                "values(?,?,?,?,?,?,?)";
        Connection conn= connect();
        if(conn!=null){
            b=new Book();
            b.input(b);
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,b.getName());
            preparedStatement.setString(2, String.valueOf(b.getPrice()));
            preparedStatement.setInt(3, Integer.parseInt(b.getGenre()));
            preparedStatement.setString(4, b.getAuthor());
            preparedStatement.setString(5, String.valueOf(b.getQty()));
            preparedStatement.setString(6, String.valueOf(b.getStatus()));
            preparedStatement.setString(7, String.valueOf(b.getTotalPage()));
            preparedStatement.executeUpdate();
        }
    }

    public static void Update() throws SQLException {
        String sql= "Update book set author = ?, pricce = ?, qty = ? where name = ?";
        Connection conn= connect();
        if(conn!=null){
            Scanner sc=new Scanner(System.in);
            String name,author,pricce,qty;
            name=sc.nextLine();
            author=sc.nextLine();
            pricce=sc.nextLine();
            qty=sc.nextLine();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,author);
            preparedStatement.setString(2,pricce);
            preparedStatement.setString(3,qty);
            preparedStatement.setString(4, name);
            preparedStatement.executeUpdate();
        }
    }

    public static void remove() throws SQLException {
        Connection conn=connect();
        String sql="Delete from book where name = ?";
        String name;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name: ");
        name=sc.nextLine();
        PreparedStatement statement=conn.prepareStatement(sql);
        statement.setString(1,name);
        statement.executeUpdate();
    }

    public static List<Book> findIncompletedTrainee() throws SQLException {
        List<Book> lst=new ArrayList<>();
        String sql="select * from book ";
        Connection conn=connect();
        if(conn!=null){
            PreparedStatement prepa=conn.prepareStatement(sql);
            ResultSet resultSet=prepa.executeQuery();
            while (resultSet.next()){
                int ID=resultSet.getInt("ID");
                String name=resultSet.getString("name");
                float price= resultSet.getFloat("price");
                String genre=resultSet.getString("genre");
                String author=resultSet.getString("author");
                int status=resultSet.getInt("status");
                int totalPage=resultSet.getInt("totalPage");
                Book b=new Book();
                b.setBookID(ID);
                b.setName(name);
                b.setPrice(price);
                b.setGenre(genre);
                b.setAuthor(author);
                b.setStatus(status);
                b.setTotalPage(totalPage);
                lst.add(b);
            }
        }
        return lst;
    }

}
