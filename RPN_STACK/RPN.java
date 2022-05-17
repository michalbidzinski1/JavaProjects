package pl.michalbidzinski;


public class RPN {


    public static float calculate(String line)  {
        Stack stack = new Stack(50);


        if(line.equals("")) {
            throw new IllegalArgumentException();

        }

        String[] elements = line.trim().split(" ");

        for(String element : elements) {
            if(element.matches("\\d|[-]?[1-9]\\d*")) {

                int number = Integer.parseInt(element);

                stack.push(number);

            } else {

                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (element) {
                    case "+":
                        stack.push(val2 + val1);
                        break;
                    case "-":
                        stack.push(val2 - val1);
                        break;
                    case "*":
                        stack.push(val2 * val1);
                        break;
                    case "/":
                        stack.push(val2 / val1);
                        break;
                    default:
                        throw new IllegalArgumentException();

                }
            }
        }


           return stack.pop();


    }


    public static void main(String[] args) {
        String line = "2 7 /";
        System.out.println(calculate(line));






    }


}