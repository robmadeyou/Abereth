package com.gmail.robmadeyou.tests;

import com.gmail.robmadeyou.Abereth;
import com.gmail.robmadeyou.ABScreen;
import com.gmail.robmadeyou.ABScreen.GameType;
import com.gmail.robmadeyou.ABTarget;
import com.gmail.robmadeyou.Entity.ABPlayer;
import com.gmail.robmadeyou.World.ABCamera;

public class CameraInCamera {
	public static void main(String args[]){
		ABScreen.create(700, 600, "CaminCam", GameType.SIDE_SCROLLER, false);
		
		
		ABScreen.setUpWorld();
		ABPlayer player = (ABPlayer) Abereth.addEntity(new ABPlayer(0, 0, 32, 64));
		ABCamera cam = Abereth.addNewCamera(new ABCamera(0, 0, 0, 0, ABScreen.getWidth(), ABScreen.getWidth()));
		cam.setCameraBounds(true);
		cam.setFollowingTarget(true);
		cam.setTarget(new ABTarget(player));
		ABCamera cam2 = Abereth.addNewCamera(new ABCamera(400, 0, 0, 0, 300, 200));
		
		
		while(!ABScreen.isAskedToClose()){
			ABScreen.update(60);
			
			
			
			ABScreen.refresh();
		}
	}
}