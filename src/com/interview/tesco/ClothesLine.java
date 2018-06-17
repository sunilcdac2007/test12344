package com.interview.tesco;

public class ClothesLine {

	public static void main(String[] args) {
		
		 int length = 10;int clothes = 5;int[][] orders = {{0,4},{6,3},{1,5},{6,4},{7,2}};
		  
		  for( int i =0 ; i < clothes; i++ ){
		   orders[i][1] = orders[i][0] + orders[i][1];
		  }
		  int count = 0;
		  int[][] array = prepareMatrix(orders,clothes, length);
		  
		  for(int index = 0; index < clothes ; index ++){
		   boolean isVisible = false;
		   for(int j = orders[index][0] ; j < orders[index][1]; j++ ){
		    int counter = 0;
		     for(int inner = index+1; inner < clothes ; inner++){
		      counter += array[inner][j];
		      if(counter>0){
		       break;  //break it when cloth is under
		      }
		     }
		    if(counter == 0){
		     isVisible = true; //visible
		    }
		   }
		   if(isVisible){
		    count++;
		   }
		  }
		  System.out.println("Total counter == "+( count));
		
	}
	
	static int[][] prepareMatrix(int[][] orders, int size, int length){

		  int[][] array = new int[size][length];
		  for(int index = size-1; index >= 0 ; index --){
		   for(int j = 0 ; j < length; j++ ){
		    if(j >= orders[index][0] && j<= orders[index][1]){
		     array[index][j] = 1;
		    }else{
		     array[index][j] = 0;
		    }
		   }
		  }
		  return array;

		 }

}
