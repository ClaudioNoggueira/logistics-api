CREATE TABLE occurence (
	id SERIAL,
	delivery_id BIGINT NOT NULL,
	description VARCHAR(255) NOT NULL,
	register_date DATE NOT NULL,

	PRIMARY KEY(id)
);

ALTER TABLE occurence ADD CONSTRAINT fk_occurence_delivery
	FOREIGN KEY(delivery_id) REFERENCES delivery(id);
	