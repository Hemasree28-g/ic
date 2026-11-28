
CREATE DATABASE IF NOT EXISTS shopping_management;
USE shopping_management;

CREATE TABLE IF NOT EXISTS products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
    stock_quantity INT NOT NULL DEFAULT 0 CHECK (stock_quantity >= 0),
    supplier VARCHAR(100) NOT NULL,
    created_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS customers (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    city VARCHAR(50) NOT NULL,
    age INT NOT NULL CHECK (age >= 18),
    registration_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS sales (
    sale_id INT PRIMARY KEY,
    customer_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    total_amount DECIMAL(10,2) NOT NULL CHECK (total_amount >= 0),
    payment_mode VARCHAR(30) NOT NULL DEFAULT 'Cash',
    sale_date DATE NOT NULL,
    CONSTRAINT fk_sales_customer FOREIGN KEY (customer_id)
        REFERENCES customers(customer_id),
    CONSTRAINT fk_sales_product FOREIGN KEY (product_id)
        REFERENCES products(product_id)
);

-- Display databases, select the project database, and inspect tables.
SHOW DATABASES;
USE shopping_management;
SHOW TABLES;
DESC products;
DESC customers;
DESC sales;

-- Insert 15 products in one statement.
INSERT INTO products
(product_id, product_name, category, price, stock_quantity, supplier, created_date)
VALUES
(101, 'Smartphone', 'Electronics', 25000.00, 20, 'Tech World', '2025-01-05'),
(102, 'Laptop', 'Electronics', 65000.00, 8, 'Global Tech', '2025-01-08'),
(103, 'Headphones', 'Electronics', 2500.00, 35, 'Sound Tech', '2025-01-10'),
(104, 'Smartwatch', 'Electronics', 7500.00, 12, 'Tech World', '2025-01-12'),
(105, 'Bluetooth Speaker', 'Electronics', 3200.00, 18, 'Audio Tech', '2025-01-15'),
(106, 'Office Chair', 'Furniture', 8500.00, 10, 'Comfort Furnishings', '2025-01-18'),
(107, 'Study Table', 'Furniture', 12000.00, 6, 'Modern Furniture', '2025-01-20'),
(108, 'Bookshelf', 'Furniture', 5500.00, 14, 'Modern Furniture', '2025-01-22'),
(109, 'T-Shirt', 'Clothing', 800.00, 50, 'Style House', '2025-01-25'),
(110, 'Jeans', 'Clothing', 1800.00, 28, 'Denim House', '2025-01-27'),
(111, 'Running Shoes', 'Clothing', 3500.00, 16, 'Active Wear', '2025-02-01'),
(112, 'Microwave', 'Appliances', 9500.00, 9, 'Home Tech', '2025-02-03'),
(113, 'Refrigerator', 'Appliances', 32000.00, 5, 'Home Tech', '2025-02-05'),
(114, 'Water Bottle', 'Accessories', 450.00, 60, 'Daily Needs', '2025-02-07'),
(115, 'Desk Lamp', 'Accessories', 1200.00, 7, 'Bright Tech', '2025-02-09');

-- Insert 15 customers in one statement.
INSERT INTO customers
(customer_id, customer_name, email, city, age, registration_date)
VALUES
(201, 'Aarav Sharma', 'aarav@example.com', 'Bangalore', 24, '2025-01-02'),
(202, 'Ananya Rao', 'ananya@example.com', 'Chennai', 22, '2025-01-04'),
(203, 'Rahul Verma', 'rahul@example.com', 'Mysore', 29, '2025-01-06'),
(204, 'Sneha Reddy', 'sneha@example.com', 'Hyderabad', 25, '2025-01-08'),
(205, 'Karan Mehta', 'karan@example.com', 'Mumbai', 31, '2025-01-10'),
(206, 'Priya Nair', 'priya@example.com', 'Bangalore', 27, '2025-01-12'),
(207, 'Arjun Kumar', 'arjun@example.com', 'Chennai', 23, '2025-01-14'),
(208, 'Meera Iyer', 'meera@example.com', 'Pune', 28, '2025-01-16'),
(209, 'Rohan Das', 'rohan@example.com', 'Mysore', 26, '2025-01-18'),
(210, 'Divya Shah', 'divya@example.com', 'Delhi', 30, '2025-01-20'),
(211, 'Vikram Singh', 'vikram@example.com', 'Hyderabad', 32, '2025-01-22'),
(212, 'Kavya Menon', 'kavya@example.com', 'Bangalore', 21, '2025-01-24'),
(213, 'Manav Joshi', 'manav@example.com', 'Mumbai', 34, '2025-01-26'),
(214, 'Ishita Bose', 'ishita@example.com', 'Chennai', 24, '2025-01-28'),
(215, 'Nikhil Jain', 'nikhil@example.com', 'Kolkata', 29, '2025-01-30');

-- Insert 25 sales transactions in one statement.
INSERT INTO sales
(sale_id, customer_id, product_id, quantity, total_amount, payment_mode, sale_date)
VALUES
(301, 201, 101, 1, 25000.00, 'UPI', '2025-03-01'),
(302, 202, 103, 2, 5000.00, 'Card', '2025-03-02'),
(303, 203, 109, 3, 2400.00, 'Cash', '2025-03-03'),
(304, 204, 102, 1, 65000.00, 'UPI', '2025-03-04'),
(305, 205, 106, 1, 8500.00, 'Card', '2025-03-05'),
(306, 206, 104, 2, 15000.00, 'UPI', '2025-03-06'),
(307, 207, 110, 2, 3600.00, 'Cash', '2025-03-07'),
(308, 208, 112, 1, 9500.00, 'Net Banking', '2025-03-08'),
(309, 209, 105, 1, 3200.00, 'UPI', '2025-03-09'),
(310, 210, 107, 1, 12000.00, 'Card', '2025-03-10'),
(311, 211, 101, 1, 25000.00, 'UPI', '2025-03-11'),
(312, 212, 111, 1, 3500.00, 'Cash', '2025-03-12'),
(313, 213, 108, 1, 5500.00, 'Card', '2025-03-13'),
(314, 214, 103, 1, 2500.00, 'UPI', '2025-03-14'),
(315, 201, 104, 1, 7500.00, 'Net Banking', '2025-03-15'),
(316, 202, 113, 1, 32000.00, 'Card', '2025-03-16'),
(317, 203, 101, 1, 25000.00, 'UPI', '2025-03-17'),
(318, 204, 105, 2, 6400.00, 'Cash', '2025-03-18'),
(319, 205, 110, 1, 1800.00, 'UPI', '2025-03-19'),
(320, 206, 102, 1, 65000.00, 'Card', '2025-03-20'),
(321, 207, 106, 1, 8500.00, 'UPI', '2025-03-21'),
(322, 208, 114, 4, 1800.00, 'Cash', '2025-03-22'),
(323, 209, 103, 2, 5000.00, 'UPI', '2025-03-23'),
(324, 210, 112, 1, 9500.00, 'Net Banking', '2025-03-24'),
(325, 211, 101, 1, 25000.00, 'Card', '2025-03-25');

-- Example of inserting selected columns only.
INSERT INTO products
(product_id, product_name, category, price, stock_quantity, supplier, created_date)
VALUES
(116, 'Gaming Mouse', 'Electronics', 2200.00, 22, 'Tech World', '2025-02-11');

-- Display inserted records.
SELECT * FROM products;
SELECT * FROM customers;
SELECT * FROM sales;


-- =========================================================
-- MODULE 3: PRODUCT SEARCH AND FILTERING
-- =========================================================

-- All available products.
SELECT * FROM products;

-- Product names and prices.
SELECT product_name, price FROM products;

-- Unique product categories.
SELECT DISTINCT category FROM products;

-- Products costing more than 5000.
SELECT * FROM products WHERE price > 5000;

-- Products costing less than 2000.
SELECT * FROM products WHERE price < 2000;

-- Electronics products.
SELECT * FROM products WHERE category = 'Electronics';

-- Products with stock below 10.
SELECT * FROM products WHERE stock_quantity < 10;

-- Electronics products with prices above 10000.
SELECT * FROM products
WHERE category = 'Electronics' AND price > 10000;

-- Electronics or Furniture products.
SELECT * FROM products
WHERE category = 'Electronics' OR category = 'Furniture';

-- Products not in Clothing.
SELECT * FROM products
WHERE NOT category = 'Clothing';


-- =========================================================
-- MODULE 4: ADVANCED SEARCHING
-- =========================================================

-- Product names start with S.
SELECT * FROM products WHERE product_name LIKE 'S%';

-- Product names end with e.
SELECT * FROM products WHERE product_name LIKE '%e';

-- Product names contain Phone.
SELECT * FROM products WHERE product_name LIKE '%Phone%';

-- Customer names start with A.
SELECT * FROM customers WHERE customer_name LIKE 'A%';

-- Customers from Bangalore, Chennai, or Mysore.
SELECT * FROM customers
WHERE city IN ('Bangalore', 'Chennai', 'Mysore');

-- Products priced between 1000 and 10000 (inclusive).
SELECT * FROM products
WHERE price BETWEEN 1000 AND 10000;

-- Customers aged between 20 and 30 (inclusive).
SELECT * FROM customers
WHERE age BETWEEN 20 AND 30;

-- Suppliers whose names contain Tech.
SELECT * FROM products
WHERE supplier LIKE '%Tech%';


-- =========================================================
-- MODULE 5: SORTING AND LIMITING
-- =========================================================

-- Products ascending by price.
SELECT * FROM products ORDER BY price ASC;

-- Products descending by price.
SELECT * FROM products ORDER BY price DESC;

-- Five most expensive products.
SELECT * FROM products ORDER BY price DESC LIMIT 5;

-- Five cheapest products.
SELECT * FROM products ORDER BY price ASC LIMIT 5;

-- Customers alphabetically.
SELECT * FROM customers ORDER BY customer_name ASC;

-- Latest ten sales transactions.
SELECT * FROM sales ORDER BY sale_date DESC, sale_id DESC LIMIT 10;

-- Products sorted by stock quantity (lowest first).
SELECT * FROM products ORDER BY stock_quantity ASC;


-- =========================================================
-- MODULE 6: UPDATING AND DELETING RECORDS
-- =========================================================
-- These are real changes to the sample data. Run carefully.

-- Update the price of a particular product.
UPDATE products SET price = 26000.00 WHERE product_id = 101;

-- Increase the price of all Electronics products by 10%.
UPDATE products
SET price = price * 1.10
WHERE category = 'Electronics';

-- Update the stock quantity of a product.
UPDATE products SET stock_quantity = 30 WHERE product_id = 103;

-- Change a customer's city.
UPDATE customers SET city = 'Hyderabad' WHERE customer_id = 215;

-- Update a customer's email address.
UPDATE customers
SET email = 'nikhil.jain@example.com'
WHERE customer_id = 215;

-- Change the payment mode of a sales transaction.
UPDATE sales SET payment_mode = 'UPI' WHERE sale_id = 325;

-- Check a product's sales before attempting deletion.
SELECT * FROM sales WHERE product_id = 115;

-- Delete product 115 (Desk Lamp). It has no associated sales in this sample.
DELETE FROM products WHERE product_id = 115;

-- Check a customer's sales before attempting deletion.
SELECT * FROM sales WHERE customer_id = 215;

-- Customer 215 has no associated sales in this sample, so it can be deleted.
DELETE FROM customers WHERE customer_id = 215;

-- Delete sales records before a specified date.
-- This removes sales before 2025-03-05 from the sample data.
DELETE FROM sales WHERE sale_date < '2025-03-05';


-- =========================================================
-- MODULE 7: TABLE MODIFICATION
-- =========================================================

-- Add discount percentage.
ALTER TABLE products
ADD COLUMN discount_percentage DECIMAL(5,2) NOT NULL DEFAULT 0.00;

-- Add mobile number.
ALTER TABLE customers
ADD COLUMN mobile_number VARCHAR(15);

-- Modify supplier datatype/size.
ALTER TABLE products
MODIFY COLUMN supplier VARCHAR(150) NOT NULL;

-- Rename created_date to product_added_date.
ALTER TABLE products
RENAME COLUMN created_date TO product_added_date;

-- Add product status with a default value.
ALTER TABLE products
ADD COLUMN product_status VARCHAR(20) NOT NULL DEFAULT 'Available';

-- Add and then drop an example unnecessary column.
ALTER TABLE products ADD COLUMN temporary_note VARCHAR(100);
ALTER TABLE products DROP COLUMN temporary_note;

-- Display modified table structures.
DESC products;
DESC customers;
DESC sales;


-- =========================================================
-- MODULE 8: SALES CALCULATIONS
-- =========================================================

-- Total number of products.
SELECT COUNT(*) AS total_products FROM products;

-- Total number of customers.
SELECT COUNT(*) AS total_customers FROM customers;

-- Total number of sales.
SELECT COUNT(*) AS total_sales FROM sales;

-- Total revenue.
SELECT SUM(total_amount) AS total_revenue FROM sales;

-- Average product price.
SELECT AVG(price) AS average_product_price FROM products;

-- Most expensive product.
SELECT product_name, price
FROM products
ORDER BY price DESC
LIMIT 1;

-- Cheapest product.
SELECT product_name, price
FROM products
ORDER BY price ASC
LIMIT 1;

-- Highest sales transaction amount.
SELECT MAX(total_amount) AS highest_transaction
FROM sales;

-- Total quantity of products sold.
SELECT SUM(quantity) AS total_quantity_sold
FROM sales;

-- Average sales transaction value.
SELECT AVG(total_amount) AS average_transaction_value
FROM sales;


SELECT category, COUNT(*) AS product_count
FROM products
GROUP BY category;

-- Average product price category-wise.
SELECT category, AVG(price) AS average_price
FROM products
GROUP BY category;

-- Total stock quantity category-wise.
SELECT category, SUM(stock_quantity) AS total_stock
FROM products
GROUP BY category;

-- Total revenue category-wise.
SELECT products.category, SUM(sales.total_amount) AS total_revenue
FROM products
INNER JOIN sales ON products.product_id = sales.product_id
GROUP BY products.category;

-- Number of sales transactions for each payment mode.
SELECT payment_mode, COUNT(*) AS transaction_count
FROM sales
GROUP BY payment_mode;

-- Total sales quantity for each product.
SELECT products.product_id, products.product_name,
       SUM(sales.quantity) AS total_quantity_sold
FROM products
INNER JOIN sales ON products.product_id = sales.product_id
GROUP BY products.product_id, products.product_name;

-- Categories having more than three products.
SELECT category, COUNT(*) AS product_count
FROM products
GROUP BY category
HAVING COUNT(*) > 3;

SELECT products.product_id, products.product_name,
       SUM(sales.quantity) AS total_quantity_sold
FROM products
INNER JOIN sales ON products.product_id = sales.product_id
GROUP BY products.product_id, products.product_name
HAVING SUM(sales.quantity) > 5;

-- Payment modes with more than five transactions.
SELECT payment_mode, COUNT(*) AS transaction_count
FROM sales
GROUP BY payment_mode
HAVING COUNT(*) > 5;

SELECT customers.customer_name, sales.sale_id, sales.quantity,
       sales.total_amount, sales.payment_mode, sales.sale_date
FROM customers
INNER JOIN sales ON customers.customer_id = sales.customer_id;

-- Product names with their sales quantities.
SELECT products.product_name, sales.quantity
FROM products
INNER JOIN sales ON products.product_id = sales.product_id;

-- Customer names, product names, and total amounts.
SELECT customers.customer_name, products.product_name, sales.total_amount
FROM sales
INNER JOIN customers ON sales.customer_id = customers.customer_id
INNER JOIN products ON sales.product_id = products.product_id;

-- Customer names with their purchased products.
SELECT customers.customer_name, products.product_name
FROM sales
INNER JOIN customers ON sales.customer_id = customers.customer_id
INNER JOIN products ON sales.product_id = products.product_id;

-- All customers, including customers who have never purchased anything.
SELECT customers.customer_id, customers.customer_name, sales.sale_id
FROM customers
LEFT JOIN sales ON customers.customer_id = sales.customer_id;

-- All products, including products that have never been sold.
SELECT products.product_id, products.product_name, sales.sale_id
FROM products
LEFT JOIN sales ON products.product_id = sales.product_id;

-- Sales details with customer information using RIGHT JOIN.
SELECT sales.sale_id, sales.quantity, sales.total_amount,
       customers.customer_name, customers.city
FROM sales
RIGHT JOIN customers ON sales.customer_id = customers.customer_id;

-- Complete sales report.
SELECT customers.customer_name, products.product_name, products.category,
       sales.quantity, sales.payment_mode, sales.total_amount
FROM sales
INNER JOIN customers ON sales.customer_id = customers.customer_id
INNER JOIN products ON sales.product_id = products.product_id;


-- =========================================================
-- FINAL BUSINESS REPORTS
-- =========================================================

-- Product Inventory Report.
SELECT product_id, product_name, category, stock_quantity, product_status
FROM products;

-- Low Stock Report.
SELECT * FROM products WHERE stock_quantity < 10;

-- Category Report.
SELECT category, COUNT(*) AS product_count
FROM products
GROUP BY category;

-- Product Price Report: highest and lowest priced products.
SELECT product_name, price
FROM products
WHERE price = (SELECT MAX(price) FROM products)
   OR price = (SELECT MIN(price) FROM products);

-- Customer Report.
SELECT * FROM customers;

-- Sales Report.
SELECT sales.sale_id, customers.customer_name, products.product_name,
       sales.quantity, sales.total_amount, sales.payment_mode, sales.sale_date
FROM sales
INNER JOIN customers ON sales.customer_id = customers.customer_id
INNER JOIN products ON sales.product_id = products.product_id;

-- Revenue Report.
SELECT SUM(total_amount) AS total_revenue FROM sales;

-- Payment Report.
SELECT payment_mode, COUNT(*) AS transactions,
       SUM(total_amount) AS payment_revenue
FROM sales
GROUP BY payment_mode;

-- Best-Selling Products.
SELECT products.product_name, SUM(sales.quantity) AS total_quantity_sold
FROM products
INNER JOIN sales ON products.product_id = sales.product_id
GROUP BY products.product_id, products.product_name
ORDER BY total_quantity_sold DESC;

-- Customer Purchase Report.
SELECT customers.customer_name, SUM(sales.total_amount) AS total_purchases
FROM customers
INNER JOIN sales ON customers.customer_id = sales.customer_id
GROUP BY customers.customer_id, customers.customer_name
ORDER BY total_purchases DESC;


-- =========================================================
-- FINAL CHALLENGE QUESTIONS
-- =========================================================

-- 1. Product that generated the highest total revenue.
SELECT products.product_id, products.product_name,
       SUM(sales.total_amount) AS total_revenue
FROM products
INNER JOIN sales ON products.product_id = sales.product_id
GROUP BY products.product_id, products.product_name
ORDER BY total_revenue DESC
LIMIT 1;

-- 2. Customer who made the highest-value purchase (single transaction).
SELECT customers.customer_name, sales.sale_id, sales.total_amount
FROM customers
INNER JOIN sales ON customers.customer_id = sales.customer_id
ORDER BY sales.total_amount DESC
LIMIT 1;

SELECT products.product_id, products.product_name
FROM products
LEFT JOIN sales ON products.product_id = sales.product_id
WHERE sales.product_id IS NULL;

-- 4. Customers who have never made a purchase.
SELECT customers.customer_id, customers.customer_name
FROM customers
LEFT JOIN sales ON customers.customer_id = sales.customer_id
WHERE sales.customer_id IS NULL;

SELECT products.category, SUM(sales.total_amount) AS total_revenue
FROM products
INNER JOIN sales ON products.product_id = sales.product_id
GROUP BY products.category
ORDER BY total_revenue DESC
LIMIT 1;

SELECT * FROM products WHERE stock_quantity < 5;

SELECT payment_mode, SUM(total_amount) AS total_revenue
FROM sales
GROUP BY payment_mode;

SELECT products.product_id, products.product_name,
       SUM(sales.quantity) AS total_quantity_sold
FROM products
INNER JOIN sales ON products.product_id = sales.product_id
GROUP BY products.product_id, products.product_name
ORDER BY total_quantity_sold DESC
LIMIT 5;
SELECT customers.customer_id, customers.customer_name,
       COUNT(DISTINCT sales.product_id) AS different_products
FROM customers
INNER JOIN sales ON customers.customer_id = sales.customer_id
GROUP BY customers.customer_id, customers.customer_name
HAVING COUNT(DISTINCT sales.product_id) > 1;

-- 10. Monthly sales summary.
SELECT YEAR(sale_date) AS sales_year,
       MONTH(sale_date) AS sales_month,
       COUNT(*) AS total_transactions,
       SUM(quantity) AS total_items_sold,
       SUM(total_amount) AS monthly_revenue
FROM sales
GROUP BY YEAR(sale_date), MONTH(sale_date)
ORDER BY sales_year, sales_month;
