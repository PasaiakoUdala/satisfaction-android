package eus.pasaia.org.satisfaction.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Satisfaction {

  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("emaitza")
  @Expose
  private Integer emaitza;
  @SerializedName("kokapena")
  @Expose
  private String kokapena;
  @SerializedName("saila")
  @Expose
  private String saila;
  @SerializedName("galdera")
  @Expose
  private String galdera;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getEmaitza() {
    return emaitza;
  }

  public void setEmaitza(Integer emaitza) {
    this.emaitza = emaitza;
  }

  public String getKokapena() {
    return kokapena;
  }

  public void setKokapena(String kokapena) {
    this.kokapena = kokapena;
  }

  public String getSaila() {
    return saila;
  }

  public void setSaila(String saila) {
    this.saila = saila;
  }

  public String getGaldera() {
    return galdera;
  }

  public void setGaldera(String galdera) {
    this.galdera = galdera;
  }

  @Override
  public String toString() {
    return "Satisfaction{" +
      "galdera='" + galdera + '\'' +
      ", emaitza=" + emaitza +
      ", id=" + id +
      '}';
  }

}
