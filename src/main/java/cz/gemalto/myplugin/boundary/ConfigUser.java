package cz.gemalto.myplugin.boundary;

import cz.gemalto.dontchangeit.Config;
import cz.gemalto.myplugin.qualifier.ConfigFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Petr Hunka (MiX-CZ)
 */
@Stateless
public class ConfigUser {

    @Inject @ConfigFactory
    private Config config;
    //==============================================================================
    //  CONSTRUCTORS 
    //==============================================================================

    //==============================================================================
    //  PUBLIC  
    //==============================================================================
    public void call(){
     config.test("gmalto");
    }

    //==============================================================================
    //  PRIVATE 
    //==============================================================================

    //==============================================================================
    //  GET & SET 
    //==============================================================================

}
