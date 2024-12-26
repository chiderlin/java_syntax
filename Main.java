import java.util.Scanner; // input

// input package usage:
class Myclass {
  public void test(){
    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter username");

    String userName = myObj.nextLine();
    System.out.println("Username is: " + userName);
  }
}



// encapsulation

class Person {
  private String name;
  private int age;

  public String getName(){
    return name;
  }

  public int getAge(){
    return age;
  }

  public void setAge(int age){
    if(age > 0){
      this.age = age;
    } else {
    }
    System.out.println("Age must be positive.");
  }

  public void setName(String name){
    this.name = name;
  }

  public void displayInfo(){
    System.out.println("Name: " + name+", Age: " + age);
  }
}


public class Main {
  public static void main(String[] args){
    Person person = new Person();
    person.setName("Bob");
    person.setAge(12);
    person.displayInfo();

    person.setAge(-5);

    Myclass my_class = new Myclass();
    my_class.test();
    
  }
}
