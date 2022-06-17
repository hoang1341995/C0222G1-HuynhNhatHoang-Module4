package example.repository;

import example.model.Mailbox;

import java.util.List;

public interface IMailboxRepository {

    List<Mailbox> returnMailboxList();

    void addNewSettings(Mailbox mailbox);
}
