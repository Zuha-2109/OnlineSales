// Task-2
// Evaluate multiple mathematical expressions at once using a Web API

// Problem Statement
// Write a program that accepts multiple mathematical expressions and evaluates each of them using any public Web API available. The program should display the result of each expression on the console.
// Rules
// No expressions should be evaluated in the code. All evaluations should be using the Web API.
// You can assume different expressions that are compatible with the API you choose. 
// Example: Some API might use ^ operator for power some might use pow()
// Example
// Input (every line is an expression, evaluate when “end” is provided as an expression)
// 2 * 4 * 4
// 5 / (7 - 5)
// sqrt(5^2 - 4^2)
// sqrt(-3^2 - 4^2)
// end
// Output
// 2 * 4 * 4 => 32
// 5 / (7 - 5) => 2.5
// sqrt(5^2 - 4^2) => 3
// sqrt(-3^2 - 4^2) = 5i


// Assuming

// The expressions are valid mathematical expressions.

// The WEBAPI works


import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task2 {

    public static void main(String[] args) throws IOException {


        // appid to get the expressions from wolfframe

        String appId = "Q9UTUQ-G2J5AYJ793";
        String baseUrl = "https://api.wolframalpha.com/v2/query?appid=" + appId;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

       String[] input = {
            "2* 4* 4",
            "5/(7-5)",
            "sqrt(5^2-4^2)",
            "sqrt(-3^2-4^2)",
            "end"
        };

        //checking for base cases
        while ((line = reader.readLine()) != null && !line.equals("end")) {
            input += String.join("", URLEncoder.encode(String.join("", line.split("%0A")).toString(), StandardCharsets.UTF_8));
        }

        URL url = new URL(baseUrl + "&input=" + input + "&format=plaintext");

        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        // storing the results
        String result = "";
          String line2;
        while ((line2 = in.readLine()) != null) {
            result += line2;
        }

        in.close();

        // Using regular expressions to extract the results from the XML response
        String[] results = result.split("<plaintext>(.*?)</plaintext>");

        StringBuilder sb = new StringBuilder();
        for (String result1 : results) {
            sb.append(result1);
        }

        String output = sb.toString();

        System.out.println(output);
    }
}

// The output response is empty with a incompatible error, Not sre whats causing it bt wil to to debugg the code

// Assuming the webapi is not sending proper response to evaluate the expressions