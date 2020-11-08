package com.example.coffeecup;

import java.util.ArrayList;

public class ListOfBrews {

    private static ArrayList<Brew> listOfBrews;

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
            if (listOfBrews.get(i).get().equals(brewName)) {
                listOfBrews.remove(i);
            }
        }
    }

    /**
     This method handles renaming a list
     @param listName - the name of the list we'd like to rename
     @param newName - the new name of the list
     */
    public static void renameList(String listName, String newName) {
        Lists list;
        // find the list object with the name
        list = find(listName);
        // update the list object name
        list.updateName(newName);

        // insert new list object into allLists array
        for (int i = 0; i < mallLists.size(); i ++) {
            if (mallLists.get(i).getMlistName().equals(listName)) {
                mallLists.set(i, list);
            }
        }
    }




}
