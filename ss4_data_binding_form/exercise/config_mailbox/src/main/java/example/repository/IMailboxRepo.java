package example.repository;

import example.model.Mailbox;

import java.util.List;

public interface IMailboxRepo {

    List<Mailbox> returnMailboxList();

    void addNewSettings(Mailbox mailbox);
}
