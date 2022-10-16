package Example1;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    static ArrayList<ContactManager> listcontact =new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    public static int inputInt(){

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

    public static ContactManager addContact(ContactManager c){
        System.out.println("Nhập tên: ");
        c.setName(sc.nextLine());
        System.out.println("Nhập sđt: ");
        c.setPhone(sc.nextLine());
        return c;
    }
    public static void findName(String name){
        for (ContactManager c:listcontact) {
            if(c.getName().equalsIgnoreCase(name)){
                System.out.println(c.getName()+"\t\t\t\t\t"+c.getPhone());
            }
        }
    }
    public static void display(){
        System.out.println("Contact Name\t\t\t\t\t\tPhone Number");
        for (ContactManager c: listcontact) {
            System.out.println(c.getName()+"\t\t\t\t"+c.getPhone());
        }
    }
    public static boolean again(){
        String s;
        System.out.println("Continue (y/n)?");
        s = sc.nextLine();
        if(s.equalsIgnoreCase("y")) return true;
        else return false;
    }

    public static void menu(){
        System.out.println("1. Add new contact");
        System.out.println("2. Find a contacts by name");
        System.out.println("3. Display contacts");
        System.out.println("4. Exit");
        int s;
        System.out.println("Press option");
        s = inputInt();
        boolean again1;
        switch (s){
            case 1:
                ContactManager c1 = new ContactManager();
                addContact(c1);
                listcontact.add(c1);
                again1 = again();
                do{
                    ContactManager c = new ContactManager();
                    addContact(c);
                    listcontact.add(c);
                    again1 = again();
                }while (again1 == true);
                menu();
                break;
            case 2:
                String name;
                name = sc.nextLine();
                findName(name);
                menu();
                break;
            case 3:
                display();
                menu();
                break;
            case 4:
                System.out.println("Bye bye!!!");
                break;
            default:
                System.out.println("Nhập sai, nhập lại!!!");
                menu();
        }
    }
}
