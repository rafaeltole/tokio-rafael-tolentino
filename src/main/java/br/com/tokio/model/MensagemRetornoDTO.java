package br.com.tokio.model;

public class MensagemRetornoDTO {

    private String mensagem;

    private String erro;

    public String getMensagem() {
        return mensagem;
    }

    public String getErro() {
        return erro;
    }

    public static MensagemRetornoDTO buildComSucesso(String mensagem) {
        MensagemRetornoDTO retorno = new MensagemRetornoDTO();
        retorno.mensagem = mensagem;
        return retorno;
    }

    public static MensagemRetornoDTO buildComErro(String mensagem, String erro) {
        MensagemRetornoDTO retorno = new MensagemRetornoDTO();
        retorno.mensagem = mensagem;
        retorno.erro = erro;
        return retorno;
    }


}
