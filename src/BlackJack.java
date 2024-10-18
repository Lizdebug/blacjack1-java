import java.util.Random;

public class BlackJack {
    static int player = 0;
    static int dealer = 0;

    static String playermensaje = "Las cartas del jugador son: ";
    static String dealermensaje = "Las cartas del dealer son: ";
    static int[] cards = new int[52];

    // Método para crear el mazo de cartas
    public static void createDeck() {
        int cartValue = 2;
        int cartCount = 0;
        for (int figure = 1; figure <= 4; figure++) {
            for (int card = 1; card <= 13; card++) {
                switch (card) {
                    case 10:
                    case 11:
                    case 12:
                        cartValue = 10;
                        break;
                    case 13:
                        cartValue = 11;
                        break;
                    default:
                        break;
                }
                cards[cartCount] = cartValue;
                cartCount++;
                cartValue++;
            }
            cartValue = 2;
        }
    }

    // Método para sacar una carta al azar
    public static int drawCard() {
        Random random = new Random();
        int card = random.nextInt(52)+1; // Genera un número entre 1 y 52
        return cards[card];
    }

    // Método para iniciar el juego y repartir las cartas al jugador y dealer
    public static void initGame() {
        player = drawCard() + drawCard(); // Dos cartas para el jugador
        dealer = drawCard() + drawCard(); // Dos cartas para el dealer

        // Mostrar las cartas y las puntuaciones iniciales
        System.out.println(playermensaje + player + " puntos.");
        System.out.println(dealermensaje + dealer + " puntos.");
    }

    // Método para validar el resultado del juego
    public static void validateGame() {
        // Verificar si el jugador tiene 21 puntos
        if (player == 21) {
            System.out.println("Ganaste, tienes 21 puntos exactos!");
        }
        // Verificar si el jugador tiene más puntos que el dealer
        else if (player > dealer && player <= 21) {
            System.out.println("Ganaste, tienes más puntos que el dealer!");
        }
        // Verificar si es un empate
        else if (player == dealer) {
            System.out.println("Empate!");
        }
        // Si el dealer tiene más puntos o el jugador se pasó de 21
        else {
            System.out.println("Perdiste, el dealer tiene más puntos o te pasaste de 21!");
        }
    }

    // Método principal
    public static void main(String[] args) {
        createDeck();   // Crear el mazo
        initGame();     // Iniciar el juego y repartir las cartas
        validateGame(); // Validar quién ganó
    }
}