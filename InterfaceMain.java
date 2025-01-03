interface Animal {
  public void animalSound(); // interface method
  public void sleep(); // interface method
}

// Pig "implements" the Animal interface
class Pig implements Animal {
  public void animalSound(){
    // The body of animalSound() is provided here
    System.out.println("The pig says: wee wee");
  }

  public void sleep(){
    // The body of sleep() is provided here
    System.out.println("Zzz");
  }
}



public class InterfaceMain {
  public static void main(String[] args){
    Pig myPig = new Pig();
    myPig.animalSound();
    myPig.sleep();
  }
}
