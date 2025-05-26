package parrot;

public class NorwegianBlueParrot extends Parrot{
  private final double voltage;
  private final boolean isNailed;

  public NorwegianBlueParrot(double voltage, boolean isNailed){
    this.voltage = voltage;
    this.isNailed = isNailed;
  }

  @Override
  public double getSpeed(){
    return isNailed ? 0.0 : Math.min(24.0, voltage * 12.0);
  }

}
