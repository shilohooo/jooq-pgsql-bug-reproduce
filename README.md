# JOOQ Bug Reproduction Sample

This project provide a sample project to reproduce a bug in jOOQ open source edition.

## Bug

When generating code with a [custom code generator strategy](./src/main/java/com/github/shiloh/jooq/codegen/CustomJooqCodeGeneratorStrategy.java), the following error occurs:

```text
org.apache.maven.lifecycle.LifecycleExecutionException: Failed to execute goal org.jooq:jooq-codegen-maven:3.20.10:generate (generate-jooq) on project jooq-pgsql-example: Error running jOOQ code generation tool
    at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute2 (MojoExecutor.java:333)
    at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute (MojoExecutor.java:316)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:212)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:174)
    at org.apache.maven.lifecycle.internal.MojoExecutor.access$000 (MojoExecutor.java:75)
    at org.apache.maven.lifecycle.internal.MojoExecutor$1.run (MojoExecutor.java:162)
    at org.apache.maven.plugin.DefaultMojosExecutionStrategy.execute (DefaultMojosExecutionStrategy.java:39)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:159)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:105)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:73)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:53)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:118)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:261)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:173)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:101)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:906)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:283)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:206)
    at jdk.internal.reflect.DirectMethodHandleAccessor.invoke (DirectMethodHandleAccessor.java:103)
    at java.lang.reflect.Method.invoke (Method.java:580)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:255)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:201)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:361)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:314)
Caused by: org.apache.maven.plugin.MojoExecutionException: Error running jOOQ code generation tool
    at org.jooq.codegen.maven.Plugin.execute (Plugin.java:246)
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:126)
    at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute2 (MojoExecutor.java:328)
    at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute (MojoExecutor.java:316)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:212)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:174)
    at org.apache.maven.lifecycle.internal.MojoExecutor.access$000 (MojoExecutor.java:75)
    at org.apache.maven.lifecycle.internal.MojoExecutor$1.run (MojoExecutor.java:162)
    at org.apache.maven.plugin.DefaultMojosExecutionStrategy.execute (DefaultMojosExecutionStrategy.java:39)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:159)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:105)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:73)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:53)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:118)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:261)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:173)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:101)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:906)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:283)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:206)
    at jdk.internal.reflect.DirectMethodHandleAccessor.invoke (DirectMethodHandleAccessor.java:103)
    at java.lang.reflect.Method.invoke (Method.java:580)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:255)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:201)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:361)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:314)
Caused by: java.lang.ClassNotFoundException: com.github.shiloh.jooq.codegen.CustomJooqCodeGenerator
    at java.net.URLClassLoader.findClass (URLClassLoader.java:445)
    at java.lang.ClassLoader.loadClass (ClassLoader.java:593)
    at java.lang.ClassLoader.loadClass (ClassLoader.java:526)
    at org.jooq.tools.ClassUtils.loadClass (ClassUtils.java:58)
    at org.jooq.codegen.GenerationTool.loadClass (GenerationTool.java:1289)
    at org.jooq.codegen.GenerationTool.run0 (GenerationTool.java:415)
    at org.jooq.codegen.GenerationTool.run (GenerationTool.java:254)
    at org.jooq.codegen.GenerationTool.generate (GenerationTool.java:249)
    at org.jooq.codegen.maven.Plugin.execute (Plugin.java:243)
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:126)
    at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute2 (MojoExecutor.java:328)
    at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute (MojoExecutor.java:316)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:212)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:174)
    at org.apache.maven.lifecycle.internal.MojoExecutor.access$000 (MojoExecutor.java:75)
    at org.apache.maven.lifecycle.internal.MojoExecutor$1.run (MojoExecutor.java:162)
    at org.apache.maven.plugin.DefaultMojosExecutionStrategy.execute (DefaultMojosExecutionStrategy.java:39)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:159)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:105)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:73)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:53)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:118)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:261)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:173)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:101)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:906)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:283)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:206)
    at jdk.internal.reflect.DirectMethodHandleAccessor.invoke (DirectMethodHandleAccessor.java:103)
    at java.lang.reflect.Method.invoke (Method.java:580)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:255)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:201)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:361)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:314)
```


## Stack

| Name     | Version  |
|----------|----------|
| Java     | 21.0.9   |
| Maven    | 3.9.9    |
| JOOQ     | 3.20.10  |
| Postgres | 18.1     |
| IntelliJ | 2025.2.5 |

## How to reproduce

1. Clone this repository.
2. Open the project in your IDE (like IntelliJ IDEA).
3. Install all dependencies.
4. Run following command: 

```shell
mvn clean compile -X
```

