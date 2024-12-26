import java.util.HashMap;


public class HashMapMain {
  public static void main(String[] args){
    HashMap<String, String> capitalCities = new HashMap<String, String>();

    // add keys and values (Country, City)
    capitalCities.put("England", "London");
    capitalCities.put("Germany", "Berlin");
    capitalCities.put("Norway", "Oslo");
    capitalCities.put("USA", "Washington DC");
    System.out.println(capitalCities); //output:{USA=Washington DC, Norway=Oslo, England=London, Germany=Berlin}



    String get_city = capitalCities.get("England");
    System.out.println(get_city); 

    capitalCities.remove("England"); // delete one item
    System.out.println(capitalCities); 
    
    
    capitalCities.clear(); // reomve all items
    System.out.println(capitalCities); 

  }
  
}
