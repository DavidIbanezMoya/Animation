package com.davidiba.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class AnimationGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	public Animation<TextureRegion> runningAnimation;
	TextureRegion frames[] = new TextureRegion[16];
	Animation<TextureRegion> gold;
	Float stateTime = 0.0f;

//...

	//runningAnimation = new Animation<TextureRegion>(0.033f, atlas.findRegions("running"), Animation.PlayMode.LOOP);

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("goldSprite.jpg");
		//img = new Texture("sprite-animation4.jpg");

		// per cada frame cal indicar x,y,amplada,alçada

		//Sprite de la PT
		frames[0] = new TextureRegion(img,0,0,64,64);
		frames[1] = new TextureRegion(img,0,64,64,64);
		frames[2] = new TextureRegion(img,0,128,64,64);
		frames[3] = new TextureRegion(img,0,192,64,64);
		frames[4] = new TextureRegion(img,64,0,64,64);
		frames[5] = new TextureRegion(img,64,64,64,64);
		frames[6] = new TextureRegion(img,64,128,64,64);
		frames[7] = new TextureRegion(img,64,192,64,64);
		frames[8] = new TextureRegion(img,128,0,64,64);
		frames[9] = new TextureRegion(img,128,64,64,64);
		frames[10] = new TextureRegion(img,128,128,64,64);
		frames[11] = new TextureRegion(img,128,192,64,64);
		frames[12] = new TextureRegion(img,192,0,64,64);
		frames[13] = new TextureRegion(img,192,64,64,64);
		frames[14] = new TextureRegion(img,192,128,64,64);
		frames[15] = new TextureRegion(img,192,192,122,109);

		//Posar les direccions segons la textureRegion
		frames[0] = new TextureRegion(img,0,0,64,64);
		frames[1] = new TextureRegion(img,0,64,64,64);
		frames[2] = new TextureRegion(img,0,128,64,64);
		frames[3] = new TextureRegion(img,0,192,64,64);

		frames[4] = new TextureRegion(img,64,0,64,64);
		frames[5] = new TextureRegion(img,64,64,64,64);
		frames[6] = new TextureRegion(img,64,128,64,64);
		frames[7] = new TextureRegion(img,64,192,64,64);

		frames[8] = new TextureRegion(img,128,0,64,64);
		frames[9] = new TextureRegion(img,128,64,64,64);
		frames[10] = new TextureRegion(img,128,128,64,64);
		frames[11] = new TextureRegion(img,128,192,64,64);

		frames[12] = new TextureRegion(img,192,0,64,64);
		frames[13] = new TextureRegion(img,192,64,64,64);
		frames[14] = new TextureRegion(img,192,128,64,64);
		frames[15] = new TextureRegion(img,192,192,122,109);
		gold = new Animation<TextureRegion>(0.25f,frames);

		//Implementar el panel
	}

	@Override
	public void render () {
		//ScreenUtils.clear(1, 0, 0, 1);
		stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
		TextureRegion frame = gold.getKeyFrame(stateTime,true);

		batch.begin();
// si volem invertir el sentit, ho podem fer amb el paràmetre scaleX=-1
		batch.draw(frame, 200, 100, 0, 0,
				frame.getRegionWidth(),frame.getRegionHeight(),3,3,0);batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
