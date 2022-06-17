package example.repository;

import example.model.Declaration;

import java.util.List;

public interface IDeclarationRepository {

    List<Declaration> returnDeclarationList();

    void addNewDeclaration(Declaration declaration);

    List<String> returnyearOfBirthdayList();

    List<String> returnCountryList();

    List<String> returnVehiclesList();

    List<String> returnGenderList();


}
