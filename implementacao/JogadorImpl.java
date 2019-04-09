package implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.ArrayList;

import dao.JogadorDAO;
import campeonato.Jogador;
import conn.ProvedorConexao;

public class JogadorImpl implements JogadorDAO {

	private PreparedStatement preparedStatement;
	private Statement stm;
	private Connection conn;

	@Override
	public List<Jogador> listarTodosJogadores() {

		List<Jogador> jogadores = new ArrayList<>();

		try {
			this.conn = ProvedorConexao.getConnection();
			String insertTableSQL = "SELECT * FROM jogador";
			this.preparedStatement = this.conn.prepareStatement(insertTableSQL);

			ResultSet resultado = this.preparedStatement.executeQuery(insertTableSQL);
			//ResultSetMetaData rsmd = resultado.getMetaData();

			//int columnsNumber = rsmd.getColumnCount();
			while (resultado.next()) {
				Jogador jogador = new Jogador(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getInt(4));
				jogadores.add(jogador);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jogadores;
	}

	@Override
	public Jogador verJogadorPorCodigo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarJogador(Jogador jogador) {

		try {
			this.conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO jogador"
					+ "(cod, nome, data_nascimento, time_cod) VALUES"
					+ "(?,?,?,?)";

			this.preparedStatement = this.conn.prepareStatement(insertTableSQL);
			this.preparedStatement.setInt(1, jogador.getCod());
			this.preparedStatement.setString(2, jogador.getNome());
			this.preparedStatement.setString(3, jogador.getDataNascimento());
			this.preparedStatement.setInt(4, jogador.getTimecod());
			int resultado = this.preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletarJogador(Jogador jogador) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizarJogador(Jogador jogador) {
		// TODO Auto-generated method stub

	}

}
