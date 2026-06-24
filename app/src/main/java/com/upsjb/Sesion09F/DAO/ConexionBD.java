package com.upsjb.Sesion09F.DAO;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;


public abstract class ConexionBD {

  public static Connection conexion() throws Exception{
       var ds = new SQLServerDataSource();
       ds.setServerName("localhost");
       ds.setDatabaseName("InventarioColegio");
       ds.setPortNumber(1433);
       ds.setUser("AlumnoUPSJB");
       ds.setPassword("123456");
       ds.setTrustServerCertificate(true);
       ds.setEncrypt("true");
       return ds.getConnection();
   }
}
