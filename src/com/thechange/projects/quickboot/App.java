package com.thechange.projects.quickboot;

import android.app.Application;
import android.content.Context;

public class App extends Application {

	private static Context sContext;
	private static final Object LOCK = new Object();

	@Override
	public void onCreate() {
		super.onCreate();
		sContext = getApplicationContext();
	}

	public static Context getContext() {
		synchronized (LOCK) {
			return sContext;
		}
	}
}
