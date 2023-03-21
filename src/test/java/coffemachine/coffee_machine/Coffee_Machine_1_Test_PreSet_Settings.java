package coffemachine.coffee_machine;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Coffee_Machine_1_Test_PreSet_Settings {

    CoffeeMachineSettingData settings = new CoffeeMachineSettingData(true);
    @Test
    void Coffee_Machine_1_Test_validateVoltage() {
        assertEquals(settings.validateVoltage(210),true);
        assertEquals(settings.validateVoltage(0),false);
        assertEquals(settings.validateVoltage(234),true);
        assertEquals(settings.validateVoltage(208),true);
        assertEquals(settings.validateVoltage(240),true);
        assertEquals(settings.validateVoltage(300),false);
    }
    @Test
    void Coffee_Machine_2_Test_validateWaterWeight() {
        assertEquals(settings.validateWaterWeight(210),true);
        assertEquals(settings.validateWaterWeight(0),false);
        assertEquals(settings.validateWaterWeight(234),true);
        assertEquals(settings.validateWaterWeight(100),true);
        assertEquals(settings.validateWaterWeight(240),true);
        assertEquals(settings.validateWaterWeight(600),false);
    }

    @Test
    void Coffee_Machine_3_Test_validateCoffeeWeight() {
        assertEquals(settings.validateCoffeeWeight(55),false);
        assertEquals(settings.validateCoffeeWeight(0),false);
        assertEquals(settings.validateCoffeeWeight(44),true);
        assertEquals(settings.validateCoffeeWeight(50),true);
        assertEquals(settings.validateCoffeeWeight(240),false);
        assertEquals(settings.validateCoffeeWeight(3),false);
    }
}
