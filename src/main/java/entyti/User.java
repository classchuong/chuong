package entyti;

import java.util.Objects;

public class User {
  private int id ;
  private String fullName ;
  private String email ;
    private String proSkill;
    private String password ;
  private String role ;
  private int  ExpInYear ;
  private String ProSkill ;

    public User(int id, String name, String fullName) {
        this.id= id ;
        this.fullName = fullName ;
        this.email = email ;
    }

    public User() {

    }

    public User(int id, String fullName, String email, String password, Role role) {
        this.id = id ;
        this.fullName = fullName ;
        this.email = email ;
        this.password = password ;
this.role = String.valueOf(role);

    }


//    @Override
//    public String toString() {
//        return String.format("%-10s | %-10s | %-30s" ,id,fullName,email);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && ExpInYear == user.ExpInYear && Objects.equals(fullName, user.fullName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && role == user.role && Objects.equals(ProSkill, user.ProSkill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, password, role, ExpInYear, ProSkill);
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int expInYear) {
        ExpInYear = expInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    @Override
    public String toString() {

        System.out.print( "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +

                ", password='" + password + '\'' +
                ", role=" + role
);
        if (role == "Admin"){
            System.out.println( ", ExpInYear=" + ExpInYear );
        }
        else if (role == "Employee"){
            System.out.println(" ProSkill = " + ProSkill  ) ;
        }


        return null ;
    }
}
