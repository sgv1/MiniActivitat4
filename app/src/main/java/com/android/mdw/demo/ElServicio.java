package com.android.mdw.demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class ElServicio extends Service {

	private MediaPlayer player;
	private MediaPlayer playerM;

	@Override
	public IBinder onBind(Intent intent) {

		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, R.string.createservice, Toast.LENGTH_SHORT).show();
		player = MediaPlayer.create(this, R.raw.sable);
		playerM = MediaPlayer.create(this, R.raw.star_wars);
		player.setLooping(true);
		playerM.setLooping(true);
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, R.string.stopservice, Toast.LENGTH_SHORT).show();
		if (player.isPlaying()){
			player.stop();
		}
		if (playerM.isPlaying()){
			playerM.stop();
		}
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startid) {
		Bundle bundle = intent.getExtras();
		int id = bundle.getInt("btnini");
		if(id == R.id.btnIniMusic) {
			playerM.start();
		}
		else {
			player.start();
		}
		Toast.makeText(this, R.string.iniservice, Toast.LENGTH_SHORT).show();
		return startid;		
	}	

}
