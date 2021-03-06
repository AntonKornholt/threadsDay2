package threadexercises.ex3;

import java.util.concurrent.ArrayBlockingQueue;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class RandomNumberProducer implements Runnable{

  public static final int MAX_NUMBERS_TO_PRODUCE = 100;
  public static final int MAX_RANDOM = 100;

  ArrayBlockingQueue<Integer> numbersProduced;

  public RandomNumberProducer(ArrayBlockingQueue<Integer> numbersProduced) {
    this.numbersProduced = numbersProduced;
  }
  
  @Override
  public void run() {
    //Todo: Produce MAX_NUMBERS_TO_PRODUCE of random numbers between 0 and MAX_RANDOM and
    //      place the numbers in numbersProduced
    for(int i = 0; i < MAX_NUMBERS_TO_PRODUCE; i++)
    {
        int randomNumber = (int) ((Math.random()*MAX_RANDOM+1));
        
        try {
            this.numbersProduced.put(randomNumber);
        }
        catch(InterruptedException ex){
            System.out.println(ex);
        }
    }
    
  }
  
  //By now, you should know how to produce random numbers, but if not, use/run this as a guide
//  public static void main(String[] args) {
//    int MAX_RAND = 2;
//    for (int i = 0; i < 10; i++) {
//      int random = (int) ((Math.random() * MAX_RAND+1));
//      System.out.println(random);
//    }
//  }

  
  
}
