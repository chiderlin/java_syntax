public class Test {
  int x = 5;

  public static void main(String[] args){
    System.out.println("Hello World");
    System.out.println(3*5);

    int myNum;
    myNum = 15;
    System.out.println(myNum);


    // final -> unchangeable and read-only
    final int mytest = 11;
    // mytest = 12; 



    float studentFee = 75.25f;
    int studentID = 15;
    char studentGrade = 'B';
    boolean myBool = true;
    String name = "John";
    System.out.println("student name: " + name);
    System.out.println("student id: " + studentID);
    System.out.println("studentGrade: " + studentGrade);


    // widening casting
    double myDouble = myNum;
    System.out.println(myDouble);


    // narrow casting
    double myD = 9.78d;
    int myInt = (int)myD;
    System.out.println(myD);
    System.out.println(myInt);


    String txt = "Hello world";
    System.out.println(txt.toUpperCase());
    System.out.println(txt.toLowerCase());
    String txt2 = "Please locate where 'locate' occurs!";
    System.out.println(txt2.indexOf("locate")); // 7

    String firstName = "John ";
    String lastNmae = "Doe";
    System.out.println(firstName.concat(lastNmae));

    for(int i=0; i<=2; i++){
      System.out.println(i);
    }
    String[] cars = {"Volvo", "BMW", "Ford","Mazda"};
    System.out.println(cars[0]);
    System.out.println(myMethod(3));
    Test myObj = new Test();
    System.out.println(myObj.x);


    myStaticMethod(); // call the static method
    // mypubMethod(); // this would compile an error



    Test myobj = new Test();
    myobj.mypubMethod();
  }
  
  static int myMethod(int x){
    return 5+x;
  }

  // static v.s public
  static void myStaticMethod(){
    System.out.println("Static method can be called without creating objects.");
  }
  
  
  public void mypubMethod(){
    System.out.println("Static methods MUST be called by creating objects.");
  }


}
