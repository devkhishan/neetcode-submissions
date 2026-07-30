class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>(); 

        beginSet.add(beginWord);
        endSet.add(endWord);

        int length = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();

            for(String word : beginSet) {
                char[] temp = word.toCharArray();
                for(int i=0;i<temp.length;i++) {
                    char og = temp[i];

                    for(char j='a';j<='z';j++) {
                        if (temp[i] == j) continue;

                        temp[i] = j;
                        String nWord = new String(temp);

                        if (endSet.contains(nWord)) {
                            return length+1;
                        }

                        if (wordSet.contains(nWord)) {
                            nextSet.add(nWord);
                            wordSet.remove(nWord);
                        }
                    }

                    temp[i] = og;
                }
            }
            length++;
            beginSet = nextSet;
        }

        return 0;
    }
}