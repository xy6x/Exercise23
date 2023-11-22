package com.example.employeemana.ValidationEmployee;

import com.example.employeemana.ModleEmployee.ModleEmployee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ValidationEmployee {
    ArrayList<ModleEmployee> mod = new ArrayList<>();

    public ArrayList<ModleEmployee> getMod() {
        return mod;
    }

    public void addMod(ModleEmployee modleEmployee) {
        mod.add(modleEmployee);
    }

    public boolean UpdateModel(String id, ModleEmployee modleEmployee) {
        for (int i = 0; i < mod.size(); i++) {
            if (mod.get(i).getId().equals(id)) {
                mod.set(i, modleEmployee);
                return true;
            }
        }
        return false;
    }

    public boolean deleteModel(String id) {
        for (int i = 0; i < mod.size(); i++) {
            if (mod.get(i).getId().equals(id)) {
                mod.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<ModleEmployee> searchModel(String Position) {
        ArrayList<ModleEmployee> mo = new ArrayList<>();

        for (int i = 0; i < mod.size(); i++) {
            if (mod.get(i).getPosition().equals(Position)) {
                mo.add(mod.get(i));
            }
        }
        return mo;
    }

    public ArrayList<ModleEmployee> getRange(int min, int max) {
        ArrayList<ModleEmployee> ag = new ArrayList<>();
        for (int i = 0; i < mod.size(); i++) {
            if ((mod.get(i).getAge() > min) && (mod.get(i).getAge() < max)) {
                ag.add(mod.get(i));
            }
        }
        return ag;


    }

    public void getAnnualLeave(String id) {
        for (int i = 0; i < mod.size(); i++) {
            for (ModleEmployee m : mod
            ) {
                if (m.getId().equals(id)) {

                    if (0 < m.getAnnualLeave()) {

                        if (m.isOnLeave() == false) {
                            m.setAnnualLeave(m.getAnnualLeave() - 1);
                        }
                    }

                }
            }

        }
    }

    public ArrayList<ModleEmployee> getAnnul(String id) {
        ArrayList<ModleEmployee> mn = new ArrayList<>();
        for (int i = 0; i < mod.size(); i++) {
            for (ModleEmployee m : mod
            ) {
                if (m.getAnnualLeave() == 0) {
                    mn.add(mod.get(i));
                }
            }

        }
        return mn;
    }

    public ArrayList<ModleEmployee> promote(String id) {
        for (int i = 0; i < mod.size(); i++) {
            for (ModleEmployee promote : mod
            ) {
                if (promote.getId().equals(id) && promote.getAge() >= 30) {

                    if (promote.getPosition().equals("coordinator")) {
                        promote.setPosition("supervisor");
                        System.out.println(promote);
                    }

                }
            }

        }
        return null;
    }
}
