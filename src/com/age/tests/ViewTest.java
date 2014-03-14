package com.age.tests;

import com.age.Game;
import com.age.View;

/**
 * Created by apex on 14/03/14.
 */
public class ViewTest extends View{
    public static void main(String...args){
        Game g = new Game("ViewTest", 600,400);
        g.start(new ViewTest());
    }

    public ViewTest(){
        super("ViewTest");
    }

    @Override
    public void update() {
        System.out.println("Nope");
        getGame().changeView(new SecondView());
    }

    @Override
    public void dispose(){
        System.out.println("I got switched!");
    }

    public class SecondView extends View{
        public SecondView(){
            super("SecondView");
        }

        @Override
        public void update(){
            System.out.println("It really works!");
            getGame().changeView(new ViewTest());
        }

        @Override
        public void dispose(){

        }
    }
}
