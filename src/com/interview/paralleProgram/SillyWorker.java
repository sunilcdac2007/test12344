package com.interview.paralleProgram;

import org.perf4j.StopWatch;

public class SillyWorker {
 
 public static void main(String[] args) throws Exception {
  
  int n = 50;
  long  smiliSecond = System.currentTimeMillis();
  StopWatch stopWatch = new StopWatch();
  FibonacciProblem bigProblem = new FibonacciProblem(n); 
  
  long result = bigProblem.solve();   
  stopWatch.stop();
  
  System.out.println("Computing Fib number: " + n);
  System.out.println("Computed Result: " + result);
  System.out.println("Elapsed Time: " + stopWatch.getElapsedTime() +"  Start time "+stopWatch.getStartTime() );
  long  endmilisecond = System.currentTimeMillis();
  
  System.out.println("Start time "+smiliSecond + "  end time "+endmilisecond +" Total time "+(endmilisecond-smiliSecond));
  
 }

}
