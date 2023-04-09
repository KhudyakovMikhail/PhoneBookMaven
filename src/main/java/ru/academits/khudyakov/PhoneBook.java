package ru.academits.khudyakov;

import ru.academits.khudyakov.coverter.ContactConverter;
import ru.academits.khudyakov.coverter.ContactValidationConverter;
import ru.academits.khudyakov.dao.ContactDao;
import ru.academits.khudyakov.service.ContactService;

public class PhoneBook {

    public static ContactDao contactDao = new ContactDao();

    public static ContactService phoneBookService = new ContactService();

    public static ContactConverter contactConverter = new ContactConverter();

    public static ContactValidationConverter contactValidationConverter = new ContactValidationConverter();
}
