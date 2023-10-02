package design3;

// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

import design5.PointCP5;

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public class PointCP3 extends PointCP5
{
    //Instance variables ************************************************

    /**
     * Contains C(artesian) to identify the type of
     * coordinates that are being dealt with.
     */
    private char typeCoord;

    /**
     * Contains the current value of X or RHO depending on the type
     * of coordinates.
     */
    private double x;

    /**
     * Contains the current value of Y or THETA value depending on the
     * type of coordinates.
     */
    private double y;


    //Constructors ******************************************************

    /**
     * Constructs a coordinate object, with a type identifier.
     */
    public PointCP3(char type, double xOrRho, double yOrTheta)
    {
        if(type != 'C')
            throw new IllegalArgumentException();
        this.x = xOrRho;
        this.y = yOrTheta;
        typeCoord = type;
    }


    //Instance methods **************************************************

    /*
     * Test:  done
     */
    public double getX()
    {
        return x;
    }
    /*
     * Test:  done
     */
    public double getY()
    {
        return y;
    }
    /*
     * Test:  done
     */
    public double getRho() {
        return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
    }
    /*
     * Test:  done
     */
    public double getTheta() {
        return Math.toDegrees(Math.atan2(y, x));
    }


    /**
     * Converts Cartesian coordinates to Polar coordinates.
     */
    /*
     * Test:  done
     */
    public void convertStorageToPolar()
    {
        double Rho = getRho();
        double Theta = getTheta();

        System.out.println("Value of Rho: "+getRho()+", Value of Theta: "+getTheta());
    }
    public void convertStorageToPolar2()
    {
        double Rho = getRho();
        double Theta = getTheta();

    }


    /**
     * Calculates the distance in between two points using the Pythagorean
     * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
     *
     * @param //pointA The first point.
     * @param pointB The second point.
     * @return The distance between the two points.
     */

    /*
     * Test:  done
     */
    public double getDistance(PointCP3 pointB)
    {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    /**
     * Rotates the specified point by the specified number of degrees.
     * Not required until E2.30
     *
     * @param //point The point to rotate
     * @param rotation The number of degrees to rotate the point.
     * @return The rotated image of the original point.
     */

    /*
     * Test:  done
     */
    public PointCP3 rotatePoint(double rotation)
    {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP3('C',
                (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
                (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */


    public String toString()
    {
        return "Cartesian  (" + getRho() + "," + getTheta() + ")";
    }
}
