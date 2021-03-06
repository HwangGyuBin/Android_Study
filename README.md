# Android_Study

# 레이아웃
  <details> 
  <summary> 목록 </summary>
  
  * 레이아웃 공통
    - xml 이해
      + 접두어
        + xmlns:android > 안드로이드 기본 SDK에 포함되어 있는 속성
        + xmlns:app > 프로젝트에서 사용하는 외부 라이브러리에 포함되어 있는 속성
        + xmlns:tools > 디자이너 도구 등에서 화면에 보여줄 때 사용. 앱에서는 보이지 않음(적용x)
    - 크기 단위
      + | 이름| 단위 표현| 설명 |
        | -- | -- | -- | 
        | px | 픽셀 | 화면 픽셀의 수|
        | dp 또는 dip | 밀도 독립적 픽셀 | 160dpi 화면을 기준으로 한 픽셀 <br/> 해상도에 비례하는 비슷한 크기로 보이게할때 사용 |
        | sp 또는 sip | 축척 독립적 픽셀 | 텍스트 크기 지정에 사용하는 단위, 글꼴의 설정에 따라 1sp당 픽셀수가 달라짐|
        | in | 인치 | 1인치로 된 물리적 길이 |
        | mm | 밀리미터 | 1밀리미터로 된 물리적 길이 |
        | em | 텍스트 크기 | 글꼴과 상관없이 동일한 텍스트 크기 표시|
    - 테두리, 마진, 패딩
      + 테두리선을 기준으로 테두리선의 바깥쪽 공간을 마진이라 함
      + 테두리선을 기준을 안쪽의 공간을 패딩이라 함
    - Context
      + 객체의 정보를 담고있는 객체. 구성 요소인 뷰에 대한 정보를 쉽게 확인하고 설정할 수 있도록 인자로 전달됨
      + 뷰 객체를 코드에서 만들 떄는 항상 Context 객체가 요구됨
    - 정렬
      + layout_gravity > 부모 컨테이너의 여유 공간에 뷰가 모두 채워지지 않아, 여유 공간이 생겼을 때 안에서 뷰를 어떻게 정렬할건지
      + gravity > 뷰 안에 표시하는 내용물들을 어떻게 정렬할 것인지
    - layout_weight
      + 부모 컨테이너에 남아 있는 여유 공간을 분할하여, 기존에 추가했던 뷰에 할당
      + 비율로 지정
  
  * 제약 레이아웃
    - 이해
      + 뷰의 크기와 위치를 결정할 때, 제약 조건을 사용
      + 제약 조건이란 뷰가 레이아웃 안의 다른 요소와 어떻게 연결되는지 알려주는 것
      + 제약 조건은 뷰의 연결점과 대상(타깃)을 연결하여 설정
      + 타킷은 1. 같은 부모 레이아웃 안에 들어있는 다른 뷰의 연결점, 2. 부모 레이아웃의 연결점, 3. 가이드라인 등이 될 수 있다
      + 연결점은 1. 위, 아래, 왼, 오른쪽, 2. 가로축 가운데, 세로축 가운데, 3. 베이스라인 등이 될 수 있다 
    - 가이드라인
      + 여러 개의 뷰를 일정한 기준 선에 정렬할 때 사용
      + 뷰처럼 화면에 추가할 수 있지만, 화면에 보이지 않음
  
  
  * 리니어 레이아웃
    - 이해
      + 박스 모델을 사용하는 레이아웃
      + 한쪽 방향으로 차례대로 뷰를 추가하며 화면을 구성함
      + 뷰가 차지할 수 있는 사각형 영역을 할당하여 구성
  
  * 상대 레이아웃
    - 이해
      + 부모 컨테이너나 다른 뷰와의 상대적인 위치를 이용해 뷰의 위치를 결정할 수 있는 레이아웃
      + 규칙 기반의 모델
      + 제약 레이아웃을 사용하게 되므로써, 권장하지 않음
    - 속성
      + 부모 컨테이너와의 상대적 위치 이용
        + layout_alignParentTop
        + layout_alignParentBottom
        + layout_alignParentLeft
        + layout_alignParentRight
        + layout_centerHorizontal
        + layout_centerVertical
        + layout_centerInParent
      + 다른 뷰와의 상대적 위치 이용
        + layout_above
        + layout_below
        + layout_toLeftOf
        + layout_toRightOf
        + layout_alignTop
        + layout_alignBottom
        + layout_alignLeft
        + layout_alignRight
        + layout_alignBaseline
        
  * 테이블 레이아웃
    - 이해
      + 각각의 행과 그 안에 여러 개의 열을 넣어 레이아웃을 구성
      + 격자 모양의 배열을 사용하여 화면을 구성하는 레이아웃
    - 핵심 태그 및 속성
      + TableLow 태그 > 한 행을 의미, 안에 여러개의 뷰가 들어가고 이들이 각각 열이 됨
      + stretchColumns 속성 > 가로방향으로 여유가 있다면, 그 여유공간을 채우도록 컬럼을 설정(ex> 0,1,2)
      + shrinkColumns 속성 > 부모 컨테이너의 폭에 맞추도록 각 열의 폭을 강제로 축소
      + layout_column 속성 > 칼럼 인덱스를 지정하여, 순서를 설정
      + layout_span 속성 > 뷰가 여러 칼럼에 걸쳐있도록 만드는 속성(ex> 2)
      
  * 프레임 레이아웃
    - 이해
      + 싱글 모델을 기반으로 한 레이아웃
      + 가장 상위에 있는 하나의 뷰 또는 뷰그룹만 보여줌
      + 여러 개의 뷰가 들어가면 중첩하여 쌓게됨.
      + 가장 단순하지만 여러 개의 뷰를 중첩한 후, 각 뷰를 전환하여 보여주는 방식으로 자주 사용
    - 핵심 속성
      + 가시성(visibility)
     
  * 스크롤 뷰
    - 이해
      + 추가된 뷰의 영역이 한눈에 보이지 않을 때 사용
      + 스크롤 뷰 안에 뷰를 넣으면 스크롤이 생김
      
    - 핵심 태그 및 속성
      + HorizontalScrollView 태그 > 수평 스크롤을 위한 스크롤 뷰
      + ScrollView 태그 > 수직 스크롤을 위한 스크롤  
  </details>
  
  
  
