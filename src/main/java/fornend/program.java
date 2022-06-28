package fornend;

import backend.Demo;
import entyti.User;

import java.util.ArrayList;
import java.util.Scanner;

public class program {
    public static void main(String[] args) throws Exception {
//      bai2();
//       bai3();
//        bai4(7);
//        bai5("kmcguigan0@google.it","QVJM29");
//        bai6("nam","namc11");
//        logi_and_create();

    } public static void bai2(){
        ArrayList<User>list = Demo.getall();
        String use =("%-10s | %-10s |%-30s | " );
        System.out.printf(use ,"id","fullname","email");
        for (User user:list
             ) {
            System.out.println(user);

        }
    }
    public  static  void bai3(int id){
      User user = Demo.getid(id);
        System.out.println(user);

    }
    public static void bai4(int id){
        User user = Demo.delete(id);
        System.out.println(user);

    }
    public static  void bai5(String email,String password){
        User user = Demo.dangnhap(email,password);
        System.out.println(user);
    }
    public static void bai6(String fullname,String email){
        User user = Demo.createdata(fullname,email);
    }
    public static void logi_and_create() throws Exception {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("nhap email de ");
//        String email = scanner.nextLine() ;
//        if (!Demo.isEmailValid(email)){
//            throw new Exception("loi dinh dang") ;
//        }
//        System.out.println("nhap password");
//        String password = scanner.nextLine() ;
//        if (!Demo.isPasswordValid(password)){
//            throw  new Exception("ko dung") ;
//        }
//
//        User user = Demo.dangnhap(email,password);
//        System.out.println(user);

        System.out.println("nhap ten de tao account");
        String fullname = scanner.nextLine();
      if(!Demo.isFullNameValid(fullname)){
            throw new Exception("chu") ;
        }
        System.out.println("nhap email de tao account");
        String email1 = scanner.nextLine();
        if (!Demo.isEmailValid(email1)){
        throw  new Exception("loi");

        }

 User  user = Demo.createdata(fullname,email1);
        System.out.println(user);


    }
}
