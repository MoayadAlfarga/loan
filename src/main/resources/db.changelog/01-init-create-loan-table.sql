--liquibase formatted sql

--changeset moayad:1
CREATE TABLE IF NOT EXISTS `loan_status` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `loan_status` VARCHAR(50) NOT NULL,
    `loan_id` BIGINT,
    `created_at` DATETIME DEFAULT NULL,
    `created_by` VARCHAR(100) DEFAULT NULL,
    `updated_at` DATETIME DEFAULT NULL,
    `updated_by` VARCHAR(100) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `loans` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `first_name_beneficiary` VARCHAR(100) DEFAULT NULL,
    `second_name_beneficiary` VARCHAR(100) DEFAULT NULL,
    `last_name_beneficiary` VARCHAR(100) DEFAULT NULL,
    `email_beneficiary` VARCHAR(100) DEFAULT NULL,
    `account_number` BIGINT DEFAULT NULL,
    `loan_type` VARCHAR(50) DEFAULT NULL,
    `principal_amount` DECIMAL(18,2) DEFAULT NULL,
    `interest_rate` DECIMAL(18,2) DEFAULT NULL,
    `loan_term_in_months` INT DEFAULT NULL,
    `outstanding_balance` DECIMAL(18,2) DEFAULT NULL,
    `start_date` DATE DEFAULT NULL,
    `end_date` DATE DEFAULT NULL,
    `loan_number` BIGINT DEFAULT NULL,
    `status_id` BIGINT,
    `created_at` DATETIME DEFAULT NULL,
    `created_by` VARCHAR(100) DEFAULT NULL,
    `updated_at` DATETIME DEFAULT NULL,
    `updated_by` VARCHAR(100) DEFAULT NULL,
    CONSTRAINT `fk_status` FOREIGN KEY (`status_id`) REFERENCES `loan_status` (`id`)
);

ALTER TABLE `loan_status` ADD CONSTRAINT `fk_loan` FOREIGN KEY (`loan_id`) REFERENCES `loans` (`id`);
