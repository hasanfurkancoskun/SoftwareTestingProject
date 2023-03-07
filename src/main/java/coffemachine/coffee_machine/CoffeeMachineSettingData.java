package coffemachine.coffee_machine;

import jakarta.persistence.Entity;

import javax.persistence.Id;

@Entity
public class CoffeeMachineSettingData {
    private String P_deviceId = "COFFEE_MACHINE_HOME"; // INVARIANT
    private int P_voltage = 220;		    // Working voltage	integer	208 <= [VAC] =< 240
    private int P_frequency = 50;		    // Working frequency	integer	= 50[Hz] OR 60[Hz]
    private float P_current = 30;			// Working current	Floating point	<= 30 [A]
    private float P_FinalTemperature =93;   // Final Temperature	of Coffee	91 <= [C] =< 95.5
    private float P_WaterWeight=300;		// Approximate weight of Water	100 <= [GR] =< 500
    private float P_CoffeeWeight=300;		// Approximate weight of Coffee Beans	5 <= [GR] =< 50
    private boolean P_dimensions=true ;	    // Existence of Coffee Hopper

    @Id
    private String deviceId;        // INVARIANT A unique device ID
    private int voltage;		    // Charging voltage	integer	208 <= [VAC] =< 240
    private int frequency;	        // Charging frequency integer = 50[Hz] OR 60[Hz]
    private float current;		    // Charging current	Floating point	<= 30 [A]
    private float fTemperature;     // Final Temperature 91 <= [C] =< 95.5
    private float WaterWeight;		// Approximate weight of Water	100 <= [GR] =< 500
    private float CoffeeWeight;	    // Approximate weight of Coffee	Beans 5 <= [GR] =< 50
    private boolean dimensions;	    // Existence of Coffee Hopper

    public CoffeeMachineSettingData () {

    }
    public CoffeeMachineSettingData (boolean preset) {
        if (preset == true) {
            this.deviceId = P_deviceId;  		    // INVARIANT A unique device ID incorporates  the specification EVSE-RS String[16] = CS_FORD_EVSE_RS
            this.voltage = P_voltage;		        // Charging voltage	integer	208 <= [VAC] =< 240
            this.frequency = P_frequency;	        // Charging frequency	integer	= 50[Hz] OR 60[Hz]
            this.current = P_current;			    // Charging current	Floating point	<= 30 [A]
            this.fTemperature = P_FinalTemperature; // Final Temperature of Coffee	91<= [C] =< 96
            this.dimensions = P_dimensions;	        // Existence of Coffee Hopper
            this.CoffeeWeight = P_CoffeeWeight;		// Approximate weight of Coffee Beans	5 <= [GR] =< 50
            this.WaterWeight = P_WaterWeight;	    // Approximate weight of Water	50 <= [GR] =< 500
        }
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public float getCurrent() {
        return current;
    }

    public void setCurrent(float current) {
        this.current = current;
    }

    public float getfTemperature() {
        return fTemperature;
    }

    public void setfTemperature(float fTemperature) {
        this.fTemperature = fTemperature;
    }

    public float getWaterWeight() {
        return WaterWeight;
    }

    public void setWaterWeight(float waterWeight) {
        WaterWeight = waterWeight;
    }

    public float getCoffeeWeight() {
        return CoffeeWeight;
    }

    public void setCoffeeWeight(float coffeeWeight) {
        CoffeeWeight = coffeeWeight;
    }

    public boolean isDimensions() {
        return dimensions;
    }

    public void setDimensions(boolean dimensions) {
        this.dimensions = dimensions;
    }

    //Validation Methods
    public boolean validateDeviceId(String deviceId) {
        if ( deviceId.equals(P_deviceId)) return true;
        return false;
    }
    public boolean validateFrequency(float frequency) {
        if (frequency == 50 ||  frequency == 60) return true;
        return false;
    }
    public boolean validateVoltage(float voltage) {
        if (voltage >= 208 &&  voltage <= 240) return true;
        return false;
    }

    public boolean validateCurrent(float current) {
        if (current >= 0 &&  current <= 30) return true;
        return false;
    }
    public boolean validateFinalTemperature(float f) {
        if (f >= 01 &&  f <= 96) return true;
        return false;
    }
    public boolean validateDimensions(String dimensions) {
        if (dimensions.equals(P_dimensions)) return true;
        return false;
    }
    public boolean validateWaterWeight(float f) {
        if (f >= 100 &&  f <= 500) return true;
        return false;
    }
    public boolean validateCoffeeWeight(float f) {
        if (f >= 5 &&  f <= 50) return true;
        return false;
    }
}
