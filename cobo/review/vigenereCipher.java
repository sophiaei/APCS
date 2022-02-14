public class vigenereCipher {
    public static String encode(String plain, String keyword) {
        String encoded = "";
        char[] charArray = plain.toCharArray();
        int i = 0;
        for (char c : charArray) {
            if (c < 65 || c > 90) {
                encoded += c;
            }
            // System.out.println(keyword.charAt(i % keyword.length()));
            else if (c + keyword.charAt(i % keyword.length()) - 'A' <= 90) {
                encoded += (char) (c + keyword.charAt(i % keyword.length()) - 'A');
                i++;
            }
            else if (c + keyword.charAt(i % keyword.length()) - 'A' > 90) {
                encoded += (char) (c - (91 - keyword.charAt(i % keyword.length())));
                i++;
            }
        }
        return encoded;
    }

    public static void main(String[] args) {
        System.out.println(encode("THANK YOU", "COVER")); //should print VVVRB ACP
        System.out.println(encode("DECODE", "KEY")); //should print NIAYHC
    }
}
