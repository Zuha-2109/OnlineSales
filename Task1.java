
// Task-1
// Simulation of an Event that Follows Given Biasness

// Problem Statement: Write a program that accepts a map of all possible outcomes of an event along with their probabilities and every occurrence of the event would generate outcomes based on the given probabilities. This could be seen as a generalization of events like rolling of a dice (could be biased) or flipping of a coin (could be biased). 
// Examples
// Rolling of a six-faced biased dice
// Input: [ {1, 10}, {2, 30}, {3, 15}, {4, 15}, {5, 30}, {6, 0} ]
// Flipping of a coin

// Rules
// Input: Probabilities given are as integers and percentages.
// Each occurrence of the event should only generate one of the outcomes given in input
// The outcome of each occurrence is independent of that of others.
// On observing a large number (say 1000) of occurrences, the probability distribution should roughly follow the given biasness.
// Example
// Input: [ {1: 35}, {2: 65} ]  ## 1=Head, 2=Tail
// Output:
// On triggering the event 1000 times, Head appeared 332 times and Tail 668 times which is roughly inline with the biasness given.
// This is just one of the possibilities.


// Assuming

// The event will have finite number of possible outcomes, each with a given probability.

// The number of occurrences is fixed and predetermined.

// The outcome of each occurrence is recorded and stored in a map.

// The program outputs the results as a map of outcomes and the number of times each outcome occurred.


import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        // Input probabilities as integers
        Map<Integer, Integer> probabilities = new HashMap<>();
        probabilities.put(1, 10);
        probabilities.put(2, 30);
        probabilities.put(3, 15);
        probabilities.put(4, 15);
        probabilities.put(5, 30);
        // 0 probability means this outcome will never happen
        

        // Checking for Head and Tail probabalities as given in testcase
        // probabilities.put(1, 35);
        // probabilities.put(2, 65);
        
        // Simulating event

        // number of times to simulate the event
        int numOccurrences = 1000; 

        // storing the number of occurrences of each outcome
        Map<Integer, Integer> results = new HashMap<>(); 

        // loop over the number of occurrences
        for (int i = 1; i <= numOccurrences; i++) { 

            // generating a random number between 0 and 99
            int randNum = (int) (Math.random() * 100); 
            int sum = 0; 
            for (Map.Entry<Integer, Integer> entry : probabilities.entrySet()) { 
               
               // adding the current probability to the sum
                sum += entry.getValue(); 

                // if the random number is less than the sum of probabilities
                if (randNum < sum) { 

                    int outcome = entry.getKey(); 
                    // increment the count of the outcome
                    results.put(outcome, results.getOrDefault(outcome, 0) + 1); 
                    break; 
                }
            }
        }
        
        // Output results
        for (Map.Entry<Integer, Integer> entry : results.entrySet()) { 

            // set the outcome to the current key
            int outcome = entry.getKey(); 

            // set the number of occurrences to the current value
            int numTimes = entry.getValue(); 
            System.out.println("Outcome " + outcome + " occurred " + numTimes + " times."); 
        }
    }
}