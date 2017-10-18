/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.VereadorDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Vereador;

/**
 * REST Web Service
 *
 * @author smaicon passo 1 > implantar ou build passo 2 > testar webservices ou
 */
@Path("DONC")
public class DoncWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DoncWS
     */
    public DoncWS() {
    }

    /**
     * Retrieves representation of an instance of ws.DoncWS
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJson() {
        return "meu primeiro webservice RestFul";
    }
        
    //busca usuario especifico
    /*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("vereador/get/{nome_completo}")
    public String getVereador(@PathParam("nome_completo") String nome_completo) {
        Vereador v = new Vereador();

        v.setNome_completo(nome_completo);

        VereadorDAO dao = new VereadorDAO();
        v = dao.buscar(v);
        //converter para Json
        Gson g = new Gson();
        return g.toJson(v);

    }*/

    @GET
    @Path("vereador/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String listVereador() {
        List<Vereador> lista;

        VereadorDAO dao = new VereadorDAO();
        lista = dao.listar();

        //converter para Json
        Gson g = new Gson();
        return g.toJson(lista);

    }

    /**
     * PUT method for updating or creating an instance of DoncWS
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
