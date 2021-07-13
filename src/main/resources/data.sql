
INSERT INTO `mockashop`.`customer` (`customer_id`, `customer_name`, `customer_email`, `customer_pswd`, `customer_contact`, `customer_wallet`) VALUES ('10001', 'cindi', 'cindi@gmail.com', 'abc123', '92212152', 190.50);
INSERT INTO `mockashop`.`customer` (`customer_id`, `customer_name`, `customer_email`, `customer_pswd`, `customer_contact`, `customer_wallet`) VALUES ('10002', 'shah', 'shah@gmail.com', 'xyz456', '93262634', 612.40);

INSERT INTO `mockashop`.`seller` (`seller_id`, `seller_name`, `seller_email`, `seller_pswd`, `seller_contact`, `seller_wallet`) VALUES ('20001', 'cindi', 'cindi2@gmail.com', 'abc123', '92212152', 456.20);
INSERT INTO `mockashop`.`seller` (`seller_id`, `seller_name`, `seller_email`, `seller_pswd`, `seller_contact`, `seller_wallet`) VALUES ('20002', 'shah', 'shah2@gmail.com', 'xyz456', '93262634', 300.50);

INSERT INTO `mockashop`.`product` (`product_id`, `product_name`, `product_price`, `product_description`, `seller_id`) VALUES ('30001', 'shoe', '40.50', 'for gym', '20001');
INSERT INTO `mockashop`.`product` (`product_id`, `product_name`, `product_price`, `product_description`, `seller_id`) VALUES ('30002', 'bag', '140.60', 'for travel', '20001');
INSERT INTO `mockashop`.`product` (`product_id`, `product_name`, `product_price`, `product_description`, `seller_id`) VALUES ('30003', 'cap', '20.50', 'protect from the sun', '20002');
INSERT INTO `mockashop`.`product` (`product_id`, `product_name`, `product_price`, `product_description`, `seller_id`) VALUES ('30004', 'shirt', '30.45', 'jalan jalan', '20002');
