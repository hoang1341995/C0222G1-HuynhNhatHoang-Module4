package example.service;

import example.model.Declaration;

import java.util.List;

public interface IDeclarationService {

    List<Declaration> returnDeclarationList();

    void addNewDeclaration(Declaration declaration);

    List<String> returnyearOfBirthdayListList();

}
