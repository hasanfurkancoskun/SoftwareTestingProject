package coffemachine.coffee_machine;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class Coffee_Machine_State_Transitions {
    coffeeMachine coffee_machine = coffeeMachine.getInstance();
    @Test
    void Coffee_Machine_1_Test_Transition_From_POWER_OFF_to_STAND_BY() {
        assertEquals(coffee_machine.triggerCoffeeMachine(coffeeMachine.Event.Power_on),coffeeMachine.State.STAND_BY);
    }

    @Test
    void Coffee_Machine_2_Test_Transition_From_STAND_BY_to_WORKING() {
        assertEquals(coffee_machine.triggerCoffeeMachine(coffeeMachine.Event.Button_click), coffeeMachine.State.WORKING);
    }
    @Test
    void Coffee_Machine_3_Test_Transition_From_STANDY_BY_to_POWER_OFF() {
        assertEquals(coffee_machine.triggerCoffeeMachine(coffeeMachine.Event.Power_off), coffeeMachine.State.POWER_OFF);
    }
    @Test
    void Coffee_Machine_4_Test_Transition_From_WORKING_to_STAND_BY() {
        assertEquals(coffee_machine.triggerCoffeeMachine(coffeeMachine.Event.Coffee_ready), coffeeMachine.State.STAND_BY);
    }
    @Test
    void Coffee_Machine_5_Test_Transition_From_STAND_BY_to_TROUBLE() {
        assertEquals(coffee_machine.triggerCoffeeMachine(coffeeMachine.Event.Failure), coffeeMachine.State.TROUBLE);
    }
    @Test
    void Coffee_Machine_6_Test_Transition_From_TROUBLE_to_WORKING() {
        assertEquals(coffee_machine.triggerCoffeeMachine(coffeeMachine.Event.Failure_fixed), coffeeMachine.State.WORKING);
    }
    @Test
    void Coffee_Machine_7_Test_Transition_From_WORKING_to_POWER_OFF() {
        assertEquals(coffee_machine.triggerCoffeeMachine(coffeeMachine.Event.Power_off), coffeeMachine.State.POWER_OFF);
    }

}
