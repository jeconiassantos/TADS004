package implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.JogoDAO;
import campeonato.Jogo;
import conn.ProvedorConexao;

public class JogoImpl implements JogoDAO {

    @Override
	public List<Jogo> listarTodosJogos() {
		// TODO Auto-generated method stub
		return null;
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
				preparedStatement.setString(1, "" + jogo.getCod());
				preparedStatement.setString(2, jogo.getResultado());
                preparedStatement.setString(3, "" + jogo.getTimea());
                preparedStatement.setString(4, "" + jogo.getTimeb());
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
