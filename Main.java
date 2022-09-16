import java.security.SecureRandom;

class Main {

  private static final SecureRandom randomNumbers = new SecureRandom();
  private enum Status{ CONTINUE, WON, LOST };

  public static int rollDice(){
    int dado1 = 1 + randomNumbers.nextInt(6);
    int dado2 = 1 + randomNumbers.nextInt(6);
    
    int sum = dado1 + dado2;

    System.out.printf("O jogador rolou: %d + %d = %d\n", dado1, dado2, sum);
    return sum;
  }
  
  public static void main(String[] args) {
    int meusPontos = 0;
    Status gameStatus;
    int somaDosDados = rollDice();

    switch(somaDosDados){
      case 7:
      case 11:
        gameStatus = Status.WON;
        break;
        
      case 2:
      case 3:
      case 12:
        gameStatus = Status.LOST;
        break;
  
      default:
        gameStatus = Status.CONTINUE;
        meusPontos = somaDosDados;
        //System.out.printf("Os pontos são: %d\n", meusPontos);
        break;
    }

    while(gameStatus == Status.CONTINUE){
      somaDosDados = rollDice();

      if(somaDosDados == meusPontos){
        gameStatus = Status.WON;
      }else if(somaDosDados == 7){
        gameStatus = Status.LOST;
      }
    }

    if(gameStatus == Status.WON){
      System.out.println("O jogador venceu !!!");
    } else if(gameStatus == Status.LOST){
      System.out.println("O jogador perdeu !!!");
    }

  }
}