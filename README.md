# everyday_farm
(game) Grow up sheep in the farm!

## Structure
- PrimaryPanel
  - DayTimePanel
     - FarmPanel
        + UpPanel
        + DownPanel
     - DayPanel
  - NightTimePanel


## 1. DayTimePanel
낮 화면 패널
### 1.1 FarmPanel
  게임 시작 화면
#### Data
- lblLogo: 제목이미지
- lblHelpMessage: 게임안내메시지
- btnStartSheep1~3: 게임을 시작하는 양그림의 버튼
### 1.2 DayPanel
 게임 메인 화면
upPanel, downPanel로 구성
* upPanel - 양 우리, 농부, 상점, 소지금화가 표시
* downPanel - 가축(양, 소)가 배치

#### Data
- type: SheepThread의 색깔 타입 저장 변수
- SheepThread[] st: 가축을 구입할 경우 이미지가 들어가는 공간

#### Function
- getSheepType()
시작 화면에서 고른 양을 DayPanel로 불러오기

- color(int a)
ActionListener, SheepThread[count]를 통해 객체를 화면에 출력

- SheepThread
시간과 타입을 받아 객체를 생성, 객체 클릭 시 reset()함수를 통해 원상태로 돌아감


## 2. NightTimePanel
밤화면 패널
늑대를 쫓아내는 미니게임 실행
#### Function
- Move
늑대를 움직이게 하는 Thread 생성
