package br.unincor.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Usuario {
	
	
	public void exibeMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public void exibeMsgErro(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Erro!", JOptionPane.ERROR_MESSAGE);
	}
	
	public void exibeMsgDebug(String msg) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(sdf.format(new Date()) + " [DEBUG] - " + msg);
	}
	
	public Integer exibeMenuPrincipal() {
		Object[] opcoes = {"Inserir", "Alterar"};
		Integer op = JOptionPane.showOptionDialog(null,
					"Escolha uma opção?",
					"Menu Principal",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					opcoes,
					-1);

		return op;
	}
	
	public Long recebeLong(String texto) {
		try {
			return Long.parseLong(JOptionPane.showInputDialog(texto));	
		} catch (Exception e) {
			this.exibeMsgErro("Erro na entrada de usuário");
		}
		return null;
	}
	
	public Double recebeDouble(String texto) {
		try {
			String resposta = JOptionPane.showInputDialog(texto);
			Double respostaConvertida = Double.parseDouble(resposta);
			return respostaConvertida;
		} catch (Exception e) {
			exibeMsg("Entrada inválida!");
		}
		return null;
	}

	public Float recebeFloat(String texto) {
		try {
			String resposta = JOptionPane.showInputDialog(texto);
			Float respostaConvertida = Float.parseFloat(resposta);
			return respostaConvertida;
		} catch (Exception e) {
			exibeMsg("Entrada inválida!");
		}
		return null;
	}

	public Boolean recebeBoolean(String texto) {
		Integer op = JOptionPane.showConfirmDialog(null, texto);

		if (op == 0)
			return true;
		return false;
	}
	
	public String recebeTexto(String texto) {
		return JOptionPane.showInputDialog(texto);
	}
}
