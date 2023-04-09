package ru.academits.khudyakov.coverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.academits.khudyakov.model.Contact;

import java.util.List;

public class ContactConverter {
    private final Gson gson = new GsonBuilder().create();

    public String convertToJson(List<Contact> contactList) {
        return gson.toJson(contactList);
    }

    public Contact convertFormJson(String contactJson) {
        return gson.fromJson(contactJson, Contact.class);
    }
}
