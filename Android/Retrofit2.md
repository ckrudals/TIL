# Retrofit2란 무엇인가
---

## Retrofit2이란?
- 레트로핏은 서버와 클라이언트와 데이터통신을 편히 하기 위한 라이브러리로 회원가입이나. API 받아오는 곳에 쓰입니다.

~~~~
 Retrofit2 통신은 Http과 Https 통신으로 나누어 지는데 이 md에서는 Http 통신으로 이루어져 있습니다. 
 ~~~~
 
 ## Build grade

 ``` kotlin

    // Retrofit 라이브러리
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'

    // Gson 변환기 라이브러리
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

    //okHttp
    implementation 'com.squareup.okhttp3:okhttp:4.9.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.9.0'
 ```

 okHttp 를 쓸거기 때문에 관련 라이브러리도 설치합니다.

 ## Retrofit2를 써보자

 #### Retrofit2를 쓸려면 postMan 을 사용하여 Json 객체를 받아와야합니다.

 - 저는 학교 급식앱을 만들 것 이기 때문에 서버에 요청을 해야합니다.
  
  > [나이스](https://open.neis.go.kr/portal/data/service/selectServicePage.do?page=1&rows=10&sortColumn=&sortDirection=&infId=OPEN17320190722180924242823&infSeq=2) 사이트에 들어가 인증키 를 요청 해줍니다.

  그리고 Open API에 있는 기본인자와 신청인자를 postMan에 요청 해줍니다

  ~~~
  기본인자는 무조건 다 써야 하지만, 신청인자는 필요한 것만 적어도 됩니다.
  ~~~

  ![postMan](./../Image/retrofit2.png)

  > - KEY : 인증키
  > - Type : 타입 (JSON, XML 등)
> - ATPT_OFCDC_SC_CODE : 시도교육청코드
>  - SD_SCHUL_CODE: 표준학교코드
>  - MLSV_YMD : 날짜
> MMEAL_SC_CODE : 1 [아침] 2 [점심] 3 :[저녁]

만약 데이터가 정상적으로 들어갔다면 정상적으로 Json이 뜹니다
```
{
    "mealServiceDietInfo": [
        {
            "head": [
                {
                    "list_total_count": 1
                },
                {
                    "RESULT": {
                        "CODE": "INFO-000",
                        "MESSAGE": "정상 처리되었습니다."
                    }
                }
            ]
        },
        {
            "row": [
                {
                    "ATPT_OFCDC_SC_CODE": "F10",
                    "ATPT_OFCDC_SC_NM": "광주광역시교육청",
                    "SD_SCHUL_CODE": "7380292",
                    "SCHUL_NM": "광주소프트웨어마이스터고등학교",
                    "MMEAL_SC_CODE": "1",
                    "MMEAL_SC_NM": "조식",
                    "MLSV_YMD": "20210324",
                    "MLSV_FGR": "228",
                    "DDISH_NM": "백미밥*<br/>참치김치찌개*5.9.13.<br/>알감자버터구이*2.5.6.<br/>콩나물매운무침*5.<br/>열무김치*9.<br/>콘푸로스트/초코첵스&백색우유.2.5.6.13.",
                    "ORPLC_INFO": "쌀 : 국내산<br/>김치류 : 국내산<br/>고춧가루(김치류) : 국내산<br/>쇠고기(종류) : 국내산(한우)<br/>돼지고기 : 국내산<br/>닭고기 : 국내산<br/>오리고기 : 국내산<br/>쇠고기 식육가공품 : 국내산<br/>돼지고기 식육가공품 : 국내산<br/>닭고기 식육가공품 : 국내산<br/>오리고기 가공품 : 국내산<br/>낙지 : 국내산<br/>고등어 : 국내산<br/>갈치 : 국내산<br/>오징어 : 국내산<br/>꽃게 : 국내산<br/>참조기 : 국내산<br/>콩 : 국내산",
                    "CAL_INFO": "828.5 Kcal",
                    "NTR_INFO": "탄수화물(g) : 138.9<br/>단백질(g) : 29.4<br/>지방(g) : 17.9<br/>비타민A(R.E) : 885.0<br/>티아민(mg) : 1.9<br/>리보플라빈(mg) : 2.2<br/>비타민C(mg) : 98.0<br/>칼슘(mg) : 420.1<br/>철분(mg) : 8.3",
                    "MLSV_FROM_YMD": "20210324",
                    "MLSV_TO_YMD": "20210324"
                }
            ]
        }
    ]
}
``` 

이제 이것을 dataClass로 바꿔줘야합니다. 
이것을 바꿔주는 라이브러리가 있습니다.
  ![라이브러리](./../Image/Json_to_kotlin.png)
  이 라이브러리를 사용하면 Json만 넘겨준다면 자동으로 DataClass로 바꿔줘야합니다.

### 그리고 API Interface를 만들어 줘야합니다.

``` kotlin
@GET("hub/mealServiceDietInfo")
    fun getInfo(
            //  인증키
            @Query("KEY") KEY: String = "f50a392c9e2647e4a030ca8f95d7c568",
            //호출 문서(xml, json)
            @Query("Type") Type: String = "json",
            //시도교육청코드
            @Query("ATPT_OFCDC_SC_CODE") ATPT_OFCDC_SC_CODE: String = "F10",
            //표준학교코드
            @Query("SD_SCHUL_CODE") SD_SCHUL_CODE: String = "7380292",
            //급식일자
            @Query("MLSV_YMD") MLSV_YMD: String,
            //식사코드
            @Query("MMEAL_SC_CODE") MMEAL_SC_CODE: Int


    ): Call<meal_model>
```

**@GET** 으로 서버에서 정보를 가져옵니다.
그리고 서버에 있는 데이터를 **@QUERY**로 가져와, 필수적인 DATA는 여기서 미리 선언해줍니다.

### 그리고 RetrofitBuilder를 만들어줍니다

``` kotlin
 // 서버 주소
    private const val BASE_URL = "https://open.neis.go.kr/"


    var service: RetrofitService


    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(createOkHttpClient())
            .build()


        service = retrofit.create(RetrofitService::class.java)
    }

    private fun createOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(interceptor)
        return builder.build()
    }
```

- **먼저 BaseUrl은 자신이 쓸 주소를 넣어줘야합니다. 필자는 나이스에서 쓰기 때문에 나이스 서버를 적어주어습니다.**
- **addConverterFactory : Json형식의 파일을 나중에 만들 POJO Class 형식으로
자동으로 변환하여 줍니다.**
- **OkHttp**는 서버에 받아온 것을 log를 찍기위해 쓴다고 생각하시면 됩니다.

### MainActivity

``` kotlin
 fun Retrofit(time: Int) {
        RetrofitBuilder.service.getInfo(MLSV_YMD = formatted, MMEAL_SC_CODE = time).enqueue(object : Callback<meal_model> {
            override fun onFailure(call: Call<meal_model>, t: Throwable) {
                t.printStackTrace()
                Log.d(ContentValues.TAG, "MainActivity - onFailure()")
            }

            override fun onResponse(
                    call: Call<meal_model>,
                    response: Response<meal_model>
            ) {

                if (response.isSuccessful) {
                    val res = response.body()?.mealServiceDietInfo?.get(1)?.row



                    if (res != null) {
                        for (i in res.indices) {
                            val obj = res[i]
                            val row = obj.DDISH_NM
                            Log.d(TAG, "onResponse: $row")

                            when (time) {

                                1 -> {
                                    binding.mealText.setText(row)
                                    Log.d(TAG, "아침: ${binding.mealText.text}")
                                }
                                2 -> {
                                    binding.mealText.setText(row)
                                    Log.d(TAG, "점심: ${binding.mealText.text}")
                                }
                                3 -> {
                                    binding.mealText.setText(row)
                                    Log.d(TAG, "저녘: ${binding.mealText.text}")

                                }
                            }

                        }
                    } else {
                        Log.d(ContentValues.TAG, "onResponse: ${response.code()}")
                    }

                }
            }


        })
    }
```

우리는 dataClass를 쓸거면 쓰기 때문에 Head와 row가 있는 meal_model를 씁니다.
<br>
그리고  onFailure과 onResponse를 implement 해줍니다.
만약 응답이 성공했을때 dataClass에 있는 값을 xml의 textView에 연결 시켜주면 됩니다.

### 마무리
Retrofit2과 OkHttp로 서버에 있는 데이터를 가져온 것을 해보았는데, 접근성이 처음에 어렵다고 생각했지만, 코드를 짜고 공부를 해보면서 자신감이 한층 생긴 것 같습니다.

    

  
  





  
 
