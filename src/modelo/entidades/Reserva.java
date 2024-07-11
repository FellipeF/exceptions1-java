package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import modelo.excecoes.DomainException;

//Terceira implementação: Try Catch
public class Reserva {

    private Integer numeroQuarto;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva() {
    }

    public Reserva(Integer numeroQuarto, Date checkin, Date checkout){
        if (!checkout.after(checkin)) {
            throw new DomainException("data do check-out deve ser superior a do check-in");
        }

        this.numeroQuarto = numeroQuarto;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duracao() {
        long dif = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
    }

    public void atualizarDatas(Date checkin, Date checkout) {

        Date agora = new Date();
        if (checkin.before(agora) || checkout.before(agora)) {
            throw new DomainException("as datas para atualizar a reserva nao devem ser menores do que a data atual");   //Argumentos passados para o método são inválidos
        }

        if (!checkout.after(checkin)) {
            throw new DomainException("data do check-out deve ser superior a do check-in");
        }

        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Sala " + numeroQuarto + ", check-in: " + sdf.format(checkin) + ", check-out: " + sdf.format(checkout) + ", " + duracao() + " noites";
    }

}
