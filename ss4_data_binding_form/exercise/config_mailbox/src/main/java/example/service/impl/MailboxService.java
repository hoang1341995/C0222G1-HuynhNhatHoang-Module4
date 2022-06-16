package example.service.impl;

import example.model.Mailbox;
import example.repository.IMailboxRepo;
import example.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailboxService implements IMailboxService {

    @Autowired
    private IMailboxRepo iMailboxRepo;

    @Override
    public List<Mailbox> returnMailboxList() {
        return iMailboxRepo.returnMailboxList();
    }

    @Override
    public void addNewSettings(Mailbox mailbox) {
        iMailboxRepo.addNewSettings(mailbox);
    }
}
