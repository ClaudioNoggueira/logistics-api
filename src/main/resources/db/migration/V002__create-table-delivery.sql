CREATE TABLE delivery (
	id SERIAL,
	customer_id BIGINT NOT NULL,
   	fee DECIMAL(10,2) NOT NULL,
	status VARCHAR(20) NOT NULL,
	request_date DATE NOT NULL,
	conclusion_date DATE,
    
	receiver_name VARCHAR(60) NOT NULL,
	receiver_address VARCHAR(255) NOT NULL,
	receiver_number VARCHAR(30) NOT NULL,
	receiver_district VARCHAR(30) NOT NULL,
	receiver_complement VARCHAR(60),
    
	PRIMARY KEY (id)
);

ALTER TABLE delivery ADD CONSTRAINT fk_delivery_customer
FOREIGN KEY (customer_id) REFERENCES customer (id);