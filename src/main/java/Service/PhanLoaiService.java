package Service;

import Dao.ManageMySQL;
import Model.PhanLoai;

import java.util.ArrayList;

public class PhanLoaiService {
    public static ArrayList<PhanLoai> listpl = new ArrayList<>();

    public PhanLoaiService() {
        try {
            listpl = (ArrayList<PhanLoai>) ManageMySQL.SelectID();
        } catch (Exception a) {
            a.printStackTrace();
        }

    }
}


