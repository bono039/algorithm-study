import java.util.*;

class Solution {
    static HashMap<String, List<Integer>> map = new HashMap<>();    // info의 각 단어가 포함될 수 있는 경우의 수, 점수 리스트

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // 1. info에 있는 값을 띄어쓰기 기준으로 분리하고, 만들 수 있는 모든 경우의 수 만들기
        for(int i = 0 ; i < info.length ; i++) {
            String[] s = info[i].split(" ");
            makeSentence(s, 0, "");
        }

        // 2. 이분탐색 위해 map의 value인 점수 리스트들 오름차순 정렬하기
        for(String key : map.keySet())
            Collections.sort(map.get(key));

        for(int i = 0 ; i < query.length ; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");

            // q[0]으로 map 조회하고, 리스트에 해당하는 값들 가져오기
            if(map.containsKey(q[0]))
                answer[i] = binarySearch(q[0], Integer.parseInt(q[1]));
            else
                answer[i] = 0;
        }

        return answer;
    }

    // [DFS] 각 항목이 속할 수 있는 모든 경우의 수 구해 map에 점수 넣기
    private static void makeSentence(String[] strArr, int cnt, String str) {
        if(cnt == 4) {
            if(!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }

            map.get(str).add(Integer.parseInt(strArr[4]));  // map의 value인 리스트에 점수 넣기
            return;
        }

        makeSentence(strArr, cnt + 1, str + "-");           // - 붙이기
        makeSentence(strArr, cnt + 1, str + strArr[cnt]);   // 현재 문자 붙이기
    }

    // [이분 탐색] key로 map을 조회해 score 점수 이상 받은 사람 수 계산하기
    private static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);

        int start = 0;
        int end = list.size() - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return list.size() - start; // key에 해당하는 점수의 총 개수 - 점수보다 크거나 같은 처음 idx
    }
}