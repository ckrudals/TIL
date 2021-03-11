# ViewPager2 어떻게 써야할까?

## 뷰페이저란

데이터를 페이지 단위로 표시하고, 좌/우 뒤집기(flip)을 통해 페이지를 전환할 수 있도록 만들어주는 컨테이너 이다.

어떻게 써야할까?

먼저 build.grade에 추가한다.

[##_Image|kage@bNqL54/btqX82y2Tb4/JWPAFIUwxEiTUNEtpq3Ld1/img.png|alignCenter|width="100%" data-origin-width="924" data-origin-height="214" data-ke-mobilestyle="widthContent"|||_##]

[안드로이드 공식문서 ViewPager2](https://developer.android.com/jetpack/androidx/releases/viewpager2?hl=ko)  
[뷰페이저2 애니매이션](https://github.com/tommybuonomo/dotsindicator)

[

tommybuonomo/dotsindicator

Three material Dots Indicators for view pagers in Android ! - tommybuonomo/dotsindicator

github.com



](https://github.com/tommybuonomo/dotsindicator)

[

ViewPager2  |  Android 개발자  |  Android Developers

스와이프할 수 있는 형식으로 뷰 또는 프래그먼트를 표시합니다. 최근 업데이트 현재 안정화 버전 다음 버전 후보 베타 버전 알파 버전 2020년 4월 1일 1.0.0 - - 1.1.0-alpha01 AndroidX 종속 항목 ViewPager2

developer.android.com



](https://developer.android.com/jetpack/androidx/releases/viewpager2?hl=ko)

그다음 2개의 xml를 추가한다.

- activity_main_view_pager
- activity_pager_item

activity_main_view_pager

ViewPager에서 ViewPager2로 바뀐점은 Recyclerview 형태를 띄게 됐다는 것이다.
RecyclerView를 할 수 있으면 ViewPage2도 쉽게 할 수 있다.

Recyclerview와 똑같은 형태로 만들어준다.

data class

