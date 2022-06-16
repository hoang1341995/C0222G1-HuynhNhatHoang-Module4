package example.repository.impl;

import example.model.Declaration;
import example.repository.IDeclarationRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeclarationRepo implements IDeclarationRepo {

    static List<String> yearOfBirthdayList = new ArrayList<>();
    static List<Declaration> declarationList = new ArrayList<>();

    static {
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

        declarationList.add(new Declaration("Hoang Huỳnh","1996","Viet Nam","Nam","9999","Xe Máy","43-e1","01","12/12/2020","13/12/2020","Ở nhà"));
        declarationList.add(new Declaration("Luân cold","1995","Viet Nam","Nam","9999","Xe Máy","43-e1","01","12/12/2020","13/12/2020","Ở nhà"));
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
    public List<String> returnyearOfBirthdayListList() {
        return yearOfBirthdayList;
    }
}
