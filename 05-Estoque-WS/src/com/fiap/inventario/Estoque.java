package com.fiap.inventario;

import org.apache.axis2.AxisFault;

import com.fiap.loja.EstoqueBO;
import com.fiap.loja.to.ProdutoTO;

public class Estoque {

	/**
	 * M�todo para retornar um produto atrav�s do c�digo do produto.
	 * @param codProduto
	 * @return ProdutoTO - Produto encontrado com o c�digo inserido.
	 */
	public ProdutoTO buscarProduto(String codProduto) {
		
		EstoqueBO estoqueBO = new EstoqueBO();
		ProdutoTO produtoBuscado = new ProdutoTO();
		
		try {
			produtoBuscado = estoqueBO.consultarProduto(Integer.parseInt(codProduto));
			
			if (produtoBuscado == null)
				throw new AxisFault("Produto n�o encontrado");
			
		} catch (AxisFault err) {
			err.printStackTrace();
		}
		
		return produtoBuscado;
	}
	
}
