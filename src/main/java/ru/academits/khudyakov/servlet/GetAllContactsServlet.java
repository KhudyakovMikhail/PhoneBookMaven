package ru.academits.khudyakov.servlet;

import ru.academits.khudyakov.PhoneBook;
import ru.academits.khudyakov.coverter.ContactConverter;
import ru.academits.khudyakov.model.Contact;
import ru.academits.khudyakov.service.ContactService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GetAllContactsServlet extends HttpServlet {
    private final ContactService phoneBookService = PhoneBook.phoneBookService;
    private final ContactConverter contactConverter = PhoneBook.contactConverter;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Contact> contactList = phoneBookService.getAllContacts();
            String contactListJson = contactConverter.convertToJson(contactList);
            resp.getOutputStream().write(contactListJson.getBytes(StandardCharsets.UTF_8));
            resp.getOutputStream().flush();
            resp.getOutputStream().close();
        } catch (Exception e) {
            System.out.println("error in GetAllContactsServlet GET: ");
            e.printStackTrace();
        }
    }
}
