package com.tocsyk.dao.daoImp;

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

-- 2017 10 12

ALTER TABLE `banking`.`bank`
CHANGE COLUMN `bank_contact` `bank_contact` INT(10) NOT NULL ;

ALTER TABLE `banking`.`branch`
CHANGE COLUMN `branch_contact` `branch_contact` INT(10) NOT NULL ;

ALTER TABLE `banking`.`branch`
CHANGE COLUMN `balanse` `balance` FLOAT NOT NULL ;


ALTER TABLE `banking`.`branch`
ADD COLUMN `branch_bank` INT(10) NOT NULL AFTER `branch_contact`;
ALTER TABLE `banking`.`branch`
ADD CONSTRAINT `FK_BANK_BRANCH`
  FOREIGN KEY (`ID`)
  REFERENCES `banking`.`bank` (`ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `banking`.`adress`
RENAME TO  `banking`.`address` ;


ALTER TABLE `banking`.`branch`
CHANGE COLUMN `branch_bank` `bank_branch` INT(10) NOT NULL ;


ALTER TABLE `banking`.`customer`
ADD COLUMN `branch_customer` INT(10) NOT NULL AFTER `balance`;
ALTER TABLE `banking`.`customer`
ADD CONSTRAINT `FK_BRANCH_CUSTOMER`
  FOREIGN KEY (`ID`)
  REFERENCES `banking`.`branch` (`ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `banking`.`account`
DROP FOREIGN KEY `FK_ACCOUNT_CONTRACT`;
ALTER TABLE `banking`.`account`
CHANGE COLUMN `account_contract` `customer_account` INT(10) NOT NULL ;
ALTER TABLE `banking`.`account`
ADD CONSTRAINT `FK_CUSTOMER_ACCOUNT`
  FOREIGN KEY (`ID`)
  REFERENCES `banking`.`customer` (`ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `banking`.`contract`
ADD COLUMN `account_contract` INT(10) NOT NULL AFTER `contract_type`;
ALTER TABLE `banking`.`contract`
ADD CONSTRAINT `FK_ACCOUNT_CONTRACT`
  FOREIGN KEY (`ID`)
  REFERENCES `banking`.`contact` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `banking`.`payment`
DROP FOREIGN KEY `PF_PAYMENT_CONTRACT`;
ALTER TABLE `banking`.`payment`
CHANGE COLUMN `payment_contract` `contract_payment` INT(10) NOT NULL ;
ALTER TABLE `banking`.`payment`
ADD CONSTRAINT `PF_CONTRACT_PAYMENT`
  FOREIGN KEY (`ID`)
  REFERENCES `banking`.`contract` (`ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

DROP TABLE `banking`.`account_status`;

CREATE TABLE `banking`.`account_status` (
  `ID` INT(10) NOT NULL,
  `status_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_ACCOUNT_ACCSTAT`
    FOREIGN KEY (`ID`)
    REFERENCES `banking`.`account` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



ALTER TABLE `banking`.`account`
DROP FOREIGN KEY `FK_ACCOUNT_TYPE`;
ALTER TABLE `banking`.`account`
DROP INDEX `FK_ACCOUNT_TYPE_idx` ;

ALTER TABLE `banking`.`bank`
DROP COLUMN `name`;





*/