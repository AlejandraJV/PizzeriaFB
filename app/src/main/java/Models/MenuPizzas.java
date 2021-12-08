package Models;

public class MenuPizzas {
    private int id;
    private String[] tipoPizza ={"Pizza Napolitana", "Pizza Predilecta", "Pizza Vegana", "Pizza Selecta"};
    private int[] precioPizza ={12500, 13800, 15600, 18600};

    public MenuPizzas()
    {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getTipoPizza() {
        return tipoPizza;
    }

    public void setTipoPizza(String[] tipoPizza) {
        this.tipoPizza = tipoPizza;
    }

    public int[] getPrecioPizza() {
        return precioPizza;
    }

    public void setPrecioPizza(int[] precioPizza) {
        this.precioPizza = precioPizza;
    }

    //Añadir adicional a precio pizza
    public int anadirAdicional(int valor, int adicional){
        return valor + adicional;
    }
}
