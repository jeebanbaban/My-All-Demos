package com.example.myapplication.testJava;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class Test{

    public Test(){

    }

    public static void main(String[] args) {
        System.out.println("main thread priority= "+Thread.currentThread().getPriority());
        //Thread.currentThread().setPriority(5);
        MyThread myThread =new MyThread();
        myThread.setPriority(1);
        myThread.start();

        for (int i=1 ; i<5 ; i++) {
            System.out.println("Main Thread");
        }

        MyNewThread myNewThread=new MyNewThread();
        myNewThread.setPriority(10);
        myNewThread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    public static class MyThread extends Thread{
        @Override
        public void run() {
            //super.run();
            for (int i=1 ; i<5 ; i++){
                System.out.println(" 1st Child Thread");
            }
        }
    }

    public static class MyNewThread extends Thread{
        @Override
        public void run() {
            //super.run();
            for (int i=1 ; i<5 ; i++){
                System.out.println(" 2nd Child Thread");
            }
        }
    }

}