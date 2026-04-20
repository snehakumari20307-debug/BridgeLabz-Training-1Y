package com.gla.LambdaExpression;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class SmartLightingAutomation {

    // Light action interface using Consumer
    private static Consumer<String> lightAction;

    public static void main(String[] args) {
        // Define different triggers mapped to lambda behaviors
        Map<String, Consumer<String>> triggers = new HashMap<>();

        // Motion trigger
        triggers.put("motion", (room) ->
                System.out.println("Motion detected in " + room +
                        " → Turning ON lights with soft white glow"));

        // Time of day trigger
        triggers.put("morning", (room) ->
                System.out.println("Good morning! In " + room +
                        " → Bright daylight mode activated"));

        triggers.put("evening", (room) ->
                System.out.println("Evening in " + room +
                        " → Warm dim lighting for relaxation"));

        // Voice command trigger
        triggers.put("voice:on", (room) ->
                System.out.println("Voice command: Lights ON in " + room));

        triggers.put("voice:off", (room) ->
                System.out.println("Voice command: Lights OFF in " + room));

        // Simulate events
        executeTrigger(triggers, "motion", "Living Room");
        executeTrigger(triggers, "morning", "Kitchen");
        executeTrigger(triggers, "evening", "Bedroom");
        executeTrigger(triggers, "voice:on", "Study Room");
        executeTrigger(triggers, "voice:off", "Hallway");
    }

    // Helper method to execute trigger
    private static void executeTrigger(Map<String, Consumer<String>> triggers, String trigger, String room) {
        Consumer<String> action = triggers.get(trigger);
        if (action != null) {
            action.accept(room);
        } else {
            System.out.println("No action defined for trigger: " + trigger);
        }
    }
}


