package backend;

import entyti.ConnectionJDBC;
import entyti.Role;
import entyti.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {


    public static ArrayList<User> getall() {
        ConnectionJDBC connectionJDBC = new ConnectionJDBC();
        Connection connection = connectionJDBC.conNec();
String sql = "select id,fullName,email from User " ;
ArrayList<User>list = new ArrayList<>() ;
        try {
            Statement statement = connection.createStatement() ;
            ResultSet resultSet = statement.executeQuery(sql) ;
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullName") ;
                String email = resultSet.getString("email") ;
             User user = new User(id, fullName, fullName);
                list.add(user) ;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static User getid(int id) {
        ConnectionJDBC connectionJDBC = new ConnectionJDBC();
        Connection connection = connectionJDBC.conNec();
        String sql = "select * from User where id = ?";
      User user = new User() ;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
String role = resultSet.getString("role") ;
 user = new User(id,fullName,email,password,Role.valueOf(role));




            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public static User delete(int id) {
ConnectionJDBC connectionJDBC = new ConnectionJDBC() ;
Connection connection = connectionJDBC.conNec() ;
String sql = "delete from User where id = ? ";
User user = new User() ;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        int resultSet = statement.executeUpdate() ;
        if (resultSet != 0 ) {
            System.out.println("done");
        }else {
            throw new Exception("id not exists");
        }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    public static User dangnhap(String email, String password) {

ConnectionJDBC connectionJDBC = new ConnectionJDBC() ;
Connection connection = connectionJDBC.conNec();
String sql = "select * from User where email = ? and  password = ? " ;
        try {
            PreparedStatement statement = connection.prepareStatement(sql) ;
        statement.setString(1,email);
        if (!isEmailValid(email)) {
            throw new Exception("dinh dang khong dung") ;
        }

        statement.setString(2,password);
        if (password.length() < 6 || password.length() > 12 || !isPasswordValid(password)
            ){throw new Exception("ngan vs dai") ;

        }
        ResultSet resultSet = statement.executeQuery() ;
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String fullName = resultSet.getString(2);
            String email1 = resultSet.getString(3);
            String password1 = resultSet.getString(4);
            String role = resultSet.getString(5);
            int ExpInYear = resultSet.getInt(6);
            String ProSkill = resultSet.getString(7);
            System.out.println("welcome " + fullName);

        }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static boolean isEmailValid(String email) {
        Pattern compileEmail = Pattern.compile("^[\\w\\-_.]+@[\\w\\-_]+(\\.[\\w\\-_]+){1,2}$");
        Matcher matcherEmail = compileEmail.matcher(email);
        return matcherEmail.find();
    }
    public static boolean isPasswordValid(String password) {
        Pattern compilePwd = Pattern.compile(".*[A-Z].*");
        Matcher matcherPwd = compilePwd.matcher(password);
        return password.length() >= 6 && password.length() <= 12 && matcherPwd.find();
    }
    public static User createdata(String fullName , String email){
        ConnectionJDBC connectionJDBC = new ConnectionJDBC() ;
        Connection connection = connectionJDBC.conNec();
        String sql = "insert into  user(fullname,email,password)" + "value(?,?,123456)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,fullName);
            preparedStatement.setString(2,email);
            int resultSet = preparedStatement.executeUpdate() ;
            if (resultSet !=0){
                System.out.println("create done");
            } else {
                System.out.println("exception");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    public static boolean isFullNameValid(String password) {
        Pattern compilePwd = Pattern.compile("^[a-zA-Z\\s]+$");
        Matcher matcherPwd = compilePwd.matcher(password);
        return matcherPwd.find();
    }
}
