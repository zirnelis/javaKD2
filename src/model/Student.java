/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Elina
 */
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private int grade;

    public Student() {
    }
    //Konstruktors, lai ielasitu datubaze 
    public Student(String firstname, String lastname, int age) {
        this.id = 0;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.grade = 0;
    }
    //Konstruktors, lai nolasitu no datubazes
    public Student(int id, String firstname, String lastname, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }
    
    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }

    public void setId(int id) {
        if(id > 0 ) {
            this.id = id;
        } else {
            System.out.println("Negativu id nevar pieskirt");
        }
            
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        if (age > 0) {
           this.age = age; 
        } else {
            System.out.println("Negativu vecumu nevar pieskirt");
        }   
            
    }

    public void setGrade(int grade) {
        if (grade > 0 && grade < 11) {
            this.grade = grade;
        } else {
            System.out.println("Atzimes var but tikai no 1 - 10");
        }
        
        
    }
    
    
}
