import java.util.*;

public class 회의실배정_강한주 {
	static class Meeting implements Comparable<Meeting>{ //미팅 객체
		int start; //시작시간
		int end; //끝난시간

		public Meeting(int st,int ed) {
			this.start = st;
			this.end = ed;
		}

		@Override// Comparable 인터페이스의 compareTo메서드를 오버라이딩 한다
		public int compareTo(Meeting m) { //객체 정렬의 기준을 바꾼다
			if(this.end > m.end)return 1; //미팅 끝나는 시간이 더 늦으면 1을 반환
			else if(this.end < m.end)return -1; //미팅 끝나는 시간이 더 빠르면 -1 반환
			else return this.start-m.start; //만약 끝나는 시간이 같으면 더 일찍 시작한 회의 순으로 정렬된다
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n  = sc.nextInt();

		List<Meeting> list = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			list.add(new Meeting(start,end));
		}

		Collections.sort(list);


		int endTime = 0;
		int cnt = 0;

		for(Meeting m:list) {
			if(endTime <= m.start) {
				cnt++;
				endTime = m.end;
			}
		}

		System.out.println(cnt);

	}
}
