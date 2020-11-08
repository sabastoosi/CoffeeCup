package com.example.coffeecup;

import java.util.ArrayList;

public class ListOfBrews {

    private static ArrayList<Brew> listOfBrews;

    /**
     This method returns all brews in an array of Brew objects
     @return - ArrayList of Brew objects
     */
    public ArrayList<Brew> getAllBrews() {
        return listOfBrews;
    }

    /**
     This method adds a brew to our master list of brews
     @param brewToAdd - the List object of the list we'd like to add
     */
    public static void addBrew(Brew brewToAdd) {
        listOfBrews.add(brewToAdd);
    }

    /**
     This method deletes a brew from the master list of brews
     @param brewName - the name of the list we'd like to delete
     */
    public static void deleteList(String brewName) {
        for (int i = 0; i < listOfBrews.size(); i ++) {
            if (listOfBrews.get(i).getmName().equals(brewName)) {
                listOfBrews.remove(i);
            }
        }
    }

    /**
     This method handles renaming a Brew
     @param brewName - the name of the brew we'd like to rename
     @param newName - the new name of the brew
     */
    public static void renameList(String brewName, String newName) {
        Brew brew;
        // find the brew object with the name
        brew = find(brewName);
        // update the brew object name
        brew.setmName(newName);

        // insert new brew object into listOfBrews array
        for (int i = 0; i < listOfBrews.size(); i ++) {
            if (listOfBrews.get(i).getmName().equals(brew)) {
                listOfBrews.set(i, brew);
            }
        }
    }

    /**
     This method finds a brew object with the given name
     @return a Brew object
     @param brewName - the name of the brew we'd like to find the object for
     */
    public static Brew find(String brewName) {
        for (int i = 0; i < listOfBrews.size(); i ++) {
            if (listOfBrews.get(i).getmName().equals(brewName)) {
                return listOfBrews.get(i);
            }
        }
        return null;
    }

}
