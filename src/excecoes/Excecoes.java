package excecoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modelo.entidades.Reserva;

public class Excecoes {

    //Propagação de exceção
    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto: ");
        int num = input.nextInt();

        System.out.print("Data de check-in (dd/MM/yyyy): ");
        Date checkin = sdf.parse(input.next());

        System.out.print("Data de check-out (dd/MM/yyyy): ");
        Date checkout = sdf.parse(input.next());

        //Lógica de validação no programa principal
        if (!checkout.after(checkin)) {
            System.out.println("Erro na reserva: data do check-out deve ser superior a do check-in");
        } else {
            Reserva reserva = new Reserva(num, checkin, checkout);
            System.out.println("Reserva: " + reserva);

            System.out.println("");

            System.out.println("Insira as datas para atualizar a reserva");

            System.out.print("Data de check-in (dd/MM/yyyy): ");
            checkin = sdf.parse(input.next());

            System.out.print("Data de check-out (dd/MM/yyyy): ");
            checkout = sdf.parse(input.next());

            String erro = reserva.atualizarDatas(checkin, checkout);
            if (erro != null) {
                System.out.println("Erro na reserva: " + erro);
            } else {
                System.out.println("Reserva: " + reserva);
            }
        }
        
        input.close();
    }
}
