import java.util.*;

class 주차요금계산_한의정 {
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int perTime = fees[2];
        int perFee = fees[3];

        Map<String, String> map = new HashMap<>();      // 차량 번호, 시각
        Map<String, Integer> map2 = new HashMap<>();    // 차량 번호, 누적 주차 시간

        for(int i = 0 ; i < records.length ; i++) {
            String[] info = records[i].split(" ");

            String time = info[0];
            String carNum = info[1];
            String cmd = info[2];

            if(cmd.equals("IN")) {
                if(!map.containsKey(carNum) && !info[0].equals("23:59"))
                    map.put(carNum, time);
            }
            else {
                if(map.containsKey(carNum)) {
                    String[] startInfo = map.get(carNum).split(":");
                    int startH = Integer.parseInt(startInfo[0]);
                    int startM = Integer.parseInt(startInfo[1]);

                    String[] endInfo = time.split(":");
                    int endH = Integer.parseInt(endInfo[0]);
                    int endM = Integer.parseInt(endInfo[1]);

                    // 누적 주차 시간 세기
                    int HH = endH - startH;
                    int MM = 0;

                    if(endM < startM) {
                        MM = (endM + 60) - startM;
                        HH--;
                    }
                    else {
                        MM = endM - startM;
                    }

                    map2.put(carNum, map2.getOrDefault(carNum, 0) + 60 * HH + MM);   // 누적 주차 시간 저장

                    map.remove(carNum); // 키 삭제
                }
            }
        }

        // 남은 주차 중인 차들 처리
        for(String carNum : map.keySet()) {
            String[] time = map.get(carNum).split(":");

            int tmpTime = (23 - Integer.parseInt(time[0])) * 60 + (59 - Integer.parseInt(time[1]));

            map2.put(carNum, map2.getOrDefault(carNum, 0) + tmpTime);
        }

        // 주차 요금 계산하기
        List<Node> list = new ArrayList<>();

        for(String carNum : map2.keySet()) {
            int time = map2.get(carNum);
            int fee = basicFee;

            if(time > basicTime) {
                fee += (int)Math.ceil((time - basicTime) / (double)perTime) * perFee;   // 정확한 나눗셈 연산 위해 double을 꼭 해줘야 함!
            }
            list.add(new Node(carNum, time, fee));
        }

        Collections.sort(list); // 차량 번호가 작은 자동차부터 되도록 리스트 정렬

        int[] answer = new int[list.size()];    // 차별 주차 요금
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = list.get(i).money;
        }
        return answer;
    }
}

class Node implements Comparable<Node> {
    String num;
    int time, money;

    public Node(String num, int time, int money) {
        this.num = num;
        this.time = time;
        this.money = money;
    }

    // 차량 번호 오름차순 정렬
    @Override
    public int compareTo(Node n) {
        return Integer.parseInt(this.num) - Integer.parseInt(n.num);
    }
}