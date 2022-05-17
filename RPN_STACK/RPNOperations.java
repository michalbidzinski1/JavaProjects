package pl.michalbidzinski;

import java.util.HashMap;
import java.util.Map;

public class RPNOperations {
    public static Map<String, RPN2.Operation> createMap() {
        final Map<String, RPN2.Operation> mapOfOperations = new HashMap<>();
        mapOfOperations.put("+", stack -> stack.push(stack.pop() + stack.pop()));
        mapOfOperations.put("-", stack -> {
            final int subtraction = stack.pop();
            stack.push(stack.pop() - subtraction);
        });
        mapOfOperations.put("*", stack -> stack.push(stack.pop() * stack.pop()));
        mapOfOperations.put("/", stack -> {
            final int division = stack.pop();
            stack.push(stack.pop() / division);
        });

        return (mapOfOperations);
    }
}
