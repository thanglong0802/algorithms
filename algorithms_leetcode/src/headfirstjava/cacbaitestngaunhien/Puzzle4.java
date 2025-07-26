package headfirstjava.cacbaitestngaunhien;

public class Puzzle4 {

    public static void main(String[] args) {
        Value[] values = new Value[6];
        int number = 1;
        int i = 0;
        while (i < 6) {
            values[i] = new Value();
            values[i].intValue = number;
            number *= 10;
            i += 1;
        }

        int result = 0;
        i = 6;
        while (i > 0) {
            i -= 1;
            result += values[i].doStuff(i);
        }
        System.out.println("result " + result);
    }

}

class Value {
    int intValue;

    public int doStuff(int factor) {
        if (intValue > 100) {
            return intValue * factor;
        } else {
            return intValue * (5 - factor);
        }
    }
}
