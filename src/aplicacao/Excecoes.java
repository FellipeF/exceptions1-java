package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modelo.entidades.Reserva;
import modelo.excecoes.DomainException;

public class Excecoes {

    //Tratamento de exceção ao invés da propagação
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Numero do quarto: ");
            int num = input.nextInt();

            System.out.print("Data de check-in (dd/MM/yyyy): ");
            Date checkin = sdf.parse(input.next());

            System.out.print("Data de check-out (dd/MM/yyyy): ");
            Date checkout = sdf.parse(input.next());

            Reserva reserva = new Reserva(num, checkin, checkout);
            System.out.println("Reserva: " + reserva);

            System.out.println("");

            System.out.println("Insira as datas para atualizar a reserva");

            System.out.print("Data de check-in (dd/MM/yyyy): ");
            checkin = sdf.parse(input.next());

            System.out.print("Data de check-out (dd/MM/yyyy): ");
            checkout = sdf.parse(input.next());

            reserva.atualizarDatas(checkin, checkout);

            System.out.println("Reserva: " + reserva);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido");
        } catch (DomainException e)
        {
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch (RuntimeException e)
        {
            System.out.println("Erro inesperado");
        }

        input.close();
    }
}
