# Payment Clearing & Transaction Processing System
Project simulating Transactions in a Claring House using Spring 3, Java 17, MySQL97, Kafka, Postman, Swagger, Docker

Enterprise-grade banking transaction processing platform built using modern Java microservice architecture principles.

---

# Overview

This project simulates a real-world ACH/NACH-style payment processing platform used in banking and financial systems.

The application supports:
- REST API-based transaction processing
- Asynchronous Kafka event publishing
- Transaction status tracking
- Retry mechanism for failed payments
- Incident logging
- Scheduler-based recovery jobs
- Database persistence
- Swagger API documentation
- Production-support-style monitoring

This project was designed to demonstrate:
- Backend development knowledge
- Production support knowledge
- API integration capabilities
- Kafka event-driven architecture
- Enterprise troubleshooting scenarios

---

# Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Core Programming |
| Spring Boot 3.x | REST APIs |
| Apache Kafka | Async Messaging |
| MySQL | Data Persistence |
| Postman | API Testing |
| Swagger UI | API Documentation |
| Docker | Containerization |
| GitHub | Version Control |
| IntelliJ IDEA | Development |

---

# Architecture

```text
                +-------------------+
                |   Client/Postman  |
                +---------+---------+
                          |
                          v
                +-------------------+
                |   REST API Layer  |
                +---------+---------+
                          |
                          v
                +-------------------+
                |  Service Layer    |
                +---------+---------+
                          |
             +------------+-------------+
             |                          |
             v                          v
   +-------------------+     +-------------------+
   |   MySQL Database  |     |   Kafka Producer  |
   +-------------------+     +---------+---------+
                                        |
                                        v
                              +-------------------+
                              |  Kafka Consumer   |
                              +---------+---------+
                                        |
                                        v
                              +-------------------+
                              | Retry Scheduler   |
                              +-------------------+
```

---

# Features

## Transaction Processing
- Create payment transactions
- Track transaction status
- Store transaction details in database

## Kafka Integration
- Publish payment events asynchronously
- Consume transaction events
- Decouple payment ingestion from processing

## Retry Mechanism
- Scheduler retries failed transactions
- Simulates enterprise recovery workflows

## Incident Management
- Log production incidents
- Capture service failures and severities

## Exception Handling
- Global exception handling
- Cleaner API responses

## API Documentation
- Swagger/OpenAPI integration

---

# Project Structure

```text
src/main/java/com/pb/paymentsystem

├── controller
├── service
├── repository
├── entity
├── dto
├── kafka
├── scheduler
├── exception
├── config
└── util
```

---

# Database Tables

## payment_transaction

Stores payment transaction details.

| Column | Description |
|---|---|
| txn_id | Unique transaction ID |
| account_number | Customer account |
| amount | Payment amount |
| status | Transaction status |
| remarks | Additional notes |

---

## incident_log

Stores production incident information.

| Column | Description |
|---|---|
| service_name | Failed service |
| severity | P1/P2/P3 |
| issue_description | Incident details |

---

# API Endpoints

## Create Transaction

```http
POST /api/transactions
```

### Request

```json
{
  "txnId": "TXN1001",
  "accountNumber": "9876543210",
  "amount": 5000,
  "remarks": "Salary Payment"
}
```

---

## Get Transaction

```http
GET /api/transactions/{txnId}
```

---

## Raise Incident

```http
POST /api/incidents
```

### Request

```json
{
  "serviceName": "payment-service",
  "severity": "P1",
  "issueDescription": "Database timeout"
}
```

---

# Kafka Configuration

## Topic

```text
payment-topic
```

## Producer
Publishes transaction events.

## Consumer
Consumes transaction events asynchronously.

---

# Swagger UI

Access Swagger documentation:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# How To Run

## 1. Clone Repository

```bash
git clone <repository-url>
```

---

## 2. Configure MySQL

Create database:

```sql
CREATE DATABASE payment_db;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/payment_db
spring.datasource.username=root
spring.datasource.password=root
```

---

## 3. Start Kafka

Start:
- Zookeeper
- Kafka Server

Create topic:

```bash
kafka-topics.bat --create --topic payment-topic --bootstrap-server localhost:9092
```

---

## 4. Run Application

```bash
mvn spring-boot:run
```

---

## 5. Test APIs

Use:
- Postman
- Swagger UI

---

# Sample Production Support Scenarios

## Scenario 1 — Kafka Down

### Issue
Transaction processing delayed.

### Resolution
- Restart Kafka broker
- Replay failed events
- Retry scheduler reprocesses transactions

---

## Scenario 2 — Database Timeout

### Issue
API returning HTTP 500.

### Resolution
- Verify DB connectivity
- Check connection pool
- Analyze slow queries
- Restart impacted services

---

## Scenario 3 — Failed Payment Retry

### Issue
Downstream banking service unavailable.

### Resolution
- Mark transaction FAILED
- Retry scheduler automatically retries processing

---

# Future Enhancements

- JWT Authentication
- Role-Based Access Control
- CSV ACH File Upload
- Splunk Integration
- ELK Monitoring
- Redis Caching
- Kubernetes Deployment
- Circuit Breaker Pattern
- Email Notifications
- Dead Letter Queue (DLQ)

---

# Monitoring Endpoints

## Health Check

```text
/actuator/health
```

## Metrics

```text
/actuator/metrics
```

---

# Learning Outcomes

This project demonstrates:
- REST API development
- Kafka event-driven architecture
- Enterprise exception handling
- Production support troubleshooting
- Database persistence
- Scheduler implementation
- Microservice design principles

---

# Author

Developed as a production-support-oriented banking transaction processing system to simulate real enterprise integration workflows.

---

# License

This project is intended for learning, demonstration purposes.