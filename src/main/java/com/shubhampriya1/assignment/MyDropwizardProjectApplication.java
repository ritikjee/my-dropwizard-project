package com.shubhampriya1.assignment;

import com.shubhampriya1.assignment.controller.HomeController;
import com.shubhampriya1.assignment.health.AppHealthCheck;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class MyDropwizardProjectApplication extends Application<MyDropwizardProjectConfiguration> {

    public static void main(final String[] args) throws Exception {
        if (args.length == 0) {
            new MyDropwizardProjectApplication().run("server", "config.yml");
        } else {
            new MyDropwizardProjectApplication().run(args);
        }
    }

    @Override
    public String getName() {
        return "MyDropwizardProject";
    }

    @Override
    public void initialize(final Bootstrap<MyDropwizardProjectConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final MyDropwizardProjectConfiguration configuration,
            final Environment environment) {

        environment.healthChecks().register("app", new AppHealthCheck());
        environment.jersey().register(new HomeController());
    }

}
