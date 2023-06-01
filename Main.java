import java.util.*;

public class Main {
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