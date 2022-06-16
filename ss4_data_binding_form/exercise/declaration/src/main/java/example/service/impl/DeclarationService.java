package example.service.impl;

import example.model.Declaration;
import example.repository.IDeclarationRepo;
import example.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationService implements IDeclarationService {

    @Autowired
    private IDeclarationRepo iDeclarationRepo;

    @Override
    public List<Declaration> returnDeclarationList() {
        return iDeclarationRepo.returnDeclarationList();
    }

    @Override
    public void addNewDeclaration(Declaration declaration) {
        iDeclarationRepo.addNewDeclaration(declaration);
    }

    @Override
    public List<String> returnyearOfBirthdayListList() {
        return iDeclarationRepo.returnyearOfBirthdayListList();
    }
}
