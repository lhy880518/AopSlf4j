# BasicProject+Aop
## aop란
* 스프링의 가장 큰 특징 세가지를 꼽아보자면 IOC(제어역전),DI(의존관계 주입),AOP(관점 지향 프로그래밍)이다.
* 객체의 재사용을 통해서도 반복되는 코드를 없앨 수 없는 경우가 있는데, 예를들어 로그, 권한체크, 예외처리 등 필수적으로 해야되기 때문에 소스에서 반복되는 코드들이 그 예이다.
* AOP는 이런 부분을 해결 해 주는데 공통적 기능을 종단간으로 삽입함으로써 해결한다.

## 로깅과 Slf4j
### Logging이란
* 프로그램 개발 중이나 완료 후 발생할 수 있는 오류에 대해 디버깅하거나 운영 중인 프로그램 상태를 모니터링 하기위해 필요한 정보를 기록하는것
* java의 주요 Logging Framework
    * native java.util.logging: 별로 사용하지 않는다.
    * Log4J: 몇 년 전까지 사실상 표준으로 사용했다.
    * Logback: Log4J 개발자가 만든 Log4J의 후속 버전, 현재 많은 프로젝트에서 사용되고 있다.
    * SLF4J(Simple Logging Facade for Java): Log4J 또는 Logback과 같은 백엔드 Logger Framework의 facade pattern
    * tinylog: 사용하기 쉽게 최적화된 Java용 최소형(75KB Jar) 프레임워크

### SLF4J
* 다양한 Logging Framework에 대한 추상화
    * SLF4J는 추상 로깅 프레임워크이기 때문에 단독으로는 사용하지 않는다. 

## 참고사이트
* [웹 서비스 기본구조](https://gmlwjd9405.github.io/2018/10/29/web-application-structure.html)(현재 프로젝트의 구조와 동일)
* [AOP참고자료](https://addio3305.tistory.com/86)
* [Log4j 설정](https://gmlwjd9405.github.io/2019/01/04/logging-with-slf4j.html)