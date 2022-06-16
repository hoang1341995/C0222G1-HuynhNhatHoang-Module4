package example.repository;

import example.model.Declaration;

import java.util.List;

public interface IDeclarationRepo {

    List<Declaration> returnDeclarationList();

    void addNewDeclaration(Declaration declaration);

    List<String> returnyearOfBirthdayListList();

}
