# 🐱‍🏍algorithm-study
**깡한** 알고리즘 스터디

<br/>

## 👩‍👧‍👦 스터디 멤버

<table>
 <tr>
    <td align="center"><a href="https://github.com/ahyun39"><img src="https://avatars.githubusercontent.com/ahyun39" width="130px;" alt=""></a></td>
    <td align="center"><a href="https://github.com/kanghanju"><img src="https://avatars.githubusercontent.com/kanghanju" width="130px;" alt=""></a></td>
    <td align="center"><a href="https://github.com/bono039"><img src="https://avatars.githubusercontent.com/bono039" width="130px;" alt=""></a></td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/ahyun39"><b>ahyun39</b></a></td>
    <td align="center"><a href="https://github.com/kanghanju"><b>kanghanju</b></a></td>
    <td align="center"><a href="https://github.com/bono039"><b>bono039</b></a></td>
  </tr>
  <tr> 
    <td align="center"><img src="https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white"></td>
    <td align="center"><img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white"></td>
    <td align="center"><img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white"></td>
  </tr> 
</table>
<br/>

## 📌 스터디 진행 및 코드리뷰 방식
> 매주 일요일 20-21시

**[진행 전]**
- 매주 7개의 문제를 푼다.
- 다른 사람들의 풀이를 보고 **궁금한 사항**이 있다면, **일요일 오후 4시 전까지** 질문한다. <br/>
  - _질문 시 : 해당 PR 내역의 comment로 질문 작성_

**[진행 중]**
- 작성한 질문 사항들에 대해 질의응답하고, 좋은 코드에 대한 분석이나 해당 문제의 또 다른 좋은 풀이법 등을 공유한다.
  - _답변 시 : PR comment + 게더 (텍스트로 설명하기 어려운 경우)_

**[종료 후]**
- 한 주간의 모든 PR 내역들을 merge한다.
- 스터디 때 이해하지 못 한 문제가 있다면, 다음 스터디까지 해결해와서 설명한다.
- 매주 정리하고 싶은 내용을 Issues에 작성해 올린다.

<br/>

## 🤗 참여 방법

1. 이 저장소를 `clone` 한다.
2. 생성된 저장소에 해당 주차에 맞게 `BOJ_문제번호` 로 폴더를 생성한다.
3. 생성된 폴더에 자신의 소스코드를 업로드한다. ex) `문제이름_자신이름.py / java ...`
4. commit 규칙을 지켜서 커밋한다.
5. 원본 저장소로 `Pull Request` 를 한다.
6. 다른 사람들의 PR 을 보고 자유롭게 코드리뷰를 한다. 되도록이면 다른 멤버들의 코드를 보고 하나 이상씩 피드백을 남깁시다.

<br/>

## 📁 Repository 폴더 구조

```
week@/플랫폼_문제번호/문제명_본인이름.ts/ java ...
```

- 예시 : `week1/BOJ_2548/대표자연수_한의정.py`

<br/>

### 플랫폼

| 플랫폼                  | 태그 |
|----------------------| ---- |
| 백준                   | BOJ  |
| 프로그래머스               | PGS  |
| 삼성 SW Expert Academy | SEA  |
| 그 외                  | ETC  |

<br/>

## ✏️ commit 규칙

- commit 메세지 : [플랫폼] 문제번호_문제이름 / 난이도 / 걸린시간 / 문제풀이성공여부
- merge 가 아니더라도 push 후 PR해줘야 코드 리뷰 가능!

```
git commit -m "[BOJ] 2548_대표자연수 / 실버3 / 10분 / O(X) "
```

- 코드를 커밋하는 경우가 아닐 때 ( readme 수정, 이름 변경, 코드 수정, 주석 추가 및 오타 수정 등 )는 자유롭게 커밋 가능
  <br/>

## 🤝 PR 규칙

- [BOJ] 문제번호_문제이름 / 난이도 / 걸린 시간 / 풀이성공여부
- `[BOJ] 20436_ZOAC3 / 실버4 / 100분 / O`

> 120분을 넘기면 더 이상 시간을 쓰지 말고 다른 분들의 풀이를 참고하시면 좋을 것 같습니다~

<br/>

## 📅 일정표 ( 매주 7문제 )

