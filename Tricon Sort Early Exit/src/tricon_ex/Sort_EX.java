package tricon_ex;

public class Sort_EX 
{
    static int arr[] = {9,8,1,2,3,4,5,6,7}; //number of elements = 9
    static int arr_num = arr.length; //better if multiple of 3
    static String finalpoint = " "; //for decision based on last result of comparison
    static int a = 0; //hold element for comparison
    static int b = 0; //hold element for comparison
    static int c = 0; //hold element for comparison
    static int pull = 0; //pull from 0th element of array
    static int push = 0; //push at 0th position of array
    static int loop_time = 0; //number of times , looping , loop #1
    static int comp_one = 0; //store unique value after comparison
    static int comp_two = 0; //store unique value after comparison
    static int comp_thr = 0; //store unique value after comparison
    static int comp_val = 0; //create a unique value after addition , of the three
    static int interval = 1; //n-1,n-3,n-5,n-7,...
    static int i = 1; //loop #1
    static int j = 3; //loop #2
    static int result = 1; //used for e_e validation
    static int diff = 2; //used in early_exit()
    
    public static void main(String[] args)
    {
    		//Initial pull
	   	a = arr[pull++]; //pull 0th element from array
	   	b = arr[pull++]; //pull 1st element from array
	   	c = arr[pull++]; //pull 2nd element from array
	       	
	       	//loop_time calculations
	       	loop_time = arr_num / 2; //only integer value is required 
	       	
	       	//call e_e() to check if sorted 
	       	result = early_exit();
	       	
	       	//loop #1
	       	 for(i = 1 ; i <= loop_time && result == 1; i++)
	       	 {
	       		//loop #2
	       		 for(j = 3 ; j <= (arr_num - interval); j++) //pull is being handled by j
	       		 {
	           		 //compare #2
	       			 compare();
	           		 
	           		 //push #2
	       			 push();
	           		 
	           		//set default values
	           		 comp_one = 0; //reset values , to avoid issues 
	           		 comp_two = 0; //in above compare , calculations
	           		 comp_thr = 0;
	           		 comp_val = 0;
	           		 
	           		 if(j == (arr_num - interval)) //when j's value becomes equal to the last array element  
	           		 {			      //then compare is required , push is required 
	           			//compare #2	     //but that pull from array is not required (present in push)
	           			 compare();
	               		 
	               		       //push_no_pull #2
	           			 push_no_pull();        			
	               		 
	           		 } //end if(condition)
	       		 } //end loop #2 
	       		 
	       		 if(i != loop_time) //because when i==loop_time , this is not required , as there are only -
	       		 {		   //- three elements remaining , for sorting
	       			//comparison and push based on final point #1
	       			 finalpoint();
	       			 
	       		 } //end if(condition)
	       		 
	       		if(i != loop_time) //because when i==loop_time , this is not required , as there are only -
	       		{		  //- three elements remaining , for sorting
	       			//set default values
	          		 interval = interval + 2; //for intervals , in loop #2
	          		 push = 0; //push should start from 0th position
	          		 pull = 0; //new array , pull from 0th element
	          		 a = arr[pull++]; //new array , new pull 0th element
	          		 b = arr[pull++]; //new array , new pull 1st element
	          		 c = arr[pull++]; //new array , new pull 2nd element
	       		} //end if(condition)
	       		
	       		if(i == loop_time) //because when i==loop_time , there are only three elements remaining , for sorting
	       		{
	       			//set default values
	          		 comp_one = 0; //reset values , to avoid issues 
	          		 comp_two = 0; //in above compare , calculations
	          		 comp_thr = 0;
	          		 comp_val = 0;
	       			
	   	       		//compare #1
	   	       		 compare();
	   	       		 
	   	       		//push_no_pull #1
	   	       		 push_no_pull();
	   	       		 
	   	       		//comparison and push based on final point #1
	   	       		 finalpoint();
	       		}
	       		
	        	diff = diff + 2; //update the value of diff , to update , number of comparison checks
	        	result = early_exit(); //call e_e() to check if sorted
	        	
	       	 } //end loop #1
    	 
     //display array elements
     for(int k = 0; k < arr_num; k++)
     {
    	 System.out.print(" " + arr[k] + " ");
     }
    	 
     //display value of i , loop #1
     System.out.print("\n\n"+"loop #1 i = "+i);
     System.out.print(" subtract one , times executed");
    	 
    } //end main method
//**********************************************//    
    static void compare()
    {
    	if(a < c)
		 {
		   comp_one = 1; //store this value , else zero default 
		 }
		 if(c < b)
		 {
		   comp_two = 2; //store this value , else zero default
		 }
		 if(b < a)
		 {
		   comp_thr = 5; //store this value , else zero default
		 }
		 
		 comp_val = comp_one + comp_two + comp_thr; //create a unique value by addition
    }
//**********************************************//    
    static void push()
    {
    	switch(comp_val) //use this unique value for further , push steps 
		 {
		 case 8: //TTT
			 arr[push++] = a; //smallest value pushed in the array
			 a = arr[j]; //pull element from array , and place it in empty variable
			 finalpoint = "a"; //used when all elements are pulled and only two out of three -
			 break;           // - remain in the tricon
		 case 3: //TTF
			 arr[push++] = a;
			 a = arr[j];
			 finalpoint = "a";
			 break;
		 case 6: //TFT
			 arr[push++] = b;
			 b = arr[j];
			 finalpoint = "b";
			 break;
		 case 1: //TFF
			 arr[push++] = a;
			 a = arr[j];
			 finalpoint = "a";
			 break;
		 case 7: //FTT
			 arr[push++] = c;
			 c = arr[j];
			 finalpoint = "c";
			 break;
		 case 2: //FTF
			 arr[push++] = c;
			 c = arr[j];
			 finalpoint = "c";
			 break;
		 case 5: //FFT
			 arr[push++] = b;
			 b = arr[j];
			 finalpoint = "b";
			 break;
		 case 0: //FFF
			 arr[push++] = a;
			 a = arr[j];
			 finalpoint = "a";
			 break;
		 } //end switch(condition)
    }//end method
//**********************************************//    
    static void push_no_pull()
    {
    	switch(comp_val)
		 {
		 case 8:
			 arr[push++] = a;
			 finalpoint = "a";
			 break;
		 case 3:
			 arr[push++] = a;
			 finalpoint = "a";
			 break;
		 case 6:
			 arr[push++] = b;
			 finalpoint = "b";
			 break;
		 case 1:
			 arr[push++] = a;
			 finalpoint = "a";
			 break;
		 case 7:
			 arr[push++] = c;
			 finalpoint = "c";
			 break;
		 case 2:
			 arr[push++] = c;
			 finalpoint = "c";
			 break;
		 case 5:
			 arr[push++] = b;
			 finalpoint = "b";
			 break;
		 case 0:
			 arr[push++] = a;
			 finalpoint = "a";
			 break;
		 } //end switch(condition)
    } //end method
//**********************************************//    
    static void finalpoint()
    {
    	switch(finalpoint)
		 {
		 case "a":
			 if(c < b)
			 {
				 arr[push++] = c;
				 arr[push] = b;
			 }
			 else
			 {
				 arr[push++] = b;
				 arr[push] = c;
			 }
			 break;
		 case "b":
			 if(a < c)
			 {
				 arr[push++] = a;
				 arr[push] = c;
			 }
			 else
			 {
				 arr[push++] = c;
				 arr[push] = a;
			 }
			 break;
		 case "c":
			 if(b < a)
			 {
				 arr[push++] = b;
				 arr[push] = a;
			 }
			 else
			 {
				 arr[push++] = a;
				 arr[push] = b;
			 }
			 break;
		 } //end switch(condition)
    } //end method
//**********************************************//
    static int early_exit()
    {
    	int send = 1; //execute code normally
    	
    	for(int l = 0; l <= (arr_num - diff); l++) //from 0 to n-2 ,n-4,... ,because if(condition) has -
    	{					  //l and l+1 , so comparison of all elements - 
    		if(arr[l] < arr[l + 1])		 //- becomes possible
    		{
    			continue; //if(true) , keep on comparing , till the limit(arr_num - diff)
    		}
    		else
    		{
    			return send; //if even one false , then algorithm -
    		}		    //- has to run in order to sort the data
    	}
    	
    	return send = 0; //do early exit
    }
} //end class
