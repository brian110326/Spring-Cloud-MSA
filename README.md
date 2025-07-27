# ☁️ Spring Cloud MSA Project

MSA(Microservices Architecture) 기반으로 설계한 간단한 주문 처리 시스템입니다.  
사용자는 User 서비스에서 주문하고, Order 서비스가 주문을 처리하며, Catalog 서비스는 재고 수량을 관리합니다.

## 📌 주요 기능

- User 서비스: 사용자 관리 및 주문 요청  
- Order 서비스: 주문 생성 및 처리  
- Catalog 서비스: 재고 수량 관리 및 감소  
- 서비스 간 비동기 통신을 위해 Kafka 메시지 큐 사용

## 🔧 기술 스택

Spring Boot, Spring Cloud, Kafka, Docker, MySQL, Spring Data JPA

## 🛠️ 프로젝트 특징 및 학습 내용

- MSA 설계 방식으로 서비스들을 독립적으로 분리하여 개발  
- Kafka를 활용한 비동기 이벤트 기반 서비스 간 통신 구현  
- Docker를 사용해 각 마이크로서비스를 컨테이너화하여 실제 환경에서 동작  
- Postman을 활용해 API 동작 및 서비스 간 통신 확인  
- 서비스별 책임과 역할 분담에 따른 시스템 확장성 및 유지보수성 향상  
- 간단한 주문-재고 연동 프로세스 설계 및 구현 경험

## 👤 담당 역할

본 프로젝트는 개인 프로젝트로,  
MSA 기반 서비스 설계부터 구현, Kafka 연동, Docker 컨테이너화, 그리고 API 테스트까지 전 과정을 직접 수행했습니다.

## 📦 Docker Hub 이미지

해당 프로젝트는 Docker Hub에 public 이미지로 배포되어 있습니다.
link : https://hub.docker.com/repositories/brian1103
