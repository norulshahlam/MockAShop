

CREATE TABLE `mockashop`.`customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(45) NOT NULL,
  `customer_email` VARCHAR(45) NOT NULL,
  `customer_pswd` VARCHAR(45) NOT NULL,
  `customer_contact` VARCHAR(45) NOT NULL,
  `customer_wallet` INT NOT NULL,
 
  PRIMARY KEY (`customer_id`),
  UNIQUE INDEX `customer_id_UNIQUE` (`customer_id` ASC) VISIBLE,
  UNIQUE INDEX `customer_email_UNIQUE` (`customer_email` ASC) VISIBLE);


CREATE TABLE `mockashop`.`seller` (
  `seller_id` INT NOT NULL AUTO_INCREMENT,
  `seller_name` VARCHAR(45) NOT NULL,
  `seller_email` VARCHAR(45) NOT NULL,
  `seller_pswd` VARCHAR(45) NOT NULL,
  `seller_contact` VARCHAR(45) NOT NULL,
    `seller_wallet` INT NOT NULL,
  PRIMARY KEY (`seller_id`),
  UNIQUE INDEX `seller_id_UNIQUE` (`seller_id` ASC) VISIBLE,
  UNIQUE INDEX `seller_email_UNIQUE` (`seller_email` ASC) VISIBLE);

CREATE TABLE `mockashop`.`product` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NOT NULL,
  `product_price` VARCHAR(45) NOT NULL,
  `product_description` VARCHAR(45) NOT NULL,
  `seller_id` INT NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `product_id_UNIQUE` (`product_id` ASC) VISIBLE,
  INDEX `seller_id_idx` (`seller_id` ASC) VISIBLE,
  CONSTRAINT `seller_id`
    FOREIGN KEY (`seller_id`)
    REFERENCES `mockashop`.`seller` (`seller_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
