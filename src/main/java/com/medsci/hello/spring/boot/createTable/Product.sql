-- auto Generated on 2020-07-03
-- DROP TABLE IF EXISTS product;
CREATE TABLE product(
	id INT (11) UNIQUE NOT NULL AUTO_INCREMENT COMMENT 'id',
	product_name VARCHAR (50) NOT NULL COMMENT 'productName',
	company_id INT (11) NOT NULL COMMENT 'companyId',
	created_at DATETIME NOT NULL COMMENT 'createdAt',
	update_at VARCHAR (50) NOT NULL COMMENT 'updateAt',
INDEX `ix_company_id`(company_id),
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'product';

