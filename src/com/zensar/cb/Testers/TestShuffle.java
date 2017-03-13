package com.zensar.cb.Testers;

import java.util.Arrays;
import java.util.Random;

class TestShuffle
{
  public static void main(String args[])
  {
    long[] solutionArray = { 1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11 };

    shuffleArray(solutionArray);
    System.out.println(Arrays.toString(solutionArray));
  }

  // Implementing Fisher–Yates shuffle
  static void shuffleArray(long[] ar)
  {
    Random rnd = new Random();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      long a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }
}