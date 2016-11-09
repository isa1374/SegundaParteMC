Public class Regla{
  private String Terminal;
  private String Cadena;

  public regla(String Terminal,String Cadena)
    {
    this.Terminal=Terminal;
    this.Cadena=Cadena;
    }

  public String getCadena()
    {
    return Cadena;
    }

  public String setTerminal()
    {
    return Terminal;
    }

  public void setCadena(String Cadena)
    {
    this.Cadena=Cadena;
    }

  public void setTerminal(String Terminal)
    {
    this.Terminal=Terminal;
    }

}
