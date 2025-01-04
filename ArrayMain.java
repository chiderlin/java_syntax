import java.util.ArrayList; 

public class ArrayMain {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add(0,"Mazda");
    System.out.println(cars);

    String c_idx = cars.get(0);
    System.out.println(c_idx);

    String crm_idx = cars.remove(0);
    System.out.println(crm_idx);
    System.out.println(cars);
    System.out.println(cars.size());
    
    // to remove all the element
    cars.clear();
  }

}

