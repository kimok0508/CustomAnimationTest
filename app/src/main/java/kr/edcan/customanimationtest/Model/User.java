package kr.edcan.customanimationtest.Model;

/**
 * Created by mac on 2017. 9. 12..
 */

public class User {
    private String name;
    private int age;
    private String imageUrl;

    public User(String name, int age, String imageUrl){
        this.name = name;
        this.age = age;
        this.imageUrl = imageUrl;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getImageUrl(){
        return this.imageUrl;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
}
