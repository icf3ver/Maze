package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Window extends ApplicationAdapter {
	public static ShapeRenderer sr;
	Maze maze;
	@Override
	public void create () {
		sr = new ShapeRenderer();
		maze = new Maze();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sr.begin(ShapeRenderer.ShapeType.Line);
		maze.render();
		sr.end();
		for (int i = 0; i < 100000 ; i++) {
			maze.generate();
		}
	}
	
	@Override
	public void dispose () {
		sr.dispose();
	}
}
