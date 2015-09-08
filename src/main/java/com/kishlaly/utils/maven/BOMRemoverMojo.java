package com.kishlaly.utils.maven;

import com.kishlaly.utils.config.Factory;
import com.kishlaly.utils.config.Remover;
import com.kishlaly.utils.core.Parameters;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.Arrays;

/**
 * @author Vladimir Kishlaly
 * @since 04.09.2015
 */
@Mojo(name = "work", defaultPhase = LifecyclePhase.PACKAGE)
public class BOMRemoverMojo extends AbstractMojo {

    @Parameter(property = "folder", defaultValue = ".")
    private String folder;

    @Parameter(property = "masks", defaultValue = "")
    private String[] masks;

    @Parameter(property = "recursively", defaultValue = "no")
    private String recursively;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (getLog().isDebugEnabled()) {
            System.out.println("Folder: " + folder);
            System.out.println("Masks: " + Arrays.toString(masks));
            System.out.println("Recursively: " + recursively);
        }
        Parameters parameters = new Parameters.Builder()
                .folder(folder)
                .masks(masks)
                .recursively(!recursively.equals("no") ? true : false)
                .build(folder != null ? true : false);
        Remover remover = Factory.getInstance(parameters);
        remover.work();
    }
}
