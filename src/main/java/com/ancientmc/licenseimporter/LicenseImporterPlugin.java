package com.ancientmc.licenseimporter;

import org.apache.commons.io.FileUtils;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LicenseImporterPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        LicenseImporterExtension extension = project.getExtensions().create("license-importer", LicenseImporterExtension.class, project);

        project.afterEvaluate(proj -> {
            try {
                URL license = new URL(extension.getUrl().get());
                File output = extension.getOutput().get();

                FileUtils.copyURLToFile(license, output);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
