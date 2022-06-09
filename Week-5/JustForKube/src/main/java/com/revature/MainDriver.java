package com.revature;

import io.javalin.Javalin;
import io.javalin.plugin.metrics.MicrometerPlugin;

public class MainDriver {

	public static void main(String[] args) {


		Javalin app = Javalin.create().start(7000);
		
		app.get("/", ctx -> {
			ctx.result("Hello from my very very basic Javalin app!");
		});

	}

}
