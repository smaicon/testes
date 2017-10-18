/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Vereador;

/**
 *
 * @author smaicon
 */
public class VereadorDAO {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    public VereadorDAO() {

    }

    public boolean inserir(Vereador vereador) {
        String sql = "INSERT INTO vereadores(cor_raca, email, grau_instrucao, partido) VALUES(?,?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setInt(1, vereador.getId());
            pst.setString(2, vereador.getCor_raca());
            pst.setString(3, vereador.getEmail());
            pst.setString(4, vereador.getGrau_instrucao());
            pst.setString(5, vereador.getPartido());

            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VereadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

    public boolean atualizar(Vereador vereador) {
        String sql = "UPDATE vereadores set cor_raca=?,email=?,grau_instrucao=?, partido=?where id=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setInt(1, vereador.getId());
            pst.setString(2, vereador.getCor_raca());
            pst.setString(3, vereador.getEmail());
            pst.setString(4, vereador.getGrau_instrucao());
            pst.setString(5, vereador.getPartido());
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VereadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

    public boolean excluir(Vereador vereador) {
        String sql = "DELETE FROM vereadores where id=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setInt(1, vereador.getId());
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VereadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

    public List<Vereador> listar() {
        String sql = "SELECT * FROM vereadores";
        List<Vereador> retorno = new ArrayList<Vereador>();

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Vereador item = new Vereador();
                item.setId(res.getInt("id"));
                item.setCor_raca(res.getString("cor_raca"));
              
                // item.setData_nascimento(new java.sql.Date(res.getData_nascimento(data_nascimento).getTime()));
                item.setEmail(res.getString("email"));
            //    item.setFim_mandato(res.getDate(sdsa));
                //foto vem ? definir
                item.setGrau_instrucao(res.getString("grau_instrucao"));
                //item.setInicio_mandato(res.getDate(dsda));
                item.setNome_completo(res.getString("nome_completo"));
                item.setNome_publico(res.getString("nome_publico"));
                item.setPartido(res.getString("partido"));
                item.setSexo(res.getString("sexo"));
                item.setTelefone(res.getString("telefone"));
                item.setTotal_votos(res.getInt("total_votos"));
                
                
                

                retorno.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VereadorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }

    public Vereador buscar(Vereador vereador) {
        String sql = "SELECT * FROM vereadores where id=?";
        Vereador retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setInt(1, vereador.getId());
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                retorno = new Vereador();
                retorno.setId(res.getInt("id"));
                retorno.setCor_raca(res.getString("cor_raca"));
                retorno.setEmail(res.getString("email"));
                retorno.setGrau_instrucao(res.getString("grau_instrucao"));
                retorno.setPartido(res.getString("partido"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(VereadorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }

}
