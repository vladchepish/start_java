package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDateGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDateGenerator generator = new ContactDateGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactDate> contacts = generateContacts(count);
        if (format.equals("csv")){
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }

    }

    private void saveAsXml(List<ContactDate> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactDate.class);
        String xml = xstream.toXML(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private void saveAsCsv(List<ContactDate> contacts, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (ContactDate contact : contacts) {
                writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getLastName(),
                        contact.getMiddleName(), contact.getHomePhone(), contact.getHomePhone(), contact.getMobilePhone(),
                        contact.getWorkPhone(), contact.getEmail1(), contact.getEmail2(), contact.getEmail3(), contact.getAddress()));
            }
        }
    }

    private List<ContactDate> generateContacts(int count) {
        File photo = new File("src/test/resources/avatar.png");
        List<ContactDate> contacts = new ArrayList<ContactDate>();
        for (int i = 0; i < count; i++){
            contacts.add(new ContactDate()
                    .withFirstName(String.format("firstName" + "%s", i)).withLastName(String.format("lastName" + "%s", i)).withMiddleName(String.format("middleName" +"%s", i))
                    .withHomePhone(String.format("+(" + "%s" + ")-111-22-33", i)).withWorkPhone(String.format("+(" + "%s" + ")-111-22-33", i)).withMobilePhone(String.format("+(" + "%s" + ")-111-22-33", i))
                    .withEmail1(String.format("test1" + "%s" + "@test.ru", i)).withEmail2(String.format("test2" + "%s" + "@test.ru", i)).withEmail3(String.format("test3" + "%s" + "@test.ru", i)).withPhoto(photo)
                    .withAddress(String.format("address" + "%s", i)));
        }
        return contacts;
    }
}
