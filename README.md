# Java Algorithm Study
> 🍥 SSAFY 알고리즘 스터디입니다.
* 기간: 2025년 7월 21일~
* 수준: 백준 실버🥈 3-4
* 언어: Java

# ✍️ 스터디 규칙
- 매일 각 주제 별 두 문제씩 풀이 (당일 11:59분까지)

- 추후 코드리뷰 각자 진행

# 📝 참여 방법
```
1. 이 저장소를 `clone`한다.
2. 생성된 저장소에 `Github ID`로 폴더를 생성한다.
3. 해당 주차의 폴더를 생성한다. ex) {GithubID}/week1
4. 각자 `branch`를 판 뒤 생성된 폴더에 자신의 소스코드를 업로드한다. ex) [문제번호]_GithubID
5. 원본 저장소로 `Pull Request`를 한다.
6. 해당 `PR`에서 코드 리뷰를 진행한다🎉
```

etc. 확인했으면 `approve`하기❗❗❗    


# 스터디 일정

|  | 월 | 화 | 수 | 목 | 금 |
| --- | --- | --- | --- | --- | --- |
| 기본 1 | 자료구조(스택/큐/힙) | 완전탐색/구현/시뮬레이션 | DFS/BFS | 그리디 | DP |
| 기본 2 | Union/Find | 위상정렬 | 이분탐색 | 최단경로 | 백트래킹 |
| 심화 | 투포인터 | 비트마스킹 | LIS | 세크먼트트리 | 팬윅트리 |

- 1주차는 `기본 1`, 2주차는 `기본 2`, 3주차는 `기본 1`과 `기본 2`의 문제를 랜덤하게 뽑아 진행
- 위 싸이클(3주 간격)로 스터디 진행
- 심화 문제는 개인적으로 추가 공부 (기본 문제가 익숙해진다면 함께 진행)

## WEEK 1 (0721 ~ 0727)

### DAY 1 자료구조

> 기본 문제는 자료구조 문제를 풀기 전 익히면 좋을 문제들입니다! 필수는 아니지만 학습을 위해 풀어봤으면 좋겠어요 :)

| 기본 | Title | Difficulty |
| :---: | :---: | :---: |
| 스택 | [1874 스택 수열](https://www.acmicpc.net/problem/1874) | ![Silver II](https://img.shields.io/badge/SILVER%20II-A3A3A3?style=flat)  |
| 큐 | [18258 큐 2](https://www.acmicpc.net/problem/18258) | ![Silver IV](https://img.shields.io/badge/SILVER%20IV-A3A3A3?style=flat)  |
| 힙 | [1927 최소 힙](https://www.acmicpc.net/problem/1927) | ![Silver II](https://img.shields.io/badge/SILVER%20II-A3A3A3?style=flat)  |

| # | Title | Difficulty |
| :---: | :---: | :---: |
| 1 | [1966 프린터 큐](https://www.acmicpc.net/problem/1966) | ![Silver III](https://img.shields.io/badge/SILVER%20III-A3A3A3?style=flat) |
| 2 | [4949 균형 잡힌 세상](https://www.acmicpc.net/problem/4949) | ![Silver IV](https://img.shields.io/badge/SILVER%20IV-A3A3A3?style=flat) |

### DAY 2 완전탐색/구현/시뮬레이션

| # | Title | Difficulty |
| :---: | :---: | :---: |
| 1 | [1913 달팽이](https://www.acmicpc.net/problem/1913) | ![Silver III](https://img.shields.io/badge/SILVER%20III-A3A3A3?style=flat) |
| 2 | [1158 요세푸스 문제](https://www.acmicpc.net/problem/1158) | ![Silver IV](https://img.shields.io/badge/SILVER%20IV-A3A3A3?style=flat) |

### DAY 3 DFS/BFS

| # | Title | Difficulty |
| :---: | :---: | :---: |
| 1 | [1260 DFS와 BFS](https://www.acmicpc.net/problem/1260) | ![Silver II](https://img.shields.io/badge/SILVER%20II-A3A3A3?style=flat) |
| 2 | [2331 반복수열](https://www.acmicpc.net/problem/2331) | ![Silver IV](https://img.shields.io/badge/SILVER%20IV-A3A3A3?style=flat) |

### DAY 4 그리디

| # | Title | Difficulty |
| :---: | :---: | :---: |
| 1 | [13305 주유소](https://www.acmicpc.net/problem/13305) | ![Silver III](https://img.shields.io/badge/SILVER%20III-A3A3A3?style=flat) |
| 2 | [11047 동전 0](https://www.acmicpc.net/problem/11047) | ![Silver IV](https://img.shields.io/badge/SILVER%20IV-A3A3A3?style=flat) |

### DAY 5 DP

| # | Title | Difficulty |
| :---: | :---: | :---: |
| 1 | [1463 1로 만들기](https://www.acmicpc.net/problem/1463) | ![Silver III](https://img.shields.io/badge/SILVER%20III-A3A3A3?style=flat) |
| 2 | [2579 계단 오르기](https://www.acmicpc.net/problem/2579) | ![Silver III](https://img.shields.io/badge/SILVER%20III-A3A3A3?style=flat) |


# 👓 PR 규칙
- PR 제목: 이름/주차/문제번호
- PR 내용
  + 적용 알고리즘 간단히 설명
  + 시간 복잡도, 공간 복잡도 계산
  + 기타 (적용 실패한 접근 방식, 개선한 코드 등)

# 🕶️ 코드리뷰 규칙
- PR에서 코드리뷰 한다.
- 전체 코드 흐름을 파악한 뒤 의견 제시
  + 잘했다고 생각하는 부분
  + 이렇게 하면 더 좋을 것 같다고 생각한 부분
  + 왜 이렇게 풀었는지 궁금한 부분
  + 또 다른 풀이 방식 제시
- 코드의 일부분에 코드리뷰 해도 되고 전체 코드 밑이나 PR 밑에다 코멘트 작성으로 리뷰해도 됩니다.

# 📁 Repository 폴더 구조
```
{GithubID}/week$/{날짜}/{코드.java}
```
→ ex) dnaeuuon/week1/20250721/1000.java

# 💬 Commit Convention
``` 
[#문제번호/{Github ID}] 문제이름
```
→ ex) [#1000/dnaeuuon] A+B
