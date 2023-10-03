// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

import design1.PointCP;
import design2.PointCP2;
import design3.PointCP3;

import java.io.*;
import java.util.Random;

import java.time.Instant;
import java.time.Duration;


/**
 * This class prompts the user for a set of coordinates, and then 
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCPTest
{
  //Class methods *****************************************************

  /**
   * This method is responsible for the creation of the PointCP
   * object.  This can be done in two ways; the first, by using the
   * command line and running the program using <code> java 
   * PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
   * </code> and the second by getting the program to prompt the user.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompte him or her.
   *
   * @param //args[0] The coordinate type.  P for polar and C for
   *                cartesian.
   * @param //args[1] The value of X or RHO.
   * @param //args[2] The value of Y or THETA.
   */
  public static void main(String[] args) {

    PointCP2 point;
    PointCP3 point1;

    System.out.println("Cartesian-Polar Coordinates Conversion Program");

    // Check if the user input coordinates from the command line
    // If he did, create the PointCP object from these arguments.
    // If he did not, prompt the user for them.

    //test for cp2
    try {
      point = new PointCP2(args[0].toUpperCase().charAt(0),
              Double.valueOf(args[1]).doubleValue(),
              Double.valueOf(args[2]).doubleValue());

      //

    } catch (Exception e) {
      // If we arrive here, it is because either there were no
      // command line arguments, or they were invalid
      if (args.length != 0)
        System.out.println("Invalid arguments on command line");

      try {
        point = getInput();
      } catch (IOException ex) {
        System.out.println("Error getting input. Ending program.");
        return;
      }
    }

    System.out.println("\nYou entered:\n" + point);
    point.convertStorageToCartesian();

    //Do all CP2 tests


    PointCP2 pointCP2 = new PointCP2('P', 6.5, 3.2);

    System.out.println("CP2 Test: getDistance on: " + pointCP2.toString() + " and: " + point.toString() + ": " + point.getDistance(pointCP2));
    //enter test code here
    //create a new cp2 object here then put the get string of that method in the line 81

    System.out.println("CP2 Test: rotatePoint on: " + pointCP2.toString() + " and: " + point.toString() + ": " + point.rotatePoint(7.9));


    //cp3 test
    try {
      point1 = new PointCP3(args[0].toUpperCase().charAt(0),
              Double.valueOf(args[1]).doubleValue(),
              Double.valueOf(args[2]).doubleValue());

      //

    } catch (Exception e) {
      // If we arrive here, it is because either there were no
      // command line arguments, or they were invalid
      if (args.length != 0)
        System.out.println("Invalid arguments on command line");

      try {
        point1 = getInput2();
      } catch (IOException ex) {
        System.out.println("Error getting input. Ending program.");
        return;
      }
    }
    System.out.println("\nYou entered:\n" + point1);
    point1.convertStorageToPolar();

    //method tests
    PointCP3 pointCP3 = new PointCP3('C', 6.5, 3.2);

    System.out.println("CP3 Test: getDistance on: " + pointCP3.toString() + " and: " + point1.toString() + ": " + point1.getDistance(pointCP3));
    //enter test code here
    //create a new cp2 object here then put the get string of that method in the line 81

    System.out.println("CP3 Test: rotatePoint on: " + pointCP3.toString() + " and: " + point1.toString() + ": " + point1.rotatePoint(7.9));

    //PERFORMANCE TESTING
    System.out.println("Starting performance testing for PointCP");

    //get time now and ten seconds from now
    long startTime = System.currentTimeMillis();
    int i = 0;
    Random rand = new Random();
    char[] types = {'C', 'P'};

    while (i < 20000000) {

      //input code here


      // Create the first random instance of PointCP
      char type1 = types[rand.nextInt(2)];
      double xOrRho1 = rand.nextDouble() * 100;  // random value between 0 and 100
      double yOrTheta1 = rand.nextDouble() * 100;  // random value between 0 and 100
      PointCP point11 = new PointCP(type1, xOrRho1, yOrTheta1);

      // Create the second random instance of PointCP
      char type2 = types[rand.nextInt(2)];
      double xOrRho2 = rand.nextDouble() * 100;  // random value between 0 and 100
      double yOrTheta2 = rand.nextDouble() * 100;  // random value between 0 and 100
      PointCP point2 = new PointCP(type2, xOrRho2, yOrTheta2);

      // Running all the methods on the first instance
      point11.getX();
      point11.getY();
      point11.getRho();
      point11.getTheta();
      point11.getDistance(point2);
      point11.rotatePoint(rand.nextDouble() * 360);  // Rotate by a random angle between 0 and 360 degrees
      point11.toString();

      if (type1 == 'C') {
        point11.convertStorageToPolar();
      } else {
        point11.convertStorageToCartesian();
      }

      // Running all the methods on the second instance
      point2.getX();
      point2.getY();
      point2.getRho();
      point2.getTheta();
      point2.getDistance(point11);
      point2.rotatePoint(rand.nextDouble() * 360);  // Rotate by a random angle between 0 and 360 degrees
      point2.toString();

      if (type2 == 'C') {
        point2.convertStorageToPolar();
      } else {
        point2.convertStorageToCartesian();
      }

      // Update the end time

      i++;
    }
    long timelapsed = System.currentTimeMillis()-startTime;
    System.out.println("Performance test completed for PointCP in: "+timelapsed+" milliseconds");
    System.out.println("Starting performance testing for PointCP2");
    startTime = System.currentTimeMillis();
    i = 0;
    char[] types2 = {'P'};
    types = types2;
    while (i < 20000000) {
      // Create the first random instance of PointCP2
      char type1 = types[rand.nextInt(1)];
      double rho1 = rand.nextDouble() * 100;  // random value between 0 and 100
      double theta1 = rand.nextDouble() * 100;  // random value between 0 and 100
      PointCP2 point111 = new PointCP2(type1, rho1, theta1);

      // Create the second random instance of PointCP2
      char type2 = types[rand.nextInt(1)];
      double rho2 = rand.nextDouble() * 100;  // random value between 0 and 100
      double theta2 = rand.nextDouble() * 100;  // random value between 0 and 100
      PointCP2 point2 = new PointCP2(type2, rho2, theta2);

      // Running all the methods on the first instance
      point111.getX();
      point111.getY();
      point111.getRho();
      point111.getTheta();
      point111.getDistance(point2);
      point111.rotatePoint(rand.nextDouble() * 360);  // Rotate by a random angle between 0 and 360 degrees
      point111.toString();

      // The convertStorageToCartesian function in PointCP2 only prints the values and doesn't change the state.
      // So, we will just call it as is without checking for the type
      point111.convertStorageToCartesian2();

      // Running all the methods on the second instance
      point2.getX();
      point2.getY();
      point2.getRho();
      point2.getTheta();
      point2.getDistance(point111);
      point2.rotatePoint(rand.nextDouble() * 360);  // Rotate by a random angle between 0 and 360 degrees
      point2.toString();
      point2.convertStorageToCartesian2();

      i++;
    }
    timelapsed = System.currentTimeMillis() - startTime;
    System.out.println("Performance test completed for PointCP2 in: " + timelapsed + " milliseconds");
    System.out.println("End of performance testing for PointCP2");

    System.out.println("Starting performance testing for PointCP3");

// Resetting the iteration count and getting the start time.
    startTime = System.currentTimeMillis();
    i = 0;

// As per your class, PointCP3 supports both 'C' and 'P' types.
    char[] types3 = {'C'};

    while (i < 20000000) {
      // Create random instances of PointCP3
      char type1 = types3[rand.nextInt(types3.length)];
      double val1_1 = rand.nextDouble() * 100;
      double val1_2 = rand.nextDouble() * 100;
      PointCP3 point3_1 = new PointCP3(type1, val1_1, val1_2);

      char type2 = types3[rand.nextInt(types3.length)];
      double val2_1 = rand.nextDouble() * 100;
      double val2_2 = rand.nextDouble() * 100;
      PointCP3 point3_2 = new PointCP3(type2, val2_1, val2_2);

      // Running methods on the PointCP3 instances
      point3_1.getX();
      point3_1.getY();
      point3_1.getRho();
      point3_1.getTheta();
      point3_1.getDistance(point3_2);
      point3_1.rotatePoint(rand.nextDouble() * 360);  // Rotate by a random angle between 0 and 360 degrees
      point3_1.toString();

      point3_2.getX();
      point3_2.getY();
      point3_2.getRho();
      point3_2.getTheta();
      point3_2.getDistance(point3_1);
      point3_2.rotatePoint(rand.nextDouble() * 360);  // Rotate by a random angle between 0 and 360 degrees
      point3_2.toString();

      // If PointCP3 has a conversion method, use it. However, the class doesn't seem to change its internal state upon conversion.
      point3_1.convertStorageToPolar2();
      point3_2.convertStorageToPolar2();

      i++;
    }

    timelapsed = System.currentTimeMillis() - startTime;
    System.out.println("Performance test completed for PointCP3 in: " + timelapsed + " milliseconds");
    System.out.println("End of performance testing for PointCP3");





  }

  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a PointCP
   * object.
   *
   * @return A PointCP constructed using information obtained 
   *         from the user.
   * @throws IOException If there is an error getting input from
   *         the user.
   */
  private static PointCP2 getInput() throws IOException
  {
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information
    
    //Information to be passed to the constructor
    char coordType = 'P'; // Temporary default, to be set to P or C
    double a = 0.0;
    double b = 0.0;

    // Allow the user to enter the three different arguments
    for (int i = 0; i < 3; i++)
    {
      while (!(isOK))
      {
        isOK = true;  //flag set to true assuming input will be valid
          
        // Prompt the user
        if (i == 0) // First argument - type of coordinates
        {
          System.out.print("Enter the type of Coordinates you "
            + "are inputting ((C)artesian or (P)olar), this object only supports Polar coordinates: ");
        }
        else // Second and third arguments
        {
          System.out.print("Enter the value of " 
            + (coordType == 'P'
              ? (i == 1 ? "X " : "Y ")
              : (i == 1 ? "X " : "Y "))
            + "using a decimal point(.): ");
        }

        // Get the user's input      
       
        // Initialize the buffer before we read the input
        for(int k=0; k<1024; k++)
        	buffer[k] = '\u0020';        
             
        System.in.read(buffer);
        theInput = new String(buffer).trim();
        
        // Verify the user's input
        try
        {
          if (i == 0) // First argument -- type of coordinates
          {
            if (!((theInput.toUpperCase().charAt(0) == 'P')))
            {
              //Invalid input, reset flag so user is prompted again
              isOK = false;
            }
            else
            {
              coordType = theInput.toUpperCase().charAt(0);
            }
          }
          else  // Second and third arguments
          {
            //Convert the input to double values
            if (i == 1)
              a = Double.valueOf(theInput).doubleValue();
            else
              b = Double.valueOf(theInput).doubleValue();
          }
        }
        catch(Exception e)
        {
        	System.out.println("Incorrect input");
        	isOK = false;  //Reset flag as so not to end while loop
        }
      }

      //Reset flag so while loop will prompt for other arguments
      isOK = false;
    }
    //Return a new PointCP object
    return (new PointCP2(coordType, a, b));
  }





  private static PointCP3 getInput2() throws IOException
  {
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information

    //Information to be passed to the constructor
    char coordType = 'C'; // Temporary default, to be set to P or C
    double a = 0.0;
    double b = 0.0;

    // Allow the user to enter the three different arguments
    for (int i = 0; i < 3; i++)
    {
      while (!(isOK))
      {
        isOK = true;  //flag set to true assuming input will be valid

        // Prompt the user
        if (i == 0) // First argument - type of coordinates
        {
          System.out.print("Enter the type of Coordinates you "
                  + "are inputting ((C)artesian or (P)olar), This object only supports Cartesian: ");
        }
        else // Second and third arguments
        {
          System.out.print("Enter the value of "
                  + (coordType == 'C'
                  ? (i == 1 ? "Rho " : "Theta ")
                  : (i == 1 ? "Rho " : "Theta "))
                  + "using a decimal point(.): ");
        }
        // Get the user's input

        // Initialize the buffer before we read the input
        for(int k=0; k<1024; k++)
          buffer[k] = '\u0020';

        System.in.read(buffer);
        theInput = new String(buffer).trim();

        // Verify the user's input
        try
        {

          if (i == 0) // First argument -- type of coordinates
          {
            if (!((theInput.toUpperCase().charAt(0) == 'C')))
            {
              //Invalid input, reset flag so user is prompted again
              isOK = false;
            }
            else
            {
              coordType = theInput.toUpperCase().charAt(0);
            }
          }
          else  // Second and third arguments
          {
            //Convert the input to double values
            if (i == 1)
              a = Double.valueOf(theInput).doubleValue();
            else
              b = Double.valueOf(theInput).doubleValue();
          }
        }
        catch(Exception e)
        {
          System.out.println("Incorrect input");
          isOK = false;  //Reset flag as so not to end while loop
        }
      }

      //Reset flag so while loop will prompt for other arguments
      isOK = false;
    }
    //Return a new PointCP object
    return (new PointCP3(coordType, a, b));
  }
}