# 기본 위젯
  <details>
  <summary> 목록 </summary>
  
  * 기본 위젯
  * 이벤트 처리 이해
  * 토스트
  * 스낵바
  * 대화상자
  * 프로그레스바
  </details>



# 선택 위젯
  <details>
  <summary> 목록 </summary>
  
  * 나인패치 이미지
  * 커스텀 뷰
  * 카드뷰
  * 리싸이클러뷰
  * 스피너
  </details>



# 다양한 위젯
  <details>
  <summary> 목록 </summary>
  
  * 앱 화면에 웹 브라우저 넣기
  * 시크바
  * 키패드
  </details>



# 드로어블
  <details>
  <summary> 목록 </summary>
  
  * 드로어블
  </details>



# 화면 전환
  <details>
  <summary> 목록 </summary>
  
  * 레이아웃 인플레이션 이해
  * 다수의 화면 만들고, 화면간 전환하기
  * 인텐트
  * 플래그와 부가 데이터
  * 태스크 관리
  * 액비티시 수명주기
  * SharedPreferences
  </details>
  
  
  
# 프래그먼트
  <details>
  <summary> 목록 </summary>
  
  * 프래그먼트
  * 액션바
  * 상단 탭
  * 하단 탭
  * 뷰페이저
  * 바로가기 메뉴
  </details>
  
  
  
# 서비스와 수신자
  <details>
  <summary> 목록 </summary>
  
  * 서비스
  * 브로드캐스트 수신자
  * 위험 권한 부여
  * 리소스와 매니페스트
  * 그래들
  </details>
  
  
  
# 애니메이션
  <details>
  <summary> 목록 </summary>
  
  * 애니메이션
  * 페이지 슬라이딩
  </details>
  
  
  
# 쓰레드와 핸들러
  <details>
  <summary> 목록 </summary>
  
  * 핸들러
  * 일정 시간 후 실행
  * 쓰레드로 메시지 전송
  * AsyncTask
  * 쓰레드로 애니메이션
  </details>
  
  
  
# 서버 데이터 요청, 응답받기
  <details>
  <summary> 목록 </summary>
  
  * 네트워킹
  * 소켓 사용
  * 웹으로 요청
  * Volley 
  * JSON 데이터 다루기
  * 영화 정보 가져오기
  </details>
  
  
  
# 단말에 DB, 내용 제공자 만들기
  <details>
  <summary> 목록 </summary>
  
  * 모바일 DB란
  * DB와 테이블 만들기
  * 헬퍼 클래스로 업그레이드 지원
  * 데이터 조회
  * 내용 제공자
  * 앨범과 연락처 조회
  </details>
  
  
  
# 그래픽
  <details>
  <summary> 목록 </summary>
  
  * 뷰에 그래픽 그리기
  * 드로어블 객체로 만들어 그리기
  * 비트맵 이미지 사용
  * 페인트보드 
  * 멀티터치 이미지 뷰어
  * 머티리얼 디자인
  </details>
  
  
  
# 멀티미디어
  <details>
  <summary> 목록 </summary>
  
  * 카메라로 사진 찍어 저장
  * 화면에 카메라 미리보기 넣기
  * 음악 파일 재생
  * 동영상 재생
  * 오디오 녹음하여 저장
  * 동영상 녹화
  * 유튜브 영상 재생
  </details>
  
  
  
# 위치기반 서비스
  <details>
  <summary> 목록 </summary>
  
  * GPS로 내 위치 확인
  * 현재 위치 지도로 보여주기
  * 지도에 아이콘 추가
  </details>
  
  
  
# 앱 위젯
  <details>
  <summary> 목록 </summary>
  
  * 앱위젯
  </details>
  
  
  
# 푸시 서비스
  <details>
  <summary> 목록 </summary>
  
  * 진동과 소리로 알려주기
  * 상단 알림으로 알려주기
  * 푸시 서비스
  </details>
  
  
  
# 센서 및 단말 기능 사용
  <details>
  <summary> 목록 </summary>
  
  * 센서
  * 시스템 서비스
  * 네트워크 기능 활용
  * 다중 창 지원
  </details>
