package coffemachine.coffee_machine;

public class coffeeMachine {
    // Singleton class
    private void coffeeMachine() {}
    private static coffeeMachine _this = null;
    public static coffeeMachine getInstance () {
        if (_this == null) {
            _this = new coffeeMachine();
            _this.init(); // set state to POWER_OFF
        }
        return _this;
    }
    public static enum Event {
        Power_on,
        Ready_to_work,
        Coffee_ready,
        Failure_fixed,
        Failure,
        Power_off  // init state
    };
    public static enum State {
        POWER_OFF,
        POWER_PRESENT,
        COFFE_MACHINE_WORKING,
        TROUBLE
    }
    private State myState;
    private void init() {
        transition_to(State.POWER_OFF);   // default transition
    }
    private void transition_to(State target_state) {
        myState = target_state;
    }

    public State getState() {
        return myState;   // default transition
    }
    // FMS
    public State triggerCoffeeMachine(Event e) {
        // in any state, following events are valid: failure, power_off
        if ( e == Event.Failure) {
            transition_to(State.TROUBLE);
        }
        if (e == Event.Power_off) {
            transition_to(State.POWER_OFF);
        }
        switch (myState) {
            case POWER_OFF:
                // only following event(s) are valid: power_on
                switch (e) {
                    case Power_on:
                        transition_to(State.POWER_PRESENT);
                        break;
                }
                break;
            case POWER_PRESENT:
                // only following event(s) are valid: Ready_to_work
                switch (e) {
                    case Ready_to_work:
                        transition_to(State.COFFE_MACHINE_WORKING);
                        break;
                }
                break;

            case COFFE_MACHINE_WORKING:
                switch (e) {
                    // only following event(s) are valid: stop_charging
                    case Coffee_ready:
                        transition_to(State.POWER_PRESENT);
                        break;
                }
                break;
            case TROUBLE:
                switch (e) {
                    // only following event(s) are valid: failer_fixed
                    case Failure_fixed:
                        transition_to(State.POWER_PRESENT);
                        break;
                }
                break;

        }
        return getState();
    }

}

