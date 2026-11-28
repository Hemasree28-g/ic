CREATE DATABASE retail_shop;
USE retail_shop;
CREATE TABLE products (
    product_id INT,
    product_name VARCHAR(100),
    category VARCHAR(50),
    price DOUBLE,
    stock_quantity INT
);
desc products;