package main.java.com.kishlaly.utils.maven;

import com.kishlaly.utils.config.Factory;
import com.kishlaly.utils.config.Remover;
import com.kishlaly.utils.config.Type;
import com.kishlaly.utils.core.Parameters;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * @author Vladimir Kishlaly
 * @since 04.09.2015
 */
@Mojo(name = "work", defaultPhase = LifecyclePhase.PACKAGE)
public class BOMRemoverMojo extends AbstractMojo {

    @Parameter(property = "folder", defaultValue = ".")
    private String folder;

    @Parameter(property = "mask", defaultValue = "*")
    private String mask;

    @Parameter(property = "type", defaultValue = "default")
    private String type;

    @Parameter(property = "deep", defaultValue = "y")
    private String deep;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Parameters parameters = new Parameters.Builder()
                .folder(folder)
                .mask(mask)
                .type(Type.valueOf(type.toUpperCase()))
                .deep(deep.equals("y") ? true : false)
                .build();
        Remover remover = Factory.getInstance(parameters);
        remover.work();
    }
}
