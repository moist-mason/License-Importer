**License Importer**

A simple Gradle plugin that allows you to import a license file (not headers) into an existing repository's source tree.
Good for people who are using a custom license and don't want to constantly drag in the files manually if they make a change,
or for people who are using continually updated licenses.

**How to use:**

In your build.gradle file, put this in the buildscript block:

```
buildscript {
    repositories {
        mavenCentral()
        maven { url = 'https://github.com/ancientmc/ancientmc-maven/raw/maven' }
    }
    dependencies {
        classpath 'io.github.moist-mason.license-importer'
    }
}
```

Add this line to your repository block:

```
repositories {
    maven { url = 'https://github.com/ancientmc/ancientmc-maven/raw/maven/' }
}
```

Add this line after the repositories block:

```
apply plugin: 'io.github.moist-mason.license-importer'
```

Finally, add this extension:

```
license-importer {
  url = "https://myurl.com"
  output = file(projectDir.path + "\\LICENSE")
}
```

Replace the fake URL with the url to the license. You can edit the output path as well, but keeping it as "project.projectDir"
is recommended, since that is the source directory.