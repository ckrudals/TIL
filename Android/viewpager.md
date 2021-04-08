# ViewPager2 어떻게 써야할까?

## 뷰페이저란

데이터를 페이지 단위로 표시하고, 좌/우 뒤집기(flip)을 통해 페이지를 전환할 수 있도록 만들어주는 컨테이너 이다.

어떻게 써야할까?

먼저 build.grade에 추가한다.

```kotlin
dependencies {
        implementation "androidx.viewpager2:viewpager2:1.0.0"
        implementation 'com.tbuonomo.andrui:viewpagerdotsindicator:4.1.2'
    }
```
[안드로이드 공식문서 ViewPager2](https://developer.android.com/jetpack/androidx/releases/viewpager2?hl=ko)  
[뷰페이저2 애니매이션](https://github.com/tommybuonomo/dotsindicator)




그다음 2개의 xml를 추가한다.

 - activity\_main\_view\_pager

\- activity\_pager\_item

activity\_main\_view\_pager의 소스

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <androidx.viewpager2.widget.ViewPager2
        android:id="@+id/main_view_pager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_centerInParent="true" />

    <!--   viewpager 애니매이션-->
    <com.tbuonomo.viewpagerdotsindicator.DotsIndicator
        android:id="@+id/dots_in"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="60dp"
        app:dotsColor="#F1F1F1"
        app:dotsCornerRadius="8dp"
        app:dotsSize="16dp"
        app:dotsSpacing="4dp"
        app:dotsWidthFactor="2.5"
        app:progressMode="true" />

    <ImageView
        android:id="@+id/next_btn"
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:layout_alignParentTop="true"
        android:layout_alignParentRight="true"
        android:src="@drawable/right"
        android:textStyle="bold" />

    <ImageView
        android:id="@+id/previous_btn"
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:layout_alignParentLeft="true"
        android:layout_alignParentTop="true"
        android:src="@drawable/left"
        android:textStyle="bold" />

</RelativeLayout>
```


 activity\_pager\_item의 소스

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center_horizontal"
    android:id="@+id/pager_item_bg">

    <ImageView
        android:id="@+id/pager_item_image"
        android:layout_width="350dp"
        android:layout_height="350dp"
        android:layout_marginTop="90dp"
        android:layout_marginBottom="20dp"
        />

    <TextView
        android:id="@+id/pager_item_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="뷰페이저 아이템 레이아웃"
        android:textSize="30sp"
        android:textAlignment="center"
        android:gravity="center_horizontal" />


</LinearLayout>
```

ViewPager에서 ViewPager2로 바뀐점은 Recyclerview 형태를 띄게 됐다는 것이다.

RecyclerView를 할 수 있으면 ViewPage2도 쉽게 할 수 있다.

Recyclerview와 똑같은 형태로 만들어준다.

data class

```kotlin
class PageItem(val bgColor: Int, val image: Int, val content: String) 
```

Adapter

```kotlin
class PageRecyclerAdapter(private var pageList: ArrayList<PageItem>) : RecyclerView.Adapter<PageViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        return PageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pager_item, parent, false))
    }

    override fun getItemCount(): Int {
        return pageList.size
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        holder.bindWithView(pageList[position])
    }

}
```

MainAcitivty

```kotlin
//pagelist
    private var pageItemList = ArrayList<PageItem>()

    //Adapter 가져오기
    private lateinit var myIntroPagerRecyclerAdapter: PageRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view_pager)

        var i = 0

        previous_btn.setOnClickListener {
            Log.d(TAG, "MainActivity - 이전 버튼 클릭")
            main_view_pager.currentItem = main_view_pager.currentItem - 1
            i--
            Log.d(TAG, "$i")

        }
        next_btn.setOnClickListener {
            Log.d(TAG, "MainActivity - 다음 버튼 클릭")
            main_view_pager.currentItem = main_view_pager.currentItem + 1
            i++
            Log.d(TAG, "$i")
            //i가 2 보다 클시, 다른 액티비티로 이동
            if (i > 2) {
                val intent = Intent(this, SubActivity::class.java)
                startActivity(intent)
                Log.d(TAG, "$i")

            }

        }


        pageItemList.add(PageItem(R.color.design_default_color_primary, R.drawable.item1, "첫번째 화면",))
        pageItemList.add(PageItem(R.color.design_default_color_primary, R.drawable.item2, "두번째 화면",))
        pageItemList.add(PageItem(R.color.black, R.drawable.item3, "3번째 화면"))

        //어뎁터 연결
        myIntroPagerRecyclerAdapter = PageRecyclerAdapter(pageItemList)


         // 뷰페이저에 설정
        main_view_pager.apply {
            //Adapter 연결
            adapter = myIntroPagerRecyclerAdapter
            //수평으로 설정
            orientation = ViewPager2.ORIENTATION_HORIZONTAL

            dots_in.setViewPager2(this)
        }

    }
```

만약 자기가 이미지를 바꾸고 싶다면, drawable에 추가하면 된다.

만약 소스가 이해가 안됀다면, RecyclerView부터 공부하고 오길 추천한다.