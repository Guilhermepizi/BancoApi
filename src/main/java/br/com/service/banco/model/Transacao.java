
package br.com.service.banco.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idTransacao",
    "idConta",
    "valor",
    "dataTransacao"
})
@Generated("jsonschema2pojo")
public class Transacao {

    @JsonProperty("idTransacao")
    public Integer idTransacao;
    @JsonProperty("idConta")
    public Integer idConta;
    @JsonProperty("valor")
    public String valor;
    @JsonProperty("dataTransacao")
    public String dataTransacao;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Transacao.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("idTransacao");
        sb.append('=');
        sb.append(((this.idTransacao == null)?"<null>":this.idTransacao));
        sb.append(',');
        sb.append("idConta");
        sb.append('=');
        sb.append(((this.idConta == null)?"<null>":this.idConta));
        sb.append(',');
        sb.append("valor");
        sb.append('=');
        sb.append(((this.valor == null)?"<null>":this.valor));
        sb.append(',');
        sb.append("dataTransacao");
        sb.append('=');
        sb.append(((this.dataTransacao == null)?"<null>":this.dataTransacao));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
