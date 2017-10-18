package exceptionHandling_05;

public class PinValidator {
    private String pin = "0000";

    public boolean validatePin(String pin){
        return pin.equals(this.pin);
    }
}
