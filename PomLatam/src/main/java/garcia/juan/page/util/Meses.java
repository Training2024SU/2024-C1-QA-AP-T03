package garcia.juan.page.util;

public enum Meses {
    enero(1),
    febrero(2),
    marzo(3),
    abril(4),
    mayo(5),
    junio(6),
    julio(7),
    agosto(8),
    septiembre(9),
    octubre(10),
    noviembre(11),
    diciembre(12);

    private final int numero;

    Meses(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public static Meses obtenerPorNumero(int numero) {
        for (Meses mes : Meses.values()) {
            if (mes.numero == numero) {
                return mes;
            }
        }
        throw new IllegalArgumentException("No se encontró un mes con el número " + numero);
    }
}

