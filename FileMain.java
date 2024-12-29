import java.io.File; // import the file class
import java.io.FileWriter; // import the FileWriter class
import java.io.FileNotFoundException; // import this class to handle errors
import java.io.IOException; // import the IOException calss to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class FileMain {
  public static void main(String[] args){
    FileMain fileMain = new FileMain(); // create self object

    fileMain.createFile("test2.txt");
    fileMain.writeFile("test2.txt", "Files in Java might be tricky, but it is fun enough.");
    fileMain.readFile("test2.txt");
  }

  public void writeFile(String fileName, String content){
    try(FileWriter myWriter = new FileWriter(fileName)) {
      myWriter.write(content);
      // myWriter.write("Files in Java might be tricky, but it is fun enough.");
      myWriter.close();
      System.out.println("Successfully wrote to the file: "+ fileName);
    } catch (IOException e){
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
  }

  public void createFile(String fileName){
    try{
      File myObj = new File(fileName);
      if(myObj.createNewFile()){
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    }catch(IOException e){
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void readFile(String fileName){
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()){
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch(FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void deleteFile(String fileName){
      File myObj = new File(fileName);
      if(myObj.delete()){
        System.out.println("Deleted the file: " + myObj.getName());
      } else {
        System.out.println("Failed to delete the file.");
      }
    }
}
