package Models;

public class Ingredientes {
    private int id;
    private String[] nombreIngr ={"Tocino", "Extra Queso", "Champiñón", "Salame", "Albahaca"};
    private int[] valorIng ={350, 500, 250, 300, 450};

    public Ingredientes()
    {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getNombreIngr() {
        return nombreIngr;
    }

    public void setNombreIngr(String[] nombreIngr) {
        this.nombreIngr = nombreIngr;
    }

    public int[] getValorIng() {
        return valorIng;
    }

    public void setValorIng(int[] valorIng) {
        this.valorIng = valorIng;
    }
}
