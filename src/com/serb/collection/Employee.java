package com.serb.collection;

/**
 * User: sbezugliy
 * Date: 01.03.2010
 */
public class Employee {

  private int age;

  private String name;

  private String surname;

  private Gender gender;

  private long profit;

  public Employee() {

  }

  public Employee(String name, String surname, int age, long profit, Gender gender) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.profit = profit;
    this.gender = gender;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String sername) {
    this.surname = surname;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public long getProfit() {
    return profit;
  }

  public void setProfit(long profit) {
    this.profit = profit;
  }

  public static enum Gender {
    MALE, FEMALE
  }
}
