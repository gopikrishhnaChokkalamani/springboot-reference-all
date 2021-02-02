package com.learning.java.jvm;

public class ClassInitialization {
  
  {
    System.out.println("ClassInitialization : Instance Initializer!...");
  }
  
  static {
    System.out.println("ClassInitialization : Static intializer!...");
  }
  
  static int getInt() {
    System.out.println("ClassInitialization : getInt()!...");
    return 3;
  }
  
  int getInt5() {
    System.out.println("ClassInitialization : getInt5()!...");
    return 5;
  }
  
  public static void main(String[] args) {
    System.out.println("\nJVM invoked the main method ... ");
    System.out.println("Subclass.STATIC_FINAL: " + SubClass.STATIC_FINAL);
    //System.out.println("Subclass.stringLiteral: " + Subclass.stringLiteral);
    System.out.println("Invoking Subclass.STATIC_FINAL2  ... ");
    System.out.println("Subclass.STATIC_FINAL2: " + SubClass.STATIC_FINAL2);
    System.out.println("\nInstantiating Subclass ...");
    new SubClass();
    System.out.println("Superinterface.STATIC_FINAL3: " + SuperInterface.STATIC_FINAL3);
    ///SuperInterface.staticMethod();
  }
}

interface SuperInterface {
  
  int STATIC_FINAL3 = new ClassInitialization().getInt();
  
  int STATIC_FINAL5 = new ClassInitialization().getInt5();
  
  static void staticMethod() {
    System.out.println("Superinterface: staticMethod");
  }
}

class ObjectReference {
  
  ObjectReference() {
    System.out.println("ObjectReference: constructor");
  }
}

class SuperClass {
  
  static {
    System.out.println("Superclass: static initializer");
  }
  
  {
    System.out.println("Superclass: instance initializer");
  }
  
  SuperClass() {
    System.out.println("Superclass: constructor");
  }
}

class SubClass extends SuperClass implements SuperInterface {
  static final int STATIC_FINAL = 47;
  static final int STATIC_FINAL2 = (int) (Math.random() * 5);
  
  //static String stringLiteral = "hello";
  //public static int STATIC_FINAL4 = new ClassInitializationDemo().getInt();
  
  ObjectReference objectReference = new ObjectReference();
  
  static {
    System.out.println("Subclass: static initializer");
    //staticFinal = 47;
  }
  
  SubClass () {
    System.out.println("Subclass: constructor");
  }
  
  // Instance initializer is copied to the beginning of constructor by compiler
  {
    System.out.println("Subclass: instance initializer");
  }
}
