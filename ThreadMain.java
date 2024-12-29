public class ThreadMain extends Thread {
  public void run(){
    System.out.println("This code is running in a thread.");
  }

  public static void main(String[] args){
    ThreadMain thread = new ThreadMain();
    thread.start();
    System.out.println("This code is outside of the thread");
  }
}
/*
 * Another way to create a thread is to implement the `Runnable interface`
 */


 /*  
 "extending" vs "implementing" Threads
when a class extends the Thread class, you cannot extend any other class,
but by implementing the Runnable interface, it is possible to extend from another class as well.
Myclass extends OtherClass impletements Runnable{}

 */


 /* 
public class _Main implements Runnable {
  public void run(){
    System.out.println("This code is running in a thread");
  }
}
*/