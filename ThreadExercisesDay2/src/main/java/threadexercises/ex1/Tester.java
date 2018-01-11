package threadexercises.ex1;

public class Tester {
 /*
    A)
    Each run method takes a lot of time because they need to each fetch information from a website. 
    Secondly they are run sequentially because it is not done in a thread. So each run must wait for the 
    previous run to complete before starting.
    Took from 1.5 to 2 seconds on my fast desktop.
    
    B)
    Was easy to refactor because the class already contained a run method. Simply needed to extend the thread and add Override annotation for run.
    
    C)
    - They can now run parallel with each other. 
    - This is because we don't wait for the threads to finish their job before printing their results.
    - By using join on the threads before printing we can see their results printed after each have executed its own task.
    
    D) 
    There is useally a difference of around 200 miliseconds between the sequential and parralel run. Which means that parallel is around 18% faster in this case.
*/
    
    
    
  public static void main(String[] args) throws InterruptedException {
     
    System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());  
    
    
    TagCounter tc1 = new TagCounter("http://www.fck.dk");
   
    TagCounter tc2= new TagCounter("http://www.google.com");
    
    TagCounter tc3= new TagCounter("http://politiken.dk/");
    
    long start = System.nanoTime();
    tc1.start();
    tc2.start();
    tc3.start();
    
    
    
    System.out.println("Title: "+tc1.getTitle());
    System.out.println("Div's: "+tc1.getDivCount());
    System.out.println("Body's: "+tc1.getBodyCount());         
    
    
    System.out.println("Title: "+tc2.getTitle());
    System.out.println("Div's: "+tc2.getDivCount());
    System.out.println("Body's: "+tc2.getBodyCount());   
    
    System.out.println("Title: "+tc3.getTitle());
    System.out.println("Div's: "+tc3.getDivCount());
    System.out.println("Body's: "+tc3.getBodyCount());  
    
    tc1.join();
    tc2.join();
    tc3.join();
    
    long end = System.nanoTime();
    System.out.println("Time Parallel: "+(end-start));
    
    
    
    start = System.nanoTime();
    
    tc1.run();
    tc2.run();
    tc3.run();
    
    System.out.println("Title: "+tc1.getTitle());
    System.out.println("Div's: "+tc1.getDivCount());
    System.out.println("Body's: "+tc1.getBodyCount());         
    
    
    System.out.println("Title: "+tc2.getTitle());
    System.out.println("Div's: "+tc2.getDivCount());
    System.out.println("Body's: "+tc2.getBodyCount());   
    
    System.out.println("Title: "+tc3.getTitle());
    System.out.println("Div's: "+tc3.getDivCount());
    System.out.println("Body's: "+tc3.getBodyCount());  
    
    end = System.nanoTime();
    System.out.println("Time Sequential: "+(end-start));
    
    
  }
}
