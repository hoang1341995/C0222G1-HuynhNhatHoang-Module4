package example.service;

import example.model.Mailbox;

import java.util.List;

public interface IMailboxService {

    List<Mailbox> returnMailboxList();

    void addNewSettings(Mailbox mailbox);
}
