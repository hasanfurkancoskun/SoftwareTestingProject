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
        Power_off,
        Failure,
        Failure_fixed,
        Button_click,
        Coffee_ready

    };
    public static enum State {
        POWER_OFF,
        STAND_BY,
        WORKING,
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
                        transition_to(State.STAND_BY);
                        break;
                }
                break;
            case STAND_BY:
                // only following event(s) are valid: Ready_to_work
                switch (e) {
                    case Button_click:
                        transition_to(State.WORKING);
                        break;
                }
                break;

            case WORKING:
                switch (e) {
                    // only following event(s) are valid: stop_charging
                    case Coffee_ready:
                        transition_to(State.STAND_BY);
                        break;
                    case Button_click:
                        transition_to(State.POWER_OFF);
                        break;
                }
                break;
            case TROUBLE:
                switch (e) {
                    // only following event(s) are valid: failer_fixed
                    case Failure_fixed:
                        transition_to(State.STAND_BY);
                        break;
                }
                break;

        }
        return getState();
    }

}

