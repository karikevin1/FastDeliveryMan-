/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.entity;

import ModuleA.entity.Food;
import ModuleA.adt.FoodInterface;
import ModuleA.adt.FoodList;
import ModuleA.adt.MenuInterface;
import ModuleA.adt.MenuList;

/**
 *
 * @author Sing Keat
 */
  public class Menu {
	int menuID;
	String menuName;
	String menuStatus;
        String menuPromo;
	private FoodInterface<Food> food = new FoodList();

    public Menu(){
    }

    public Menu(int menuID, String menuName, String menuStatus, String menuPromo){
	this.menuID = menuID;
	this.menuName = menuName;	
	this.menuStatus = menuStatus;
        this.menuPromo = menuPromo;
    }


    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
       	this.menuID = menuID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }


    public String getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(String menuStatus) {
        this.menuStatus = menuStatus;
    }

    public Food getFood(int givenFoodPosition){
	return food.getFoodEntry(givenFoodPosition);
    }	

    public FoodInterface<Food> getFoodList(){
	return this.food;
    }

    public String getMenuPromo() {
        return menuPromo;
    }

    public void setMenuPromo(String menuPromo) {
        this.menuPromo = menuPromo;
    }
    
    

    public String toString(){
	return String.format("%-20d%-20s%15s%15s", menuID, menuName, menuStatus, menuPromo);
    }


}

