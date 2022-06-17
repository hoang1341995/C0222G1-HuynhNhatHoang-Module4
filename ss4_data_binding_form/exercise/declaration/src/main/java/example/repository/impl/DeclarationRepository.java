package example.repository.impl;

import example.model.Declaration;
import example.repository.IDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeclarationRepository implements IDeclarationRepository {

    static List<String> yearOfBirthdayList = new ArrayList<>();
    static List<String> countryList = new ArrayList<>();
    static List<Declaration> declarationList = new ArrayList<>();
    static List<String> vehiclesList = new ArrayList<>();
    static List<String> genderList = new ArrayList<>();

    static {

        vehiclesList.add("Tàu bay");
        vehiclesList.add("Tàu thuyền");
        vehiclesList.add("Ô tô");
        vehiclesList.add("Xe máy");

        genderList.add("Khác");
        genderList.add("Nam");
        genderList.add("Nữ");

        yearOfBirthdayList.add("1990");
        yearOfBirthdayList.add("1991");
        yearOfBirthdayList.add("1992");
        yearOfBirthdayList.add("1993");
        yearOfBirthdayList.add("1994");
        yearOfBirthdayList.add("1995");
        yearOfBirthdayList.add("1996");
        yearOfBirthdayList.add("1997");
        yearOfBirthdayList.add("1998");
        yearOfBirthdayList.add("1999");

        countryList.add("Việt Nam");
        countryList.add("Trung Quốc");
        countryList.add("Mỹ");
        countryList.add("Nhật Bản");
        countryList.add("Hàn Quốc");

        declarationList.add(new Declaration("Hoang Huỳnh", "1996", "Viet Nam", "Nam", "9999", "Xe Máy", "43-e1", "01", "12/12/2020", "13/12/2020", "Ở nhà"));
        declarationList.add(new Declaration("Luân cold", "1995", "Viet Nam", "Nam", "9999", "Xe Máy", "43-e1", "01", "12/12/2020", "13/12/2020", "Ở nhà"));
    }

    @Override
    public List<Declaration> returnDeclarationList() {
        return declarationList;
    }

    @Override
    public void addNewDeclaration(Declaration declaration) {
        declarationList.add(declaration);

    }

    @Override
    public List<String> returnyearOfBirthdayList() {
        return yearOfBirthdayList;
    }

    @Override
    public List<String> returnCountryList() {
        return countryList;
    }

    @Override
    public List<String> returnVehiclesList() {
        return vehiclesList;
    }

    @Override
    public List<String> returnGenderList() {
        return genderList;
    }
}
