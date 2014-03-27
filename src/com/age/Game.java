package com.age;

import com.age.helper.Ascii;
import com.age.helper.Binary;

/**
 * Created by apex on 14/03/14.
 */
public class Game {
    public static View currentView;
    private View overLay;
    public Game(String title, int width, int height){
        Screen.create(width, height,title);
    }

    /**
     * This method should only be ever called once
     * @param view View you would like the game to start with
     */
    public void start(View view){
        changeView(view);
        update();
    }

    public void update(){
        while(!Screen.isCloseRequested()){
            Screen.update();
            if(currentView != null){
                currentView.update();
                currentView.render();
            }
            //TODO create fluctuating fps for less of a power usage
            Screen.refresh(60);
        }
    }

    public boolean changeView(View view){
        if(currentView != null)
            currentView.dispose();
        view.setGame(this);
        currentView = view;
        if(!currentView.isHasInitialized()){
            currentView.init();
            currentView.setHasInitialized(true);
        }
        return true;
    }
}
