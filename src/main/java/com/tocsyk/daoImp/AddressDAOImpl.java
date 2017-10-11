package com.tocsyk.daoImp;

import com.tocsyk.dao.AddressDAO;
import com.tocsyk.models.Address;

public class AddressDAOImpl implements AddressDAO {

    @Override
    public void registerAddress(Address address) {

    }

    @Override
    public Address loadAddress(String adressName) {
        return null;
    }
}

/*


CREATE TABLE `banking`.`adress`
(
	`id` INT(10) NOT NULL,
	`city` VARCHAR(45) NOT NULL,
	`street` VARCHAR(45) NOT NULL,
	`house` VARCHAR(45) NOT NULL,
	`postalcode` VARCHAR(45) NOT NULL,
	 PRIMARY KEY (`id`)
);



CREATE TABLE `banking`.`contact`
(
	`id` INT(10) NOT NULL,
	`mobile` VARCHAR(45) NOT NULL,
	`telephone` VARCHAR(45) NOT NULL,
	`email` VARCHAR(45) NOT NULL,
	`address` VARCHAR(45) NOT NULL,
	 PRIMARY KEY (`id`),
	CONSTRAINT `FT_CONTACT_ADDRESS`
    FOREIGN KEY (`id`)
	 REFERENCES `banking`.`adress` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `banking`.`contract_type` (
  `contracttype` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`contracttype`));

CREATE TABLE `banking`.`payment_type` (
  `Paymenttype` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Paymenttype`));


CREATE TABLE `banking`.`statuses_type` (
  `statusestype` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`statusestype`));




INSERT INTO `banking`.`statuses_type`
(`statusestype`)
VALUES
('Unspecified');

INSERT INTO `banking`.`statuses_type`
(`statusestype`)
VALUES
('Open');

INSERT INTO `banking`.`statuses_type`
(`statusestype`)
VALUES
('Closed');

INSERT INTO `banking`.`statuses_type`
(`statusestype`)
VALUES
('Suspended');


INSERT INTO `banking`.`contract_type`
(`contracttype`)
VALUES
('Unspecified');

INSERT INTO `banking`.`contract_type`
(`contracttype`)
VALUES
('Credit');
INSERT INTO `banking`.`contract_type`
(`contracttype`)
VALUES
('Debit');
INSERT INTO `banking`.`contract_type`
(`contracttype`)
VALUES
('Leasing');
INSERT INTO `banking`.`contract_type`
(`contracttype`)
VALUES
('Grant');



INSERT INTO `banking`.`payment_type`
(`Paymenttype`)
VALUES
('Unspecified');
INSERT INTO `banking`.`payment_type`
(`Paymenttype`)
VALUES
('Debited');
INSERT INTO `banking`.`payment_type`
(`Paymenttype`)
VALUES
('Credited');


CREATE TABLE `banking`.`role_type` (
  `roletype` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`roletype`));


INSERT INTO `banking`.`role_type`
(`roletype`)
VALUES
('Unspecified');
INSERT INTO `banking`.`role_type`
(`roletype`)
VALUES
('ADMIN');INSERT INTO `banking`.`role_type`
(`roletype`)
VALUES
('BANK');INSERT INTO `banking`.`role_type`
(`roletype`)
VALUES
('BRANCH');INSERT INTO `banking`.`role_type`
(`roletype`)
VALUES
('CUSTOMER');INSERT INTO `banking`.`role_type`
(`roletype`)
VALUES
('CONTRACT');INSERT INTO `banking`.`role_type`
(`roletype`)
VALUES
('PAYMENT');


CREATE TABLE `banking`.`payment` (
  `contract_id` INT NOT NULL,
  `payment_amount` FLOAT NOT NULL,
  `payment_date` DATE NOT NULL,
  `payment_contract` INT NOT NULL,
  PRIMARY KEY (`contract_id`));





*/