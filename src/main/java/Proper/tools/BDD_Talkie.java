package Proper.tools;

import java.sql.*;

/**
 * Created by Simerron on 06/07/2017.
 * Last edited by Simerron on 06/07/2017
 */
public class BDD_Talkie {
    public BDD_Talkie() {
        try { //Chargement Driver Mysql
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection connexion = null;
    private Statement statement;

    public void Connextion_BDD(String url, String utilisateur, String motDePasse) {
        try {
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            statement = connexion.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Close_BDD(){
        try{
            connexion.close();
            connexion = null;
            statement = null;
        }catch (Exception e){/*Ignoring*/}
    }

    public void ecriture_BDD(String insert){
        try {
            int status = statement.executeUpdate(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet lecture_BDD(String select) {
        /* Exécution d'une requête de lecture */
        ResultSet resultat = null;
        try {
            resultat = statement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }
}
