/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.entity;

import ModuleA.entity.Menu;
import ModuleA.adt.MenuInterface;
import ModuleA.adt.MenuList;

/**
 *
 * @author Sing Keat
 */
public class Restaurant {
    private String name;
    private String address;
    private String telnum;
    private MenuInterface<Menu> menu = new MenuList();

    public void setMenu(Menu menu) {
        this.menu.addMenu(menu);
    }
    
    public Restaurant(String name, String address, String telnum) {
        this.name = name;
        this.address = address;
        this.telnum = telnum;
    }
    
    public Restaurant(String name, String address, String telnum, Menu menu) {
        this.name = name;
        this.address = address;
        this.telnum = telnum;
        this.menu.addMenu(menu);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }
    
    public Menu getMenu(int givenMenuPosition) {
        return menu.getMenuEntry(givenMenuPosition);
    }
    
    public MenuInterface<Menu> getMenuList() {
        return this.menu;
    }

    public String getName() {
        return name;
    }
}
    
