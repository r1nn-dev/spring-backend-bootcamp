# Spring Backend Bootcamp

- 기간
    - start 2025/12/30 
    - finish 2026/11/

## Repository Structure
```text
spring-backend-bootcamp/
├── README.md                         # 레포 소개 + 전체 목차 
├── .gitignore
│
├── 00-foundations/                   # 컴퓨터/웹 백엔드 기반 지식
│   ├── README.md
│   ├── 01-linux/
│   ├── 02-git-basic/
│   ├── 03-web-basic/
│   ├── 04-network/
│   ├── 05-operating-system/
│   ├── 06-database-basic/
│   ├── 07-auth-security/
│   └── 99-etc/
├── 01-java/                          # Java
│   ├── README.md                     
│   ├── 01-basic/                     # java - basic
│   ├── 02-oop/                       # java - oop
│   └── 03-advanced/                  # java - advanced
├── 02-spring/                        # Spring 
│   ├── README.md
│   ├── 01-spring-basic/
│   ├── 02-spring-boot/
│   ├── 03-spring-mvc/
│   ├── 04-spring-data-jpa/
│   └── 05-spring-security/
├── 03-database/                      # Database
│   ├── README.md
│   ├── 01-sql/
│   ├── 02-modeling/
│   └── 03-orm/
├── 04-spring-ai/                     # Spring AI
│   ├── README.md
│   ├── 01-basic/
│   ├── 02-llm-api/
│   └── 03-practice/ 
├── 05-frontend/                      # Frontend
│   ├── README.md                     
│   ├── 01-html/                      # frontend - html
│   ├── 02-css/                       # frontend - css
│   ├── 03-javascript/                # frontend - javascript
│   └── 04-react/                     # frontend - react
├── 06-algorithm/                     # Algorithm
│   ├── README.md
│   ├── 01-data-structure/
│   ├── 02-algorithm/
│   ├── 03-problem-solving/
│   └── 99-coding-test/
├── 07-rest-api/                      # REST API
│   ├── README.md
│   ├── 01-rest-concept/
│   ├── 02-api-design/
│   └── 03-api-practice/
├── 08-cloud/                         # Cloud / Deployment
│   ├── README.md
│   ├── 01-cloud-basic/
│   ├── 02-deployment/
│   └── 03-devops/
└── 09-coursework/                    # 수업 평가/산출물 기록
    ├── README.md    
    ├── 01-special-lectures/             
    ├── 99-final-project/             # final project summary
    ├── 02-exam-review/               # concept exam review
    └── 99-missions/                  # platform mission
```

## 기록 규칙

* `README.md`: 각 섹션의 주제, 목차, 학습 흐름
* 개념 정리 파일 형식: Markdown 
* 코드 예제: 코드 + 실행 목적, 핵심 흐름, 주의점 
* 실습 결과나 프로젝트 산출물은 필요할 경우 별도 폴더로 분리한다.
* 커밋 메시지와 폴더 구조 일관성 있게 유지한다.

## Commit Convention

### Type

| Type       | Meaning                |
| ---------- | ---------------------- |
| `docs`     | 문서 작성 및 수정             |
| `study`    | 학습 노트 추가               |
| `code`     | 실습 코드 추가               |
| `fix`      | 오타, 잘못된 개념, 코드 수정      |
| `chore`    | 폴더 구조, 설정 파일, 기타 관리 작업 |
| `refactor` | 기존 정리 내용 구조 개선         |
| `project`  | 프로젝트 산출물 추가 및 수정       |

### Example
```text
<type>(scope): <message>
```
```text
docs: add root README
chore: initialize bootcamp directory structure
study(java): add basic syntax notes
study(spring): add spring boot overview
code(rest-api): add api practice example
fix(database): correct SQL join explanation
refactor(foundations): reorganize network notes
project(coursework): add final project summary
```
