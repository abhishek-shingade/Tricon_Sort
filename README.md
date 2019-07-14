# Tricon_Sort

"" <i> only comparisons allow sorting , no comparisons , no sorting </i>""

## Points

1) Basic Sorting Algorithm . 

2) Uses Three point , Comparisons

3) Number of Array Elements = Multiple of Three

4) Able to Place Two Big elements on there positions , after each iteration

<img src="ScreenShots/one.jpg" height="300" width="300">

## Concept

Algorithm has Three major steps :

1) Pull
2) Compare
3) Push

The Pull part involves , pulling elements from the array , to three variables </br>
for comparison . It also covers the part of pulling new elements from the array  </br>
when previous comparisons are done .


## How does it Compare

<img src="ScreenShots/Compare Truth Table.jpg" height="300" width="450">

1) The three variables , which are being used for comparison will get a specific value </br>
     when there comparison results to True . If there comparison results to false , then </br>
     the value assigned is zero .

2) This technique is used , so that , the alternative of if...else if ladder is avoided </br>
   and a better approach of switch(condition) is used .

3) The values are added and a new unique value is generated , which is given to </br>
     Push-step for futher movement of data into the array .

## How are the elements Pushed

1) Based on the value provided from the Compare-step , switch(condition) is used </br>
     for Pushing data on the array . 

2) Out of the three one variable has the smallest value , which is pushed on to the array </br>
     , then a new element is Pulled from the array and Comparisons are done again .

## Early Exit Feature

1) This a method in the code , which compares elements in the array before </br>
     the elments are pulled , compared or pushed .

2) The level of Comparions required to decide , wheater the array is sorted or not </br>
     decreases as the number loops increase . (loop #1 i)

3) So first cheking is done and if the array is sorted then , the Algorithm skips to the </br>
     part of , printing the elements of array .

## Some thoughts

1) Do not judge this for speed or time complexity , it might be requiring more time than </br>
     Bubble Sort Early Exit . But do Note the point that , they are still various ways to sort elements </br>
     or to place elements in there proper positions .

2) Ofcourse many options , solutions , methods exist to solve a problem but we as an individuals should also</br>
     allow our thinking to be a part o the solution . Because ultimately , "<i> a Code is your thinking in Text .</i> "
