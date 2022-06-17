package example.service.impl;

import example.model.Declaration;
import example.repository.IDeclarationRepository;
import example.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationService implements IDeclarationService {

    @Autowired
    private IDeclarationRepository iDeclarationRepository;

    @Override
    public List<Declaration> returnDeclarationList() {
        return iDeclarationRepository.returnDeclarationList();
    }

    @Override
    public void addNewDeclaration(Declaration declaration) {
        iDeclarationRepository.addNewDeclaration(declaration);
    }

    @Override
    public List<String> returnyearOfBirthdayList() {
        return iDeclarationRepository.returnyearOfBirthdayList();
    }

    @Override
    public List<String> returnCountryList() {
        return iDeclarationRepository.returnCountryList();
    }

    @Override
    public List<String> returnVehiclesList() {
        return iDeclarationRepository.returnVehiclesList();
    }

    @Override
    public List<String> returnGenderList() {
        return iDeclarationRepository.returnGenderList();
    }
}
