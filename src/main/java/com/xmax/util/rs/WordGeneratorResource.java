/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xmax.util.rs;

import java.io.IOException;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.bind.PropertyException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author jcernaq
 */
@Path("wordGenerator")
public class WordGeneratorResource {
    private static final Logger LOGGER = LogManager.getLogger(WordGeneratorResource.class.getName());
    
    public WordGeneratorResource(){
    }
    
    @POST
    @Path("/word/generator")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response wordGenerator(){
        StreamingOutput stream = new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException {
                try {
                    byte[] resultado = null;
                    //ReclamoInternoBroker reclamoBb = new ReclamoInternoBroker();
                    
                    output.write(resultado);
                    output.flush();
                } catch (IOException ex) {
                    LOGGER.error("ERROR 3: " + ex.getMessage(), ex);
                } finally {                    
                    output.close();
                }
            }
        };
        
        return Response.ok(stream).build();
    }
}
