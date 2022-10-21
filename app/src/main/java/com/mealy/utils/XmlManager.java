package com.mealy.utils;

import android.content.Context;

import com.mealy.data.Meal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class XmlManager {
    private String _saveFileName;
    private Context _context;

    public XmlManager() {
        _saveFileName = /*Environment.getDataDirectory() + */"/Mealy/mealList";
        _context = Manager.getInstance().getContext();
    }

    public void saveMeals(){
        try {
            FileOutputStream fos = getContext().openFileOutput(new File(_saveFileName).getName(), Context.MODE_PRIVATE);
            //FileOutputStream fos = new FileOutputStream(new File(_saveFileName));
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(Manager.getInstance().getMeals());
            os.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMeals(){
        File file = new File(getContext().getFilesDir(), _saveFileName);
        //Check if the file exists
        if(!file.exists()){
            //Create it if it doesn't exist
            saveMeals();
        }else{
            //Load it if it exists
            try {
                FileInputStream fis = getContext().openFileInput(_saveFileName);
                //FileInputStream fis = new FileInputStream(new File(_saveFileName));
                ObjectInputStream is = new ObjectInputStream(fis);
                Manager.getInstance().setMeals( (List<Meal>) is.readObject() );
                is.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    //GETTERS AND SETTERS
    public Context getContext() {
        return _context;
    }
}
