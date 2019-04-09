package com.ExercisesonVariables;

public class DefiningVariables {



/// EXERCISE 1- Invalid Definitions for DataTypes
        //   int gear = a;
        //   String B= "New";
        //   Float Amount = 1200;
        //   byte A= 45678;
        //   Long Beta= 101010101;
        //   short S= 201010000;
        //   Boolean test = 0;
        //   double var1 = 1200f_;

        // errors on the above definitions:
        //    Information:java: Errors occurred while compiling module 'ExercisesonVariables'
        //    Information:javac 1.8.0_201 was used to compile java sources
        //     Information:9/4/19 12:08 PM - Build completed with 7 errors and 0 warnings in 1 s 501 ms
        //             /home/user/IdeaProjects/ExercisesonVariables/src/com/ExercisesonVariables/DefiningVariables.java
        //     Error:(7, 20) java: cannot find symbol
        //    symbol:   variable a
        //    location: class com.ExercisesonVariables.DefiningVariables
        //    Error:(9, 24) java: incompatible types: int cannot be converted to java.lang.Float
        //    Error:(10, 17) java: incompatible types: possible lossy conversion from int to byte
        //   Error:(11, 20) java: incompatible types: int cannot be converted to java.lang.Long
        //    Error:(12, 18) java: incompatible types: possible lossy conversion from int to short
        //  Error:(13, 24) java: incompatible types: int cannot be converted to java.lang.Boolean
        //    Error:(14, 23) java: cannot find symbol
        //    symbol:   variable $1200
        //    location: class com.ExercisesonVariables.DefiningVariables
        //    Error:(14, 28) java: ';' expected
        //Warning:(14, 28) java: '_' used as an identifier
        //  (use of '_' as an identifier might not be supported in releases after Java SE 8)


/// Exercise 2- --Uninitialised fields

        // int gear ;
        // String B;
        // Float Amount ;
        // byte A;
        // Long Beta;
        // short S;
        // Boolean test;
        // double var1;

        // System.out.println("int:" + gear);
        //  System.out.println("string:" + B);
        //  System.out.println("Float:" + Amount);
        // System.out.println("byte:" + A);
        //  System.out.println("Long:" + Beta);
        //  System.out.println("short:" + S);
        //  System.out.println("Boolean:" + test);
        //  System.out.println("double:" + var1);

        ////Error Messages
        // Error:(48, 37) java: variable gear might not have been initialized
        // Error:(49, 40) java: variable B might not have been initialized
        // Error:(50, 39) java: variable Amount might not have been initialized
        // Error:(51, 38) java: variable A might not have been initialized
        // Error:(52, 38) java: variable Beta might not have been initialized
        // Error:(53, 39) java: variable S might not have been initialized
        // Error:(54, 41) java: variable test might not have been initialized
        // Error:(55, 40) java: variable var1 might not have been initialized

//Exercise -3 : Local Variables : uninitialized variables

            void getValue(){

                int gear;
                String B;
                Float Amount;
                byte A;
                Long Beta;
                short S;
                Boolean test;
                double var1;

                System.out.println("int:" + gear);
                System.out.println("string:" + B);
                System.out.println("Float:" + Amount);
                System.out.println("byte:" + A);
                System.out.println("Long:" + Beta);
                System.out.println("short:" + S);
                System.out.println("Boolean:" + test);
                System.out.println("double:" + var1);
    }
public static void main(String[] args) {
        System.out.println(" inside main");
}
}

/// Errors from the Exercise 3 compilation

        //ror:(81, 45) java: variable gear might not have been initialized
        //Error:(82, 48) java: variable B might not have been initialized
        //Error:(83, 47) java: variable Amount might not have been initialized
        //Error:(84, 46) java: variable A might not have been initialized
        //Error:(85, 46) java: variable Beta might not have been initialized
        //Error:(86, 47) java: variable S might not have been initialized
        //Error:(87, 49) java: variable test might not have been initialized
        //Error:(88, 48) java: variable var1 might not have been initialized