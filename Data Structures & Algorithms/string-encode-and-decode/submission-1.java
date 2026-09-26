class Solution {

    public String encode(List<String> strs) {
        // for each string
        // pre-pend length + #
        // put them all together
        StringBuilder encoded = new StringBuilder();
        for (String word : strs) {
            int length = word.length();
            encoded.append(length);
            encoded.append('#');

            for(char c : word.toCharArray()) {
                encoded.append(c);
            }
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        // go to first #
        // the char before it is the chunk length
        // take that chunk and put in list
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.parseInt(str.substring(i, j));

            i = j + 1;
            j = i + length;

            String word = str.substring(i, j);
            list.add(word);
            
            i = j;
        };

        return list;

    }
}
