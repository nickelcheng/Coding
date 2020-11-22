class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        String[] code = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            code[i] = "";
            for (int j = 0; j < words[i].length(); j++) {
                code[i] += morseCode[words[i].charAt(j)-'a'];
            }
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            boolean unique = true;
            for (int j = i+1; j < words.length && unique; j++) {
                if (code[i].equals(code[j])) {
                    unique = false;
                }
            }
            if (unique) ans++;
        }
        return ans;
    }
}
