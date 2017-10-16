package com.tocsyk.service.ImplService;

import com.tocsyk.model.Contact;
import com.tocsyk.service.AbstractService.AbstractContactService;
import org.springframework.stereotype.Service;

@Service("contactService")
public class ContactServiceImpl implements AbstractContactService {
    @Override
    public int registerContact(Contact contact) {
        return 0;
    }

    @Override
    public Contact loadContactDataByID(int contactID) {
        return null;
    }
}
