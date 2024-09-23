# SpartaHubFlow
[내일배움캠프 Spring 심화] Ch.4 팀 프로젝트 물류관리 및 배송 시스템

---

## 팀원 역할 분담

- 전반적인 설계 및 프로젝트 관리는 모든 팀원이 공동으로 작업

### 김홍성
- `eureka-server`, `user`, `gateway`, `slack` App 기능 구현

### 박상훈

- `product`, `order`, `company` App 기능 구현

### 이미연

- `hub`, `delivery` App 기능 구현

---

## 서비스 구성 및 실행 방법

![image](https://github.com/user-attachments/assets/076304fd-a903-428c-a4f3-a20cfee73c57)


프로젝트는 `docker-compose`와 별도의 `.yml` 파일을 이용하여 실행할 수 있습니다. 자세한 실행 방법은 아래의 단계를 따릅니다:

1. 루트 폴더 아래에 .env 파일 제작
2. `docker-compose up -d` 명령어를 사용하여 서비스 실행
3. 서비스가 정상적으로 기동되었는지 확인

---

## 프로젝트 목적/상세

이 프로젝트는 B2B 물류 관리 및 배송 시스템은 MSA 기반 플랫폼으로 개발된 프로젝트입니다. 더 나아가 AI API와 연동하여 기존의 서비스들과 차별화를 두었습니다.


---

## ERD

![image](https://github.com/user-attachments/assets/c8b5e554-0aff-42dd-b80e-d17f8d7db8c3)

---

## 기술 스택

- **백엔드**: Spring Boot 3.3.3
- **데이터베이스:** PostgreSQL, Redis
- **빌드 툴:**  Docker, Gradle
- **버전 관리:** Git을 이용한 버전 관리
- **API 문서**: Swagger

---

## API Docs

- [Notion 링크](https://www.notion.so/teamsparta/2c39338ec4114b2da46db8a172de505d?v=06e3a960012b45b0b5ccbff5aefb41a9)

- Swagger를 통한 문서화 (루트 폴더 내의 api-docs 폴더 참조!)

### Company
![image](https://github.com/user-attachments/assets/3b63c0c3-f41d-4ac1-bb6f-a6dd3bfe9610)

### Delivery
![image](https://github.com/user-attachments/assets/9e3d101f-fdd2-4074-8b29-12e1e43ad2e9)

### Hub
![image](https://github.com/user-attachments/assets/76188c90-760d-415b-8273-656881721f93)

### Order
![image](https://github.com/user-attachments/assets/c19f918a-fb0b-43f5-b224-9149f177a305)

### Product
![image](https://github.com/user-attachments/assets/4e817df2-6ee3-416d-b173-077308de8ab6)

---

### 트러블 슈팅

![image](https://github.com/user-attachments/assets/67277108-b397-4d97-9ed4-9e26e735e59b)

- 첫 번째로 요구 사항 중  주문 시 해당 상품의 재고가 자동으로 차감 되며 배송이 자동으로 생성되어야 한다는 요구 사항이 있었습니다. 이 경우 Order App과 Product App은 한 사람이 동시에 개발하고 있었지만 Order App과 Delivery App은 서로 다른 개발자들이 분담하고 있었기에 어느 정도의 소통이 필요했습니다.

- 주문을 생성할 때 주문 App 내에서 배송을 한번에 생성하는 로직도 생각을 했었지만, 그래도 MSA 환경을 최대한 활용해보고자 주문 생성 시 배송 APP에서 생성 api를 호출하여 배송을 생성함으로써 MSA를 최대한 활용한 설계가 완성이 되었다고 생각합니다.

![image](https://github.com/user-attachments/assets/a2f9952d-728b-4199-93c8-4f635c820455)

- 발제 내용중 예시 업체로 부산시의 바구니 제작 업체가 경기도 일산의 플라스틱 가공 업체에 1000개의 플라스틱 가공품을 주문하였을 때, 플라스틱 가공업체는 스파르타 물류에 허브를 통해 가공품의 배송을 요청하도록 요구가 되어있었습니다.

- 이에대해 저희 팀은 두가지 서로 상이한 프로세스들을 생각하게 되었습니다.

- 첫 번째로, 주문은 누구든 생성 가능하며 우리 물류관리및 배달서비스에 등록된 업체의 물건을 전달하는 시스템,

- 두 번째로 주문은 우리 물류관리, 배달서비스에 등록된 업체만 주문하며 hub 대여와 배달을 제공하는 시스템으로 생각하였습니다.
 
- 프로젝트 중반 즈음 pr과정에서 서로 상이한 프로세스로 개발 진행한걸 인지하였습니다.

- 등록되지 않은 업체가 주문을 생성할 수 있다면 주문서비스 담당자가 주문생성시 주문 회사의 주소를통해 허브를 자동으로 지정하는 로직 추가필요한데, 주문과 배달이 동시에 생성되야하는 요구사항에 따라 개발복잡도 증가하게 됩니다.

- 따라서 거의 모든 프로세스가 수정되어야하며 이미 프로젝트 중간 단계에서 모든걸 구현하기엔 시간상 불가능 할것같다고 생각하였고, 후자인 우리 물류관리, 배달서비스에 등록된 업체만 주문을 생성 가능하도록 설계하였습니다.

- 이와 같이 개선함으로써 db에 적재된 데이터를 불러오는 식으로 데이터 관리에 용이해졌고 개발 시간 단축되었습니다. 

- **설계 단계부터 팀원과의 소통이 중요**하다고 느낀 트러블 슈팅 과정이었습니다.

![image](https://github.com/user-attachments/assets/4f6d67e1-b2ae-4419-b8bb-46a2d7358952)

- 처음에는 인증 및 인가 처리를 어떻게 해야 할지 고민을 했었습니다. 각 App마다 Spring Security 의존성을 주입하여 Controller 마다 인증을 구현하자니 MSA를 구축한 의미가 퇴색되는 것 같았습니다.

- 그래서 Gateway에서 SecurityConfig를 작성해 각 App으로 보낼 때 API 명세서의 권한 목록을 참조하여 1차적으로 접근 가능한 유저의 권한을 검사 하고, 각 App에서 Header를 통해 userId와 Role을 받아온 후 Service 단에서 권한에 따라 분기하도록 하여 기능을 분리하였습니다.

- 이렇게 구현하셨을 때, msa에서 각자 권한 체크에 대한 추가 로직이 필요하지 않아 중앙집중형으로 관리할 수 있습니다. 
---
