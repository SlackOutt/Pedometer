package fi.tamk.tiko;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;


public class Pedometer extends ApplicationAdapter {
	SpriteBatch batch;
	FreeTypeFontGenerator generator;
	BitmapFont font12;
	OrthographicCamera camera;
	static int steps;
	String stringSteps = "";
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 450);
		batch = new SpriteBatch();
		generator = new FreeTypeFontGenerator(Gdx.files.internal("helsinki.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 50;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 3;
		font12 = generator.generateFont(parameter);

	}

	@Override
	public void render () {
		batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stringSteps = Integer.toString(steps);
		batch.begin();
		font12.draw(batch,stringSteps,100,100);
		batch.end();
	}
	public static void setSteps(int numSteps) {
		steps = numSteps;
	}
	@Override
	public void dispose () {
		batch.dispose();
	}

}
