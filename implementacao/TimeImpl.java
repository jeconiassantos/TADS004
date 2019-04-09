package implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.ArrayList;

import dao.TimeDAO;
import campeonato.Time;
import conn.ProvedorConexao;

public class TimeImpl implements TimeDAO{

	private PreparedStatement preparedStatement;
	private Statement stm;
	private Connection conn;

	@Override
	public List<Time> listarTodosTimes() {

		List<Time> times = new ArrayList<>();

		try {
			this.conn = ProvedorConexao.getConnection();
			String insertTableSQL = "SELECT * FROM time";
			this.preparedStatement = this.conn.prepareStatement(insertTableSQL);

			ResultSet resultado = this.preparedStatement.executeQuery(insertTableSQL);
			//ResultSetMetaData rsmd = resultado.getMetaData();

			//int columnsNumber = rsmd.getColumnCount();
			while (resultado.next()) {
				Time time = new Time(resultado.getInt(1), resultado.getString(2), resultado.getString(3));
				times.add(time);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return times;
	}

	@Override
	public Time verTimePorCodigo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarTime(Time time) {

		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO time"
					+ "(cod, nome, data_fundacao) VALUES"
					+ "(?,?,?)";

				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setInt(1, time.getCod());
				preparedStatement.setString(2, time.getNome());
				preparedStatement.setString(3, time.getDatafundacao());
				int resultado = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletarTime(Time time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizarTime(Time time) {
		// TODO Auto-generated method stub

	}

}
