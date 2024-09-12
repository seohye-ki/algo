package boj1062;

import java.util.*;

class Main {
    static int K; //배울 수 있는 단어 개수
    static int N; //주어진 단어 수
    static String[] words; //주어진 단어
    static char[] noteach; //단어에 등장하는 알파벳
    static char[] teach; //배운 단어
    static int max = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //단어개수
        K = sc.nextInt(); //가르칠 수 있는 알파벳 수
        words = new String[N]; //주어진 단어
        
        boolean[] alpabet = new boolean[26]; //단어에서 알파벳의 등장 플래그
        List<Character> wordList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String str = sc.next();
            words[i] = str;
            //앞뒤 4글자는 제외하고 돌리기
            for(int idx = 4; idx < str.length() - 4; idx++){
            	char letter = str.charAt(idx);
            	//전에 등장하지 않았던 알파벳이라면 플래그 켜기
                if(letter != 'a' && letter != 'c' && letter != 'i' && letter != 'n' && letter != 't' && alpabet[str.charAt(idx) - 'a'] == false){
                    alpabet[letter - 'a'] = true;
                    wordList.add(letter);
                }
            }
        }

        //배울 수 있는 단어 5개 미만이면 읽을 수 있는 단어 없음
        if(K < 5){
            System.out.println(0);
            return;
        }
        
        //5개 이외에 배울 단어가 없거나 전부다 배울 수 있다면
        if(wordList.size() == 0 || wordList.size() < K - 5) {
        	System.out.println(N);
        	return;
        }

        //단어에 등장하는 알파벳 배열로 만들기
        noteach = new char[wordList.size()];
        for(int i = 0; i < wordList.size(); i++){
        	noteach[i] = wordList.get(i);
        }
   
        teach = new char[K - 5];
    	comb(0, 0);
    	System.out.println(max);
    }

    static boolean canRead(int idx){
        for(int i = 4; i < words[idx].length() - 4; i++){
            char letter = words[idx].charAt(i);
            if(letter == 'a' || letter == 'c' || letter == 'i' || letter == 'n' || letter == 't')
                continue;
            int j = 0;
            while (j < K - 5){
                if(letter == teach[j])
                    break;
                j++;
            }
            if(j == K - 5)
                return false;
        }
        return true;
    }
    
    static void comb(int cnt, int idx) {
        if(cnt == K - 5){
            int total = 0;
            for(int i = 0; i < N; i++){
                if(canRead(i))
                    total++;
            }
            max = Math.max(max, total);
            return;
        }

        for(int i = idx; i < noteach.length; i++){
            teach[cnt] = noteach[i];
            comb(cnt + 1, i + 1);
        }
    }
}
    