# Spring Boot Core
> Spring Boot의 기본 구조, 빌드 도구, 설정 방식, 핵심 Java 보완 개념

## 1. 범위
| 구분             | 내용                                                               |
|----------------|------------------------------------------------------------------|
| Spring 등장 배경   | EJB의 한계, POJO 기반 개발 철학                                           |
| Spring Boot 개요 | Spring Framework와 Spring Boot의 차이                                |
| 핵심 철학          | Convention over Configuration                                    |
| 자동 설정          | Auto Configuration, Conditional, Back-off                        |
| 의존성 구조         | Starter, BOM, classpath 기반 설정                                    |
| 실행 구조          | SpringApplication.run(), ApplicationContext, 내장 서버               |
| 핵심 애노테이션       | @SpringBootApplication, @ComponentScan, @EnableAutoConfiguration |
| 기본 실습          | 	Spring Initializr, Hello API, Postman 테스트                       |
| 디버깅	           | Conditions Evaluation Report 확인                                  |

## 2. 핵심 키워드
### Spring Framework
* Spring Framework
* EJB(Enterprise JavaBeans)
* POJO(Plain Old Java Object)
* IoC(Inversion of Control)
* DI(Dependency Injection)
* ApplicationContext
* Bean
* AOP(Aspect-Oriented Programming)
### Spring Boot
* Spring Boot
* Convention over Configuration
* Auto Configuration
* Starter
* Embedded Server
* Embedded Tomcat
* Executable JAR
* Externalized Configuration
* Actuator
### 자동 설정
* `@EnableAutoConfiguration`
* `@Conditional`
* `@ConditionalOnClass`
* `@ConditionalOnMissingBean`
* `@ConditionalOnProperty`
* Back-off
* classpath
* `AutoConfiguration.imports`
* Conditions Evaluation Report
### 웹 실행 구조
* Spring MVC
* DispatcherServlet
* Controller
* `@RestController`
* `@GetMapping`
* `@PathVariable`
* HttpMessageConverter
* JSON Serialization
* Postman

## 실습


### 실습 흐름
```text
Spring Initializr 프로젝트 생성 
→ Gradle Sync 확인 
→ 메인 클래스 실행 
→ 내장 Tomcat 실행 확인 
→ HelloController 작성 
→ 브라우저 테스트 
→ Postman 테스트 
→ 자동 설정 리포트 확인
```

## 정리
