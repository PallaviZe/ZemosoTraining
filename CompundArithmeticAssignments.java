package com.Operators;

public class CompundArithmeticAssignments {

    public static void main(String[] args) {

        int result = 1 + 2;
        System.out.println(result);

        result = result - 1;
        System.out.println(result);

        result = result*2;
        System.out.println(result);

        result = result / 2;
        System.out.println(result);

        result = result + 8;
        System.out.println(result);

        result = result % 7;
        System.out.println(result);

  //Exercise --- changing code to add code for compound assignments;

        result = 3;
        System.out.println(result);
        result -= 1;
        System.out.println(result);
        result *= 2;
        System.out.println(result);
        result /= 2;
        System.out.println(result);
        result += 8;
        System.out.println(result);
        result %=7;
        System.out.println(result);

  //Exercise -- In the following Example, explain why "6" is printed twice in a row::


                 int i = 3;
                i++;
                System.out.println(i);    // "4"
                ++i;
                System.out.println(i);    // "5"
                System.out.println(++i);  // "6"
                System.out.println(i++);  // "6"
                System.out.println(i);    // "7"


   //Answer ::: given i = 3; i++ means i+i = 3+ 3 = 6; here the value of i becomes 6 only after the statement is fully executed.
          //  In case of ++i ; it means i + i ; but the value of i becomes 6 even before the statement is fully executed and final value is assigned. As this step is complete currently value of i = 6.




    }
}
