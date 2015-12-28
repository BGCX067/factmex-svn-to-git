package mx.com.factmex.app.server.services.rpc;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.response.Response;
import mx.com.factmex.app.server.sqlmaps.dao.DAOManager;
import mx.com.factmex.app.server.sqlmaps.model.TEmisor;
import mx.com.factmex.app.server.sqlmaps.model.TEmisorExample;
import mx.com.factmex.app.server.sqlmaps.model.TEmisorExample.Criteria;

public class EmisorService {

		public Response obtenEmisoresCompaniaActual(Request request){
			System.out.println("obtenEmisoresCompaniaActual: compania=" + LoginService.companiaActual);
			Response response = new Response();
			TEmisorExample example = new TEmisorExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdCompaniaEqualTo(new BigDecimal(LoginService.companiaActual).toString());
			try {
				int cuantosEmisores = DAOManager.getInstance().getTEmisorDAO().countByExample(example);
				String data [][] = new String[cuantosEmisores][2];
				example.setOrderByClause("Nombre");
				List<TEmisor> emisores = DAOManager.getInstance().getTEmisorDAO().selectByExample(example);
				for(int i = 0; i < emisores.size(); i++ ){
					TEmisor emisor = emisores.get(i);
					data[i][0] = emisor.getIdEmisor().toString();
					data[i][1] = emisor.getNombre();
				}
				response.setData(data);
				response.setSuccess(true);
				response.setMessage("Emisores consultados");
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				response.setSuccess(false);
				response.setMessage("Error en el sistema : " + e.getMessage());
			} catch (Exception e) {
				System.err.println(e.getMessage());
				response.setSuccess(false);
				response.setMessage("Error en el sistema : " + e.getMessage());
			}
			System.out.println("obtenEmisoresCompaniaActual [termina]: " + response.isSuccess());
			return response;
		}
}
