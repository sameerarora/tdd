package com.xyz.training.caesershift;

public class CaeserShift {

    private static final char START = 'a';

    private static final int ALPHABET_SIZE = 26;

    public String decode(String input, int shift) {
        return encode(input, -shift);
    }

    public String encode(String input, int shift) {
        StringBuilder builder = new StringBuilder();
        for (char c : input.toCharArray()) {
            builder.append(applyShift(c, shift));
        }
        return builder.toString();
    }

    private char applyShift(char character, int shift) {
        int shifted = character + shift % ALPHABET_SIZE;

        if (fallsBehindAlphabets(shifted)) {
            return (char) (shifted + ALPHABET_SIZE);
        }

        if (movesBeyondAlphabets(shifted)) {
            return (char) (shifted - ALPHABET_SIZE);
        }

        return (char) (shifted);
    }

    private boolean movesBeyondAlphabets(int shifted) {
        return shifted >= ALPHABET_SIZE + START;
    }

    private boolean fallsBehindAlphabets(int shifted) {
        return shifted < START;
    }

}
