Name: Shiyu Liu        NetID: sliu89
email: sliu89@u.rochester.edu

Synopsis: My package contains six java documents: ICtestjava, InfixCalculator.java
LinkedList.java, myQueue.java, myStack.java, and Node.java. At first, I created the 
Node class to implement the LinkedList class. I used generics to implement a few
methods that would help me build my own stack and queue. The methods include:
a boolean method isEmpty() that checks whether the linkedlist is empty or not, an int
method getSize() that return the nummer of nodes, a void addfirst() generic method 
that adds a node to the front of the linked list, a void addLast() generic method that
adds a node to the tail of the linked list, a generic method removeFirst() that removes
a node at the front of the linked list, a generic method peek() that returns the data
of the first node, and a void printAll() method to print data in all the nodes from
head to tail separated by a white space. Then, I used the LinkedList class to implement
myStack and myQueue class. Both of them inherent isEmpty(), getSize(), peek() and 
printAll() from LinkedList for the same utility. In myStack, I took addfirst() and  
removefirst() from LinkedList and changed their name to push() and pop(). In myQueue,
I took addLast() and  removefirst() from LinkedList and changed their name to enqueue() 
and dequeue(). Note that printAll() is only used to test my code, so I deleted all the code
containing this method after the code is perfect.

The main body of my algorithm is in InfixCalculator class. It contains four methods: a void
method InfixToPostfix() to convert an infix expression to a postix expression, a boolean method
isOperator() to determined whether a string is an operator or not, an int method precedence()
that returns the precedence of each operator, and a double method calculator() that returns
the result obtained from the postifx expression supplied by  InfixToPostfix(). In InfixToPostfix(),
an inputString is separated into chars and then converted back into strings. An array of if else
statements checks whether a string is an operator or not: If it is, push it into the string stack s 
and pop all the operators that has the same or lower precedence and enqueue them. If it isn't,
keep adding the string to numstring until an operator is encountered. At this point, numString
is enqueued into the string queue q and reset to null. For brackets, simply push "(" into s until
")" is encounter. Then numstring is enqueued and reset, all the operators are poped out of s
and enqueue into q. When the outmost for loop exists, an if statement and a while loop make 
sure there isn't any number or operator that hasn't been enqueued.

After  InfixToPostfix() completes its job, calculator() is called to handle the postfix expression
in q. First of all, since my InfixToPostfix() generates some empty node that would result in great
trouble, I have to delete them before every round of evaluation. After that, strings are dequeued
and checked. If the string isn't an operator, it is converted into a double and pushed into the 
double stack Evals. If it is an operator, the switch statement will match each operator with its
corresponding operation, then push the result into Evals. After all the operations, there is only one
number left in Evals so calculator() returns its value. In this case, calculation is completed.

Finally, the input file is read and an output file is written in ICtest class. I created a File object that
read the first string from the command line as the route of the input file and a Printwriter object that
read the second string from the command line as the route of the output file. I used a scanner to scan
each line from the input file call InfixToPostfix(), and then print the result returned from calculator()
into the output file. For result smaller than-1000000 or larger than 1000000, scientific notation is printed.
Other numbers are printed with two digits after the decimal point. 

Obstacles: First of all, the idea of converting char to string an then to double is pretty complicated.
In InfixToPostfix(), I only used char at first but then realized that it cannot handle numbers other than
int. Since char and double are not mutually convertible, I used string to connect these two types. Even
though the idea is feasible, the process of converting my original InfixToPostfix() to the one I handed in
is very twisted: I had to print out the stack and queue and draw graphs on a piece of paper at various 
positions to debug. The second biggest problem is the empty nodes in s. It took me quite a while to find
where the problem is and the reason that causes it.

For extra credit: In my algorithm, I implemented special cases that can solve exponentiation, sine, cosine,
tangent and modulo. Their function can be demonstrated by the extra_test.txt file I enclosed in the 
package. The expected result is presented in myEval.txt. You can also use your own test to check it.
(for sin, cos and tan, please enter degree, not radian) Moreover, my algorithm manages to print 
extra larger or extra small numbers in scientific notation. And if there are more "(" than ")", it will 
print "Invalid expression!" in the console.









