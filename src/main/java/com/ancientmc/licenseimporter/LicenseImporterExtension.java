package com.ancientmc.licenseimporter;

import org.gradle.api.Project;
import org.gradle.api.provider.Property;

import java.io.File;

public class LicenseImporterExtension {
    protected final Project project;

    private final Property<String> url;
    private final Property<File> output;

    public LicenseImporterExtension(final Project project) {
        this.project = project;
        this.url = project.getObjects().property(String.class);
        this.output = project.getObjects().property(File.class);
    }

    public Property<String> getUrl() {
        return this.url;
    }

    public Property<File> getOutput() {
        return this.output;
    }
}
