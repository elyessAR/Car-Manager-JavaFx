
package javafxapplication2;

public class Admins {
    private int id;
    private String username;
    private String password;
    public Admins(){
    super(); 
    
}
    public Admins(int i,String u,String p){
        this.id=i;
        this.username=u;
        this.password=p;
       
    }
    void setID(int i){this.id=i;}
    void setUsername(String u){this.username=u;}
    void setPassword(String p){this.password=p;}
    int getID(){return this.id;}
    String getUsername(){return this.username;}
    String getPassword(){return this.password;}

}