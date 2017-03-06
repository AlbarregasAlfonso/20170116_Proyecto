/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

/**
 *
 * @author AlfonsoTerrones
 */
public class MyLogger {
    public void doLog(Exception e, Class c, String level){
        System.setProperty("logPath", c.getSimpleName());
        System.setProperty("proyecto", "20170328_AlfonsoTerrones");
        org.apache.log4j.Logger logger= org.apache.log4j.Logger.getLogger(c);
        
        String out = "Linea: " + e.getStackTrace()[0].getLineNumber()+" Causa: "+e;
        switch(level){
            case "fatal":
                logger.fatal(out);
                break;
            case "warn" :
                logger.warn(out);
                break;
            case "error" :
                logger.error(out);
                break;
            default:
                logger.info(out);
                break;
        }
    }
      
}
