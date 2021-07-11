## Restful API tutorials

We will go step-by-step on how to create from scratch using a problem statement given.

  1. create db
  2. Create entity / model - use lombok
  3. repository
  4. service to implement repo
  5. controller
  6. h2 / mysql config
  

## 1. create db - seller

create database mockashop;
use mockashop;

CREATE TABLE `mockashop`.`customer` (
  `seller_id` VARCHAR(45) NOT NULL,
  `seller_name` VARCHAR(45) NOT NULL,
  `seller_email` VARCHAR(45) NOT NULL,
  `seller_pswd` VARCHAR(45) NOT NULL,
  `seller_contact` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`seller_id`),
  UNIQUE INDEX `seller_id_UNIQUE` (`seller_id` ASC) VISIBLE,
  UNIQUE INDEX `seller_pswd_UNIQUE` (`seller_pswd` ASC) VISIBLE,
  UNIQUE INDEX `seller_contact_UNIQUE` (`seller_contact` ASC) VISIBLE,
  UNIQUE INDEX `seller_email_UNIQUE` (`seller_email` ASC) VISIBLE);

INSERT INTO `mockashop`.`customer` (`seller_id`, `seller_name`, `seller_email`, `seller_pswd`, `seller_contact`) VALUES ('10001', 'cindi', 'cindi@gmail.com', 'abc123', '92212152');
INSERT INTO `mockashop`.`customer` (`seller_id`, `seller_name`, `seller_email`, `seller_pswd`, `seller_contact`) VALUES ('10002', 'shah', 'shah@gmail.com', 'xyz456', '93262634');