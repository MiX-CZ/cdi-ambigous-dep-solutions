package cz.gemalto.myplugin.control;

import cz.gemalto.dontchangeit.Config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

/**
 * Petr Hunka (MiX-CZ)
 */
@ApplicationScoped
@Alternative
public class MyVersion implements Config {

    //==============================================================================
    //  CONSTRUCTORS 
    //==============================================================================

    //==============================================================================
    //  PUBLIC  
    //==============================================================================
    @Override
    public void test(String usr) {
        System.out.println("SECOND class call " + usr);
    }

    //==============================================================================
    //  PRIVATE 
    //==============================================================================

    //==============================================================================
    //  GET & SET 
    //==============================================================================

}
