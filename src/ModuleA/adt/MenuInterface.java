/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;
import ModuleA.entity.Menu;
/**
 *
 * @author User
 */
public interface MenuInterface<T> {
        public boolean addMenu(T newMenu);
        public void clearMenu();
        public boolean updateMenu(int givenMenuPosition, T newMenu);
        public T getMenuEntry(int givenMenuPosition);
        public int getNumberOfMenu();
        public boolean isMenuEmpty(); 
        
}
