public class PointCP3 {
    //Instance variables ************************************************

    /**
     * Contains C(artesian) or P(olar) to identify the type of
     * coordinates that are being dealt with.
     */
    private char typeCoord;

    /**
     * Contains the current value of X or RHO depending on the type
     * of coordinates.
     */
    private double X;

    /**
     * Contains the current value of Y or THETA value depending on the
     * type of coordinates.
     */
    private double Y;


    //Constructors ******************************************************

    /**
     * Constructs a coordinate object, with a type identifier.
     */
    public PointCP3(char type, double X, double Y)
    {
        if(type != 'C' && type != 'P') {
            throw new IllegalArgumentException();
        }

        if (type == 'P'){
            X = Math.cos(Math.toRadians(Y)) * X;
            Y = Math.sin(Math.toRadians(Y)) * X;
        }
        this.X = X;
        this.Y = Y;
        typeCoord = 'C';
    }


    //Instance methods **************************************************


    public double getX()
    {
        return X;
    }

    public double getY()
    {
        return Y;
    }

    public double getRho()
    {
        return (Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2)));
    }

    public double getTheta()
    {
        return Math.toDegrees(Math.atan2(Y, X));
    }


    /**
     * Calculates the distance in between two points using the Pythagorean
     * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
     *
     * @param pointA The first point.
     * @param pointB The second point.
     * @return The distance between the two points.
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
     * @param point The point to rotate
     * @param rotation The number of degrees to rotate the point.
     * @return The rotated image of the original point.
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
        String returnString = "";
        if(typeCoord=='P') {
            returnString += "Computed Polar but not stored:\n (" + getRho() + "," + getTheta() + ")";
        }
        if(typeCoord=='C') {
            returnString += "Stored as Cartesian [" + getX() + "," + getY() + "]";
        }
        return returnString;
    }
}

