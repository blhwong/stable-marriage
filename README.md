stable-marriage
===============
Created by: Brandon Wong
Creation Date: 6/2013 

Source File is labeled Matching.java
Input Files are labeled with the .in extention

Stable Marriage problem used for kids and nannies.
We want to find a stable output.

Two types of instabilities:

-First type of instability: There are kids k and k', and a nanny na, such that
	k is assigned to na, and
	k' is assigned to no nanny, and
	na prefers k' to k

-Second type of instability: There are kids k and k', and nannies na and na', so that
	k is assigned to na, and
	k' is assigned to na', and
	na prefers k' to k, and
	k' prefers na to na'

Input specifications:

First line of the input has two integers separated by a space: m (number of nannies) and n
(number of kids). the second line will be a list of m integers separated by spaces, where the ith
integer specifies the number of kids the ith nanny can handle. The next m lines will represent
nannies' preference list, each consisting of n space separated integers which identify kids.
The ith line in this set of lines corresponds to the preference list of the ith nanny. The last n
lines will represent kids' preference lists, each consisting of m integers which identify nannies.
The ith line in t his set correspons to the preference list of the ith kid. The preference lists
are given in order of most preferred to least preferred

Output specifications:
The output consists of m space separated integers, where the ith integer specifies the number of the 
nanny assigned to the ith kid or -1 if no nanny has been assigned to him/her. 3-10-3.in outputs
-1 1 -1 -1 -1 -1 -1 2 0 -1

concepts used:
Gale Shapley Algorithm, Arrays, Queues