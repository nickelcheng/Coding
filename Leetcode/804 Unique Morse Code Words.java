class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> hash = new HashSet<>();
        
        for (String s : words) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                sb.append(morseCode[s.charAt(i)-'a']);
            }
            hash.add(sb.toString());
        }
        return hash.size();
    }
}
