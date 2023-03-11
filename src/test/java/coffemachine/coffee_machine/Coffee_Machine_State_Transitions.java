package coffemachine.coffee_machine;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class Coffee_Machine_State_Transitions {
    coffeeMachine coffee_machine = coffeeMachine.getInstance();
    @Test
    void Coffee_Machine_1_Test_Tansition_From_POWER_OFF_to_POWER_PRESENT() {
        assertEquals(coffee_machine.triggerCoffeeMachine(coffeeMachine.Event.Power_on),coffeeMachine.State.POWER_PRESENT);
    }

    @Test
    void Coffee_Machine_2_Test_Tansition_From_POWER_PRESENT_to_COFFE_MACHINE_WORKING() {
        assertEquals(coffee_machine.triggerCoffeeMachine(coffeeMachine.Event.Ready_to_work), coffeeMachine.State.COFFE_MACHINE_WORKING);

    }

}
