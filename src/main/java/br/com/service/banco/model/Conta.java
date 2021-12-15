
package br.com.service.banco.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idConta",
    "idPessoa",
    "saldo",
    "limiteSaqueDiario",
    "flagAtivo",
    "tipoConta",
    "dataCriacao"
})
@Generated("jsonschema2pojo")
public class Conta {

    @JsonProperty("idConta")
    public Integer idConta;
    @JsonProperty("idPessoa")
    public Integer idPessoa;
    @JsonProperty("saldo")
    public Float saldo;
    @JsonProperty("limiteSaqueDiario")
    public Float limiteSaqueDiario;
    @JsonProperty("flagAtivo")
    public Boolean flagAtivo;
    @JsonProperty("tipoConta")
    public Integer tipoConta;
    @JsonProperty("dataCriacao")
    public String dataCriacao;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Conta.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("idConta");
        sb.append('=');
        sb.append(((this.idConta == null)?"<null>":this.idConta));
        sb.append(',');
        sb.append("idPessoa");
        sb.append('=');
        sb.append(((this.idPessoa == null)?"<null>":this.idPessoa));
        sb.append(',');
        sb.append("saldo");
        sb.append('=');
        sb.append(((this.saldo == null)?"<null>":this.saldo));
        sb.append(',');
        sb.append("limiteSaqueDiario");
        sb.append('=');
        sb.append(((this.limiteSaqueDiario == null)?"<null>":this.limiteSaqueDiario));
        sb.append(',');
        sb.append("flagAtivo");
        sb.append('=');
        sb.append(((this.flagAtivo == null)?"<null>":this.flagAtivo));
        sb.append(',');
        sb.append("tipoConta");
        sb.append('=');
        sb.append(((this.tipoConta == null)?"<null>":this.tipoConta));
        sb.append(',');
        sb.append("dataCriacao");
        sb.append('=');
        sb.append(((this.dataCriacao == null)?"<null>":this.dataCriacao));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
