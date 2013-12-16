package cz.gemalto.myplugin;

import cz.gemalto.dontchangeit.Original;
import cz.gemalto.myplugin.boundary.ConfigUser;
import cz.gemalto.dontchangeit.Config;
import cz.gemalto.myplugin.control.ConfigProducer;
import cz.gemalto.myplugin.control.MyVersion;
import cz.gemalto.myplugin.qualifier.ConfigFactory;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;


/**
 * Petr Hunka (MiX-CZ)
 */
@RunWith(Arquillian.class)
public class ConfigTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "myplugin.jar")
                // add myplugin classes here
                .addClasses(Config.class, Original.class, MyVersion.class,
                        ConfigProducer.class, ConfigUser.class, ConfigFactory.class)
                        // add CDI descriptor
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    ConfigUser tpc;

    //==============================================================================
    //  CONSTRUCTORS 
    //==============================================================================

    //==============================================================================
    //  PUBLIC  
    //==============================================================================
    @Test
    public void tetsCall(){
        tpc.call();
    }


    //==============================================================================
    //  PRIVATE 
    //==============================================================================

    //==============================================================================
    //  GET & SET 
    //==============================================================================

}
