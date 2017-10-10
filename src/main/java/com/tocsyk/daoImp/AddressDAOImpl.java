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

	`id` INT NOT NULL,

	`city` VARCHAR(45) NOT NULL,

	`street` VARCHAR(45) NOT NULL,

	`house` VARCHAR(45) NOT NULL,

	`postalcode` VARCHAR(45) NOT NULL,

	 PRIMARY KEY (`id`)
);



CREATE TABLE `banking`.`contact`
(

	`id` INT NOT NULL,

	`mobile` VARCHAR(45) NOT NULL,

	`telephone` VARCHAR(45) NOT NULL,

	`email` VARCHAR(45) NOT NULL,

.	`address` VARCHAR(45) NOT NULL,

	 PRIMARY KEY (`id`),

	CONSTRAINT `FT_CONTACT_ADDRESS`
    FOREIGN KEY (`id`)

	 REFERENCES `banking`.`adress` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);





*/