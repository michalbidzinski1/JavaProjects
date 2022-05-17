package pl.michalbidzinski;


import java.util.Map;

import static pl.michalbidzinski.RPNOperations.createMap;

public final class RPN2 {
    static int numbers;
    static int symbol;
    private static final Map<String, Operation> Operations = createMap();

    public static void main(final String[] argv) throws Exception {
        final RPN2 calculator = new RPN2();
        System.out.println(calculator.calculate("2 7 + 3 / 14 3 - 4 * + 2 /"));



    }
    public static String[] split(String lines){
        return lines.split(" ", -1);
    }
    private static Integer parseInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (final NumberFormatException e) {
            return null;
        }
    }



     interface Operation {

        void operate(final Stack stack);
    }
    public static Boolean validator(String[] arr) throws Exception{
        if(parseInt(arr[0]) == null){
            throw new Exception("First sign should be a number");
        }
        if(parseInt(arr[arr.length-1]) != null){
            throw new Exception("Last sign should be an operator");
        }
        numbers = 0;
        symbol = 0;
        for (String element : arr) {
            if (parseInt(element) != null) {
                numbers++;
            } else {
                symbol++;
            }
        }
        if(numbers == symbol+1){
            return true;
        }else{
            throw new Exception("Insufficient parameters");
        }
    }

    public int calculate(final String line) throws Exception {
        final Stack stack = new Stack(15);
        if(validator(split(line))) {
            for (final String value : split(line)) {
                final Integer intValue = parseInt(value);
                if (intValue == null) {
                    if(!Operations.containsKey(value)){
                        throw new Exception("Not a proper operation mark");
                    }
                    Operations.get(value).operate(stack);
                } else {
                    stack.push(intValue);
                }
            }
            return stack.pop();

        } else {
            throw new Exception("Invalid mathematical expression");
        }

    }

}