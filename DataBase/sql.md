# SQL

- DB: 데이터를 보관하는 장소
- BigQuery는 데이터 분석할 때 많은 장점이 있음

- SQL은 RDBMS에서 데이터를 추출할 때 쓰는 문법

---
# BigQuery

## BigQuery의 장점

<li>
1. 난이도
<br>
 SQL 기반으로 데이터 추출 가능
   <br>
<li>
2. 속도
<br>
다른 데이터베이스는 index 또는 서버에 따라 속도가 느리지만 BigQuery는 index 개념이 없으므로 신경쓰지 않아도됌

<li>3. 앱 개발자가 흔히 쓰는 firebase를 사용할 경우 앱 데이터를 쉽게 획득 가능 

<li>4. 서버를 따로 구축할 필요가 없음
</li>
</li>

## BigQuery란

#LegacySQL 과거에 주로 사용햇던 SQL

#StandardSQL

-최근에 주로사용하는 문법

> StandardSQL을 쓰자


# SQL

SQL : Structured Query Language

데이터 선택 : SELECT
데이터 조작 : (DML) INSERT,UPDATE,DELETE
데이터 정의 : (DDL) CREATE,ALTER,DROP
데이터 제어(DCL) 

o2 : mysql 만들때 사용
AUTO_INCREMENT : 명시적으로 지정하지않고, INSERT하면 자동추가 (1)
SELECT [컬럼 이름]
FROMP [테이블 이름 ]
> 나는  [테이블 이름]에서 [컬럼 이름]을 선택한다

SELECT [컬럼 이름]
FROMP [테이블 이름 ]
WHERE [조건]
> 나는  [테이블 이름]에서 [조건] 을 가지는 [컬럼 이름]을 선택한다
