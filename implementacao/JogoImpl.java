package implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.ArrayList;

import dao.JogoDAO;
import campeonato.Jogo;
import conn.ProvedorConexao;

public class JogoImpl implements JogoDAO {

	private PreparedStatement preparedStatement;
	private Statement stm;
	private Connection conn;

    @Override
	public List<Jogo> listarTodosJogos() {

		List<Jogo> jogos = new ArrayList<>();

		try {
			this.conn = ProvedorConexao.getConnection();
			String insertTableSQL = "SELECT * FROM jogo";
			this.preparedStatement = this.conn.prepareStatement(insertTableSQL);

			ResultSet resultado = this.preparedStatement.executeQuery(insertTableSQL);
			//ResultSetMetaData rsmd = resultado.getMetaData();

			//int columnsNumber = rsmd.getColumnCount();
			while (resultado.next()) {
				Jogo jogo = new Jogo(resultado.getInt(1), resultado.getString(2), resultado.getInt(3), resultado.getInt(4));
				jogos.add(jogo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jogos;
	}

	@Override
	public Jogo verJogoPorCodigo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarJogo(Jogo jogo) {

		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO jogo"
					+ "(cod, resultado, timea_cod, timeb_cod) VALUES"
					+ "(?,?,?,?)";

				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setInt(1, jogo.getCod());
				preparedStatement.setString(2, jogo.getResultado());
                preparedStatement.setInt(3, jogo.getTimea());
                preparedStatement.setInt(4, jogo.getTimeb());
				int resultado = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletarJogo(Jogo time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizarJogo(Jogo time) {
		// TODO Auto-generated method stub

	}


}
