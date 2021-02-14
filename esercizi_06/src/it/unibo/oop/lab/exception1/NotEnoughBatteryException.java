package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends RuntimeException {

	private final double batteryLevel;
    private final double batteryRequired;

    public NotEnoughBatteryException(final double batteryLevel, final double required) {
        super();
        this.batteryLevel = batteryLevel;
        this.batteryRequired = required;
    }

    @Override
    public String toString() {
        return "La batteria è finita: " + batteryLevel + "/" + batteryRequired;
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
}
