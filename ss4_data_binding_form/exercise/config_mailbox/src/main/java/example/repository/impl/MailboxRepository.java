package example.repository.impl;

import example.model.Mailbox;
import example.repository.IMailboxRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MailboxRepository implements IMailboxRepository {
    static List<Mailbox> mailboxList = new ArrayList<>();

    static {
        mailboxList.add(new Mailbox("VietNam", 15, true, "viet"));
        mailboxList.add(new Mailbox("VietNam", 25, false, "nam"));
        mailboxList.add(new Mailbox("English", 25, true, "thien"));
        mailboxList.add(new Mailbox("VietNam", 15, false, "hai"));
    }

    @Override
    public List<Mailbox> returnMailboxList() {
        return mailboxList;
    }

    @Override
    public void addNewSettings(Mailbox mailbox) {
        mailboxList.add(mailbox);
    }
}
