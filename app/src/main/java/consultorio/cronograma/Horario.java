package consultorio.cronograma;

public class Horario {

    private int hours;
    private int minutes;
    private int seconds;
    private int nanoSeconds;

    public Horario(int hours, int minutes, int seconds, int nanoSeconds) {

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.nanoSeconds = nanoSeconds;
        
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutos(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getNanoSeconds() {
        return nanoSeconds;
    }

    public void setNanoSeconds(int nanoSeconds) {
        this.nanoSeconds = nanoSeconds;
    }

    @Override
    public String toString() {
        return "Horario{" + "horas=" + hours + ", minutos=" + minutes + ", segundos=" + seconds + ", nanoSegundos="
                + nanoSeconds + '}';
    }
}
