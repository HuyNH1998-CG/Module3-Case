package services;

import down.CRUDAccount;
import models.Account;

import java.util.ArrayList;

public class LoginService {
    public static ArrayList<Account>listAcc=new ArrayList<>();
    public LoginService(){
        try{
            listAcc= CRUDAccount.showAccount();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void save(Account account){
        try {
            CRUDAccount.saveAccount(account);
            listAcc= CRUDAccount.showAccount();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit(Account account){
        try {
            CRUDAccount.editAccount(account);
            listAcc= CRUDAccount.showAccount();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try {
            CRUDAccount.deleteAccount(id);
            listAcc= CRUDAccount.showAccount();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
