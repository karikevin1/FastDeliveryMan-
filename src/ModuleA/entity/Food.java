/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.entity;



/**
 *
 * @author User
 */
public class Food{
        int foodID;
	String foodName;
	double foodPrice;
	String foodDesc;
	

public Food(){
}

    public Food(int foodID, String foodName, double foodPrice, String foodDesc){
	this.foodID = foodID;
	this.foodName = foodName;
	this.foodPrice = foodPrice;
	this.foodDesc = foodDesc;
    }


    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
       	this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }


    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }
    
    
    public String toString(){
	return String.format("%-20d%-20s        %.2f %30s", foodID, foodName, foodPrice, foodDesc);
    }

}
