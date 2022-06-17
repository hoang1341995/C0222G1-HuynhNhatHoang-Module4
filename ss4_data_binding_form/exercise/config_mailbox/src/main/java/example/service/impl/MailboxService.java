package example.service.impl;

import example.model.Mailbox;
import example.repository.IMailboxRepository;
import example.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailboxService implements IMailboxService {

    @Autowired
    private IMailboxRepository iMailboxRepository;

    @Override
    public List<Mailbox> returnMailboxList() {
        return iMailboxRepository.returnMailboxList();
    }

    @Override
    public void addNewSettings(Mailbox mailbox) {
        iMailboxRepository.addNewSettings(mailbox);
    }
}
