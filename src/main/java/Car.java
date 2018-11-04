public class Car
{
    private String name;
    private int acceleration;
    private int topSpeed;
    private int cornerSpeed;

    public Car(String name, int acceleration, int topSpeed, int cornerSpeed)
    {
        this.name = name;
        this.acceleration = acceleration;
        this.topSpeed = topSpeed;
        this.cornerSpeed = cornerSpeed;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAcceleration()
    {
        return acceleration;
    }

    public void setAcceleration(int acceleration)
    {
        this.acceleration = acceleration;
    }

    public int getTopSpeed()
    {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed)
    {
        this.topSpeed = topSpeed;
    }

    public int getCornerSpeed()
    {
        return cornerSpeed;
    }

    public void setCornerSpeed(int cornerSpeed)
    {
        this.cornerSpeed = cornerSpeed;
    }
}
