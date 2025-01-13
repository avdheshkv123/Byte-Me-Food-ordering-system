package com.example.ap_assignment_4;

import org.junit.Test;
import static org.junit.Assert.*;

public class JUnittest{
    @Test
    public void testoutofstock(){
        menu menu = new menu();
        assertTrue("The item should be present",menu.isavailable("pizza"));
        assertFalse("The item should not present in the menu",menu.isavailable("ice cream"));
    }
    @Test
    public void testInvalidLoginattempt(){
        user testuser = new user("customer"){};
        assertTrue("The system login with correct username",testuser.check_credentials("customer"));
        assertFalse("the system couldn't login with wrong username",testuser.check_credentials("wronguser"));
        assertFalse("Empty username",testuser.check_credentials(""));

    }

    @Test
    public void testremoveitem(){
        menu menu = new menu();
        menu.removeitem("pizza");
        assertTrue("The removed item no longer be in the menu",!menu.isavailable("pizza"));
        assertFalse("The removed item is present in the menu",menu.isavailable("pizza"));
    }

    @Test
    public void testaddnewitem(){
        menu menu = new menu();
        menu.addnewitem("ice cream",2.5);
        assertTrue("The item should be present in the cart",menu.isavailable("ice cream"));
        assertEquals("The item should be present at price $2.5",2.5,menu.getprice("ice cream"),0.01);
    }

    @Test
    public void testadditemtocart(){
        menu menu = new menu();
        cart cart = new cart(menu);
        cart.additem("pizza");
        assertTrue("the cart should contain the available item",cart.cart.contains("pizza"));
        cart.additem("black coffee");
        assertFalse("the cart shouldn't contain unavailable item",cart.cart.contains("black coffee"));
    }

    @Test
    public void testviewcart(){
        menu menu = new menu();
        cart cart = new cart(menu);
        cart.viewcart();
        assertTrue("The cart should be empty initially",cart.cart.isEmpty());

        cart.additem("pizza");
        cart.additem("coffee");
        assertTrue("The cart is not empty after adding the items",!cart.cart.isEmpty());

    }

    @Test
    public void testcarttotal(){
        menu menu = new menu();
        cart cart = new cart(menu);

        assertEquals("The cart total is $0.0 initally",0.0,cart.carttotal(),0.01);
        cart.additem("pizza");
        cart.additem("veg maggie");
        assertEquals("The total should match the items added in the cart",4.9+0.7,cart.carttotal(),0.01);

    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("com.example.ap_assignment_4.JUnittest;");
    }

}

