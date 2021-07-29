package com.company.algorithms.sorting;

public class ShellSort {
    public static void main(String[] args) {
      int[] intArray = { 20, 35, -15, 7, 55, 1, -22};
      for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
          for (int i = gap; i < intArray.length; i++) {
              int newElement = intArray[i];
              int j = i;
              while (j >= gap && intArray[j - gap] > newElement) {
                  intArray[j] = intArray[j - gap];
                  j -= gap;
              }
              intArray[j] = newElement;
          }
      }
        for (int j : intArray) {
            System.out.println(j);
        }
    }
}
// Variation of Insertion Sort
// Insertion sort chooses which element to insert using a gap of 1
// Shell Sort starts out using a larger gap value
// As the algorithm runs, the gap is reduced
// Goal is to reduce the amount of shifting required

// As the algorithm progresses, the gap is reduced
// The last gap value is always 1
// A gap value of 1 is equivalent to insertion sort
// So, the algorithm does some preliminary work(using
// gap values greater than 1), and then becomes insertion
// sort
// By the time we get to insertion sort, the array has been
// partially sorted, so there's less shifting required

// 20 35 -15 7 55 1 -22
//We'll base our gap on the array's length. We'll ubutuakuze the
//gap (or interval) to array.length / 2
//On each iteration, we'll divide the gap value by 2 to get the
// next gap value
//For our array, the gap will be initialized to 3
// On the next iteration, it will be 1 - insertion sort
// i = gap = 3
// j = i = 3
// newElement = intArray[i] = 7
// Compare intArray[j - gap] with newElement
// 20 35 -15 20 55 1 -22
// i = gap = 3
// j = j - gap = 0
// newElement = intArray[i] = 7
// 7 35 -15 20 55 1 -22
// i = 4
// j = i = 4
// newElement = intArray[i] = 55
// Compare intArray[j - gap] with newElement
//Nothing to do, because 35 < 55

// i = 5
// j = i = 5
// newElement = intArray[i] = 1
// Compare intArray[j - gap] with newElement
//Nothing to do, because -15 < 1

// i = 6
// j = i = 6
// newElement = intArray[i] = -22
// Compare intArray[j - gap] with newElement
//Nothing to do, because -15 < 1
// 7 35 -15 20 55 1 -20

// i = 6
// j = h - gap = 0
// newElement = intArray[i] = -22
//Compare intArray[j - gap] with newElement
// 7 35 -15 7 55 1 -20
//There are no more elements to compare minus 22 against
//and so we assign minus 22 to position zero
// -22 35 -15 7 55 1 -20

//We have completed the iteration with gap = 3
//Notice how the array is more sorted
//We have moved -22 to the front of the array
//We have also  moved 20 closer to  its sorted
// position

// Now we update the gap (gap / 2)
// The gap will become 1, we are switching to
// insertion sort

//Shell Sort
//In-place algorithm
//Difficult to nail down the time complexity because it
// will depend on the gap. Worst case: O(n2), but it can
// perform much better than that

//Doesn't require as much shifting as insertion sort, so it
// usually performs better
// Unstable algorithm





