/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Avery Reyna
 */

package org.example;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args)
    {
        // inputs 1 and 2 ask the user for the order amount and state
        Scanner input = new Scanner(System.in);
        System.out.print("What is the order amount? ");
        String inputOrderAmount = input.nextLine();

        Scanner input2 = new Scanner(System.in);
        System.out.print("What is the state? ");
        String inputState = input2.nextLine();

        // initialized variables for rest of program, with the first one being a double version of the inputted
        // order amount
        double convertedOrderAmount = Double.parseDouble(inputOrderAmount);
        double eauClaireTax = 0.005;
        double dunnTax = 0.004;
        double wisconsinTax = 0.05;
        double illinoisTax = 0.08;
        double subtotal = convertedOrderAmount;
        double updatedTax = 0;

        // prompts the user for more information if they live in Wisconsin, with the county tax totals being updated
        // as such
        if (inputState.equals("Wisconsin"))
        {
            updatedTax = wisconsinTax;

            Scanner input3 = new Scanner(System.in);
            System.out.print("What is the county? ");
            String inputWiCounty = input3.nextLine();

            if (inputWiCounty.equals("Dunn"))
            {
                updatedTax += dunnTax;
            }
            else if (inputWiCounty.equals("Eau Claire"))
            {
                updatedTax += eauClaireTax;
            }
        }
        // updates tax for illinois
        else if (inputState.equals("Illinois"))
        {
            updatedTax = illinoisTax;
        }

        // math done for the updated tax and subtotal
        updatedTax = updatedTax * convertedOrderAmount;
        subtotal += updatedTax;

        System.out.println(String.format("The tax is $%.2f.\nThe total is $%.2f", updatedTax, subtotal));
    }
}