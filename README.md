#todo
##요구사항
>* 웹 어플리케이션으로 개발 
>* 웹어플리케이션 개발언어는 Java, Scala, Golang 중 선택을 권장함 (단, 다른 언어에 특별히 자신있는 경우 선택에 제한을 두지 않음)
>* 서버는 REST API로 구현
>* 프론트엔드 구현방법은 제약 없음
>* 데이타베이스는 사용에 제약 없음 (가능하면 In-memory db 사용)
>* 단위테스트 필수, 통합테스트는 선택
>* README.md 파일에 문제해결 전략 및 프로젝트 빌드, 실행 방법 명시

##개발 기능
###1. 조회
  - id, todo, create_date, update_date, complete_date
###2. 저장
  - todo
  - refer todo
  - complete_date
###3. 수정
  - todo

##테이블 구성
###1. List Table
  - id
  - todo
  - date(create, update, complete)
###2. Mapping Table
  - seq
  - todo id
  - ref id

##빌드
```$ gradlew clean```

```$ gradlew bootWar```

##실행
```$ java -jar build/libs/todolist-1.0.0.war```

##페이지
http://localhost:8080/web/list