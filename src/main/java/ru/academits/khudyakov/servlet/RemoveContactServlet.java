package ru.academits.khudyakov.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import static ru.academits.khudyakov.PhoneBook.contactDao;

public class RemoveContactServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try (OutputStream responseStream = resp.getOutputStream()) {
            String contactJson = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            contactJson = contactJson.replace("\"", "");
            contactDao.remove(contactJson);

            responseStream.write("Контакт удален".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            System.out.println("error in GetAllContactsServlet GET: ");
            e.printStackTrace();
        }
    }
}
