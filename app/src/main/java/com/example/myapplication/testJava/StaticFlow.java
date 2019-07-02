package com.example.myapplication.testJava;

public class StaticFlow {

    public static int i=10;

    static {
        normalMethod();
        System.out.println("First Static Block");
    }

    public static void main(String[] args){
        normalMethod();
        System.out.println("Main Method");
    }

    public static void normalMethod(){
        System.out.println(j);
    }

    static {
        System.out.println("Second Static Block");
    }

    public static int j=20;


    /////////////////////////////////////////////////EXPLANATION OF STATIC CONTROL FOLW//////////////////////////////////////////////////////////////

    // (1). Identification of static members from top to bottom
    // (2). Execution of static variables assigments and static blocks from top to bottom
    // (3). Execution of main method

    //TODO i=0[Read Indirectly Write Only]  (1)
    //TODO j=0[Read Indirectly Write Only]  (1)

    //TODO i=10[Read And write]  (2)

                                                    /////OUTPUT//////
                                           //TODO 0                       (2)
                                           //TODO First Static Block      (2)
                                           //TODO Second Static Block     (2)

    //TODO j=20[Read And write]  (2)

                                           //TODO 20                      (3)
                                           //TODO Main Method             (3)

    /////////FINAL OUTPUT/////////////
    // 0
    // First Static Block
    // Second Static Block
    // 20
    // Main Method

}
