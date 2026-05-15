CREATE DATABASE payment_db;

use payment_db;

CREATE TABLE payment_transaction (

    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    txn_id VARCHAR(100),

    account_number VARCHAR(100),

    amount DECIMAL(10,2),

    status VARCHAR(50),

    remarks VARCHAR(255),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE incident_log (

    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    service_name VARCHAR(100),

    severity VARCHAR(20),

    issue_description VARCHAR(255),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);