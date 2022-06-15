package com.revature;

import java.io.File;

import io.javalin.Javalin;
import io.javalin.plugin.metrics.MicrometerPlugin;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import io.micrometer.core.instrument.binder.system.DiskSpaceMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import io.micrometer.core.instrument.binder.system.UptimeMetrics;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

public class MainDriver {
	
	/*
	 * Monitoring is the practice of keeping track of an applicaton. 
	 * How our Java applicaiton is doing. 
	 * We could log all the data about the app into a txt file, but that could be difficult to access
	 * 
	 * We use a dependency in Java called Micrometer: 
	 * 	We will build a Prometheus registry that will keep track of monitoring data that can be 
	 * 	stored by Prometheus. 
	 */
	
	static int total = 0;
	
	public static void main(String[] args) {
		
//		For a simple regitsry 
//		SimpleMeterRegistry sMR = new SimpleMeterRegistry(); 
		
//		In preperation for our Prometheus database 
		PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
		
//		Provides key value pair tags for our app
		registry.config().commonTags("application","My-First-Monitored-App");
		
		new ClassLoaderMetrics().bindTo(registry);
		new JvmMemoryMetrics().bindTo(registry);
		new JvmGcMetrics().bindTo(registry);
		new JvmThreadMetrics().bindTo(registry);
		new UptimeMetrics().bindTo(registry);
		new ProcessorMetrics().bindTo(registry);
		new DiskSpaceMetrics(new File(System.getProperty("user.dir"))).bindTo(registry);
		
		
		//Building a custom metric!
		Counter counter = Counter
				.builder("path_request_to_drinks")
				.description("To keep track of the number of drink requests")
				.tag("purpose", "demo")
				.register(registry);
		
		Counter counter2 = Counter
				.builder("number_of_http_requests_to_planet")
				.description("To keep track of the number of planet requests")
				.tag("purpose", "planets")
				.register(registry);
		
		
//		We need to configure our Javalin application. 
		Javalin app = Javalin.create(
					config -> {
						config.registerPlugin(new MicrometerPlugin(registry));
					}
				).start(7400);
		
		
		
		
		app.get("/metrics", ctx -> {
			ctx.result(registry.scrape());
		});
		
		
		
		app.get("/drink", ctx -> {
			System.out.println("I want to keep track of how many times I've asked for a drink!");
			counter.increment(1);
		});
		
		app.get("/planet", ctx -> {
			counter2.increment(1);
		});
		
		
		app.get("/", ctx -> {
			ctx.result("Welcome to my Micrometer example!");
		});
		
	}

}
