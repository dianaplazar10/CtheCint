package practice;
import java.util.Scanner;

abstract class Distance {
    protected int feet;
    protected float inches;
    
	abstract public void setFeetAndInches(int feet, float inches);
	abstract public int getFeet();
	abstract public float getInches();
	abstract String getDistanceComparison(Distance dist2);
}


// Implementing DistanceImplementation class
class DistanceImplementation extends Distance {

    @Override
    public void setFeetAndInches(int feet, float inches) {
        this.feet = (int) (feet + (inches / 12));
        this.inches =(float) inches + (feet * 12);

    }

    @Override
    public int getFeet() {

        return feet;
    }

    @Override
    public float getInches() {
        return inches;
    }

    @Override
    String getDistanceComparison(Distance dist2) {
        int dist1a = this.getFeet();
        //System.out.println(dist1a);
        int dist2a = dist2.getFeet();
        if (dist1a > dist2a)
            return "First distance is greater";
        else if (dist1a < dist2a)
            return "Second distance is greater";
        else

            return "Both distances are equal";
    }

}
  
  

public class DistanceCalculator {
    private static final Scanner scan = new Scanner(System.in);
    
	public static void main(String[] args) {
		Distance dist1 = new DistanceImplementation();
		Distance dist2 = new DistanceImplementation();
        
        int feet1 = scan.nextInt();
        float inches1 = scan.nextFloat();
        
        int feet2 = scan.nextInt();
        float inches2 = scan.nextFloat();
        
        dist1.setFeetAndInches(feet1, inches1);
        dist2.setFeetAndInches(feet2, inches2);
        
        System.out.println(dist1.getDistanceComparison(dist2));
	}
}