package threadexercises.ex3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tester {

    /*
    a) because we can create more than 1 number at a time. As threads run in parallel they can each create a number at the same time.
       - that would not always be the right number. It depends on the amount of processors you have. Useally that is 4, so that is 
        often a good number to go with. If you have more you could create more and run with more processing power.
        I would use put because that methods block. Meaning we producer would wait for more space before making more numbers. And could wake when neeeded.
        I would then use take for the same reason as above.
    
    */
  
  public static void main(String[] args) throws InterruptedException {
    //This represent the Queue in the exercise-figure. Observe the size of the Queue
    ArrayBlockingQueue<Integer> numbers = new ArrayBlockingQueue(5);
    
    ExecutorService es = Executors.newCachedThreadPool();
    //Create and start four producers (P1-P4 in the exercise-figure)
    es.execute(new RandomNumberProducer(numbers));
    es.execute(new RandomNumberProducer(numbers));
    es.execute(new RandomNumberProducer(numbers));
    es.execute(new RandomNumberProducer(numbers));
     
    //Create and start single consumer (C1 in the exercise-figure)
    RandomNumberConsumer consumer = new RandomNumberConsumer(numbers);
    es.execute(consumer);    
    
    es.shutdown();
    es.awaitTermination(10, TimeUnit.SECONDS);
    
    System.out.println("Total of all random numbers: " + consumer.getSumTotal());
    System.out.println("Number of random numbers below 50: " + consumer.getBelow50().size());
    System.out.println("Number of random numbers >= 50: " + consumer.getAboveOr50().size());
  }
}
