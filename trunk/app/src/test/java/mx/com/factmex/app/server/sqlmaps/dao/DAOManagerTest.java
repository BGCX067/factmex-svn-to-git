package mx.com.factmex.app.server.sqlmaps.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import mx.com.factmex.app.server.sqlmaps.model.CCompania;
import mx.com.factmex.app.server.sqlmaps.model.CCompaniaExample;

import org.junit.Test;

public class DAOManagerTest {

	@Test
	public void testGetInstance() {
		try {
			CCompaniaDAO companiaDAO = DAOManager.getInstance().getCCompaniaDAO();
			//CCompania record = new CCompania();
			//record.setNombre("Despacho Contable Adriana Mendez");
			//record.setFechaAlta(new Date());
			//companiaDAO.insert(record);
			
			List<CCompania> listCompanias = companiaDAO.selectByExample(new CCompaniaExample());
			for( CCompania compania : listCompanias){
				System.out.println(compania.getNombre());
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
