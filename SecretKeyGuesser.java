package Project.ori;

public class SecretKeyGuesser {
    public void start() {
        // brute force key guessing
        SecretKey key = new SecretKey();
        String str = "MMMMMMMMMMMM";
        int match = key.guess(str);
        int currMaxMatch = match;
        int currIndex = 0;
        while (match != 12) {
            if (match > currMaxMatch) {
                str = next(str, ++currIndex);
                currMaxMatch = match;
            } else {
                str = next(str, currIndex);
            }
            System.out.println("Guessing... " + str);
            match = key.guess(str);
        }
        System.out.println("I found the secret key. It is " + str);
    }

    static int order(char c) {
        if (c == 'M') {
            return 0;
        } else if (c == 'O') {
            return 1;
        } else if (c == 'C') {
            return 2;
        } else if (c == 'H') {
            return 3;
        }
        return 4;
    }

    static char charOf(int order) {
        if (order == 0) {
            return 'M';
        } else if (order == 1) {
            return 'O';
        } else if (order == 2) {
            return 'C';
        } else if (order == 3) {
            return 'H';
        }
        return 'A';
    }

    // return the next value in 'MOCHA' order, that is
    // M < O < C < H < A
    public String next(String current, int index) {
        char[] curr = current.toCharArray();
        for (int i = curr.length - index - 1; i >=0; i--) {
            if (order(curr[i]) < 4) {
                // increase this one and stop
                curr[i] = charOf(order(curr[i]) + 1);
                break;
            } else {
                curr[i] = 'M';
            }
        }
        return String.valueOf(curr);
    }
}
