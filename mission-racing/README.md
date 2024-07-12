## 3-1. mission-racing

### 미션 설명

- 스프링 API 서버를 만드는 연습을 합니다.
- 레이어드 아키텍처에 대해 학습합니다.
- 구조적으로 유연하게 생각하며 콘솔과 API 서버를 모두 실행할 수 있게 만듭니다.
- 기본적인 스프링의 동작 원리를 파악합니다. (ex. IoC, DI, Bean, Container ...)
- 기본적인 스프링의 어노테이션을 파악합니다. (ex. RestController, @RequestBody, @RequestParam...)
- 직렬화와 역직렬화를 이해합니다.
- 어떤 것을 Bean으로 등록할지 고민 합니다.
- 패키지를 잘 나눠주세요.
- checked exception, unchecked exception의 차이를 공부합니다.
- CustomException 적용과 예외 처리를 신경써주세요.

### 미션 내용

- Java 미션에서 진행한 레이싱 경주를 API 서버로 만듭니다.
- 먼저 복습 겸 console 프로그램을 만든 후 도메인 테스트를 모두 진행한 후 API 서버로 변경을 진행합니다.
- `콘솔 프로그램 + API 서버` 모두 이용할 수 있어야합니다.
- 콘솔과 API 서버 사이의 최대한 중복 코드가 생기지 않게 구조를 설계 해주세요.

### API 문서 (응답 값은 따로 정해진 것이 없다면 자유)

#### 1. 자동차 이름 등록 (POST)

Request

```
POST /api/cars

{
    "name" : "jay,pobi,crong",
    "tryCount" : 10
}

```

#### 2. 자동차 경주 시작 (POST)

Request

```
POST /api/cars/racing
```

#### 3. 자동차 경주 결과 조회 (GET)

Request

```
GET /api/cars
```

Response

```json
{
  "winner": "pobi",   
  "status": [
    {
      "jay": 3
    },
    {
      "pobi": 5
    },
    {
      "crong": 1
    }
  ]
}
```

#### 4. 자동차 경주 결과 개별 조회 (GET)

Request

```
GET /api/cars?name=자동차명
```

Response

GET /api/cars?name=pobi

```json
{
  "pobi": 5
}
```

---

## racing 콘솔 프로그램

### 기능 요구사항
- 자동차는 이름을 가지고 있다.
- n대의 자동차가 참여할 수 있다. 
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  - 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 구할 수 있다. 우승자는 한 명 이상일 수 있다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

실행 결과

- 위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.

~~~
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
neo,brie,brown
시도할 회수는 몇회인가요?
5

neo : -
brie : -
brown : -

neo : --
brie : -
brown : --

neo : ---
brie : --
brown : ---

neo : ----
brie : ---
brown : ----

neo : -----
brie : ----
brown : -----

neo : -----
brie : ----
brown : -----

neo, brown가 최종 우승했습니다.
~~~

