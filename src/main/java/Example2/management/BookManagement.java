package Example2.management;

import Example2.dao.BookDao;
import Example2.entities.Book;

import java.sql.SQLException;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        try {
            menu();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void menu() throws SQLException {
        System.out.println("======== FA System ========\n" +
                "1. Create Trainee\n" +
                "2. Update Trainee\n" +
                "3. Remove a specific Trainee\n" +
                "4. Report incompleted training\n" +
                "5. Exit\n" +
                "Your choice:\n");
        Book b;
        int chose=inputInt();
        BookDao bDao=new BookDao();
        switch (chose){
            case 1:
                b=new Book();
                bDao.save(b);
                break;
            case 2:
                bDao.Update();
                break;
            case 3:
                bDao.remove();
                break;
            case 4:
                bDao.findIncompletedTrainee();
                break;
            case 5:
                System.out.println("Bye bye!!");
                return;
            default:
                System.out.println("Nhap lai!!!");
                menu();
        }
    }
    public static int inputInt(){
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
}
