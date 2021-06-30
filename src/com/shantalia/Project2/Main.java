package com.shantalia.Project2;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static ArrayList<Integer> integerList = new ArrayList<Integer>();

    public static void main(String[] args) {

        System.out.println(" Unsorted List: ");
        //Creating an array
        int[] randomIntegers = new int[20];
        //Create a for loop that takes in the length size of the random integer produced into an arraylist
        for (int i = 0; i < randomIntegers.length; i++) {
            //Creating the Random Number Variable
            Random number = new Random();
            //next int assigns the integer to a variable  x, and produces any number between 1 and 100000 because array size+1 is the index
            int x = 1 + number.nextInt(10000);
            integerList.add(x);

        }
        //Print out the array as a list named integer list.
        System.out.print(integerList);
        System.out.print("list after each pass: ");
        radixSort(integerList);
        //passing integerlist into method radixsort
    }

    public static void radixSort(ArrayList<Integer> list) {
//method void return radix sort
        int digitplace = 1;
        final int radix = 10;
        //create the buckets using ArrayList
        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<Integer>() {
            };

        }
        //using maximum value and the name of integer starting at -1,
        int maximumNumber = -1;
        for (int j = 0; j < integerList.size(); j++) {
            if (integerList.get(j) > maximumNumber) {
                maximumNumber = integerList.get(j);
            }
        }

        //while loop max number is greater than 0, /by 10, and add 1 to count
        int count = 0;
        while (maximumNumber > 0) {
            maximumNumber /= 10;
            count++;
        }

        int i = 0;
        while (count >= 1) {
            //in order to perform radix sort
            //bucket[temp%10].add(i), formula radix sort to store into bucket
            //values go back into numberlist based on where they are
            //count--;
            //digitplace*=Radix
            //insert values of the integers back into the bucket
            for (int sortOne : integerList) {
                i = sortOne / digitplace;
                buckets[i % 10].add(sortOne);

            }
            integerList.clear();
            for (int SortTwo = 0; SortTwo < radix; SortTwo++) {
                for (Integer p : buckets[SortTwo]) {
                    integerList.add(p);

                }
                buckets[SortTwo].clear();

            }
            //move to next place
            digitplace *= 10;


            count--;
            int counter = 0;
            System.out.print(" { ");
            for (int g : integerList) {
                System.out.print(g);
                counter++;
                if (counter < 20) {
                    System.out.print(" , ");

                }

            }
            System.out.print(" } ");
            System.out.println();
        }
    }
}