|                            | 1                                                        | 2                                                      | 3                                                        | 4                                                        | 5                                                            | 6                                                                                  | 7                                                                                |
|----------------------------|----------------------------------------------------------|--------------------------------------------------------|----------------------------------------------------------|----------------------------------------------------------|--------------------------------------------------------------|------------------------------------------------------------------------------------|----------------------------------------------------------------------------------|
| 1주차 정렬 (11.27~12.3)        | [대표 자연수](https://www.acmicpc.net/problem/2548)           | [ATM](https://www.acmicpc.net/problem/11399)           | [블랙 프라이데이](https://www.acmicpc.net/problem/18114)        | [단어 나누기](https://www.acmicpc.net/problem/1251)           | [회의실 배정](https://www.acmicpc.net/problem/1931)               | [두 용액](https://www.acmicpc.net/problem/2470)                                       | [수리공 항승](https://www.acmicpc.net/problem/1449)                                   |
| 2주차 자료구조 (12.4~12.10)      | [스택](https://www.acmicpc.net/problem/10828)              | [괄호](https://www.acmicpc.net/problem/9012)             | [프린터 큐](https://www.acmicpc.net/problem/1966)            | [풍선 터뜨리기](https://www.acmicpc.net/problem/2346)          | [쇠막대기](https://www.acmicpc.net/problem/10799)                | [괄호 제거](https://www.acmicpc.net/problem/2800)                                      | [괄호의 값](https://www.acmicpc.net/problem/2504)                                    |
| 3주차 구현 (12.11~12.17)       | [기적의 매매법](https://www.acmicpc.net/problem/20546)         | [지뢰 찾기](https://www.acmicpc.net/problem/4396)          | [달팽이](https://www.acmicpc.net/problem/1913)              | [달력](https://www.acmicpc.net/problem/20207)              | [기차가 어둠을 헤치고 은하수를](https://www.acmicpc.net/problem/15787)    | [배열 돌리기 1](https://www.acmicpc.net/problem/16926)                                  | [ZOAC](https://www.acmicpc.net/problem/16719)                                    |
| 복습 (12.18~12.24)           | 1~3주차 복습                                                 | -                                                      | -                                                        | -                                                        | -                                                            | -                                                                                  | -                                                                                |
| 4주차 구현 (12.25~12.31)       | [빙고](https://www.acmicpc.net/problem/2578)               | [ZOAC 3](https://www.acmicpc.net/problem/20436)        | [상어 초등학교](https://www.acmicpc.net/problem/21608)         | [오리](https://www.acmicpc.net/problem/12933)              | [오목](https://www.acmicpc.net/problem/2615)                   | [원상 복구](https://www.acmicpc.net/problem/22858)                                     | [빗물](https://www.acmicpc.net/problem/14719)                                      |
| 5주차 탐색 (DFS/BFS) (1.1~1.7) | [바이러스](https://www.acmicpc.net/problem/2606)             | [DFS와 BFS](https://www.acmicpc.net/problem/1260)       | [트리의 부모 찾기](https://www.acmicpc.net/problem/11725)       | [효율적인 해킹](https://www.acmicpc.net/problem/1325)          | [미로 탐색](https://www.acmicpc.net/problem/2178)                | [토마토](https://www.acmicpc.net/problem/7576)                                        | [택배 배달과 수거하기](https://school.programmers.co.kr/learn/courses/30/lessons/150369)  |
| 6주차 구현 (1.8~1.14)          | [스위치 켜고 끄기](https://www.acmicpc.net/problem/1244)        | [별 찍기 - 19](https://www.acmicpc.net/problem/10994)     | [배열 돌리기](https://www.acmicpc.net/problem/17276)          | [단어 뒤집기 2](https://www.acmicpc.net/problem/17413)        | [홀수 홀릭 호석](https://www.acmicpc.net/problem/20164)            | [사탕 게임](https://www.acmicpc.net/problem/3085)                                      | [택배 배달과 수거하기](https://school.programmers.co.kr/learn/courses/30/lessons/150369)  |
| 7주차 DP (1.15~1.21)         | [다리 놓기](https://www.acmicpc.net/problem/1010)            | [설탕 배달](https://www.acmicpc.net/problem/2839)          | [Four Squares](https://www.acmicpc.net/problem/17626)    | [가장 긴 증가하는 부분 수열](https://www.acmicpc.net/problem/11053) | [스티커](https://www.acmicpc.net/problem/9465)                  | [퇴사 2](https://www.acmicpc.net/problem/15486)                                      | [두 큐 합 같게 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/118667) |
| 8주차 그래프 탐색 (1.29~2.4)      | [특정 거리의 도시 찾기](https://www.acmicpc.net/problem/18352)    | [경로 찾기](https://www.acmicpc.net/problem/11403)         | [친구](https://www.acmicpc.net/problem/1058)               | [지름길](https://www.acmicpc.net/problem/1446)              | [Small World Network](https://www.acmicpc.net/problem/18243) | [k진수에서 소수 개수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/92335) | [숨바꼭질](https://www.acmicpc.net/problem/13549)                                    |
| 9주차 구현 (2.5~2.11)          | [DNA](https://www.acmicpc.net/problem/1969)              | [숫자 야구](https://www.acmicpc.net/problem/2503)          | [도영이가 만든 맛있는 음식](https://www.acmicpc.net/problem/2961)   | [오목](https://www.acmicpc.net/problem/2615)               | [링크와 스타트](https://www.acmicpc.net/problem/15661)             | [테트로미노](https://www.acmicpc.net/problem/14500)                                     | [행렬 테두리 회전하기](https://school.programmers.co.kr/learn/courses/30/lessons/77485)   |
| 10주차 (2.12~2.18)           | [파스칼 삼각형](https://www.acmicpc.net/problem/15489)         | [격자상의 경로](https://www.acmicpc.net/problem/10164)       | [과일 서리](https://www.acmicpc.net/problem/17213)           | [단어 맞추기](https://www.acmicpc.net/problem/9081)           | [암호](https://www.acmicpc.net/problem/1394)                   | [주차 요금 계산](https://school.programmers.co.kr/learn/courses/30/lessons/92341)        | [양궁대회](https://school.programmers.co.kr/learn/courses/30/lessons/92342)          |
| 11주차 (2.26~3.3)            | [등수 구하기](https://www.acmicpc.net/problem/1205)           | [한 줄로 서기](https://www.acmicpc.net/problem/1138)        | [비슷한 단어](https://www.acmicpc.net/problem/2607)           | [단어 맞추기](https://www.acmicpc.net/problem/9081)           | [배열 돌리기 3](https://www.acmicpc.net/problem/16935)            | [치즈](https://www.acmicpc.net/problem/2636)                                         | [순위 검색](https://school.programmers.co.kr/learn/courses/30/lessons/72412)         |
| 12주차 (3.4~3.10)            | [돌 게임](https://www.acmicpc.net/problem/9655)             | [1로 만들기](https://www.acmicpc.net/problem/1463)         | [가장 큰 증가하는 부분 수열](https://www.acmicpc.net/problem/11055) | [점프](https://www.acmicpc.net/problem/1890)               | [LCS](https://www.acmicpc.net/problem/9251)                  | [함께 블록 쌓기](https://www.acmicpc.net/problem/18427)                                  | [메뉴 리뉴얼](https://school.programmers.co.kr/learn/courses/30/lessons/72411)        |
| 13주차 (3.18~3.24)           | [트럭](https://www.acmicpc.net/problem/13335)              | [요세푸스 문제](https://www.acmicpc.net/problem/1158)        | [킹](https://www.acmicpc.net/problem/1063)                | [마법사 상어와 비바라기](https://www.acmicpc.net/problem/21610)    | [마법사 상어와 파이어볼](https://www.acmicpc.net/problem/20056)        | [마법사 상어와 블리자드](https://www.acmicpc.net/problem/21611)                              | [도넛과 막대 그래프](https://school.programmers.co.kr/learn/courses/30/lessons/258711)   |
| 14주차 (3.25~3.31)           | [동방 프로젝트 (Small)](https://www.acmicpc.net/problem/14594) | [거북이](https://www.acmicpc.net/problem/8911)            | [지구 온난화](https://www.acmicpc.net/problem/5212)           | [후보 추천하기](https://www.acmicpc.net/problem/1713)          | [인구 이동](https://www.acmicpc.net/problem/16234)               | [상어 중학교](https://www.acmicpc.net/problem/21609)                                    | [수식 최대화](https://school.programmers.co.kr/learn/courses/30/lessons/67257)        |
| 15주차 (4.1~4.7)             | [유기농 배추](https://www.acmicpc.net/problem/1012)           | [쉬운 최단거리](https://www.acmicpc.net/problem/14940)       | [봄버맨](https://www.acmicpc.net/problem/16918)             | [단지번호붙이기](https://www.acmicpc.net/problem/2667)          | [연구소](https://www.acmicpc.net/problem/14502)                 | [벽 부수고 이동하기](https://www.acmicpc.net/problem/2206)                                 | [원 이동하기 1](https://www.acmicpc.net/problem/22946)                                |
| 16주차 BFS (4.8~4.14)        | [섬의 개수](https://www.acmicpc.net/problem/4963)            | [섬의 개수](https://www.acmicpc.net/problem/4963)          | [현수막](https://www.acmicpc.net/problem/14716)             | [공주님을 구해라!](https://www.acmicpc.net/problem/17836)       | [일루미네이션](https://www.acmicpc.net/problem/5547)               | [로봇](https://www.acmicpc.net/problem/1726)                                         | [모래성](https://www.acmicpc.net/problem/10711)                                     |
| 17주차 그리디 (4.15~4.21)       | [로프](https://www.acmicpc.net/problem/2217)               | [주유소](https://www.acmicpc.net/problem/13305)           | [뒤집기 2](https://www.acmicpc.net/problem/1455)            | [강의실 배정](https://www.acmicpc.net/problem/11000)          | [우체국](https://www.acmicpc.net/problem/2141)                  | [택배](https://www.acmicpc.net/problem/8980)                                         | -                                                                                |
| 18주차 (4.22~4.28)           | [2xn 타일링 2](https://www.acmicpc.net/problem/11727)       | [1,2,3 더하기 5](https://www.acmicpc.net/problem/15990)   | [카드 구매하기](https://www.acmicpc.net/problem/11052)         | [합분해](https://www.acmicpc.net/problem/2225)              | [가장 긴 바이토닉 부분 수열](https://www.acmicpc.net/problem/11054)     | [파일 합치기](https://www.acmicpc.net/problem/11066)                                    | [플레이리스트](https://www.acmicpc.net/problem/12872)                                  |
| 19주차 (4.29~5.5)            | [두 스티커](https://www.acmicpc.net/problem/16937)           | [테트리스](https://www.acmicpc.net/problem/3019)           | [캠프 준비](https://www.acmicpc.net/problem/16938)           | [배열 돌리기 4](https://www.acmicpc.net/problem/17406)        | [NxM 보드 완주하기](https://www.acmicpc.net/problem/9944)          | [괄호 추가하기](https://www.acmicpc.net/problem/16637)                                   | [괄호 변환](https://school.programmers.co.kr/learn/courses/30/lessons/60058)         |
| 20주차 (5.6~5.12)            | [늑대와 양](https://www.acmicpc.net/problem/16956)           | [아기 상어 2](https://www.acmicpc.net/problem/17086)       | [스타트링크](https://www.acmicpc.net/problem/5014)            | [물통](https://www.acmicpc.net/problem/2251)               | [연구소2](https://www.acmicpc.net/problem/17141)                | [연구소3](https://www.acmicpc.net/problem/17142)                                      | [문자열 압축](https://school.programmers.co.kr/learn/courses/30/lessons/60057)        |
| 21주차 최단 경로 (5.13~5.19)     | [플로이드](https://www.acmicpc.net/problem/11404)            | [케빈 베이컨의 6단계 법칙](https://www.acmicpc.net/problem/1389) | [특정한 최단 경로](https://www.acmicpc.net/problem/1504)        | [n단 논법](https://www.acmicpc.net/problem/15723)           | [백도어](https://www.acmicpc.net/problem/17396)                 | [최소비용 구하기](https://www.acmicpc.net/problem/1916)     | [택배 배송](https://www.acmicpc.net/problem/5972)                                    |
| 22주차 (5.13~5.19)           | [꽃길](https://www.acmicpc.net/problem/14620)              | [치킨 배달](https://www.acmicpc.net/problem/15686)         | [숫자 재배치](https://www.acmicpc.net/problem/16943)          | [파이프 옮기기 1](https://www.acmicpc.net/problem/17070)       | [십자가 2개 놓기](https://www.acmicpc.net/problem/17085)           | [Four Squares](https://www.acmicpc.net/problem/17626)         | [카드 섞기](https://www.acmicpc.net/problem/21315)                                   |
<br/>


## 🙌 참고 레퍼런스

- [알고리즘 및 코딩 테스트 문제 풀이 챌린지 100](https://github.com/ellynhan/challenge100-codingtest-study)
- [알고리즘 및 코딩 테스트 문제 풀이](https://github.com/Seongho0503/Algo_Study)
- [코딩 테스트 기출 문제 풀이 및 업로드](https://github.com/CodeTest-StudyGroup/Code-Test-Study)
- [알고리즘 스터디1](https://github.com/b1urrrr/Algorithm-Study)
- [알고리즘 스터디2](https://github.com/Stendhalsynd/baekjoon-algorithm-study)
