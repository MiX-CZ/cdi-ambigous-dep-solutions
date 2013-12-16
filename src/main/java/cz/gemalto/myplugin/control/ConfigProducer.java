package cz.gemalto.myplugin.control;

import cz.gemalto.dontchangeit.Config;
import cz.gemalto.dontchangeit.Original;
import cz.gemalto.myplugin.qualifier.ConfigFactory;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Petr Hunka (MiX-CZ)
 */
@Stateless
public class ConfigProducer {

    //==============================================================================
    //  CONSTRUCTORS 
    //==============================================================================

    //==============================================================================
    //  PUBLIC  
    //==============================================================================
    @Produces @ConfigFactory
    public Config createConfig(InjectionPoint ip){
        System.out.println("Injection point " + ip.getBean());
        // some business decision rule
        if (false) {
            return new Original();
        } else {
            return new MyVersion();
        }
    }


    //==============================================================================
    //  PRIVATE 
    //==============================================================================

    //==============================================================================
    //  GET & SET 
    //==============================================================================

}
