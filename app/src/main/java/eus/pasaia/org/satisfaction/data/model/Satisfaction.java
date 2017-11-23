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
  @SerializedName("galderaeus")
  @Expose
  private String galderaeus;
  @SerializedName("galderaes")
  @Expose
  private String galderaes;

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

  public String getGalderaeus() {
    return galderaeus;
  }

  public void setGalderaeus(String galderaeus) {
    this.galderaeus = galderaeus;
  }

  public String getGalderaes() {
    return galderaes;
  }

  public void setGalderaes(String galderaes) {
    this.galderaes = galderaes;
  }

  @Override
  public String toString() {
    return "Satisfaction{" +
      "galdera='" + galderaeus + '\'' +
      ", emaitza=" + emaitza +
      ", id=" + id +
      '}';
  }

}
