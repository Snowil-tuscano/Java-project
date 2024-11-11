# Gender Equality Dashboard

A Java-based web application that tracks gender-related metrics such as access to education, employment rates, wage gaps, and leadership roles.

## Database Setup

Create the `gender_equality_db` database and the `gender_statistics` table using the following SQL script:



https://github.com/user-attachments/assets/db2f7aed-7725-4a1b-8108-308c6806788d


```sql
-- Create database
CREATE DATABASE gender_equality_db;
USE gender_equality_db;

-- Create table for gender statistics
CREATE TABLE gender_statistics (
    id INT PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(100) NOT NULL,
    year INT NOT NULL,
    gdi_value DECIMAL(10,4),
    gii_value DECIMAL(10,4),
    labor_force_participation DECIMAL(10,4),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_timestamp ON UPDATE CURRENT_TIMESTAMP
);

-- Insert sample data
INSERT INTO gender_statistics (country, year, gdi_value, gii_value, labor_force_participation) 
VALUES 
('Brazil', 2021, 0.994, 0.390, 54.2),
('Canada', 2021, 0.986, 0.080, 75.1),
('China', 2021, 0.961, 0.192, 69.5),
('Germany', 2021, 0.972, 0.073, 74.8),
('India', 2021, 0.849, 0.490, 32.5),
('United States', 2021, 0.994, 0.204, 68.9);

