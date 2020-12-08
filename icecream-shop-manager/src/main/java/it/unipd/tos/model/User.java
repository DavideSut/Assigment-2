////////////////////////////////////////////////////////////////////
// Davide Sut 1201267
////////////////////////////////////////////////////////////////////


package it.unipd.tos.model;

public class User {

    private String username;
    private long age;

    public User(String username, long age) {
        if(username == null || username.length() == 0) {
            throw new IllegalArgumentException("Username non è valido");
        }
        if(age <= 0) {
            throw new IllegalArgumentException("Age deve essere > 0");
        }
        this.username = username;
        this.age = age;
    }

    public String getUsername(){
        return username;
    }

    public long getAge(){
        return age;
    }

}