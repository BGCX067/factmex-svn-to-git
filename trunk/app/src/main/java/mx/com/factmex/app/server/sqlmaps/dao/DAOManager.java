package mx.com.factmex.app.server.sqlmaps.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import mx.com.factmex.app.server.sqlmaps.model.TUsuario;

import com.ibatis.common.jdbc.SimpleDataSource;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class DAOManager {
	private static DAOManager daoManager;
	private static SqlMapClient sqlMap;
	private String resource = "SqlMapConfig.xml";
	
	public static DAOManager getInstance(){
		if(daoManager == null){
			return new DAOManager();
		} else {
			return daoManager;
		}
			
	}
	
	private DAOManager(){
		if(sqlMap == null) {
			Reader reader = null;
			Properties properties = null;
			try {
				properties = new Properties();
				properties.load(new FileInputStream("c:\\factmex\\factmex.properties"));
				reader = Resources.getResourceAsReader(resource);
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}

			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader,properties);
			
		}
	}
	
	public CCompaniaDAO getCCompaniaDAO(){
		return new CCompaniaDAOImpl(sqlMap);
	}
	public CEstatusDAO getCEstatusDAO(){
		return new CEstatusDAOImpl(sqlMap);
	}
	public CParametroDAO getCParametroDAO(){
		return new CParametroDAOImpl(sqlMap);
	}
	public CPerfilDAO getCPerfilDAO(){
		return new CPerfilDAOImpl(sqlMap);
	}
	public CTipoComprobanteDAO getCTipoComprobanteDAO(){
		return new CTipoComprobanteDAOImpl(sqlMap);
	}
	public CTipoContactoDAO getCTipoContactoDAO(){
		return new CTipoContactoDAOImpl(sqlMap);
	}
	public CTipoDireccionDAO getCTipoDireccionDAO(){
		return new CTipoDireccionDAOImpl(sqlMap);
	}
	public CTipoPersonaDAO getCTipoPersonaDAO(){
		return new CTipoPersonaDAOImpl(sqlMap);
	}
	public TClienteDAO getTClienteDAO(){
		return new TClienteDAOImpl(sqlMap);
	}
	public TComprobanteDAO getTComprobanteDAO(){
		return new TComprobanteDAOImpl(sqlMap);
	}
	public TContactoDAO getTContactoDAO(){
		return new TContactoDAOImpl(sqlMap);
	}
	
	public TDireccionDAO getTDireccionDAO(){
		return new TDireccionDAOImpl(sqlMap);
	}
	public TEmisorDAO getTEmisorDAO(){
		return new TEmisorDAOImpl(sqlMap);
	}
	public TUsuarioDAO getTUsuarioDAO(){
		return new TUsuarioDAOImpl(sqlMap);
	}
	public TSerieDAO getTSerieDAO(){
		return new TSerieDAOImpl(sqlMap);
	}
	public TProductoServicioDAO getTProductoServicioDAO(){
		return new TProductoServicioDAOImpl(sqlMap);
	}
	
}
