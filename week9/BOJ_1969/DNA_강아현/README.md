## [BOJ] 1969_DNA
[문제 링크](https://www.acmicpc.net/problem/1969)

> **핵심**
> 
> : Hamming Distance가 최소가 되기 위해서는 DNA의 각 위치별로 **가장 많이 나오는 뉴클레오티드를 선택**한다.


1. DNA의 i위치에 있는 뉴클레오티드의 종류와 개수를 구한다.
    ``` python
    Counter([j[i] for j in DNA])
    ```

2. 위에서 구한 리스트에서 개수 기준으로 내림차순, 종류 기준으로 오름차순 (사전 순 제일 먼저 오는 s를 구하기 위해서) 으로 정렬한다. 

3. s와 hamming_dist는 2에서 구한 리스트의 제일 첫번째 원소로 값이 업데이트 된다.
    ```python
    s += a[0][0]
    hamming_dist += (N - a[0][1])
    ```